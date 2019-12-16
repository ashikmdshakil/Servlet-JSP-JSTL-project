package tourproject.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tourproject.Bean.User;
import tourproject.Repositories.IUserAuthentication;
import tourproject.Service.UserAuthentication;
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	protected void doPost(HttpServletRequest reuest, HttpServletResponse response) {
		doGet(reuest, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		String mail = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String role = "user";
		
		User user = new User(name, mail, number, password, role);
		IUserAuthentication authenticate = new UserAuthentication();
		authenticate.signUp(user);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ashik/welcome.jsp");
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
