package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/deleteblogsadmin")
public class DeleteBlogsAdmin extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		IBlogs blog = new BlogDAO();
		blog.deleteBlogss(id);
		
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
		//int archiveid = Integer.parseInt(request.getParameter("id"));
		
		/*try {
			PrintWriter out = response.getWriter();
			out.println(id);
			out.println(archiveid);
			
			
			
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		
		}
}
