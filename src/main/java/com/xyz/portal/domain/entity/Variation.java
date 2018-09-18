package com.xyz.portal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
@Table(name="variation")
public class Variation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="variation_id")
    private long variationId;


    @Column(name="name", nullable=false)
    private String name;


    @Column(name="ratio", nullable=false)
    private int ratio;


    @Column(name="metadata", nullable=false)
    private String metadata;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="experiment_id", nullable=false)
    private Experiment experiment;
}
