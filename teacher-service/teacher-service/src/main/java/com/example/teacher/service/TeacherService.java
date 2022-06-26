package com.example.teacher.service;

import com.example.teacher.model.Teacher;
import com.example.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createAndUpdateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findTeacherById(int id) {
        return teacherRepository.findById(id);
    }

    public Teacher findTeacherByName(String name) {
        return teacherRepository.findTeacherByName(name);
    }

    public void deleteTeacherById(int id) {
        teacherRepository.deleteById(id);
    }

    public List<Teacher> findTeacherByAgeAndSubject(int age, String subject) {
        return teacherRepository.findTeacherByAgeAndSubject(age, subject);
    }

    public List<Teacher> findTeacherByAge(int age) {
        return teacherRepository.findTeacherByAge(age);
    }
}
