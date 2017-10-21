package com.kayroc.jpa;

import com.kayroc.jpa.model.Student;
import com.kayroc.jpa.model.StudentSubject;
import com.kayroc.jpa.model.Subject;

import com.kayroc.jpa.service.StudentService;
import com.kayroc.jpa.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootApplication
public class MyJpaApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyJpaApplication.class);

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(MyJpaApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Student studentD = new Student("David Pham");

        Subject subjectM = new Subject("Math");
        Subject subjectJ = new Subject("Java Programming");

        StudentSubject studentSubjectM = new StudentSubject();
        studentSubjectM.setStudent(studentD);
        studentSubjectM.setSubject(subjectM);
        studentSubjectM.setRegisteredDate(new Date());
        studentD.getStudentSubjects().add(studentSubjectM);
        subjectService.save(subjectM);

        StudentSubject studentSubjectJ = new StudentSubject();
        studentSubjectJ.setStudent(studentD);
        studentSubjectJ.setSubject(subjectJ);
        studentSubjectJ.setRegisteredDate(new Date());
        studentD.getStudentSubjects().add(studentSubjectJ);
        subjectService.save(subjectJ);

        studentService.save(studentD);

        // dump data
        for (StudentSubject ss : studentD.getStudentSubjects()) {
            System.out.println("Student: "+ ss.getStudent().getName());
            System.out.println("Subject: "+ ss.getSubject().getName());
            System.out.println("Registered Date: "+ ss.getRegisteredDate());
        }

    }
}