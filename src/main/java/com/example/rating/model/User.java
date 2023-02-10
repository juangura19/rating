package com.example.rating.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, message = "Usuario debe tener minimo 3 digitos")
    @Column(name = "user", nullable = false, length = 50)
    private String user;

}
