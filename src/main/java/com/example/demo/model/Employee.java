package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable { // Serializable helps to transform this java class into deffent types of stream (json ..)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable=false , updatable=false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable=false,updatable=false)
    private String employeeCode;
}
