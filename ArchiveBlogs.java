package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Bean.Blogs;
import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/archiveblogs")
public class ArchiveBlogs extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//PrintWriter out = response.getWriter();
		//out.println(id);
		request.setAttribute("archId", id);	
		//RequestDispatcher dispatcher = request.getRequestDispatcher("showblogs");
		//dispatcher.forward(request, response);
		
		IBlogs blog = new BlogDAO();
		ArrayList<Blogs> blogs = blog.getBlogs(id);
		request.setAttribute("blog", blogs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/blogs.jsp");
		dispatcher.forward(request, response);
	}
}
