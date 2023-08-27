package com.studentmark.studentmark.controller;

import com.studentmark.studentmark.dto.StudentDTO;
import com.studentmark.studentmark.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/student")
@CrossOrigin

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public List<StudentDTO> getStudent(){
        return studentService.getAllStudent();
    }

    @PostMapping("/saveStudent")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        return studentService.saveStudent(studentDTO);
    }

    @PutMapping("/updateStudent")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }

//    @DeleteMapping("/deleteStudent/{id}")
//    public boolean deleteStudent(@PathVariable Integer id)
//    {
//        return studentService.deleteStudent(id);
//
//    }
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
        boolean deleted = studentService.deleteStudentById(id);

        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully");
        } else {
//            return ResponseEntity.notFound().build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student id not found");
        }
    }
}
