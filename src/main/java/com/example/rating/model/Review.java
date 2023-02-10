package com.example.rating.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Data
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Positive(message = "La calificacion debe ser mayor que cero")
    @Column(name = "rating", nullable = false)
    private Double rating;

    @ManyToOne()
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
