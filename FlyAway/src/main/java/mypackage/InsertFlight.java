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

@WebServlet("/InsertFlight")
public class InsertFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("date");
		String timein=request.getParameter("timein");
		String timeout=request.getParameter("timeout");
		String price=request.getParameter("price");
		
		HashMap<String,String> Flight=new HashMap<>();
		Flight.put("name", name);
		Flight.put("source", source);
		Flight.put("destination", destination);
		Flight.put("date",date );
		Flight.put("timein", timein);
		Flight.put("timeout", timeout);
		Flight.put("price", price);
		
		try {
			Database db=new Database();
			HttpSession session=request.getSession();
			if(db.insertFlight(Flight)) {
				
				session.setAttribute("message", "Flight Added Successfully");
			}
			else {
				session.setAttribute("message", "Invalid Details");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("error");
			e.printStackTrace();
		}
		response.sendRedirect("AdminHome.jsp");
		
	}

}
