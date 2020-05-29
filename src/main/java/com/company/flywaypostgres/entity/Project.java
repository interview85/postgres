package com.company.flywaypostgres.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prjId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dom_id")
    private Domain domain;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = {@JoinColumn(name = "prj_id") }, inverseJoinColumns = { @JoinColumn(name = "emp_id")})
    private Set<Employee> employees;
}
