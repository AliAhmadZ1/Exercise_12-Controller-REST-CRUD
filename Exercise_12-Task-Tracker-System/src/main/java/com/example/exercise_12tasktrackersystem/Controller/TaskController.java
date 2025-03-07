package com.example.exercise_12tasktrackersystem.Controller;

import com.example.exercise_12tasktrackersystem.ApiResponse.ApiResponse;
import com.example.exercise_12tasktrackersystem.Model.Task;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/v1/task-tracker")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    //GET - POST - PUT - DELETE

    //Display all tasks.
    @GetMapping("/display")
    public ArrayList<Task> displayTasks(){
        return tasks;
    }

    //Create a new task (title , description , status)
    @PostMapping("/create-task")
    public ApiResponse addTask(@RequestBody Task task){
        tasks.add(task);
        return new ApiResponse("The task Added Successfully");
    }

    //Update a task
    @PutMapping("/update-task/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task){
        tasks.set(index,task);
        return new ApiResponse("The task is updated successfully!");
    }


    //Delete a task
    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("Task is deleted!!");
    }


    //Change the task status as done or not done
    @PutMapping("/change-status/{index},{done}")
    public ApiResponse changeStatus(@PathVariable int index,@PathVariable boolean done){
        if (done) {
//            tasks.get(index) = ;
            tasks.get(index).setStatus(done);
            return new ApiResponse("the task is done");
        }
        else {
            tasks.get(index).setStatus(done);
            return new ApiResponse("the task is not done");
        }
    }


    //Search for a task by given title
    @GetMapping("/search/{title}")
    public ApiResponse searchTask(@PathVariable String title){
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTitle().equals(title)) {
                System.out.println(tasks.get(i));
                return new ApiResponse("This is your task!!"+tasks.get(i));
            }
        }
        return new ApiResponse("The task not exist..");
    }

}
