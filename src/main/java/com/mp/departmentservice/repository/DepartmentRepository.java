package com.mp.departmentservice.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mp.departmentservice.entity.Department;

@Repository
public interface DepartmentRepository {
	
	public Department create(Department department);
	public List<Department> getAllDapartment();
	public Department getIdDapartment(long departmentId);
	public Department updateDepartment(Department department);
	public long deleteDepartment(long departmentId);

}
