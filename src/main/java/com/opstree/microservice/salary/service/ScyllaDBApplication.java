package com.opstree.microservice.salary.service;

import com.opstree.microservice.salary.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.net.InetSocketAddress;

import org.springframework.beans.factory.annotation.Value;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;

public class ScyllaDBApplication {
        @Value("${scylla.address}")
        private static String address;

        @Value("${scylla.port}")
        private static Integer port;

        @Value("${scylla.keyspace-name}")
        private static String keyspaceName;

        @Value("${scylla.username}")
        private static String username;

        @Value("${scylla.password}")
        private static String password;

        public static List<Employee> getAllEmployeeSalary() {
            List<Employee> employeeList = new ArrayList<>();
            try (CqlSession session = CqlSession.builder().addContactPoint(createSocketAddress("172.17.0.3", 9042)).withAuthCredentials("scylladb", "password").withKeyspace(CqlIdentifier.fromCql("employee_db")).withLocalDatacenter("datacenter1").build()) {
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

        public static InetSocketAddress createSocketAddress(String ipAddress, int port) {
             return new InetSocketAddress(ipAddress, port);
        }
}
