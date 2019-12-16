package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Bean.Archive;
import tourproject.Repositories.IArchive;
import tourproject.Service.ArchiveDAO;
@WebServlet("/getarchive")
public class GetArchive extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		/*try {
			PrintWriter out = response.getWriter();
			out.println(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		IArchive archive = new ArchiveDAO();
		Archive archives = archive.getArchive(id);
		request.setAttribute("archive", archives);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/archivepage.jsp");
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
