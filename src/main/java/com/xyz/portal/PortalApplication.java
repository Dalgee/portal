package com.xyz.portal;

import com.xyz.portal.entity.Contract;
import com.xyz.portal.entity.Customer;
import com.xyz.portal.entity.Experiment;
import com.xyz.portal.entity.Project;
import com.xyz.portal.repository.ContractRepository;
import com.xyz.portal.repository.CustomerRepository;
import com.xyz.portal.repository.ExperimentRepository;
import com.xyz.portal.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortalApplication {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    ExperimentRepository experimentRepository;



    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }


    @Bean
    CommandLineRunner getRunner() {
        return args -> {
            Customer customer1 = new Customer();
            Customer customer2 = new Customer();

            Customer c1 = customerRepository.save(customer1);
            Customer c2 = customerRepository.save(customer2);

            Contract contract1 = new Contract();
            Contract contract2 = new Contract();

            contract1.setCustomer(c1);
            contract2.setCustomer(c2);

            contractRepository.save(contract1);
            contractRepository.save(contract2);

            Project project1 = new Project();
            Project project2 = new Project();
            Project project3 = new Project();
            Project project4 = new Project();

            project1.setCustomer(c1);
            project2.setCustomer(c1);
            project3.setCustomer(c2);
            project4.setCustomer(c2);

            projectRepository.save(project1);
            projectRepository.save(project2);
            projectRepository.save(project3);
            projectRepository.save(project4);

            Experiment experiment1 = new Experiment();
            Experiment experiment2 = new Experiment();
            Experiment experiment3 = new Experiment();
            Experiment experiment4 = new Experiment();


            experiment1.setProject(project1);
            experiment2.setProject(project2);
            experiment3.setProject(project3);
            experiment4.setProject(project4);


            experimentRepository.save(experiment1);
            experimentRepository.save(experiment2);
            experimentRepository.save(experiment3);
            experimentRepository.save(experiment4);
        };
    }
}
