package com.opstree.microservice.salary.model;

import java.time.LocalDate;
import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("employee_salary")
public class Employee implements Serializable {

    @Id
    @PrimaryKey
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("salary")
    private Float salary;

    @Column("process_date")
    private String processDate;

    @Column("status")
    private String status;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getSalary() {
        return salary;
    }

    public String getProcessDate() {
        return processDate;
    }

    public String getStatus() {
        return status;
    }
}
