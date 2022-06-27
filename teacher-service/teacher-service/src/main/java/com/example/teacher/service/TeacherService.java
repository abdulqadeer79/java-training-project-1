package com.example.teacher.service;

import com.example.teacher.model.Teacher;
import com.example.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher createAndUpdateTeacher(Teacher teacher) {
        teacher.setActive(true);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> findAllTeachers() {

        return teacherRepository.findAll()
                .stream()
                .filter(Teacher::isActive)
                .collect(Collectors.toList());
    }

    public Optional<Teacher> findTeacherById(int id) {
        if (teacherRepository.findTeacherById(id).isActive()){
            return teacherRepository.findById(id);
        }
        return Optional.empty();
    }

    public Teacher findTeacherByName(String name) {
        return teacherRepository.findTeacherByName(name);
    }

    public boolean deleteTeacherById(int id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        boolean isDeleted = false;
        if ((teacher != null) && (teacher.isActive())) {
            isDeleted = true;
            teacher.setActive(false);
            teacherRepository.save(teacher);
        }
        return isDeleted;
    }

    public List<Teacher> findTeacherByAgeAndSubject(int age, String subject) {
        return teacherRepository.findTeacherByAgeAndSubject(age, subject);
    }

    public List<Teacher> findTeacherByAge(int age) {
        return teacherRepository.findTeacherByAge(age);
    }
}
