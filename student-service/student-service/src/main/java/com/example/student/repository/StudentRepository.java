package com.example.student.repository;

import com.example.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.example.student.repository.StudentRepositoryUtility.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = FIND_STUDENT_BY_AGE_QUERY, nativeQuery = true)
    public List<Student> findStudentByAge(@Param("age") int age);

    @Query(value = FIND_STUDENT_BY_HOBBY_QUERY, nativeQuery = true)
    public List<Student> findStudentByHobby(@Param("hobby") String hobby);

    @Query(value = FIND_STUDENT_BY_TEACHER_ID_QUERY, nativeQuery = true)
    public List<Student> findStudentByTeacherId(@Param("teacherId") int teacherId);

}

