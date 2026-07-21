package practise;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.rmi.ServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException ,IOException{
		request.setCharacterEncoding("UTF-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		if(username==null||username.isBlank()||password==null||password.isBlank()) {
			request.setAttribute("error","帳號和密碼不能空白");
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			return;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try(Connection conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD)){
				String checksql="SELECT id FROM users WHERE username=?";
				try(PreparedStatement checkstmt=conn.prepareStatement(checksql)){
					checkstmt.setString(1, username);
					try(ResultSet rs=checkstmt.executeQuery()){
						if(rs.next()) {
							request.setAttribute("error", "帳號已被註冊");
							request.getRequestDispatcher("/register.jsp")
							.forward(request, response);
							return;
						}
						
					}
				}
				String insertsql ="INSERT INTO  users(username,password,role VALUES(?,?,'user')";
				try(PreparedStatement insertstmt =conn.prepareStatement(insertsql)){
					insertstmt.setString(1, username);
					insertstmt.setString(2, password);
					insertstmt.executeUpdate();
				}
				request.setAttribute("message","註冊成功" );
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				
			}
			
		}
		catch (Exception e) {
			throw new ServletException("註冊失敗",e);
		}
	}

	
	
}
