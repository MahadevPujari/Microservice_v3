package com.mp.departmentservice.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mp.departmentservice.controller.DepartmentController;
import com.mp.departmentservice.entity.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public Department create(Department department) {

		log.debug("from DepartmentRepositoryImpl");
		String sql = "insert into Department (Department_Id , Department_Name,Department_Address,Department_Code) values (?,?,?,?)";
		int insert = jdbcTemplate.update(sql, department.getDepartmentId(),department.getDepartmentName(),
					 department.getDepartmentAddress(),department.getDepartmentCode());
		
		return department;
	}


	@Override
	public Department getIdDapartment(long departmentId) {
	    String sql = "select * from Department where Department_Id = ?";
	    RowMapper<Department> rowMapper = new DepartmentRowMapperImpl();
	    //jdbcTemplate.queryForObject(sql, rowMapper,departmentId);
	   Department department = jdbcTemplate.queryForObject(sql, rowMapper,departmentId);
	   
	    return department;
	}

	
	@Override
	public List<Department> getAllDapartment() {
		String sql = "select * from Department ";
		List<Department> list =  jdbcTemplate.query(sql, new DepartmentRowMapperImpl());
		return list;
	}

	@Override
	public Department updateDepartment(Department department) {
		String sql ="update Department set Department_Name = ? , Department_Address = ? ,Department_Code = ?";
		int update = jdbcTemplate.update(sql, department.getDepartmentName() , 
				department.getDepartmentAddress() , department.getDepartmentCode());
		return department;
	}


	@Override
	public long deleteDepartment(long departmentId) {
		
		String sql = "delete from Department where Department_Id = ?";
		int delete = jdbcTemplate.update(sql,departmentId);
		return (departmentId);
	}

}
