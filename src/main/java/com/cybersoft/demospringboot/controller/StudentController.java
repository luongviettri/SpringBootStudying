package com.cybersoft.demospringboot.controller;

import com.cybersoft.demospringboot.model.AccountModel;
import com.cybersoft.demospringboot.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<StudentModel> students = new ArrayList<>();

    @PostMapping("/{name}/{age}")
    public ResponseEntity<?> insertStudentByPathVariables(
            @PathVariable String name,
              @PathVariable int age
    ){
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);
        students.add(studentModel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> insertStudentByRequestParam(
            @RequestParam String name,
            @RequestParam int age
    ){
        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);

        students.add(studentModel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<?> insertStudentByRequestBody(
            @RequestBody StudentModel studentModel
    ){
        students.add(studentModel);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


}
