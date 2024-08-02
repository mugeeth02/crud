package com.mugeeth.employeeCrud.repository;

import com.mugeeth.employeeCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
