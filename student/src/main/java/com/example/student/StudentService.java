package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        Optional<Student> studentFindByEmail = studentRepo.findStudentByEmail(student.getEmail());
        if (studentFindByEmail.isPresent()) {
            throw new IllegalStateException("Email Token");
        }
        studentRepo.save(student);
    }

    public void updateStudent(Long id, Student student) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentOptional.get().studentUpdateTo(student);
            studentRepo.save(studentOptional.get());
        } else {
            throw new IllegalStateException("Student does not exist");
        }
    }

    public void deleteStudent(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (studentOptional.isPresent()) {
            studentRepo.delete(studentOptional.get());
        } else {
            throw new IllegalStateException("Student does not exist");
        }
    }
}
