import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class show {
	Scanner sc = new Scanner(System.in);
	String Fname = "";
	String Lname = "";
	String PNum = "";
	String VNum = "";
	String PayStatus = "";
	String PayAmount = "";
	String PayDuration = "";
	String query;
	PreparedStatement stmt;
	public void show() throws SQLException {
		int records = 0;
	try {
		String query = "SELECT * FROM INFO";
		Connection connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\admin\\Documents\\parking_management.db");
		stmt = connect.prepareStatement(query);
		 records = 0;
		ResultSet rs = stmt.executeQuery();
		System.out.println("Fetching Data.........");
		Thread.sleep(4000);
		boolean flag = false;
		System.out.println("-------------------------------------------------------------------------------------------------");
		while(rs.next()) {
			flag = true;
			records++;
			Fname = rs.getString(1);
			Lname = rs.getString(2);
			PNum = rs.getString(3);
			VNum = rs.getString(4);
			PayStatus = rs.getString(5);
			PayAmount = rs.getString(6);
			PayDuration = rs.getString(7);
System.out.println("First Name      : " + Fname);
System.out.println("Last Name       : " + Lname);
System.out.println("Phone Number    : " + PNum);
System.out.println("Vehicle Number  : " + VNum);
System.out.println("Payment Status  : " + PayStatus);
System.out.println("Payment Amount  : " + PayAmount);
System.out.println("Payment Duration: " + PayDuration);
System.out.println("-------------------------------------------------------------------------------------------------");
		}
		if(!flag) {
			System.out.println(records + " Records Found\nENTER SOME RECORDS");
		}
	}catch(Exception e) {
		System.out.println(e);
		
	}
	}
	
	 
}
