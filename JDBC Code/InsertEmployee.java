import java.sql.*;
import java.io.*;
import java.util.*;

public class InsertEmployee 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

			System.out.println("Enter Data to Insert into Employee Table!!!");
			
			String ecode="";
			String ename="";
			int salary=0;
			Scanner sc=new Scanner(new InputStreamReader(System.in));
			if(sc.hasNext())
			{
				ecode=sc.nextLine();
				ename=sc.nextLine();
				salary=sc.nextInt();
			}
			

			PreparedStatement pre=con.prepareStatement("insert into employee values(?,?,?)");

			pre.setString(1,ecode);
			pre.setInt(2,salary);
			pre.setString(3,ename);

			int raffected=pre.executeUpdate();
			if(raffected>0)
				System.out.println("RECODE INSERTED SUCCESSFULLY!!!!");
			else
				System.out.println("RECODE IS NOT INSERTED x x x x x x");

		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
