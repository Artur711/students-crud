package com.example.studentsCrud.Controller;

import com.example.studentsCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentsController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentsController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @GetMapping("/students")
    public String showExStudents(Model model){
        if (studentRepository.count() > 0)
            model.addAttribute("students", studentRepository.findAll());
        else
            model.addAttribute("students", null);
        return "students";
    }

}
