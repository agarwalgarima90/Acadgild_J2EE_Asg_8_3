package pckdb;
import java.sql.*;

public class Mydb {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public Mydb(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/springjdbc", "root", "root123");
		} catch(ClassNotFoundException e) {
			System.out.println("Unable to connect");
		} catch(Exception se) { 
			System.out.println("sql error!");
		}
	}
	
	public String displayWithbrowser() {
		String dbdata="<table border='1' width='100%'>";
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from employees;");
			dbdata+="<tr align='center'><td><b>EmpId</b></td> <td><b>First Name</b></td> <td> <b>Last Name</b></td> <td> <b>Age</b> </td></tr>";
			while(rs.next()) {
				dbdata+="<tr>"+"<td>" + rs.getString(1) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) +"</td><td>" + rs.getString(2)  + "</tr>";
			}
			
			
		} catch(Exception e) {
			System.out.println("KKK:" + e);
		}
		return dbdata+"</table>";
	}
	
	public void closecon(){

		try{
			con.close();
		} catch(SQLException se) { 
			System.out.println("sql error!");
		}
	}
}
