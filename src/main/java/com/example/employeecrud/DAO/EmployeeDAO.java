package com.example.employeecrud.DAO;


import com.example.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
