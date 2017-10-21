package com.kayroc.jpa.service;

import com.kayroc.jpa.model.Student;
import com.kayroc.jpa.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudentSubjects() {
        return studentRepository.findAll();
    }
}

