import java.sql.*;

class ConnectionUtil  
{
	static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:MyDSN","system","oracle");
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
		return con;
	}
}
