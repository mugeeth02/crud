package com.mugeeth.studentCrud.repository;

import com.mugeeth.studentCrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
