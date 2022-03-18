package com.team12.foodforall.domain;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author: Heng Gao
 * @date: 17/03/2022 :18:50
 **/
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "user name should have at least 2 characters")
    private String name;

    @Email
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @Size(min = 8, message = "password should have at least 8 characters")
    @Size(max = 16, message = "password should have at most 16 characters")
    @NotEmpty(message = "Email is mandatory")
    private String password;

}
