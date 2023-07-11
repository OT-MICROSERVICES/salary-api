package com.opstree.microservice.salary.repository;

import com.opstree.microservice.salary.model.Employee;

import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

public interface EmployeeRepository extends CassandraRepository<Employee, UUID> {

    @Query("SELECT * FROM employee_salary WHERE id = ?0")
    Employee findByIdAsString(String id);
}
