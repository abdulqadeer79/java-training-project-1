package com.example.student.repository;

public class StudentRepositoryUtility {
    static final String FIND_STUDENT_BY_AGE_QUERY = "SELECT * FROM student WHERE age = :age";
    static final String FIND_STUDENT_BY_HOBBY_QUERY = "SELECT * FROM student WHERE hobby = :hobby";
    static final String FIND_STUDENT_BY_TEACHER_ID_QUERY = "SELECT * FROM student WHERE teacher_id = :teacherId";
    static final String FIND_STUDENT_BY_DATE_OF_BIRTH_QUERY = "SELECT * FROM student WHERE date_of_birth LIKE %:dateOfBirth%";
}
