import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class newCustomer {
String confirm = "9";
//newCustomer NC = new newCustomer();
Scanner sc = new Scanner(System.in);
String Fname = "";
String Lname = "";
String PNum = "";
String VNum = "";
String PayStatus = "";
String PayAmount = "";
String PayDuration = "";
Connection connect;
String query;
PreparedStatement stmt;
public  void add() throws SQLException, InterruptedException {
try {
	System.out.println("Type Customer First Name : ");
	Fname = sc.nextLine();
	System.out.println("Type Customer Last Name : ");
	Lname = sc.nextLine();
	System.out.println("Type Customer Phone Number : ");
	PNum = sc.nextLine();
	System.out.println("Type Vehicle Number : ");
	VNum = sc.nextLine();
	System.out.println("Enter Payment Status : ");
	System.out.println("Enter                : 1 to SELECT *Paid*");
	System.out.println("Enter                : 2 to SELECT *Unpaid*");
	int temp = sc.nextInt();
	if(temp == 1) {
	System.out.println("Enter Payment Amount : ");
	sc.nextLine();
	PayAmount = sc.nextLine();
	System.out.println("Enter Payement Duration(in MONTHS) : ");
	PayDuration = sc.nextLine();
	PayDuration = PayDuration + " Month";
	}else {
		PayAmount = "0";
		PayDuration = "0";
		sc.nextLine();
	}
	if(temp == 1) {
		PayStatus = "Paid";
	}if(temp == 2) {
		PayStatus = "Balanced";
	}if(temp != 1 && temp != 2) {
		PayStatus = "error";
		
	}System.out.println("Confirm?(y/n) : ");
	
	confirm = sc.nextLine();
	confirm = confirm.toLowerCase();
	if(confirm.equals("y")) {
		 connect = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\admin\\Documents\\parking_management.db");
 query = "INSERT INTO INFO (FirstName,LastName,PhoneNumber,VehicleNumber,PaymentStatus,PaymentAmount,PaymentDuration) VALUES(?,?,?,?,?,?,?)";
 stmt = connect.prepareStatement(query);
stmt.setString(1, Fname);
stmt.setString(2, Lname);
stmt.setString(3, PNum);
stmt.setString(4,VNum);
stmt.setString(5, PayStatus);
stmt.setString(6, PayAmount);
stmt.setString(7, PayDuration);
stmt.execute();
System.out.println("Data has been added Sucessfully");
	}else {
		System.out.println("Edit and Try again");
	//NC.add();
		
	}
}catch(Exception e) {
	
	System.out.println("re-trying......");
	Thread.sleep(1000);
	System.out.println("Try again.");
	System.out.println(e);
	query = "CREATE TABLE \"INFO\" (\r\n"
			+ "	\"FirstName\"	TEXT NOT NULL,\r\n"
			+ "	\"LastName\"	TEXT NOT NULL,\r\n"
			+ "	\"PhoneNumber\"	TEXT NOT NULL,\r\n"
			+ "	\"VehicleNumber\"	TEXT NOT NULL,\r\n"
			+ "	\"PaymentStatus\"	TEXT NOT NULL,\r\n"
			+ "	\"PaymentAmount\"	TEXT NOT NULL,\r\n"
			+ "	\"PaymentDuration\"	TEXT NOT NULL\r\n"
			+ ");";
	stmt = connect.prepareStatement(query);
	stmt.execute();
	
}
}
}
