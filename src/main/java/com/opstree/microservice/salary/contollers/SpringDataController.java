package com.opstree.microservice.salary.controller;

import com.opstree.microservice.salary.service.SpringDataSalaryService;
import com.opstree.microservice.salary.model.Employee;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Salary API", description = "Management APIs for all salary related transaction")
@RestController
@RequestMapping("/api/v1/salary")
@RequiredArgsConstructor
public class SpringDataController {

    @Autowired
    SpringDataSalaryService springDataSalaryService;

    @Operation(summary = "Retrieve all employee salary information", tags = {})
    @ApiResponses({@ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json") })})
    @GetMapping("/search/all")
    public ResponseEntity<List<Employee>> getAllEmployeeSalary() {
        try {
            return new ResponseEntity<>(springDataSalaryService.getAllEmployeeSalary(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(
      summary = "Retrieve a Salary by Employee Id",
      description = "Get a salary object by specifying its id. The response is Tutorial object with id, name, salary.",
      tags = {})
    @ApiResponses({@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Employee.class), mediaType = "application/json") })})
    @GetMapping("/search")
    public ResponseEntity<Employee> findSalary(@RequestParam("id") String id) {
        try {
            return new ResponseEntity<>(springDataSalaryService.getEmployeeSalary(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
