package com.example.student.controller;


import com.example.student.DTO.TeacherDTO;
import com.example.student.FeignService.FeignServiceUtility;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private FeignServiceUtility feignServiceUtility;



    // POST methods
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student myStudent = studentService.createAndUpdateStudent(student);
        return new ResponseEntity<Student>(myStudent, HttpStatus.CREATED);
    }

    // GET methods
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> findStudentById(@PathVariable int id) {
        Optional<Student> myStudent = studentService.findStudentById(id);
        if (myStudent.isPresent()) {
            return new ResponseEntity<Optional<Student>>(myStudent, HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> studentList = studentService.findAllStudents();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }


    @GetMapping("/age/{age}")
    public ResponseEntity<List<Student>> findStudentByAge(@PathVariable int age) {
        List<Student> studentList = studentService.findStudentByAge(age);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
    }


    @GetMapping("/hobby/{hobby}")
    public ResponseEntity<List<Student>> findStudentByHobby(@PathVariable String hobby) {
        List<Student> studentList = studentService.findStudentByHobby(hobby);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
    }

    @GetMapping("/teacher/name/{teacherName}")
    public ResponseEntity<List<Student>> findStudentByTeacherName(@PathVariable String teacherName) {
        ResponseEntity<TeacherDTO> myTeacher = feignServiceUtility.findTeacherByName(teacherName);
        int teacherId = myTeacher.getBody().getId();
        System.out.println(teacherId);
        List<Student> studentList = studentService.findStudentByTeacherId(teacherId);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
    }

    @GetMapping("/teacher/age/{age}")
    public ResponseEntity<StudentTeacherResponseVO> findStudentTeacherByAge(@PathVariable int age) {
        List<TeacherDTO> teacherList = feignServiceUtility.findTeacherByAge(age).getBody();
        List<Student> studentList = studentService.findStudentByAge(age);
        StudentTeacherResponseVO studentTeacherResponseVO = new StudentTeacherResponseVO();
        studentTeacherResponseVO.studentList = studentList;
        studentTeacherResponseVO.teacherList = teacherList;
        return new ResponseEntity<StudentTeacherResponseVO>(studentTeacherResponseVO, HttpStatus.OK);
    }


    @GetMapping(value = "/date/before")
    public ResponseEntity<List<Student>> findStudentBeforeADateOfBirth(@DateTimeFormat(pattern = "dd:MM:yyyy") @RequestParam(value = "date") Date dateOfBirth) {
        List<Student> studentList = studentService.findStudentBeforeADateOfBirth(dateOfBirth);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
    }

    @GetMapping(value = "/date/after")
    public ResponseEntity<List<Student>> findStudentAfterADateOfBirth(@DateTimeFormat(pattern = "dd:MM:yyyy") @RequestParam(value = "date") Date dateOfBirth) {
        List<Student> studentList = studentService.findStudentAfterADateOfBirth(dateOfBirth);
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.FOUND);
    }

    // PUT methods
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        Student myStudent = studentService.createAndUpdateStudent(student);
        return new ResponseEntity<Student>(myStudent, HttpStatus.ACCEPTED);
    }

    // DELETE methods
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("student deleted", HttpStatus.OK);
    }




}



