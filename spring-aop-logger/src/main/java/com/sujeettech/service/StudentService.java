package com.sujeettech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sujeettech.entity.Student;

@Service
public class StudentService {

	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		Student s1 = new Student(1, "Sujeet", "Mulund");
		Student s2 = new Student(2, "Prashant", "Dombivali");
		Student s3 = new Student(3, "Pratap", "Badlapur");
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		return students;
	}
}
