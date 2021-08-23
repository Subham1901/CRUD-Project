import java.sql.*;
public class Insert {

	public static void main(String[] args) {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/prac","root","subham");
			Statement st=con.createStatement();
			int i=st.executeUpdate("insert into student_contactsvalues(90,'subham','odisha','subham1901@gmail.com')");
			if(i==1) {
				System.out.println("Successfully");
			}
			else {
				System.out.println("Error");
			}
		}
		catch(Exception e) {
				e.getStackTrace();
		}

	}

}
