package com.company.flywaypostgres.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depId;

    @Column(name = "name")
    private String name;
}
