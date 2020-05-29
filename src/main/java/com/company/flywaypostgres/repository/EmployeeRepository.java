package com.company.flywaypostgres.repository;

import com.company.flywaypostgres.entity.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @EntityGraph(value = "Employee.min", type = EntityGraph.EntityGraphType.LOAD)
    Set<Employee> findEmployeesWithMinByDepartment_DepId(Long depId);

    @EntityGraph(value = "Employee.everything", type = EntityGraph.EntityGraphType.LOAD)
    Set<Employee> findEmployeesWithEverythingByDepartment_DepId(Long depId);

}
