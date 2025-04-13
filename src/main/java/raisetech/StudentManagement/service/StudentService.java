package raisetech.StudentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentService service) {
        this.repository = repository;
    }

    public List<Student> searchStudentList() {
        // You can perform additional processing here if needed.
        return repository.search2();
    }

    private List<Student> searchList() {
    return repository.search()
    }

    public List<StudentsCourses> searchStudentsCoursesList() {
        System.out.println("テスト中");
        return repository.searchStudentsCourses();
    }
}