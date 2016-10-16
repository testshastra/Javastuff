import java.sql.*;

public class EConnectionType2 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");	

			Connection con=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:XE","system","oracle");
			
			System.out.println("CONNECTION ESTABLISHED !!!!!!!");

			Statement stat=con.createStatement();
			ResultSet res=stat.executeQuery("select * from Insurance"); //jdbc call
			System.out.println("==================================");

			while(res.next()) //true false
			{
				System.out.print(res.getInt("ID")+"\t\t");
				System.out.print(res.getString("INSURANCE_NAME")+"\t");
				System.out.print(res.getDate("INVESTEMENT_DATE")+"\t");
				System.out.print(res.getInt("INVESTED_AMOUNT")+"\n");
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}