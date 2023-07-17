package com.opstree.microservice.salary.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployeeGettersAndSetters() {
        // Create a sample Employee object
        Employee employee = new Employee();
        String id = "123";
        String name = "John Doe";
        Float salary = 5000.0f;
        String processDate = "2023-07-17";
        String status = "Active";

        // Set values using setters
        employee.setId(id);
        employee.setName(name);
        employee.setSalary(salary);
        employee.setProcessDate(processDate);
        employee.setStatus(status);

        // Check if the values are correctly set using getters
        assertEquals(id, employee.getId());
        assertEquals(name, employee.getName());
        assertEquals(salary, employee.getSalary());
        assertEquals(processDate, employee.getProcessDate());
        assertEquals(status, employee.getStatus());
    }
}
