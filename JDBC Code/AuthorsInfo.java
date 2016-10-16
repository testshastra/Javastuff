import java.sql.*;
public class AuthorsInfo
{
	public static void main(String args[])
	{
		try
		{
			String str="SELECT * FROM author WHERE city LIKE 'O%'";
			/*Initialize and load the JDBC-ODBC Bridge driver*/

			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
			/*Establish a connection with a data source*/

			Connection con=DriverManager.getConnection("jdbc:odbc:MyDSN","system", "oracle");
			/*Create a Statement object to process the SELECT statement*/
			Statement stmt=con.createStatement();
			/*Execute the SELECT SQL statement*/
			ResultSet rs=stmt.executeQuery(str);
			System.out.println("Author ID\tFirst Name\tLast Name\tCity");
			/*Display the result*/
			while (rs.next())
			{
				String id=rs.getString("au_id");
				String lname=rs.getString("au_lname");
				String fname=rs.getString("au_fname");
				String city=rs.getString("city");
			
				/*Use tab to format the output. If the number of characters in a data value are less than or equal to 7, the two tabs are used to specify the position to display the next column in the ResultSet*/
				if (id.length() <=7) 
					System.out.print(id+"\t\t");
				else 
					System.out.print(id+"\t");
				if (fname.length() <=7) 
					System.out.print(fname+"\t\t");
				else 
					System.out.print(fname+"\t");
				if (lname.length() <=7)
					 System.out.print(lname+"\t\t");
				else 
					System.out.print(lname+"\t");
					System.out.println(city);
			}
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error occurred"+ex);
			//System.out.println("Error:"+ex);
		}
	}
}
