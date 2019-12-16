package tourproject.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import tourproject.Bean.Comment;
import tourproject.Repositories.IArchive;
import tourproject.Repositories.IComments;

public class CommentDAO implements IComments{
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost/touropia";
	static final String DB_Username = "root";
	static final String DB_Password = "samorpon";
	
	Connection connection = null;
    Statement statement = null;
	ResultSet result = null; 

	public void postComments(Comment comments) {
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
		String update = "insert into comment(comments, blogId, userId)values('"+comments.getComment()+"','"+comments.getBlog().getId()+"','"+comments.getUser().getId()+"')";
		
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
