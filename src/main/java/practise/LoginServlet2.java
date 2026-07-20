package practise;

import java.io.IOException;
import java.rmi.server.ServerCloneException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginPractise")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID=1L;
	
	private static final String UB_URL= "jdbc:mysql://localhost:3306/jsp_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei";	
	private static final String UB_USER="jsp_user";
	private static final String UB_PASSWORd="Cookie1007";
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
		request.getRequestDispatcher("login2.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("username");
		String password=request.getParameter("password");
		
		if("admin".equals(username)&&"1234".equals(password)) {
			request.getRequestDispatcher("admin2.jsp").forward(request, response);
		}
		else if("user".equals(username)&&"1111".equals(password)){
			request.getRequestDispatcher("user2.jsp").forward(request, response);
		}
		else {
			request.setAttribute("error", "錯誤");
			request.getRequestDispatcher("login2.jsp").forward(request, response);
		}
	}
		
	
	
}
