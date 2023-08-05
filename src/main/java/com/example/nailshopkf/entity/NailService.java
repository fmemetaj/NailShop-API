package com.example.nailshopkf.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class NailService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @OneToMany(mappedBy = "nailService")
    private List<Appointment> appointments;
}
