package com.spring.testing.controller;

import com.spring.testing.model.Student;
import com.spring.testing.model.StudentDto;
import com.spring.testing.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentDto> createStudent(Student student){
    return     ResponseEntity.ok(studentService.createStudent(student));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentDto>>  getAllStudent(){
        return    ResponseEntity.ok(studentService.getAllStudent());
    }
    @DeleteMapping("/delete")
    public ResponseEntity  deleteStudent(Long id){
        studentService.deleteStudent(id);
       return ResponseEntity.ok().build();
    }
    @PostMapping("/edit")
    public ResponseEntity<StudentDto> editStudent(Student student){
        return    ResponseEntity.ok(studentService.editStudent(student));
    }
    @GetMapping("/get")
    public ResponseEntity<StudentDto> getStudentById(Long id){
        return      ResponseEntity.ok(studentService.getStudentById(id));
    }

}
