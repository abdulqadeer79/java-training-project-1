package com.example.student.FeignService;

import com.example.student.DTO.TeacherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "teacher-api", url = "http://localhost:8081/teachers")
public interface FeignServiceUtility {

    @GetMapping("/name/{teacherName}")
    public ResponseEntity<TeacherDTO> findTeacherByName(@PathVariable String teacherName);

    @GetMapping("/age/{age}")
    public ResponseEntity<List<TeacherDTO>> findTeacherByAge(@PathVariable int age);
}
