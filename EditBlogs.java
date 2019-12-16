package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Bean.Blogs;
import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/editblogs")
public class EditBlogs extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		IBlogs blog = new BlogDAO();
		Blogs blogs = blog.getForEdit(id);
		LocalDateTime time = LocalDateTime.now();
		blogs.setTime(time);
		request.setAttribute("blog", blogs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/blogeditform.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			PrintWriter out = response.getWriter();
			out.println(blogs.getId());
			out.println(blogs.getBlogTitle());
			out.println(blogs.getBlogDescription());
			out.println(blogs.getTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
