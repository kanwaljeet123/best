package com.javainuse.dao;

import java.util.List;

import com.javainuse.model.User;

public interface EmployeeDao {
	void insertUser(User user);
	void insertObject(User user);
	
	List<User> getAllUsers();
	


List<User> getAllObjects();

List<User> getAllGroup();

void insertPermission(String username, String[] objectname, String[] permission);
void insertPermission1(String groupName,String[] objectName,String[] permission);
void groupUsertabel(String username, String groupname);
void userObject1(String data, String objectName);
void userObject2(String objectName);
 String userObject(String userName, String objectName);
	
}