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
@WebServlet("/editarchives")
public class EditArchives extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		IArchive archive = new ArchiveDAO();
		Archive archives = archive.getForEdit(id);
		LocalDateTime time = LocalDateTime.now();
		archives.setTime(time);
		request.setAttribute("archive", archives);
		/*
		try {
			PrintWriter out = response.getWriter();
			out.println(archives.getId());
			out.println(archives.getTitle());
			out.println(archives.getDescription());
			out.println(archives.getTime());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("view/archiveeditform.jsp");
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
