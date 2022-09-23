package com.example.student;
import lombok.Data;
import javax.persistence.*;
@Entity(name = "Student")
@Table
@Data
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_SEQUENCE",
            sequenceName = "student_SEQUENCE",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_SEQUENCE"

    )
    private Long id;
    private String name;
    private String email;


    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
    void studentUpdateTo(Student student){
        this.name = student.getName();
        this.email = student.getEmail();
    }
}
