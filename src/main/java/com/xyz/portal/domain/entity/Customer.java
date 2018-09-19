package com.xyz.portal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="customer", uniqueConstraints={@UniqueConstraint(columnNames="login_id"), @UniqueConstraint(columnNames="email")})
public class Customer implements Serializable {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private long customerId;


    @Column(name="login_id", nullable=false)
    private String loginId;


    @JsonIgnore
    @Column(name="encrypted_password", nullable=false)
    private String encryptedPassword;


    @Column(name="email", nullable=false)
    private String email;


    @JsonIgnore
    @Column(name="email_verified", nullable=false)
    private boolean emailVerified;


    @JsonIgnore
    @Column(name="email_verify_url")
    private String emailVerifyLink;


    @Column(name="created_date", nullable=false)
    private Date createdDate;


    @Column(name="last_login_date", nullable=false)
    private Date lastLoginDate;


    @JsonIgnore
    @Column(name="phone_number")
    private String phoneNumber;


    @JsonIgnore
    @OneToOne(mappedBy="customer", fetch=FetchType.EAGER)
    private Contract contract;


    @JsonIgnore
    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    private List<Project> projectList;
}
