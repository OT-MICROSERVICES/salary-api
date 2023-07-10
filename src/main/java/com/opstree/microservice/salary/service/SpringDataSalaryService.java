package com.opstree.microservice.salary.service;

import com.opstree.microservice.salary.model.Employee;
import com.opstree.microservice.salary.repository.EmployeeRepository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Service
@EnableCassandraRepositories(basePackages={"com.opstree.microservice.salary"})
public class SpringDataSalaryService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeSalary(){
        return employeeRepository.findAll();
    }
    public Employee getEmployeeSalary(String id){
        return employeeRepository.findByIdAsString(id);
    }
}
