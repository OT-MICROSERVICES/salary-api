package com.opstree.microservice.salary.controller;

import com.opstree.microservice.salary.service.SpringDataSalaryService;
import com.opstree.microservice.salary.model.Employee;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/salary")
@RequiredArgsConstructor
public class SpringDataController {

    @Autowired
    private final SpringDataSalaryService springDataSalaryService;

    @GetMapping("/search/all")
    public List<Employee> getAllEmployeeSalary() {
        return springDataSalaryService.getAllEmployeeSalary();
    }

    @GetMapping("/search")
    public String findSalary(@RequestParam("id") String id) {
        return "Hello World from " + id;
    }
}
