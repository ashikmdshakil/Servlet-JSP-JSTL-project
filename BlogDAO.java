package tourproject.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import tourproject.Bean.Archive;
import tourproject.Bean.Blogs;
import tourproject.Bean.Comment;
import tourproject.Bean.User;
import tourproject.Repositories.IBlogs;

public class BlogDAO implements IBlogs {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost/touropia";
	static final String DB_Username = "root";
	static final String DB_Password = "samorpon";
	
	Connection connection = null;
    Statement statement = null;
    Statement commentstatement = null;
	ResultSet result = null; 
    ResultSet comments = null;
	public void postBlogs(Blogs blog) {
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
		String update = "insert into blog(title,descriptions,times,id,userId,bloggerName)values('"+blog.getBlogTitle()+"','"+blog.getBlogDescription()+"','"+blog.getTime()+"','"+blog.getArchive().getId()+"','"+blog.getUser().getId()+"','"+blog.getUser().getName()+"')";
		
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Blogs> getBlogs(int id) {
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
		ArrayList<Blogs> bloglist = new ArrayList<Blogs>();
		
		String read = "SELECT * FROM touropia.blog where id = '"+id+"' order by times desc";
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			Blogs blog = new Blogs();
			int blogid = result.getInt("blogId");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			LocalDateTime time = result.getTimestamp("times").toLocalDateTime();
			int userId = result.getInt("id");
			String userName = result.getString("bloggerName");
			int archiveId = Integer.parseInt(result.getString("id"));
			User user = new User();
			user.setId(userId);
			user.setName(userName);
			Archive archive = new Archive();
			archive.setId(archiveId);
			blog.setId(blogid);
			blog.setBlogTitle(title);
			blog.setBlogDescription(description);
			blog.setTime(time);
			blog.setUser(user);
			blog.setDate(time.getDayOfMonth());
			blog.setMonth(time.getMonth());
			blog.setYear(time.getYear());
			bloglist.add(blog);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bloglist;
	
	}

	public Blogs getForEdit(int id) {
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
		String read = "select * from blog where blogid = '"+id+"'";
		Blogs blog = new Blogs();
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			int blogid = result.getInt("blogId");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			
			blog.setId(blogid);
			blog.setBlogTitle(title);
			blog.setBlogDescription(description);
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return blog;
	}

	public void edit(Blogs blog) {
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
		String read = "update blog set title = '"+blog.getBlogTitle()+"', descriptions = '"+blog.getBlogDescription()+"', times = '"+blog.getTime()+"' where blogId = '"+blog.getId()+"'";
		
		try {
			statement.executeUpdate(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void deleteBlogss(int id) {
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
		String read = "delete from blog  where blogId = '"+id+"'";
		
		try {
			statement.executeUpdate(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Blogs> getMyBlogs(int id) {
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
		ArrayList<Blogs> bloglist = new ArrayList<Blogs>();
		
		String read = "SELECT * FROM touropia.blog where userId = '"+id+"' order by times desc";
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			Blogs blog = new Blogs();
			int blogid = result.getInt("blogId");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			LocalDateTime time = result.getTimestamp("times").toLocalDateTime();
			int userId = result.getInt("id");
			String userName = result.getString("bloggerName");
			User user = new User();
			user.setId(userId);
			user.setName(userName);
			blog.setId(blogid);
			blog.setBlogTitle(title);
			blog.setBlogDescription(description);
			blog.setTime(time);
			blog.setUser(user);
			blog.setDate(time.getDayOfMonth());
			blog.setMonth(time.getMonth());
			blog.setYear(time.getYear());
			bloglist.add(blog);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bloglist;
		
		
	}

	public void deleteAllBlogs(int id) {
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
		String read = "delete from blog  where id = '"+id+"'";
		
		try {
			statement.executeUpdate(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Blogs> getAllBlogs() {
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
		ArrayList<Blogs> bloglist = new ArrayList<Blogs>();
		
		String read = "SELECT * FROM touropia.blog order by times desc";
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			Blogs blog = new Blogs();
			int blogid = result.getInt("blogId");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			LocalDateTime time = result.getTimestamp("times").toLocalDateTime();
			int userId = result.getInt("id");
			String userName = result.getString("bloggerName");
			int archiveId = Integer.parseInt(result.getString("id"));
			User user = new User();
			user.setId(userId);
			user.setName(userName);
			Archive archive = new Archive();
			archive.setId(archiveId);
			blog.setId(blogid);
			blog.setBlogTitle(title);
			blog.setBlogDescription(description);
			blog.setTime(time);
			blog.setUser(user);
			blog.setDate(time.getDayOfMonth());
			blog.setMonth(time.getMonth());
			blog.setYear(time.getYear());
			bloglist.add(blog);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bloglist;
		
	}

	public ArrayList<Blogs> getAllBlogsWithComments() {
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
			commentstatement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Blogs> bloglist = new ArrayList<Blogs>();
		
		String read = "SELECT * FROM touropia.blog order by times desc";
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			Blogs blog = new Blogs();
			int blogid = result.getInt("blogId");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			LocalDateTime time = result.getTimestamp("times").toLocalDateTime();
			int userId = result.getInt("id");
			String userName = result.getString("bloggerName");
			int archiveId = Integer.parseInt(result.getString("id"));
			User user = new User();
			user.setId(userId);
			user.setName(userName);
			Archive archive = new Archive();
			archive.setId(archiveId);
			blog.setId(blogid);
			blog.setBlogTitle(title);
			blog.setBlogDescription(description);
			blog.setTime(time);
			blog.setUser(user);
			blog.setDate(time.getDayOfMonth());
			blog.setMonth(time.getMonth());
			blog.setYear(time.getYear());
			
			String getComments = "select comments , userName from comment inner join user on comment.userId = user.userId where comment.userId = '"+blog.getUser().getId()+"' ";
			comments = commentstatement.executeQuery(getComments);
			ArrayList<Comment> commentlist = new ArrayList<Comment>();
			while(comments.next()) {
				String comment = comments.getString("comments");
				String username = comments.getString("userName");
				Comment comments = new Comment();
				User users = new User();
				users.setName(username);
				comments.setComment(comment);
				comments.setUser(users);
				commentlist.add(comments);
			}
			blog.setComments(commentlist);
			
			bloglist.add(blog);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bloglist;
	}

}
