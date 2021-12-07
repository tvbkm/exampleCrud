package com.example.examplecrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.examplecrud.model.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
}
