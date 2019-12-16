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
@WebServlet("/editblogsdone")
public class EditBlogsDone extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));
		LocalDateTime time = LocalDateTime.now();
		Blogs blogs = new Blogs();
		blogs.setId(id);
		blogs.setBlogTitle(title);
		blogs.setBlogDescription(description);
		blogs.setTime(time);
		IBlogs blog = new BlogDAO();
		blog.edit(blogs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("myblogs");
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
			out.println("check your database");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
