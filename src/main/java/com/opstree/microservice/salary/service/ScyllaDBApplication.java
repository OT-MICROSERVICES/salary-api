package com.opstree.microservice.salary.service;

import com.opstree.microservice.salary.model.Employee;

import java.util.ArrayList;
import java.util.List;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class ScyllaDBApplication {
        public static List<Employee> getAllEmployeeSalary() {
            List<Employee> employeeList = new ArrayList<>();
            try (CqlSession session = CqlSession.builder().build()) {
                String query = String.format("select * from employee_info");
                ResultSet rs = session.execute(query);
                for (Row row : rs.all()) {
                    Employee structure = new Employee();
                    structure.setId(row.getString("id"));
                    structure.setName(row.getString("name"));
                    structure.setSalary(row.getFloat("annual_package"));
                    employeeList.add(structure);
                }
            }
            return employeeList;
        }
}
