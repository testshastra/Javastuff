import java.sql.*;

public class  ProductRecords
{
	public static void main(String[] args) 
	{
		try
		{
			Connection con=ConnectionUtil.getConnection();
			Statement stat=con.createStatement();
			ResultSet res=stat.executeQuery("select * from Product");

			while(res.next())
			{
				System.out.print(res.getInt(1)+"\t");
				System.out.print(res.getString(2)+"\t");
				System.out.print(res.getDouble(3)+"\t");
				System.out.print(res.getInt(4)+"\t");
				System.out.print(res.getString(5)+"\n");
			}
		}
		catch (Exception e1)
		{
			System.out.println(e1);
		}
	}
}
