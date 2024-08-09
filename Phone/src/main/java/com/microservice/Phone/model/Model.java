package com.microservice.Phone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String colour;
    private Integer ram;
    private Integer storage;
    private Double frontCamera;
    private Double rearCamera;
    private Double price;

    @ManyToOne
    @JoinColumn
    private Brand brand;
}
