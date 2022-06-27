package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return studentRepository.findByTeacherId(teacherId);
    }

    public List<Student> findStudentAfterADateOfBirth(Date dateOfBirth) {
        List<Student> studentList = studentRepository.findAll();
        List<Student> newStudentList = new ArrayList<>();
        for (Student s: studentList) {
            if (dateOfBirth.before(s.getDateOfBirth())) {
                newStudentList.add(s);
            }
        }
        System.out.println(newStudentList);
        return newStudentList;
    }

    public List<Student> findStudentBeforeADateOfBirth(Date dateOfBirth) {
        List<Student> studentList = studentRepository.findAll();
        List<Student> newStudentList = new ArrayList<>();
        for (Student s: studentList) {
            if (dateOfBirth.after(s.getDateOfBirth())) {
                newStudentList.add(s);
            }
        }
        System.out.println(newStudentList);
        return newStudentList;
    }
}
