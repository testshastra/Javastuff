import java.sql.*;

public class  CreateTable 
{
	public static void main(String[] args) 
	{
		boolean flag=false;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");

			String str="create table authors(au_id char(5),au_lname varchar(50),au_fname varchar(50),phone varchar(15),address varchar(100),city char(20),state varchar(20),zip varchar(15))";

			Statement stat=con.createStatement();
			//System.out.println("Execute Returned ::  "+stat.execute(str));

			flag=stat.execute(str);
			if(!flag)
				System.out.println("TABLE IS CREATED !!!!!"+flag);
			else
				System.out.println("Table is Not Created"+flag);

/*			String dstr="drop table author1";
			stat.execute(dstr);
			System.out.println("Table AUTHOR1 is Dropped!!!");*/
		}
		catch (Exception e1)
		{
			e1.printStackTrace();							System.out.println("Table is Not Created"+flag);
		}
	}
}
