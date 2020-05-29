package com.company.flywaypostgres.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")

@NamedEntityGraphs({
        @NamedEntityGraph(name = "Employee.min",
                attributeNodes = {
                        @NamedAttributeNode("department")
                }
        ),
        @NamedEntityGraph(name = "Employee.everything",
                attributeNodes = {
                        @NamedAttributeNode("department"),
                        @NamedAttributeNode(value = "projects", subgraph = "project-everything")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "project-everything",
                                attributeNodes = {
                                        @NamedAttributeNode("domain")
                                }
                        )
                }
        )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long empId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dep_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_project", joinColumns = {@JoinColumn(name = "emp_id")}, inverseJoinColumns = {@JoinColumn(name = "prj_id")})
    private Set<Project> projects;
}
