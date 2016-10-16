import java.sql.*;
public class CallStoredProc
{
   public static void main(String args[])
   {
	try
  	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")	;
		Connection con=DriverManager.getConnection("jdbc:odbc:MyDSN","system","oracle");
		String str = "{SELECTROW}";
		CallableStatement cstmt = con.prepareCall(str);
	      	ResultSet rs = cstmt.executeQuery();
	      	while(rs.next())
         		{
		            System.out.println("Ecode   : " +   rs.getString(1)+"\n");
		            System.out.println("Employee Name : "+rs.getString(2)+"\n");
		            System.out.println("Salary : " + rs.getInt(3)+"\n");
		            System.out.println("-----------------------------------------------\n");
 	             }

	} 
     	catch(Exception e)
     	{
		System.out.println("Error : " + e);
	}
  }
}
