package com.javainuse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javainuse.dao.EmployeeDao;

import com.javainuse.model.User;
import com.javainuse.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public	void insertUser(User user){
		employeeDao.insertUser(user);
	}
	@Override
	public	void insertObject(User user){
		employeeDao.insertObject(user);
	}
	
	
	
	@Override
	public List<User> getAllUsers() {
		List<User> users = employeeDao.getAllUsers();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
		
	}
	@Override
	public List<User> getAllObjects() {
		List<User> users = employeeDao.getAllObjects();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
		
	}
	@Override
	public List<User> getAllGroup() {
		List<User> users = employeeDao.getAllGroup();
		for (User user : users) {
			System.out.println(user.toString());
		}
		return users;
		

	
		
	
	

	
		

	}
	@Override
	public void insertPermission(String userName, String[] objectName, String[] permission) {
		employeeDao.insertPermission(userName, objectName, permission);
		
	}

	@Override
	public void insertPermission1(String groupName, String[] objectName, String[] permission) {
		employeeDao.insertPermission1(groupName, objectName, permission);
		
	}

	@Override
	public void groupUsertabel(String username, String groupname) {
		employeeDao.groupUsertabel(username, groupname);
		
	}
	@Override
	public void userObject1(String data, String objectName) {
		employeeDao.userObject1(data, objectName);
	

	}
	@Override
	public void userObject2(String objectName) {
		employeeDao.userObject2(objectName);
}
	@Override
	public String userObject(String userName, String objectName) {
		String str=employeeDao.userObject(userName, objectName);
		return str;
		
	}
}