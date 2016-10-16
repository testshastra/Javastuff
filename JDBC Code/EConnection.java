import java.sql.*;

public class EConnection 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //Register the driver JRE	

			Connection con=DriverManager.getConnection("jdbc:odbc:MyDSN","system","oracle");
			
			System.out.println("CONNECTION ESTABLISHED !!!!!!!");


			Statement stat=con.createStatement();
			
			String insert="insert into employee values('E123',32553,'Smith')";
			int ra=stat.executeUpdate(insert);
			if(ra>0)
				System.out.println("Row Inserted Successfully!!!!!!!");
			else
				System.out.println("Not Inserted Successfully!!!!!!!");
	
			Statement stat1=con.createStatement();
			ResultSet res1=stat1.executeQuery("select * from Employee"); //jdbc call
			System.out.println("==================================");

			while(res1.next()) //true false
			{
				System.out.print(res1.getString("Ecode")+"\t");
				System.out.print(res1.getString("Ename")+"\t");
				System.out.print(res1.getInt("Salary")+"\n");
			}	

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}

