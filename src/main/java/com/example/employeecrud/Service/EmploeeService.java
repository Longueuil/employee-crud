package com.example.employeecrud.Service;

import com.example.employeecrud.entity.Employee;

import java.util.List;

public interface EmploeeService {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);

}
