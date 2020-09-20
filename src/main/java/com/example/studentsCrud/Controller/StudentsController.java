package com.example.studentsCrud.Controller;

import com.example.studentsCrud.Model.Student;
import com.example.studentsCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StudentsController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentsController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String showExStudents(Model model) {
        if (studentRepository.count() > 0)
            model.addAttribute("students", studentRepository.findAll());
        else
            model.addAttribute("students", null);
        return "students";
    }

    @GetMapping("/add")
    public String showAddStudent(Student student) {
        return "create-student";
    }

    @PostMapping("/add")
    public String addTheStudent(@Valid Student student, Model model) {
        studentRepository.save(student);
        model.addAttribute("students", studentRepository.findAll());
        return "redirect:students";
    }
    @GetMapping("/edit/{id}")
        public String showTheStudent(@PathVariable("id") long id, Model model){
        Student student = studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id"));
        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public void updateTheStudent(){

    }

}
