package tourproject.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tourproject.Bean.Archive;
import tourproject.Bean.Blogs;
import tourproject.Repositories.IArchive;

public class ArchiveDAO implements IArchive {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String JDBC_URL = "jdbc:mysql://localhost/touropia";
	static final String DB_Username = "root";
	static final String DB_Password = "samorpon";
	
	Connection connection = null;
	java.sql.Statement statement = null;
	ResultSet result = null; 
	public void createArchive(Archive archive) {
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
		String update = "insert into archive(title,descriptions,times)values('"+archive.getTitle()+"','"+archive.getDescription()+"','"+archive.getTime()+"')";
		
		try {
			statement.executeUpdate(update);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public ArrayList<Archive> getArchives() {
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
		ArrayList<Archive> archivelist = new ArrayList<Archive>();
		
		String read = "select * from archive order by times desc";
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			Archive archive = new Archive();
			int id = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			archive.setId(id);
			archive.setTitle(title);
			archive.setDescription(description);
			archivelist.add(archive);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return archivelist;
	}

	public Archive getForEdit(int id) {
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
		String read = "select * from archive where id = '"+id+"'";
		Archive archive = new Archive();
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			int idd = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			
			archive.setId(idd);
			archive.setTitle(title);
			archive.setDescription(description);
						
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return archive;
		
	}

	public void edit(Archive archive) {
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
		String read = "update archive set title = '"+archive.getTitle()+"', descriptions = '"+archive.getDescription()+"', times = '"+archive.getTime()+"' where id = '"+archive.getId()+"'";
		
		try {
			statement.executeUpdate(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	public void deleteArchives(int id) {
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
		String read = "delete  from archive where id = '"+id+"'";
		
		try {
			statement.executeUpdate(read);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Archive getArchive(int id) {
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
		String read = "select * from archive where id = '"+id+"'";
		Archive archive = new Archive();
		try {
			result = statement.executeQuery(read);
			while(result.next()) {
			int idd = result.getInt("id");
			String title = result.getString("title");
			String description = result.getString("descriptions");
			
			archive.setId(idd);
			archive.setTitle(title);
			archive.setDescription(description);
						
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return archive;
		
		
	}
		
	}


