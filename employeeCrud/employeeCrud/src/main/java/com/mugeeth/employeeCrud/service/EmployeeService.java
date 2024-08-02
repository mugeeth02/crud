package com.mugeeth.employeeCrud.service;

import com.mugeeth.employeeCrud.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    //create,getemp,getempId,update,delete
    public Employee createEmp(Employee emp);
    public List<Employee> getEmployees();
    public Employee getEmpByID(int id);
    public Employee updateEmp(Employee emp,int id);
    public void deleteEmp(int id);
}
