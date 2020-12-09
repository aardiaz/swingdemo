package com.swingdemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		 
		String sql  = "delete from employee where id= "+id;
		try {
			Statement  stm = con.createStatement();
			stm.execute(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		 
		String sql= "update employee set fname= ?,lname= ?,age= ?,gender= ?,email= ?,phone= ?,company= ?,post= ?,country= ?,city= ?,dob= ?,joiningDate= ?,salary= ? where id = ?";
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
			pstm.setInt(14, emp.getId());
			
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Employee getById(int id) {
		Employee  emp = new Employee();
		
		String sql ="select * from employee where id = "+id;
		try {
			Statement stm = con.createStatement();
			ResultSet  rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				
				emp.setId(rs.getInt("id"));
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setCompany(rs.getString("company"));
				emp.setPhone(rs.getString("phone"));
				emp.setGender(rs.getString("gender"));
				emp.setAge(rs.getInt("age"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDob(rs.getDate("dob"));
				emp.setJoiningDate(rs.getDate("joiningDate"));
				emp.setCountry(rs.getString("country"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public List<Employee> getAllEmp() {
		 
		List<Employee>  elist = new ArrayList<>();
		
		String sql ="select * from employee";
		try {
			Statement stm = con.createStatement();
			ResultSet  rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setCompany(rs.getString("company"));
				emp.setPhone(rs.getString("phone"));
				
				elist.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}

	@Override
	public List<Employee> search(String input) {
List<Employee>  elist = new ArrayList<>();
		
		String sql ="select * from employee where company like '%"+input+"%' OR fname like '%"+input+"%' ";
		try {
			Statement stm = con.createStatement();
			ResultSet  rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Employee emp = new Employee();
				
				emp.setId(rs.getInt("id"));
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setCompany(rs.getString("company"));
				emp.setPhone(rs.getString("phone"));
				
				elist.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elist;
	}

}
