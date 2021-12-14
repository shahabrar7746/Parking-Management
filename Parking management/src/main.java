import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
//
		int opt = 0;
		System.out.println("Choose Operation:-");
		System.out.println("                 :1 to Add Customer");
		System.out.println("                 :2 to Update Data");
		System.out.println("                 :3 to Fetch Existing Data");
	Scanner sc = new Scanner(System.in);
	System.out.print("Operation : ");
	System.out.print("");
		opt = sc.nextInt();

		
		switch(opt) {
		case 1 :
			newCustomer NC = new newCustomer();
			NC.add();
		
			break;
		case 2 :
			update udt = new update();
         	udt.operation();
         	break;
		case 3 :
			show show = new show();
			show.show();
			break;
			default :
				System.out.println("Invalid Operation!!\nTRY AGAIN");
			
		}
	
		
	}

}
