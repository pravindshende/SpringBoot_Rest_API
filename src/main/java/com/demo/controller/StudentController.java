package com.demo.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.function.Function;
import java.util.Optional;

import com.demo.repository.StudentRepo;
import com.demo.entity.Student;
@RestController
public class StudentController {
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/getstud")
	public List<Student> getallstudent() {
		return (List<Student>) repo.findAll();
		}
	
	@GetMapping("/getbyid/{id}")
	public Optional<Student> getbyid(@PathVariable Integer id){
		return  repo.findById(id);
	}
	
	@PostMapping("/addst")
	void addstudent(@RequestBody Student st) {
		repo.save(st);
	}
	
	@DeleteMapping("/deletestud/{id}")
	void deletestudent(@PathVariable Integer id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/updatest/{id}")
	Student updatestud(@RequestBody Student stobj, @PathVariable Integer id) {
		return repo.findById(id).map(student -> {
			student.setName(stobj.getName());
			student.setLnme(stobj.getLnme());
			student.setMark(stobj.getMark());
			return repo.save(student); })
				.orElseGet(() -> {
					stobj.setId(id);
					return repo.save(stobj);});
	}
}
