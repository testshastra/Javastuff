import java.sql.*;

public class EConnectionMySQL 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","mysql");
			
			System.out.println("CONNECTION ESTABLISHED !!!!!!!");

			String query="select * from Employee";
			Statement stat=con.createStatement();
			ResultSet res=stat.executeQuery(query); //jdbc call
			System.out.println("==================================");

			while(res.next()) //true false
			{
				System.out.print(res.getString("Ecode")+"\t");
				System.out.print(res.getString("Ename")+"\t");
				System.out.print(res.getInt("Salary")+"\n");
			}	
			
			String insert="insert into employee values('E123','Smith',32553)";
			int ra=stat.executeUpdate(insert);
			if(ra>0)
				System.out.println("Row Inserted Successfully!!!!!!!");
			else
				System.out.println("Not Inserted Successfully!!!!!!!");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}