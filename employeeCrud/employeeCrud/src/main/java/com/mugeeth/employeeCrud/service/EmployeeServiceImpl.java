package com.mugeeth.employeeCrud.service;

import com.mugeeth.employeeCrud.entity.Employee;
import com.mugeeth.employeeCrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository repo;
    @Override
    public Employee createEmp(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmpByID(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmp(Employee emp, int id) {
        Employee oldEmp = repo.findById(id).orElse(null);

//        oldEmp.setId(emp.getId());
        oldEmp.setName(emp.getName());
        oldEmp.setSalary(emp.getSalary());
        oldEmp.setMail(emp.getMail());
        repo.save(oldEmp);

        return oldEmp;
    }

    @Override
    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
