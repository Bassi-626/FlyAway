package mypackage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Database {
	public Connection con=null;
	public Statement st=null;

	public Database() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/FlyAway","root","Basant22");
		System.out.println("connection established with database");
		st=con.createStatement();
	}

	
	public boolean insertUser(HashMap<String, String> user) {

		String query="INSERT INTO user (Email, Password, Name, Phonenumber, Aadharnumber) "
				+ "values('"+user.get("email")+"','"+user.get("password")+"','"+user.get("name")
				+"','"+user.get("phno")+"','"+user.get("adno")+"')";                       
		
		try {
		st.execute(query);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public HashMap<String, String> checkUser(String email, String password) {
		
		HashMap<String,String> user=null;
		String query="select * from user where email='"+email+"' and password='"+password+"'";
		try {
			ResultSet rs=st.executeQuery(query);
			if(rs.next()) {
				user=new HashMap<>();
				user.put("name", rs.getString("name"));
				user.put("email",rs.getString("email"));
				user.put("phonenumber",rs.getString("phonenumber"));
				user.put("aadharnumber",rs.getString("aadharnumber"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public boolean checkAdmin(String email, String password) {
		
		try {
			ResultSet rs=st.executeQuery("select * from admin where email='"+email+"' and password='"+password+"'");
			if(rs.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean insertFlight(HashMap<String, String> Flight) throws SQLException {
		//PreparedStatement stm=con.prepareStatement("INSERT INTO 'flyaway.flights' ('name', 'from', 'to', 'date', 'time', 'price') values(?,?,?,?,?,?)");
		String sql="INSERT INTO Flight (Name, Source, Destination, Date, Time_In, Time_Out, Price) "
				+ "values('"+Flight.get("name")+"','"+Flight.get("source")+"','"+Flight.get("destination")
				+"','"+Flight.get("date")+"','"+Flight.get("timein")+"','"+Flight.get("timeout")+"','"+Flight.get("price")+"');";
		//String query1 = "INSERT INTO flights (name, fromf, tof, datef, timef, price) VALUES" + " ('"
			//	+ (flight.get("name")) + "'," + " '" + (flight.get("from")) + "'," + " '"
			//	+ (flight.get("to")) + "'," + " '" + (flight.get("date")) + "'," + " '"
			//	+ (flight.get("time")) + "'," + " '" +(flight.get("price")) + "')";
		
		//String sql="INSERT INTO `flyaway`.`flights` (`name`, `fromf`, `tof`, `datef`, `timef`, `price`) VALUES ('indigo', 'hyd', 'viz', '2021-04-08', '10:00', '2000');";
		System.out.println(Flight.get("date"));
		System.out.println(Flight.get("time"));
		//String query1="INSERT into flyaway.flights (name,from,to,date,time,price) values('indigo','hyd','viz','24-02-2022','10:30','2000')";
		try {
			//stm.execute();
			st.execute(sql);
			return true;
		} catch (SQLException e) {
			System.out.print("error");
			e.printStackTrace();
		}
		return false;
	}
	public boolean changeAdminPassword(String email, String password) {

		try {
			ResultSet rs=st.executeQuery("select * from admin where email='"+email+"'");
			if(!rs.next()) {
				return false;
			}
			st.execute("update admin set password='"+password+"' where email='"+email+"'");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
public List<String[]> getAvailableFlights(String from, String to, String departure) {
		
		List<String[]> flights=new ArrayList<>();
		String query="SELECT * FROM Flight where Source='"+from+"' and Destination='"+to+"' and Date='"+departure+"'";
		try {
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next()) {
				String[] flight=new String[4];
				flight[0]=rs.getString("name");
				flight[1]=rs.getString("time_in");
				flight[2]=rs.getString("time_out");
				flight[3]=rs.getString("price");
				flights.add(flight);
				return flights;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}


	
	
	}
	

