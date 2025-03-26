package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class students_courses {

    private String id;
    private String student_id;
    private String course_name;
    private LocalDateTime course_start_at;
    private LocalDateTime course_end_at;

//    public String getName() {
//        return name;
//    }
//
//    private void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

}