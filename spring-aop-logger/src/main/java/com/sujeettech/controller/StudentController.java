package com.sujeettech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sujeettech.entity.Student;
import com.sujeettech.service.StudentService;
import com.sujeettech.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
		
	}
	
	@GetMapping("/students/v2")
	public List<Student> getStudentsV2() {
		return studentServiceImpl.getStudents();
		
	}
 }
