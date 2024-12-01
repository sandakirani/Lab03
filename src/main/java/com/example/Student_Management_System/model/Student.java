package com.example.Student_Management_System.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (name = "first_name",nullable =false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column (name = "email_id", nullable = false , unique=true)
    private String email;
    @Column (name ="Department", nullable = false)
    private String department;
    @Column (name ="Year_Of_Enrollment", nullable = false)
    private int yearsOfEnrollment;


}

