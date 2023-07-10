package com.opstree.microservice.salary.repository;

import com.opstree.microservice.salary.model.Employee;

import java.util.List;
import java.util.UUID;
// import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface EmployeeRepository extends CassandraRepository<Employee, UUID> {
//     @AllowFiltering
//     List<Employee> findAllSalary();
}
