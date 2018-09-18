package com.xyz.portal.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="billing")
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="billing_id")
    private long billingId;


    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private Status status;


    @OneToMany(mappedBy="billing", fetch = FetchType.EAGER)
    private List<Experiment> experimentList;


    public enum Status {
        CREATED,
        SUBMITTED,
        COMPLETE
    }
}
