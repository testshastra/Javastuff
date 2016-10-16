import java.sql.*;
public class BatchUpdate
{
  public static void main(String args[])
  {
    try
    {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver")	;
		Connection con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "oracle");
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO customer (c_id, c_name, c_address, c_phone)VALUES (1001,\"Robert\", \"3410 Blonde St. Palo Alto\",\"2345678\" )");
		stmt.addBatch("INSERT INTO validate_user (username, password)VALUES (\"Robert\", \"R1o2b3\")");
		int[] results = stmt.executeBatch();
		System.out.println("Rows inserted in customer and validate_user tables");
		stmt.close();	
	}
	catch(Exception e)
	{
		System.out.println("Error : " + e);
	}
  }
}
