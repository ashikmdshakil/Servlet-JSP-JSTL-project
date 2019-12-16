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
import javax.servlet.http.HttpSession;

import tourproject.Bean.Archive;
import tourproject.Repositories.IArchive;
import tourproject.Service.ArchiveDAO;
@WebServlet("/seeplaces")
public class SeePlaces extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ArrayList<Archive> archivelist = new ArrayList<Archive>();
		IArchive archive = new ArchiveDAO();
		archivelist =  archive.getArchives();
		request.setAttribute("archives", archivelist);
		HttpSession session = request.getSession();
				
        String role = (String) session.getAttribute("userRole");
        
        
       if(role.equals("admin")) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/archiveadmin.jsp");
        	dispatcher.forward(request, response);
        }
        else if(role.equals("user")) {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/archiveuser.jsp");
        	dispatcher.forward(request, response);
        }

		/*for(Archive archives : archivelist) {
			PrintWriter out = response.getWriter();
			out.println(archives.getTitle());
		}*/
	}
}
