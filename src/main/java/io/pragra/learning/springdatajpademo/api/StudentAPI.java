package io.pragra.learning.springdatajpademo.api;

import io.pragra.learning.springdatajpademo.model.Student;
import io.pragra.learning.springdatajpademo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentAPI {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentService.addStudent(student);
    }

    @GetMapping("/getById")
    public Optional<Student> getStudent(@RequestParam Integer id) {
        return studentService.getStudentById(id);
    }
}
