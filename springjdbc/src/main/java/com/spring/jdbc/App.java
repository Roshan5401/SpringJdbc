package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
public static void main(String[] args) {
	System.out.println("My program started");
	//spring jdbc=>jdbctemplate
	
	//this is not recommened to work
	ApplicationContext context=new ClassPathXmlApplicationContext("com\\spring\\jdbc\\config.xml");
	//we can create this bcz the studentDao is the parent of studentdaoimpl
	StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
//	Student student=new Student(5,"Gurdeep","behala");
	
	//for inserting the row
	//int r=studentDao.insert(student);
	
	//for updating the row
	//int r=studentDao.change(student);
	
	//for deleting the row
//	int r=studentDao.delete(student);
	
	
	//this for fetching the single object
	Student student=studentDao.getStudent(456);
	System.out.println(student);
	
}
}
