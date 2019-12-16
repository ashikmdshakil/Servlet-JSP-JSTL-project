package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tourproject.Bean.Archive;
import tourproject.Bean.Blogs;
import tourproject.Bean.User;
import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/postblogs")
public class PostBlogs extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int archiveId = Integer.parseInt(request.getParameter("archiveid"));
		request.setAttribute("id", archiveId );
		
		LocalDateTime time = LocalDateTime.now();
		HttpSession session = request.getSession(); 
		int userId =  (Integer) session.getAttribute("userId");
		String bloggerName = (String) session.getAttribute("userName");
		Archive archive = new Archive();
		archive.setId(archiveId);
		User user = new User();
		user.setId(userId);
		user.setName(bloggerName);
		
		Blogs blog = new Blogs();
		blog.setBlogTitle(title);
		blog.setBlogDescription(description);
		blog.setTime(time);
		blog.setArchive(archive);
		blog.setUser(user);
		IBlogs blogs = new BlogDAO();
		blogs.postBlogs(blog);
		
		PrintWriter out = response.getWriter();
		out.println("check your databse");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("seeplaces");
		//RequestDispatcher dispatcher = request.getRequestDispatcher("archiveblogs");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		/*PrintWriter out = response.getWriter();
		out.println(archiveId);*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		//out.println(archiveId);
		
		
		
	}
