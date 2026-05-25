package com.codingshuttle.nitish.mvc.controller;

import com.codingshuttle.nitish.mvc.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping(path="/getsecretmessage")
    public String getSecretMessage(){
        return "Secret Message: asdffghh";
    }

    //@GetMapping(path="/getEmployee/Details/{emp_id}")
    @GetMapping(path="/{emp_id}")
    public EmployeeDTO getEmployeeDetails( @PathVariable(name= "emp_id") Long p_emp_id){
     return new EmployeeDTO(p_emp_id,"Nitish","nitish@gmail.com",27, LocalDate.of(2024,1,2),true);
    }

    //@GetMapping(path="/getEmployee/Details")
    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false, name="inp_filter_by") String p_filter_by, @RequestParam(required = false)  String p_order_by ){
        return "Hi employees are filter by "+ p_filter_by + " and sorted by " + p_order_by;
    }

    @PostMapping
    public EmployeeDTO postEmployee( @RequestBody EmployeeDTO emp){

        emp.setId(100L);

        return emp;
    }
}
