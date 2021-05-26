package com.mp.departmentservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mp.departmentservice.entity.Department;

public class DepartmentRowMapperImpl implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department department = new Department();
		
		department.setDepartmentId(rs.getLong("Department_Id"));
		department.setDepartmentName(rs.getString("Department_Name"));
		department.setDepartmentAddress(rs.getString("Department_Address"));
		department.setDepartmentCode(rs.getString("Department_Id"));		
		
		return department;
	}

	
}
