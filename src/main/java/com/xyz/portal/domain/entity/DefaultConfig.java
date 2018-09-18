package com.xyz.portal.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name="default_config")
public class DefaultConfig implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="default_config_id")
    private long defaultConfigId;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="value", nullable=false)
    private String value;
}
