package tourproject.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/deleteallblogs")
public class DeleteAllBlogs extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int archiveId = Integer.parseInt(request.getParameter("id"));
		IBlogs blogs = new BlogDAO();
		blogs.deleteAllBlogs(archiveId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("seeplaces");
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
