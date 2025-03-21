package io.pragra.learning.springdatajpademo.service;

import io.pragra.learning.springdatajpademo.model.Student;
import io.pragra.learning.springdatajpademo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    InstituteRepo instituteRepo;
    @Autowired
    JobApplicationRepo jobApplicationRepo;


    public Student addStudent(Student student) {
        System.out.println(student.getCourses());
        System.out.println(student.getAddress());

        addressRepo.save(student.getAddress());
        courseRepo.saveAll(student.getCourses());
        instituteRepo.save(student.getInstitute());
        jobApplicationRepo.saveAll(student.getJobApplications());
        return studentRepo.save(student);
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    public List<Student> findStudentsByFirstName(String firstName) {
        return studentRepo.findAllByFName(firstName);
    }

    public List<Student> findStudentsByLastName(String lastName) {
        return studentRepo.findAllByLName(lastName);
    }

    public List<Student> findStudentsByMarks(double marks) {
        return studentRepo.findAllByMarks(marks);
    }

    public Student findStudentByHighestMarks() {
        return studentRepo.findByHighestMarks();
    }

    public Student findStudentBySecondHighestMarks() {
        return studentRepo.findBySecondHighestMarks();
    }

    public List<Student> findAll(){
        return studentRepo.findAll();
    }
}
