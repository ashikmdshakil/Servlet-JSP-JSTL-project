package tourproject.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tourproject.Bean.User;
import tourproject.Repositories.IUserAuthentication;
import tourproject.Service.UserAuthentication;
@WebServlet("/getsession")
public class AssignSession extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		IUserAuthentication authenticate = new UserAuthentication();
		String mail = (String)session.getAttribute("email");
		//User user = new User();
		User user = authenticate.getSession(mail);
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		session.setAttribute("userRole", user.getRole());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("homepage");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//PrintWriter out = response.getWriter();
		//out.println("My name is "+ (String)session.getAttribute("userName"));
		//out.println("My email adress is "+(String)session.getAttribute("email"));
		//out.println("my role is "+ (String)session.getAttribute("userRole"));
		
	}
}
