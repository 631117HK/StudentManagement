package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private StudentRepository repository; // Repository for database operations

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

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

	// Endpoint to get specific student information
	@GetMapping("/students")
	public String getStudentInfo() {
		Student student = repository.searchByName("kakarot");
		if (student == null) {
			return "Student not found.";
		}
		return student.getName() + " " + student.getAge() + "歳";
	}

	// Endpoint to retrieve all student-course records
	@GetMapping("/students_courses")
	public List<students_courses> getAllCourses() {
		System.out.printf("テスト中");
		return repository.searchAll();
	}
}

