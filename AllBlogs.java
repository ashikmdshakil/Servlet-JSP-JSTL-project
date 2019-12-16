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
import tourproject.Bean.Comment;
import tourproject.Repositories.IBlogs;
import tourproject.Service.BlogDAO;
@WebServlet("/allblogs")
public class AllBlogs extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		IBlogs blog =  new BlogDAO();
		ArrayList<Blogs> blogs = blog.getAllBlogsWithComments();
		/*try {
			PrintWriter out = response.getWriter();
			for(Blogs blogss : blogs) {
				
				for(Comment comments : blogss.getComments()) {
					
					out.println(comments.getComment());
				}
				
			}
		} catch (IOException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
		request.setAttribute("blogs", blogs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/allblogs.jsp");
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
