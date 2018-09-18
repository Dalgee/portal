package com.xyz.portal.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long customerId;


    @Column(name="login_id", nullable=false)
    private String loginId;


    @Column(name="encryped_password", nullable=false)
    private String encryptedPassword;


    @Column(name="email", nullable=false)
    private String email;


    @Column(name="email_verified", nullable=false)
    private boolean emailVerified;


    @Column(name="phone_number")
    private String phoneNumber;


    @OneToOne(mappedBy="customer")
    private Contract contract;


    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    private List<Project> projectList;
}
