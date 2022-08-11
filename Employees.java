package com.example.week2day5;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/auth")
public class Employees {

    ArrayList<Employees> arr = new ArrayList<>();
    @GetMapping
    public ResponseEntity getEmployee(){
        return ResponseEntity.status(200).body(arr);
    }
    @PostMapping
    public ResponseEntity addEmployee(@RequestBody @Valid Employees employees,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message,400));
        }
        arr.add(employees);
        return ResponseEntity.status(201).body( new ApiResponse("New employee added !",201));
    }
    @PutMapping("/{index}")
    public ResponseEntity putEmployee(@PathVariable @Valid int index,Employees employees , Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message, 400));

        }
        if (index >= arr.size()){
            return ResponseEntity.status(400).body(new ApiResponse("invalid text", 400));
        }
        arr.remove(index);
        return ResponseEntity.status(201).body(new ApiResponse ("update employee",201));
    }
    @DeleteMapping("/{index}")
    public ResponseEntity deleteEmployee(@PathVariable int index){
        if (index>=arr.size()){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index", 400));
        }
        return ResponseEntity.status(201).body(new ApiResponse ("update employee",201));
    }




}