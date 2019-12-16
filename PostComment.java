package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tourproject.Bean.Blogs;
import tourproject.Bean.Comment;
import tourproject.Bean.User;
import tourproject.Repositories.IComments;
import tourproject.Service.CommentDAO;
@WebServlet("/postcomment")
public class PostComment extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String comment =  request.getParameter("comment");
		int blogid = Integer.parseInt(request.getParameter("blogid"));
		Blogs blogs = new Blogs();
		blogs.setId(blogid);
		
		HttpSession session = request.getSession();
	    int userId = (Integer) session.getAttribute("userId");
		User user = new User();
		user.setId(userId);
		Comment comments = new Comment();
		comments.setBlog(blogs);
		comments.setComment(comment);
		comments.setUser(user);
		IComments commentt =  new CommentDAO();
		commentt.postComments(comments);
		
		try {
			PrintWriter out = response.getWriter();
			out.println("check your database");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
