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
import javax.servlet.http.HttpSession;

import tourproject.Bean.Blogs;
import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/showblogs")
public class ShowBlogs extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int archiveid = Integer.parseInt(request.getParameter("id"));
		
		IBlogs blog = new BlogDAO();
		ArrayList<Blogs> blogs = blog.getBlogs(archiveid);
		request.setAttribute("id", archiveid);
		request.setAttribute("blog", blogs);
		HttpSession session = request.getSession();
		String role = (String) session.getAttribute("userRole");
		if(role.equals("admin")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/blogsadmin.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/blogsuser.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
