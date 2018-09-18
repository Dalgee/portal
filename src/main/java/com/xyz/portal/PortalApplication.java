package com.xyz.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PortalApplication {

//    @Autowired
//    DefaultConfigRepository defaultConfigRepository;
//
//    @Autowired
//    CustomerRepository customerRepository;
//
//    @Autowired
//    ContractRepository contractRepository;
//
//    @Autowired
//    ProjectRepository projectRepository;
//
//    @Autowired
//    ExperimentRepository experimentRepository;
//
//    @Bean
//    CommandLineRunner getRunner() {
//        return args -> {
//            DefaultConfig config1 = new DefaultConfig();
//            DefaultConfig config2 = new DefaultConfig();
//
//            config1.setName("timeout");
//            config1.setValue("1000");
//
//            config2.setName("visitor");
//            config2.setValue("100000");
//
//            defaultConfigRepository.save(config1);
//            defaultConfigRepository.save(config2);
//
//
//            Customer customer1 = new Customer();
//            Customer customer2 = new Customer();
//
//            customer1.setEmail("email01");
//            customer2.setEmail("email02");
//
//            customer1.setEncryptedPassword("pass1");
//            customer2.setEncryptedPassword("pass2");
//
//            customer1.setLoginId("id1");
//            customer2.setLoginId("id2");
//
//            customer1.setEmailVerified(false);
//            customer2.setEmailVerified(false);
//
//            Customer c1 = customerRepository.save(customer1);
//            Customer c2 = customerRepository.save(customer2);
//
//            Contract contract1 = new Contract();
//            Contract contract2 = new Contract();
//
//            contract1.setCustomer(c1);
//            contract2.setCustomer(c2);
//
//            contractRepository.save(contract1);
//            contractRepository.save(contract2);
//
//            Project project1 = new Project();
//            Project project2 = new Project();
//            Project project3 = new Project();
//            Project project4 = new Project();
//
//            project1.setCustomer(c1);
//            project2.setCustomer(c1);
//            project3.setCustomer(c2);
//            project4.setCustomer(c2);
//
//            projectRepository.save(project1);
//            projectRepository.save(project2);
//            projectRepository.save(project3);
//            projectRepository.save(project4);
//
//            Experiment experiment1 = new Experiment();
//            Experiment experiment2 = new Experiment();
//            Experiment experiment3 = new Experiment();
//            Experiment experiment4 = new Experiment();
//
//            experiment1.setProject(project1);
//            experiment1.setStatus(Experiment.Status.READY);
//            experiment1.setCreatedDate(new Date());
//            experiment1.setTimeoutDate(new Date());
//
//            experiment2.setProject(project2);
//            experiment2.setStatus(Experiment.Status.READY);
//            experiment2.setCreatedDate(new Date());
//            experiment2.setTimeoutDate(new Date());
//
//            experiment3.setProject(project3);
//            experiment3.setStatus(Experiment.Status.READY);
//            experiment3.setCreatedDate(new Date());
//            experiment3.setTimeoutDate(new Date());
//
//            experiment4.setProject(project4);
//            experiment4.setStatus(Experiment.Status.READY);
//            experiment4.setCreatedDate(new Date());
//            experiment4.setTimeoutDate(new Date());
//
//
//            experimentRepository.save(experiment1);
//            experimentRepository.save(experiment2);
//            experimentRepository.save(experiment3);
//            experimentRepository.save(experiment4);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
