import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class ProductInfo extends JFrame implements ActionListener
{
	/*Declare the variables to create the application interface for   the Product Information application*/
	JLabel heading, id, desc, rate, quantity, unit_of_msr, 
	empty_label,error;
	JTextField idField, descField, rateField, quantityField, 
	 unit_of_msrField;
	 JButton insert, update, delete, clear, exit;
	 GridBagLayout gbl;
	 GridBagConstraints gbc;
	 JComboBox idCombo;
	 Connection con;
	 PreparedStatement stat;
	 Statement stmt;
	 ResultSet rs;
	 Font f;
	 JPanel jp1;
	 /*Define the constructor for the Product Information application*/ 
	public ProductInfo()
	{
		setTitle("Product Information");
		setSize(600, 300);
		/*Register the WindowListener interface to define the windowClosing() method*/ 
		addWindowListener(new WindowAdapter()
	{
	public void windowClosing(WindowEvent we)
	{
		 System.exit(0);
		}
	});
	/*Initialize the JPanel object*/
	jp1=new JPanel();
	/*Set the BorderLayout as the layout manager*/
	getContentPane().setLayout(new BorderLayout());
	/*Initialize the GridBagLayout object*/
	gbl = new GridBagLayout();
	/*Initialize the GridBagConstraints object*/
	gbc = new GridBagConstraints();
	jp1.setLayout(gbl);
	f = new Font("Monospaced", Font.BOLD, 24);
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.gridwidth = 3;
	/*Initialize the JLabel object to set the caption for the application*/
	heading = new JLabel("Product Information");
	/*Set the font for the caption*/
	heading.setFont(f);
	/*Add the caption to the Panel*/
	jp1.add( heading, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 5;
		empty_label = new JLabel("");
		empty_label.setFont(f);
		jp1.add( empty_label, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
	/*Initialize the id JLabel object*/
	id = new JLabel("ID", SwingConstants.LEFT);   
	/*Add the label, id to the panel*/
		jp1.add( id, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		/*Initialize the idField JTextField object*/
		idField = new JTextField(10);
		/*Add the JtextField object, idField to the panel*/
		jp1.add( idField, gbc);
		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		/*Initialize the idCombo JComboBox object*/
		idCombo = new JComboBox();
		/*Set the editable option of idCombo object to false*/
		idCombo.setEditable(false);	
		/*Add the JComboBox object, idCombo to the panel*/
		jp1.add(idCombo, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
	/*Initialize the desc JLabel object*/
		desc = new JLabel("Description", SwingConstants.LEFT);
		/*Add the desc JLabel object to the panel*/
		jp1.add( desc, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		/*Initialize the descField JTextField object*/
		descField = new JTextField(20);
		/*Add the descField JTextField object to the panel*/
		jp1.add( descField, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		/*Initialize the rate JLabel object*/
		rate = new JLabel("Rate", SwingConstants.LEFT);
		/*Add the rate JLabel object to the panel*/
	  jp1.add( rate, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 4;
	  gbc.gridwidth = 2;
	  /*Initialize the rateField JTextField object*/
	  rateField = new JTextField(20);
	  /*Add the rateField object to panel*/
	  jp1.add( rateField, gbc);
	  gbc.gridx = 1;
	  gbc.gridy = 5;
	  gbc.gridwidth = 1;
	  /*Initialize the quantity JTextField object*/
	  quantity = new JLabel("Quantity", SwingConstants.LEFT);
	  /*Add the quantity object to panel*/
	  jp1.add( quantity, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 5;
	  gbc.gridwidth = 2;
	  /*Initialize the quantityField JTextField object*/
	  quantityField = new JTextField(20);
	  /*Add the quantityField object to panel*/
	  jp1.add( quantityField, gbc);
	  gbc.gridx = 1;
	  gbc.gridy = 6;
	  gbc.gridwidth = 1;
	  /*Initialize the unit_of_msr JLabel object*/
	  unit_of_msr = new JLabel("Unit of Measurement ",SwingConstants.LEFT);
	  /*Add the unit_of_msr object to panel*/
	  jp1.add( unit_of_msr, gbc);
	  gbc.gridx = 2;
	  gbc.gridy = 6;
	  gbc.gridwidth = 2;
	  /*Initialize the unit_of_msrField JTextField object*/
	  unit_of_msrField = new JTextField(20);
	  /*Add the unit_of_msrField object to panel*/
	  jp1.add( unit_of_msrField, gbc);
	  gbc.gridx = 0;
	  gbc.gridy = 7;
	  gbc.gridwidth = 1;
	  /*Initialize the insert JButton object*/
	  insert = new JButton("Insert");
	  /*Register ActionListener on insert JButton object*/
	  insert.addActionListener(this);
	  /*Add the insert object to the panel*/
	  jp1.add( insert, gbc);	
	  gbc.gridx = 1;
	  gbc.gridy = 7;
	  gbc.gridwidth = 1;
	  /*Initialize the update JButton object*/
	  update = new JButton("Update");
	  /*Register ActionListener on update JButton object*/
		update.addActionListener(this);
		/*Add update object to panel*/
		jp1.add( update, gbc);
		gbc.gridx = 2;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		/*Initialize the delete JButton object*/
		delete = new JButton("Delete");
		/*Register ActionListener on delete JButton object*/
		delete.addActionListener(this);
		/*Add delete object to panel*/
		jp1.add( delete, gbc);
		gbc.gridx = 3;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		/*Initialize the clear JButton object*/
		clear = new JButton("Clear");
		/*Register ActionListener on clear JButton object*/
		clear.addActionListener(this);
		/*Add the clear JButton object to panel*/
		jp1.add( clear, gbc); 
		gbc.gridx = 4;
		gbc.gridy = 7;
		gbc.gridwidth = 1;
		/*Initialize the exit JButton object*/
		exit = new JButton("Exit");
		/*Register ActionListener on exit JButton object*/
		exit.addActionListener(this);
		/*Add the exit JButton object to panel*/
		jp1.add( exit, gbc);
		/*Initialize the error JLabel object*/
		error = new JLabel("");
		/*Add jp1 JPanel object in the center of the contentpane*/
		getContentPane().add(jp1,"Center");
		/*Add error JLabel object to the contentpane*/	
		getContentPane().add(error,"South");
		try
		{
			/*Initialize and load JDBC-ODBC bridge driver*/
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			/*Connect to a data source*/
			con = DriverManager.getConnection("jdbc:odbc:MyDSN", 
			"system","oracle");
			/*Create a Statement object*/
			stmt = con.createStatement();
	/*Retrieve the rows from the product table and store them in the result set object rs*/
			rs = stmt.executeQuery("SELECT id FROM product");
	/*Display the p_id values in the idCombo object*/
		while (rs.next())
			{
					idCombo.addItem(Integer.toString(rs.getInt(1)));		}
	   /*Close the Connection object*/
	   con.close();
	  }
	  catch(Exception e)
	  {
	   System.out.println("Error : "+e);
	  }
	  idCombo.addActionListener(this);
	 }
	 public void actionPerformed(ActionEvent ae)
	 {
	  if(ae.getActionCommand() == "Exit") 
	  /*Terminate the execution of the application*/
	  System.exit(0);
	  if(ae.getActionCommand() == "Delete")
	  {
		/*Delete the selected row from the product table*/
		try
		{
			/*Initialize the con Connection object */
		con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "oracle");
		/*Initialize the stat PreparedStatement object to delete a row*/
		stat = con.prepareStatement("DELETE from Product WHERE id = ?");
			String selected_id = idCombo.getSelectedItem().toString();
			int id = Integer.parseInt(selected_id);
			stat.setInt(1, id);
			/*Execute the query*/
			stat.executeUpdate();	
			/*Close the connection*/
			con.close();
			/*Remove ActionListener from idCombo JComboBox object*/
			idCombo.removeActionListener(this);
			/*Initialize the con Connection object*/
			con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "oracle");
			/*Initialize the stmt Statement object*/
			stmt = con.createStatement();
		/*Store all the rows of the product table in the rs ResultSet object*/
			rs = stmt.executeQuery("SELECT id FROM product");
		/*Remove all the elements from the idCombo JcomboBox object*/
			idCombo.removeAllItems();
			while (rs.next())
				idCombo.addItem(Integer.toString(rs.getInt(1)));
			con.close();
					idCombo.addActionListener(this);
				idField.setText("");
				descField.setText("");
				rateField.setText("");
		   quantityField.setText("");
		   unit_of_msrField.setText("");
		   error.setText("Row Deleted");
		  }
		  catch(Exception e)
		  {
		   System.out.println("Error " + e );
		   error.setText("Row cannot be deleted");
		  }
	 }
	 if(ae.getActionCommand() == "Insert")
	 {
	  //Insert a row in the product table
	  try
	  {
	con = DriverManager.getConnection("jdbc:odbc:MyDSN",  "system", "oracle");
	stat = con.prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?, ?)");
	String id = idField.getText();
		String description = descField.getText();
		String rate = rateField.getText();
		String quantity = quantityField.getText();                              
		String unit_of_msr = unit_of_msrField.getText();    
		
		stat.setInt(1, Integer.parseInt(id));
		stat.setString(2, description);
		stat.setDouble(3, Double.parseDouble(rate));
		stat.setInt(4, Integer.parseInt(quantity));
		stat.setString(5, unit_of_msr);

		/*Execute the INSERT statement*/
		stat.executeUpdate();
		con.close();
		idCombo.removeActionListener(this);
	con = DriverManager.getConnection("jdbc:odbc:MyDSN", "system", "oracle");
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT id FROM product");
		idCombo.removeAllItems();
		while (rs.next())
	/*Refresh the id values in the idCombo JComboBox after inserting a new row*/ 
			idCombo.addItem(Integer.toString(rs.getInt(1)));
		con.close();
		idCombo.addActionListener(this);
		error.setText("Row Inserted");
	  }
	  catch(Exception e)
	  {
	   System.out.println("Error1 "+e);
	   error.setText("Row cannot be inserted");
	} 	                     
	}
	   if(ae.getSource() == idCombo)
	   { 
	/*Display the row corresponding the id selected in the idCombo combobox*/ 
		try
		{	
			con = DriverManager.getConnection("jdbc:odbc:MyDSN",         "system", "oracle");
			String selected_id = idCombo.getSelectedItem().toString();	int id = Integer.parseInt(selected_id);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT description, rate, quantity,  unit_of_msr FROM product WHERE id = " + id);
			rs.next();
			idField.setText(selected_id);
			descField.setText(rs.getString(1));
			rateField.setText(Double.toString(rs.getDouble(2)));
			quantityField.setText(Integer.toString(rs.getInt(3)));
			unit_of_msrField.setText(rs.getString(4));
			con.close();
		}
		catch(Exception e)
		{
		System.out.println("Error " + e);
		}
	 }
	if(ae.getActionCommand()=="Update")
	{
	try
		{
	con = DriverManager.getConnection("jdbc:odbc:MyDSN",  "system", "oracle");	
	/*Initialize the stat PreparedStatement object to update a row in the product table*/
	stat = con.prepareStatement("UPDATE Product SET description = ?, rate = ?,   quantity = ?, unit_of_msr = ? where id = ?");
		String description = descField.getText();
		String rate = rateField.getText();
		String quantity = quantityField.getText();                                   
		String unit_of_msr = unit_of_msrField.getText();              
		String id_selected = idField.getText();
		int id = Integer.parseInt(id_selected);
		stat.setString(1, description);
		stat.setDouble(2, Double.parseDouble(rate));
		stat.setInt(3, Integer.parseInt(quantity));
		stat.setString(4, unit_of_msr);
		stat.setInt(5, id);
		/* Execute the UPDATE statement*/
			stat.executeUpdate();	
			con.close();
			error.setText("Row Updated");
		}
			catch(Exception e)
			{
			System.out.println("Error " + e );
			error.setText("Cannot update the row");
			}
		} 
		if(ae.getActionCommand() == "Clear")
		{
		/*Clear the contents of all the fields*/
		idField.setText("");
		descField.setText("");
		rateField.setText("");
		quantityField.setText("");
		unit_of_msrField.setText("");
		}
	 }
	 public static void main(String args[])
	 {
	  ProductInfo p = new ProductInfo();
	  p.show();
	 }	
}