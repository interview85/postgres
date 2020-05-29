package com.company.flywaypostgres.service;

import com.company.flywaypostgres.entity.Employee;
import com.company.flywaypostgres.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Set<Employee> findEmployeesWithMinByDepartment_DepId(Long depId) {
        return employeeRepository.findEmployeesWithMinByDepartment_DepId(depId);
    }

    @Transactional(readOnly = true)
    public Set<Employee> findEmployeesWithEverythingByDepartment_DepId(Long depId) {
        return employeeRepository.findEmployeesWithEverythingByDepartment_DepId(depId);
    }
}
