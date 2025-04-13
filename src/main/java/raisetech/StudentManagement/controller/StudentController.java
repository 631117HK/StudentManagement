package raisetech.StudentManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.service.StudentService;

import java.util.List;


@RestController
public  class StudentController {
    private StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students_coursesList")
    public List<StudentsCourses> getStudentsCoursesList() {
        System.out.println("テスト中");
        return service.searchStudentsCoursesList();
    }

    @GetMapping("/studentList")
    public List<Student> getStudentList() {
        return service.searchStudentList();
    }


}
