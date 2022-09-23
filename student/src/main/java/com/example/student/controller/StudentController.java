package com.example.student.controller;

import com.example.student.Student;
import com.example.student.StudentRepo;
import com.example.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(path = "student")
public class StudentController {
    private final StudentService studentService;
    private final StudentRepo studentRepo;

    @Autowired
    public StudentController(StudentService studentService, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    //    @GetMapping("/getStudent")
//    public List<Student> getStudent() {
//        return studentService.getStudent();
//    }
//
    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
//
//    @PutMapping("/updateStudent/{id}")
//    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
//        studentService.updateStudent(id, student);
//    }
//
//    @DeleteMapping("/deleteStudent/{id}")
//    public void updateStudent(@PathVariable Long id) {
//        studentService.deleteStudent(id);
//    }
    @GetMapping("/something")
    String Hello(Model model) {
        model.addAttribute("test", "Hello");
        model.addAttribute("students", Arrays.asList(
                new Student("Long", "Long@gmail.com"),
                new Student("Len", "Len@gmail.com")

        ));
        return "student";
    }
}
