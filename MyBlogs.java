package tourproject.Controller;

import java.io.IOException;
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
@WebServlet("/myblogs")
public class MyBlogs extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("userId");
		IBlogs blogs = new BlogDAO();
		ArrayList<Blogs> bloglist = blogs.getMyBlogs(id);
		request.setAttribute("bloglist", bloglist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/myBlogs.jsp");
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
