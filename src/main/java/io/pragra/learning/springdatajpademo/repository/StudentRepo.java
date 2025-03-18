package io.pragra.learning.springdatajpademo.repository;

import io.pragra.learning.springdatajpademo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    // get students by First Name
    List<Student> findAllByFName(String firstName);

    // get Students by last name
    List<Student> findAllByLName(String lastName);

    List<Student> findAllByMarks(double marks);

    // find the student with highest marks
    @Query("SELECT s FROM Student s WHERE s.marks IN (SELECT MAX(marks) from Student)")
    Student findByHighestMarks();

    // find the student with the second highest marks
//    @Query(nativeQuery = true, value = "SELECT s MAX(s.marks) FROM Student s" +
//            "WHERE s.marks < (SELECT MAX(s.marks) from Student s)")
    @Query(nativeQuery = true, value = "SELECT * FROM Student s where s.marks IN (SELECT MAX(marks) from Student WHERE marks < (SELECT MAX(marks) from Student))")
    Student findBySecondHighestMarks();


}
