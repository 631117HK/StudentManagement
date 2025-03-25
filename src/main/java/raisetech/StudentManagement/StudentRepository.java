package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

@Mapper
public interface StudentRepository {

    @Select("SELECT * FROM students_courses WHERE name = #{name}")
    Student search(String name);

    @Insert("INSERT INTO students_courses (name, age) VALUES (#{name}, #{age})")
    void registerStudent(String name, int age);

    @Update("UPDATE students_courses SET age = #{age} WHERE name = #{name}")
    void updateStudent(String name, int age);

    // Corrected method for retrieving student data
    @Select("SELECT * FROM students_courses")
    List<students_courses> getStudentList();

    @Insert("INSERT INTO students_courses (student_id, course_name, course_start_at, course_end_at) VALUES (#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    void registerCourse(int studentId, String courseName, String courseStartAt, String courseEndAt);

    @Select("SELECT * FROM students_courses")
    List<students_courses> searchAll();

    Student searchByName(String kakarot);
}