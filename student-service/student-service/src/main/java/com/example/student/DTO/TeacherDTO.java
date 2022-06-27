package com.example.student.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


@Data
public class TeacherDTO {
     private int id;
     private String name;
     private int age;
     private String subject;
     @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd:MM:yyyy")
     @Temporal(TemporalType.DATE)
     private Date dateOfJoining;
}