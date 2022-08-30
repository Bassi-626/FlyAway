package mypackage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Email=request.getParameter("email");
		String Password=request.getParameter("password");
		String Name=request.getParameter("name");
		String Phonehno=request.getParameter("phno");
		String Aadharno=request.getParameter("adno");
		
		HashMap<String,String> user=new HashMap<>();
		user.put("email", Email);
		user.put("password", Password);
		user.put("name", Name);
		user.put("phno", Phonehno);
		user.put("adno", Aadharno);
		
		try {
			Database db=new Database();
			boolean result=db.insertUser(user);
			HttpSession session=request.getSession();
			if(result) {
				session.setAttribute("message", "User Added Successfully");
			}
			else {
				session.setAttribute("message","Invalid Details");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("UserPage.jsp");
	}

}
