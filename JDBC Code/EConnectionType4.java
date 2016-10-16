import java.sql.*;

public class EConnectionType4 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
			
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

			String query1="select * from Employee";
			Statement stat1=con.createStatement();
			ResultSet res1=stat1.executeQuery(query); //jdbc call
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