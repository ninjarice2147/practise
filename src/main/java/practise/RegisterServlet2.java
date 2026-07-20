package practise;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.rmi.ServerException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register2")
public class RegisterServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String DB_URL="jdbc:mysql://localhost:3306/jsp_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei";
	private static final String DB_USER="jsp_user";
	private static final String DB_PASSWORD="Cookie1007";
	
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException {
		request.getRequestDispatcher("/register.jsp").forward(request, response);
		
	}
		
	
	
}
