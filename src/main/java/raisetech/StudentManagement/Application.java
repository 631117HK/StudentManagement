package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;
import raisetech.StudentManagement.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
public class Application {


	private Application repository;

	// Endpoint to register a new student
	@PostMapping("/students")
	public void registerStudent(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);
	}

	// Endpoint to add a new student-course record
	@PostMapping("/students_courses")
	public void addCourse(
			@RequestParam int studentId,
			@RequestParam String courseName,
			@RequestParam String courseStartAt,
			@RequestParam String courseEndAt) {
		repository.registerCourse(studentId, courseName, courseStartAt, courseEndAt);
	}

	private void registerCourse(int studentId, String courseName, String courseStartAt, String courseEndAt) {

	}

	// Endpoint to get specific student information
	@GetMapping("/students")
	public String getStudentInfo() {
		Student student = repository.searchByName("kakarot");
		if (student == null) {
			return "Student not found.";
		}
		return student.getName() + " " + student.getAge() + "歳";
	}

	private Student searchByName(String kakarot) {
		return null;
	}

	// Endpoint to retrieve all student-course records
	@GetMapping("/students_coursesList")
	public List<StudentsCourses> getstudents_CoursesList() {
		System.out.println("テスト中");
		return repository.searchStudentsCourses();
	}

	private List<StudentsCourses> searchStudentsCourses() {
		return null;
	}

	@GetMapping("/studentList")
	public List<Student> getStudentList() {
		return repository.search2();
	}

	private List<Student> search2() {

        return List.of();
    }

	public void setRepository(Application repository) {
        this.repository = repository;
    }
}

