package com.msita.training.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.msita.training.entity.User;

@Repository
public class DatabaseConnector {
	
	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * login using hibernate
	 * @param username
	 * @param pass
	 * @return
	 */
	@Transactional
	public boolean login2(String username,String pass) {
		User user= (User)sessionFactory.getCurrentSession().get(com.msita.training.entity.User.class, username);
		if(user!=null && user.getPassword().equals(pass))
			return true;
		return false;
	}
	
	/**
	 * login function....by username and password
	 * using jdbc connection
	 * @param username
	 * @param pass
	 * @return
	 */
	public boolean login(String username,String pass) {
		Connection con=connect();
		String userDB = "";
		String passDB = ""; 
		try {
			if (con != null) {
				Statement stmt = con.createStatement();
				ResultSet rs;
				rs = stmt.executeQuery("select * from user where username='" + username+"'");
				while (rs.next()) {
					userDB = rs.getString(1);
					passDB = rs.getString(2);
				}
				con.close();
				if (username.equals(userDB) && pass.equals(passDB)) {
					return true;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * get connection from database
	 * @return
	 */
	public Connection connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb", "root", "1234");
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
}
