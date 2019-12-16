package tourproject.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tourproject.Bean.Archive;
import tourproject.Repositories.IArchive;
import tourproject.Service.ArchiveDAO;
@WebServlet("/homepage")
public class Homepage extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Archive> archivelist = new ArrayList<Archive>();
		IArchive archive = new ArchiveDAO();
		archivelist =  archive.getArchives();
		request.setAttribute("archives", archivelist);
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");
		request.setAttribute("username", userName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/homepage.jsp");
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
