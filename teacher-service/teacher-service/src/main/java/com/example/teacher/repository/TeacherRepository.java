package com.example.teacher.repository;

import com.example.teacher.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.example.teacher.repository.TeacherRepositoryUtility.*;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    @Query(value = FIND_TEACHER_BY_NAME_QUERY, nativeQuery = true)
    Teacher findTeacherByName(@Param("name") String name);

    @Query(value = FIND_TEACHER_BY_AGE_AND_SUBJECT_QUERY, nativeQuery = true)
    List<Teacher> findTeacherByAgeAndSubject(@Param("age") int age, @Param("subject") String subject);

    @Query(value = FIND_TEACHER_BY_AGE_QUERY, nativeQuery = true)
    List<Teacher> findTeacherByAge(@Param("age") int age);

}
