package com.xyz.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name="contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="contract_id")
    private long contractId;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
}
