package com.kayroc.jpa.service;

import com.kayroc.jpa.model.Subject;
import com.kayroc.jpa.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void save(Subject subject) {
        subjectRepository.save(subject);
   }
}
