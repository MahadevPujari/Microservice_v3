package com.mp.departmentservice.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mp.departmentservice.controller.DepartmentController;
import com.mp.departmentservice.entity.Department;
import com.mp.departmentservice.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.debug("from DepartmentService");

		 return departmentRepository.create(department);
	}

	public Department getIdDapartment(long departmentId) {
		
		return departmentRepository.getIdDapartment(departmentId);
	}
	
	public List<Department> getAllDepartment()
	{
		return departmentRepository.getAllDapartment();
	}
	
	public Department updateDepartment(Department department)
	{
		return departmentRepository.updateDepartment(department);
	}

	public long deleteDepartment(long departmentId) {
		
		return departmentRepository.deleteDepartment(departmentId);
	}
	
}
