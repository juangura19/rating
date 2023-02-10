package com.example.rating.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 3, message = "Titulo debe tener minimo 2 caracteres")
    @Column(name="title", nullable = false, length = 100)
    private String title;

    @Column(name = "rating", insertable = false, updatable = false)
    private Double rating;
}
