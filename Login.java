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
@WebServlet("/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String mail = request.getParameter("mail");
		String password =  request.getParameter("password");
		User user = new User();
		user.setMail(mail);
		user.setPassword(password);
		IUserAuthentication authenticate = new UserAuthentication();
	
		if(authenticate.validate(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("email", mail);
			
			try {
				response.sendRedirect("getsession");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//request.setAttribute("email", mail);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("getrole");
			/*try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

		else if(!authenticate.validate(user)) {
			try {
				response.sendRedirect("loginpage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*RequestDispatcher dispatcher = request.getRequestDispatcher("loginpage");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		
	}

}