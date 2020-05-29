package com.company.flywaypostgres.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domId;

    @Column(name = "name")
    private String name;
}
