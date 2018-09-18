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
@Table(name="billing")
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="billing_id")
    private long billingId;


    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=false)
    private Status status = Status.SUBMITTED;


    @OneToMany(mappedBy="billing", fetch = FetchType.EAGER)
    private List<Experiment> experimentList = Collections.emptyList();


    public enum Status {
        SUBMITTED,
        COMPLETE
    }
}
