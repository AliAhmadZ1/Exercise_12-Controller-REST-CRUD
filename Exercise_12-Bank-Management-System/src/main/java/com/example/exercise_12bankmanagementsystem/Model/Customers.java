package com.example.exercise_12bankmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Customers Class : ID , Username , Balance

@Data
@AllArgsConstructor
public class Customers {

    private int id;
    private String username;
    double balance;

}
