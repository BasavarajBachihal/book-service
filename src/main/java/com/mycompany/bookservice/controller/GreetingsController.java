package com.mycompany.bookservice.controller;

import com.mycompany.bookservice.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/greetings")
public class GreetingsController {

    @GetMapping
    public String greet(){
        return "How are you?";
    }

    @GetMapping("/withnamerppv/{empId}")
    public String greetWithName(@PathVariable("empId")Long employeeId, @RequestParam("name11")String name, @RequestParam String lname)
    {
        return "How are you" +name+" "+lname+" "+employeeId+"?";
    }

    @PostMapping("/save-employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeDTO;
    }

}