import java.sql.*;
import java.util.Scanner;

public class update {
	static Connection connect;
	static String num = "";
	static String update = "";
	static Scanner sc = new Scanner(System.in);
	public static void connect() throws SQLException {
	
	 connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\admin\\Documents\\parking_management.db");
	 System.out.print("Enter Customer Number for Identification : ");
	 sc.nextLine();
	num = sc.nextLine();
	
	}
	public void vehicleNums() throws SQLException {
		
		connect();
		
		String query = "Update INFO set VehicleNumber = ? WHERE PhoneNumber = ?";
		PreparedStatement stmt = connect.prepareStatement(query);
		System.out.print("New Vehicle Number : ");
		update = sc.nextLine();
		stmt.setString(1, update);
		stmt.setString(2, num);
		stmt.execute();
		
	}
	public void PhoneNums() throws SQLException {
		 connect();
		String query = "Update INFO set PhoneNumber = ? WHERE PhoneNumber = ?";
		PreparedStatement stmt = connect.prepareStatement(query);
		System.out.print("New Phone Number : ");
		update = sc.nextLine();
		stmt.setString(1, update);
		stmt.setString(2, num);
		stmt.execute();
		
	}
	public void payStatus() throws SQLException {
		 connect();
		String query = "Update INFO set PaymentStatus = ? WHERE PhoneNumber = ?";
		PreparedStatement stmt = connect.prepareStatement(query);
		System.out.println("1 : Paid\n2 : Not Paid");
		update = sc.nextLine();
		if(update.equals("1")) {
			update = "Paid";
		}if(update.equals("2")) {
			update = "Not Paid";
		}else {
			update = "error";
		}
		stmt.setString(1, update);
		stmt.setString(2, num);
		stmt.execute();
		
	}
	public void payDuration() throws SQLException {
		 connect();
		String query = "Update INFO set PaymentDuration = ? WHERE PhoneNumber = ?";
		PreparedStatement stmt = connect.prepareStatement(query);
		System.out.print("Enter Duration Period : ");
		int period = sc.nextInt();
		update = update.valueOf(period);
		System.out.println("Enter One Month Amount : ");
		int amount = sc.nextInt();
		stmt.setString(1, update);
		stmt.setString(2, num);
		stmt.execute();
		update = update.valueOf(period * amount);
		payAmount(update);
		
}public static void payAmount(String update) throws SQLException {
	 
	String query = "Update INFO set PaymentAmount = ? WHERE PhoneNumber = ?";
	PreparedStatement stmt = connect.prepareStatement(query);
	
	stmt.setString(1, update);
	stmt.setString(2, num);
	stmt.execute();
	
}
public void operation() throws SQLException {
	try {
	System.out.println("Operation :- \n       1  : To Update Vehicle Number\n       2  : To Update Phone Number\n       3  :"
			+ " To Update Payment Status\n       4  : To Update Payment Duration ");
 int operation = sc.nextInt();
 update updt = new update();
 switch(operation) {
 case 1 :
	 updt.vehicleNums();
	 System.out.println("Given Data Updated Sucessfully!!");
	 break;
 case 2 :
	 updt.PhoneNums();
	 System.out.println("Given Data Updated Sucessfully!!");
	 break;
 case 3 :
	 updt.payStatus();
	 System.out.println("Given Data Updated Sucessfully!!");
	 break;
 case 4 :
	 updt.payDuration();
	 System.out.println("Given Data Updated Sucessfully!!");
	 break;
	 default :
		 System.out.println("Invalid Operation!!!!");
 }
	}catch(Exception e) {
		System.out.println(e);
	}
 
}
}
