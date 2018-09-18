package com.xyz.portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@ToString
@Table(name="project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="project_id")
    private long projectId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;


    @OneToMany(mappedBy="project", fetch=FetchType.EAGER)
    private List<Experiment> experimentList = Collections.emptyList();
}
