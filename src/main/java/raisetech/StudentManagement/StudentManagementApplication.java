package raisetech.StudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	private String name = "Enami Kouji";
	private String age = "37";
	private Map<String, String> Student;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentinfo")
	public String getStudentinfo() {
		return name + " " + age + "歳";
	}

	//GET POST
	//GETは取得する,リクエストの結果を受け取る
	//POSTは情報を与える、渡す
	@PostMapping("/name")
	public void setStudentinfo(String name, String age) {
		this.name = name;
		this.age = age;
	}

	@PostMapping("/StudentName")
	public void updateStudentName(String name) {
		this.name = name;
		}
	}

