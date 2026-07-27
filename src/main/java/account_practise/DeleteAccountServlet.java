package account_practise;

import java.io.IOException;
import java.rmi.ServerException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteAccount")
public class DeleteAccountServlet extends HttpServlet {
	protected static final long serialVersionUID=1L;
	private static final String DB_URL=
		"jdbc:mysql://localhost:3306/jsp_demo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei";
	private static final String DB_USER="jsp_user";
	private static final String DB_PASSWORD="Cookie1007";
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServerException,IOException{
		
		
		
	}
}
