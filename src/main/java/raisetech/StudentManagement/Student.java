package raisetech.StudentManagement;

import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;
import org.apache.ibatis.annotations.Mapper;

@Getter
@Setter

public class Student {


    private String name;
    private int age;
    private String id;
    private String sex;
    private String email;
    private String kanaName;
    private String nickname;

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
    //test//
}

