package tourproject.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import tourproject.Bean.User;
import tourproject.Repositories.IUserAuthentication;

public class UserAuthentication implements IUserAuthentication {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost/touropia";
	static final String DB_Username = "root";
	static final String DB_Password = "samorpon";
	
	Connection connection = null;
	java.sql.Statement statement = null;

	public void signUp(User user) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(JDBC_URL, DB_Username, DB_Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String saveQuery = "insert into user(userName, userEmailAdress, userPhoneNumber, userPassword, role)values('"+user.getName()+"','"+user.getMail()+"','"+user.getPhone()+"','"+user.getPassword()+"','"+user.getRole()+"')";
		try {
			statement.executeUpdate(saveQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean validate(User user) {
		// TODO Auto-generated method stub
		boolean status = false;
		
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(JDBC_URL, DB_Username, DB_Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String validateQuery = "select * from user where userEmailAdress = '"+user.getMail()+"' and userPassword = '"+user.getPassword()+"'";
		ResultSet result = null;
		User users = new User();
		try {
			 result = statement.executeQuery(validateQuery);
			 status = result.next();
			//String mail = result.getString("userEmailAdress");
			//String password =  result.getString("userPassword");
			
			//users.setMail(mail);
			//users.setPassword(password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if(user == users) {
			//status = true;
		
		return status;
	}

	

	public User getSession(String mail) {
		// TODO Auto-generated method stub
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection =  DriverManager.getConnection(JDBC_URL, DB_Username, DB_Password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String getQuery = "select * from user where userEmailAdress = '"+mail+"'";
		ResultSet result = null;
		
		User user = new User();
		
		try {
			result = statement.executeQuery(getQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(result.next()) {
			int id = result.getInt("userId");	
			String name = result.getString("userName");
			String password = result.getString("userPassword");
			String role = result.getString("role");
			user.setId(id);
			user.setName(name);
			user.setPassword(password);
			user.setRole(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}

}
