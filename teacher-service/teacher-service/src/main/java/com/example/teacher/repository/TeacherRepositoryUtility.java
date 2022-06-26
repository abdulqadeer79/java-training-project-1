package com.example.teacher.repository;

public class TeacherRepositoryUtility {

    static final String FIND_TEACHER_BY_NAME_QUERY = "SELECT * FROM teacher WHERE name = :name";
    static final String FIND_TEACHER_BY_AGE_AND_SUBJECT_QUERY = "SELECT * FROM teacher WHERE age = :age AND subject = :subject";
    static final String FIND_TEACHER_BY_AGE_QUERY = "SELECT * FROM teacher WHERE age = :age";
}
