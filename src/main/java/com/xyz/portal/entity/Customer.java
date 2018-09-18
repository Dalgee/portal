package com.xyz.portal.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="customer_id")
    private long customerId;

    @OneToOne(mappedBy="customer")
    private Contract contract;

    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    private List<Project> projectList = Collections.emptyList();
}
