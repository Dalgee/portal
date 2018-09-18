package com.xyz.portal.configuration;

import com.xyz.portal.domain.entity.Admin;
import com.xyz.portal.domain.entity.Customer;
import com.xyz.portal.domain.dto.AdminDTO;
import com.xyz.portal.domain.dto.CustomerDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ModelMapperBean {

    @Bean(name="modelMapper")
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }



    @PostConstruct
    private void addConverters() {
        ModelMapper mapper = getModelMapper();
        mapper.addConverter(getAdminConverter());
        mapper.addConverter(getCustomerConverter());
    }



    private Converter<AdminDTO, Admin> getAdminConverter() {
        return (ctx) -> {
            Admin admin = new Admin();


            return admin;
        };
    }


    private Converter<CustomerDTO, Customer> getCustomerConverter() {
        return (ctx) -> {

            return new Customer();
        };
    }
}
