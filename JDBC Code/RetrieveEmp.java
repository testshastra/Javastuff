import java.sql.*;

public class  RetrieveEmp
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");	
			Connection con=DriverManager.getConnection("jdbc:odbc:MyDSN","system","oracle");

			PreparedStatement pre=con.prepareStatement("select * from employee where salary>?");
			int salary=Integer.parseInt(args[0]);
			pre.setInt(1,salary);

			ResultSet res=pre.executeQuery();
			while(res.next())
			{
				System.out.print(res.getString("Ecode")+"\t");
				System.out.print(res.getString("Ename")+"\t");
				System.out.print(res.getInt("Salary")+"\n");
			}
			con.close();
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
