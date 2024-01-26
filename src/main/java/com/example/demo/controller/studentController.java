package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.studentService;

@RestController
@RequestMapping("/students")
public class studentController {
	@Autowired
	private studentService studService;
	
	@GetMapping("/all")
	public List<Student> getAllStudents() {
	    return studService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable Long id) {
	    return studService.getStudentById(id);
	}

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
	    return studService.saveStudent(student);
	}

	@PutMapping("/{id}")
	public Optional<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
	    //logic
	    return studService.updateStudentDetails(id, student);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
	    studService.deleteStudent(id);
	}

	
	

}
	