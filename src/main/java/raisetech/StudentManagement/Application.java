package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController

public class Application {

	@Autowired
	private StudentRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// GET: Retrieve student info


	// POST: Update student name and age
	@PostMapping("/student")
	public void registerStudent(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo() {
		Student student = repository.searchByName("kakarot");
		return student.getName() + " " + student.getAge() + "歳";
	}
//		@PatchMapping("/student")
//
//				public void updateStudentName(String name, int age) {
//			repository.updateStudent(name, age);
//		}
	}




