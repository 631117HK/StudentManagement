package raisetech.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/student") // Base path for all student-related APIs

public class Application {

	@Autowired
	private StudentRepository repository;
	private String name = "EnamiKouji";
	private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// GET: Retrieve student info
	@GetMapping("/student")
	public String getStudentInfo(@RequestParam String name) {
		Student student = repository.searchByName("name");
		return student.getName() + " " + student.getAge() + "歳";
	}

	// POST: Update student name and age
	@PostMapping("/student")
	public void registerStudent(@RequestParam String name, @RequestParam int age) {
		repository.registerStudent(name, age);
	}

	// POST: Update only the student name
	@PostMapping("/updateName")
	public void updateStudentName(@RequestParam String name) {
		this.name = name;
	}

	@GetMapping("/studentInfo")
	public String getStudentInfo(){
		//Student student = repository.searchByName("EnamiKouji");
		//return student.getName() + " " + student.getAge() + "歳";
		return name + " " + age + "歳";
	}

    @PostMapping("/studentInfo")
    public void setStudentInfo2(String name, String age) {
		this.name = name;
		this.age = age;
	}

    @PostMapping("/studentName")
	public void updateStudentName2(String name){
			this.name = name;
}
}



