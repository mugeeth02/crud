package com.mugeeth.employeeCrud.controller;

import com.mugeeth.employeeCrud.entity.Employee;
import com.mugeeth.employeeCrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee saveEmployee(@RequestBody Employee emp){
        Employee saveEmployee = service.createEmp(emp);
        return saveEmployee;
    }

    @GetMapping("/getallemps")
    public List<Employee> getEmps(Employee emp){
        List<Employee> getEmps = service.getEmployees();
        return getEmps;

        return service.getEmployees();
    }
    @GetMapping("getemp/{id}")
    public Employee getEmpById(@PathVariable int id){
        Employee empByID = service.getEmpByID(id);
        return empByID;
    }

    @PutMapping("update/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee emp){
        Employee employee = service.updateEmp(emp,id);
        return employee;
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(code= HttpStatus.OK)
    public String deleteEmployee(@PathVariable int id){
        service.deleteEmp(id);
        return "Employee Deleted Successfully";
    }
}
