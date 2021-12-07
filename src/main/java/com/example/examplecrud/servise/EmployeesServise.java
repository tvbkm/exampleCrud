package com.example.examplecrud.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examplecrud.model.Employees;
import com.example.examplecrud.repository.EmployeesRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeesServise {
    @Autowired
    EmployeesRepository employeesRepository;

    //getting all employees records
    public List<Employees> getAllEmployees() {
        List<Employees> employees = new ArrayList<Employees>();
        employeesRepository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }

    //getting a specific record
    public Employees getEmployeesById(int id) {
        return employeesRepository.findById(id).get();
    }

    public void saveOrUpdate(Employees employees) {
        employeesRepository.save(employees);
    }

    //deleting a specific record
    public void delete(int id) {
        employeesRepository.deleteById(id);
    }
}
