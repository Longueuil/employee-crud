package com.example.employeecrud.Controllers;

import com.example.employeecrud.DAO.EmployeeDAO;
//import com.example.employeecrud.Service.EmployeeService;
import com.example.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeDAO.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found " + employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        theEmployee.setId(0);
        employeeDAO.save(theEmployee);
        return  theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeDAO.save(theEmployee);
        return  theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeDAO.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id is not found" + employeeId);
        }
        employeeDAO.deleteById(employeeId);
        return  employeeId + " Deleted";
    }

}
