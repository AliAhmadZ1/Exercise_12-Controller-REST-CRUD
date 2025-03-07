package com.example.exercise_12bankmanagementsystem.Controller;

import com.example.exercise_12bankmanagementsystem.ApiResponse.ApiResponse;
import com.example.exercise_12bankmanagementsystem.Model.Customers;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank-management-system")
public class BankManagementController {

    //Endpoints :
    //Get all the customers
    //Add new customers
    //Update customers
    //Delete customers
    //Deposit money to customer
    //Withdraw money from customers

    //temp DB
    ArrayList<Customers> customers = new ArrayList<>();

    //Get all the customers
    @GetMapping("/get-customers")
    public ArrayList<Customers> getCustomers(){
        return customers;
    }

    //Add new customers
    @PostMapping("/add-new")
    public ApiResponse addNewCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiResponse("the customer is added.");
    }

    //Update customers
    @PutMapping("/تحديث/{index}")
    public ApiResponse updateCustomer(@PathVariable int index,@RequestBody Customers customer){
        customers.set(index, customer);
        return new ApiResponse("updated!!");
    }

    //Delete customers
    @DeleteMapping("/{index}")
    public ApiResponse deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return new ApiResponse("تم حذفه بنجاح!!");
    }

    //Deposit money to customer
    @PutMapping("/deposit/{index},{amount}")
    public ApiResponse deposit(@PathVariable int index,@PathVariable double amount){
//        amount += customers.get(index).getBalance();
        customers.get(index).setBalance(amount+customers.get(index).getBalance());
        return new ApiResponse("تم الإيداع بنجاح ⍩");
    }


    //Withdraw money from customers
    @PutMapping("/withdraw/{index},{amount}")
    public ApiResponse withdraw(@PathVariable int index,@PathVariable double amount){
        customers.get(index).setBalance(customers.get(index).getBalance()-amount);
        return new ApiResponse("تم سحب المبلغ بنجاح ⍢");
    }


}
