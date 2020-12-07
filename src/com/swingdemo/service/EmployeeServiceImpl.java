package com.swingdemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.swingdemo.db.DB;
import com.swingdemo.model.Employee;

public class EmployeeServiceImpl implements EmployeeService{
	
	Connection con = null;
	
	public EmployeeServiceImpl() {
		con = DB.createConnection();
	}
	

	@Override
	public boolean addEmp(Employee emp) {
		 
		String sql= "insert into employee(fname,lname,age,gender,email,phone,company,post,country,city,dob,joiningDate,salary)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement  pstm =  con.prepareStatement(sql);
			
			pstm.setString(1, emp.getFname());
			pstm.setString(2, emp.getLname());
			pstm.setInt(3, emp.getAge());
			pstm.setString(4, emp.getGender());
			pstm.setString(5, emp.getEmail());
			pstm.setString(6, emp.getPhone());
			pstm.setString(7, emp.getCompany());
			pstm.setString(8, emp.getPost());
			pstm.setString(9, emp.getCompany());
			pstm.setString(10, emp.getCity());
			pstm.setDate(11, emp.getDob());
			pstm.setDate(12, emp.getJoiningDate());
			pstm.setInt(13, emp.getSalary());
			
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deleteEmp(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> search(String input) {
		// TODO Auto-generated method stub
		return null;
	}

}
