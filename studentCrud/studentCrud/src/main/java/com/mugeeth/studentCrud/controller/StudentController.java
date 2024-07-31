package com.mugeeth.studentCrud.controller;

import com.mugeeth.studentCrud.model.Student;
import com.mugeeth.studentCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;
    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED) //201 created will display in postman
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }
    @PutMapping("/students/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student  student = repo.findById(id).get();
        student.setName("prithvi");
        student.setPercentage(97);
        repo.save(student);
        return  student;
    }

    @DeleteMapping("/students/delete/{id}")
    public Student deleteStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
        return student;
    }

}
