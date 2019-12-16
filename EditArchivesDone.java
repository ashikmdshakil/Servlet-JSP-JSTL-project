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

import tourproject.Bean.Archive;
import tourproject.Bean.Blogs;
import tourproject.Repositories.IArchive;
import tourproject.Repositories.IBlogs;
import tourproject.Service.ArchiveDAO;
import tourproject.Service.BlogDAO;
@WebServlet("/editarchivesdone")
public class EditArchivesDone extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		int id = Integer.parseInt(request.getParameter("id"));
		LocalDateTime time = LocalDateTime.now();
		Archive archives = new Archive();
		archives.setId(id);
		archives.setTitle(title);
		archives.setDescription(description);
		archives.setTime(time);
		
		/*try {
			PrintWriter out = response.getWriter();
			out.println(archives.getTitle());
			out.println(archives.getId());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		IArchive archive = new ArchiveDAO();
		archive.edit(archives);
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
		
		/*try {
			PrintWriter out = response.getWriter();
			out.println("check your database");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
