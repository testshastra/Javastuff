import java.sql.*;
public class ColumnInfo
{
public static void main(String args[])
{
	  try
	  {
		/*Initialize and load the JDBC-ODBC bridge driver*/
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/*Establish a connection with a data source*/
		
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
				/*Create an SQL statement*/
			String str= "SELECT * FROM "+args[0]+"";
			Statement stmt = con.createStatement();
				/*Execute an SQL statement*/
				ResultSet rs = stmt.executeQuery(str);
				ResultSetMetaData rsmd = rs.getMetaData();
				rs.next();
				/*Retrieve the number of columns in a ResultSet*/
			System.out.println("Number of Attributes in the authors Table:"+rsmd.getColumnCount());
				System.out.println("");
			System.out.println("-------------------------------------");
			  System.out.println("Attributes of the "+args[0]+" Table");
			  System.out.println("-------------------------------------");
			  /*Retrieve and display the names and data types of various               columns in a ResultSet*/
			  for(int i = 1; i <= rsmd.getColumnCount(); i++)
			  {
			System.out.println(rsmd.getColumnName(i) + " : " + rsmd.getColumnTypeName(i));
			  }
			 /*Close the ResultSet object*/  
			rs.close();
			/*Close the Statement object*/
			stmt.close();
		}
		catch(Exception e)
		{
		   System.out.println("Error : " + e);
		}
	}
}