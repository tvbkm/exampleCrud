package com.example.examplecrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.examplecrud.servise.EmployeesServise;
import com.example.examplecrud.model.Employees;

@RestController
public class EmployeesController {
    //autowired the EmployeesService class
    @Autowired
    EmployeesServise employeesServise;

    @GetMapping("/employees")
    private List<Employees> getAllEmployees() {
        return employeesServise.getAllEmployees();
    }

    //creating a get mapping that retrieves the detail of a specific employees
    @GetMapping("/employees/{id}")
    private Employees getEmployees(@PathVariable("id") int id) {
        return employeesServise.getEmployeesById(id);
    }

    //creating a delete mapping that deletes a specific employees
    @DeleteMapping("/employees/{id}")
    private void deleteEmployees(@PathVariable("id") int id) {
        employeesServise.delete(id);
    }

    //creating post mapping that post the employees detail in the database
    @PostMapping("/employees")
    private int saveEmployees(@RequestBody Employees employees) {
        employeesServise.saveOrUpdate(employees);
        return employees.getId();
    }
}
