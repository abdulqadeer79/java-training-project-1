package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createAndUpdateStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findStudentByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> findStudentByHobby(String hobby) {
        return studentRepository.findStudentByHobby(hobby);
    }

    public List<Student> findStudentByTeacherId(int teacherId) {
        return studentRepository.findStudentByTeacherId(teacherId);
    }

    public List<Student> findStudentByDateOfBirth(Date dateOfBirth) {
        return studentRepository.findStudentByDateOfBirth(dateOfBirth);
    }
}
