package com.xyz.portal.service;

import com.xyz.portal.domain.dto.CustomerDTO;
import com.xyz.portal.domain.entity.Customer;
import com.xyz.portal.exception.CustomerNotFoundException;
import com.xyz.portal.exception.EmailAlreadyVerifiedException;
import com.xyz.portal.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CustomerService {

    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;


    @Autowired
    public CustomerService(ModelMapper modelMapper, CustomerRepository customerRepository) {
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }


    public Customer getCustomer(final long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("customer not founded"));
    }


    public Customer updateCustomer(final Customer customer) {
        return customerRepository.save(customer);
    }


    public Customer createCustomer(final CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setCreatedDate(new Date());
        customer.setLastLoginDate(new Date());
        customer.setEncryptedPassword(customerDTO.getPassword());
        customer.setLoginId(customerDTO.getLoginId());
        customer.setEmail(customerDTO.getEmail());
        customer.setEmailVerified(false);

        return updateCustomer(customer);
    }



    public Customer verifyEmail(final long customerId, final String uuid) {
        Customer customer = getCustomer(customerId);

        if(customer.isEmailVerified()) {
            throw new EmailAlreadyVerifiedException("");
        }

        String link = customer.getEmailVerifyLink();

        if(uuid.equals(link)) {
            customer.setEmailVerified(true);
            customer.setEmailVerifyLink(null);
            customer = updateCustomer(customer);
        }
        else {
            throw new RuntimeException("");
        }

        return customer;
    }



    public Customer sendVerifyEmail(final long customerId) {
        Customer customer = getCustomer(customerId);
        String uuid = UUID.randomUUID().toString();

//        sendMail(customer);

        customer.setEmailVerified(false);
        customer.setEmailVerifyLink(uuid);

        return updateCustomer(customer);
    }

}
