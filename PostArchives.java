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
import tourproject.Repositories.IArchive;
import tourproject.Repositories.IUserAuthentication;
import tourproject.Service.ArchiveDAO;
import tourproject.Service.UserAuthentication;
@WebServlet("/postArchives")
public class PostArchives extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		LocalDateTime time = LocalDateTime.now();
		
		Archive archive = new Archive();
		archive.setTitle(name);
		archive.setDescription(description);
		archive.setTime(time);
		IArchive archive1 = new ArchiveDAO();
		archive1.createArchive(archive);
		RequestDispatcher dispatcher = request.getRequestDispatcher("seeplaces");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//PrintWriter out = response.getWriter();
		//out.println("CHECK YOUR DATABASE");
		//out.println(description);
		//out.println(time);
	}
}
