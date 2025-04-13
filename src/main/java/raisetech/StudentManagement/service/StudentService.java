package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        // Fetch all students
        List<Student> allStudents = repository.search2();

        // Filter students whose age is in their 30s (30 to 39)
        List<Student> filteredStudents = allStudents.stream()
                .filter(student -> student.getAge() >= 30 && student.getAge() < 40)
                .collect(Collectors.toList());

        // Return the filtered list to the controller
        return filteredStudents;
    }

    public List<StudentsCourses> searchStudentsCoursesList() {
        // Fetch all students' course information
        List<StudentsCourses> allCourses = repository.searchStudentsCourses();

        // Filter for "Java course" only
        List<StudentsCourses> filteredCourses = allCourses.stream()
                .filter(course -> "Java course".equals(course.getCourseName()))
                .collect(Collectors.toList());

        // Return the filtered list to the controller
        System.out.println("Filtered courses ready for controller.");
        return filteredCourses;
    }
}
