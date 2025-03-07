package com.example.exercise_12tasktrackersystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

//Task Class : ID , title , description , status

@Data
@AllArgsConstructor
public class Task {

    private int id;
    private String title;
    private String description;
    private boolean status;

}
