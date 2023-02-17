package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//for inserting
	public int insert(Student student) {
		String query="insert into student(id,name,city) value(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	
	//for updating
	public int change(Student student) {
		String query="update student set name=? ,city=? where id=?";
		int r=this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return r;
	}
	
	//for deleting
	public int delete(Student student) {
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query,student.getId());
		return r;
	}
	
	//selecting single student data
	public Student getStudent(int studentId) {
		String query="select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		return student;
	}
	
	
}
