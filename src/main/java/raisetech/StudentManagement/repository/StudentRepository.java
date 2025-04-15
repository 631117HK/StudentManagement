package raisetech.StudentManagement.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

import java.util.Collection;
import java.util.List;
/**受講生を扱うリポジトリ
  *
  *　全体検索や単一条件での検索、コース情報の検索が行えるクラスです。
  *
  */

@Mapper
public interface StudentRepository {
    /**
      *
      * @return 全件検索した受講生情報の一覧
      *
      */
    @Select("SELECT * FROM students")
    List<Student> search2();

    @Select("SELECT * FROM students_courses WHERE name = #{name}")
    Student search(String name);

    @Insert("INSERT INTO students_courses (name, age) VALUES (#{name}, #{age})")
    void registerStudent(String name, int age);

    @Update("UPDATE students_courses SET age = #{age} WHERE name = #{name}")
    void updateStudent(String name, int age);

    // Corrected method for retrieving student data
    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> getStudentList();

    @Insert("INSERT INTO students_courses (student_id, course_name, course_start_at, course_end_at) VALUES (#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    void registerCourse(int studentId, String courseName, String courseStartAt, String courseEndAt);

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchAll();

    Student searchByName(String kakarot);

    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudentsCourses();

    List<Student> search();

    List<Student> findAll();
}