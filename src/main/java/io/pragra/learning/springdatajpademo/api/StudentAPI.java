package io.pragra.learning.springdatajpademo.api;

import io.pragra.learning.springdatajpademo.model.Student;
import io.pragra.learning.springdatajpademo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getByFname")
    public List<Student> getStudentsByFName(@RequestParam String fName) {
        return studentService.findStudentsByFirstName(fName);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/getByLname/{lName}")
    public List<Student> getStudentsByLname(@PathVariable String lName) {
        return studentService.findStudentsByLastName(lName);
    }
    @GetMapping("/getByMarks/{marks}")
    public List<Student> getStudentsByMArks(@PathVariable double marks) {
        return studentService.findStudentsByMarks(marks);
    }

    @GetMapping("/getByHighestMarks")
    public Student getStudentsByHighestMarks() {
        return studentService.findStudentByHighestMarks();
    }

    @GetMapping("/getBySecondHighestMarks")
    public Student getStudentBySecondHighestMarks() {
        return studentService.findStudentBySecondHighestMarks();
    }
}
