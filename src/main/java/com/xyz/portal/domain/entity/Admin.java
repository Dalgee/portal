package com.xyz.portal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString
@Table(name="admin", uniqueConstraints={@UniqueConstraint(columnNames="login_id"), @UniqueConstraint(columnNames="email")})
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admin_id")
    private long adminId;

    @Column(name="login_id", nullable=false)
    private String loginId;


    @JsonIgnore
    @Column(name="encrypted_password", nullable=false)
    private String encryptedPassword;


    @Column(name="email", nullable=false)
    private String email;
}
