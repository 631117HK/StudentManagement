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

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // 1. 年齢が30歳以上の学生（Student）
    public List<Student> getStudentsOver30() {
        return repository.findAll().stream()
                .filter(student -> student.getAge() >= 30)
                .collect(Collectors.toList());
    }

    // 2. Javaコースを受講している学生（StudentsCourses）
    public List<StudentsCourses> getJavaCourseStudents() {
        return repository.searchStudentsCourses().stream()
                .filter(sc -> sc.getCourseName().equalsIgnoreCase("Java"))
                .collect(Collectors.toList());
    }

}
