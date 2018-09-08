package com.javainuse.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.javainuse.dao.EmployeeDao;
import com.javainuse.model.User;

@SuppressWarnings("unused")
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void insertUser(User user) {
		String user1;

		try {

			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString = "insert into usertable(username)values(?)";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(queryString);

			stmt.setString(1, user.getUserName());
			stmt.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}

	@Override
	public void insertObject(User user) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString = "insert into objecttable(objectName)values(?)";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(queryString);

			stmt.setString(1, user.getObjectName());
			stmt.executeUpdate();

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}
	@Override
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn = null;
		ResultSet rs;

		Statement stmt = null;
		String sql = "select * from usertable";
		try {

			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString("username"));

				result.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}
	@Override
	public List<User> getAllObjects() {
		List<User> result = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn = null;
		ResultSet rs;

		Statement stmt = null;
		String sql = "select distinct objectName from objecttable";
		try {

			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setObjectName(rs.getString("objectname"));

				result.add(user);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}
	@Override
	public void insertPermission(String username, String[] objectname, String[] permission) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString = "insert into userpermissiontabel(user,objectName,permission)values(?,?,?)";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(queryString);

			for (int i = 0; i < objectname.length; i++) {
				stmt.setString(1, username);
				stmt.setString(2, objectname[i]);
				stmt.setString(3, permission[i]);
				stmt.executeUpdate();
			}

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}

	@Override
	public List<User> getAllGroup() {
		List<User> result = new ArrayList<User>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn = null;
		ResultSet rs;

		Statement stmt = null;
		String sql = "select distinct groupname from grouptabel";
		try {

			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setGroupName(rs.getString("groupname"));

				result.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;

	}
	@Override
	public void insertPermission1(String groupname, String[] objectname, String[] permission) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString = "insert into grouppermissiontabel(groupname,objectname,permission)values(?,?,?)";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(queryString);

			for (int i = 0; i < objectname.length; i++) {
				stmt.setString(1, groupname);
				stmt.setString(2, objectname[i]);
				stmt.setString(3, permission[i]);
				stmt.executeUpdate();
			}

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}

	

	@Override
	public void groupUsertabel(String username, String groupname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString = "insert into grouptabel(groupname,username)values(?,?)";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(queryString);

			
				stmt.setString(1, groupname);
				stmt.setString(2, username);
				
				stmt.executeUpdate();
			

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
	}

	@SuppressWarnings("resource")
	@Override
	public String userObject(String userName, String objectName) {
		String str1 = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString ="select groupname from grouptabel where username='" + userName+ "'";

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(queryString);
			if (rs.next()) {
			str1=rs.getString("groupname");	
			}
			if(str1!=null) {
				String qr="select permission from grouppermissiontabel where groupName='" + str1+ "'and objectname='"+objectName+"'";
				
				rs = stmt.executeQuery(qr);
				if (rs.next()) {
				str1=rs.getString("permission");
				
			}
				System.out.println(str1);
			}
			else {
				String qr1="select permission from userpermissiontabel where user='"+userName+"'and objectname='" + objectName+ "'";
				rs = stmt.executeQuery(qr1);
				if (rs.next()) {
			 str1=rs.getString("permission");	
			}
				System.out.println(str1);
			}
			

		} catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
		return str1;
		
	}
	@Override
	public void userObject1(String data, String objectName) {
		String str1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;

		String queryString ="update objecttable set objectname='"+data+"' where objectname='"+objectName+"'";
		

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			Statement stmt = conn.createStatement();

		stmt.executeUpdate( queryString);
		}
		
	 catch (SQLException sqle) {
		System.out.println("SQL Exception thrown: " + sqle);
	}
	
	
	
}
	@Override
	public void userObject2(String objectName) {
		String str1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String connectionUrl = "jdbc:mysql://localhost:3306/testing";
		String dbUser = "root";
		String dbPwd = "mysql12345";
		Connection conn;
		ResultSet rs;
String queryString ="delete from objecttable where objectname='"+objectName+"'";
		

		try {
			conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
			// Statement stmt = conn.createStatement();
			Statement stmt = conn.createStatement();

		stmt.executeUpdate( queryString);
		}
		 catch (SQLException sqle) {
			System.out.println("SQL Exception thrown: " + sqle);
		}
			
		

	}

	
	

	

	
}

	
		
		
	
	


