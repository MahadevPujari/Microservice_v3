package com.mp.departmentservice.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mp.departmentservice.entity.Department;
import com.mp.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department)
	{
		log.debug("from departmentRepository saveDepartment");
		
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getIdDepartment(@PathVariable("id") long departmentId)
	{
		log.debug("from departmentRepository getIdDepartment");
		return departmentService.getIdDapartment(departmentId);
	}
	
	@GetMapping("/")
	public List<Department> getAllDepartment()
	{
		log.debug("from departmentRepository getAllDepartment");
		return departmentService.getAllDepartment();
	}
	
	@PutMapping("/")
	public Department updateDepartment(@RequestBody Department department)
	{
		log.debug("from departmentRepository updateDepartment");
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/{id}")
	public long deleteDepartment(@PathVariable("id") long departmentId)
	{
		return departmentService.deleteDepartment(departmentId);
	}
}
