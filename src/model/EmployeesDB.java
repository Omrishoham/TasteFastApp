package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesDB extends Database
{
	private static EmployeesDB instance=null;
	
	private EmployeesDB() 
	{}
		
	public static EmployeesDB getInstance() //use singleton design pattern
	{
		if(instance==null) {
			instance=new EmployeesDB();
		}
		return instance;
	}
	
	public void insertLoginInfo(String username, String password)
    {
 
        try (Connection connect = this.connectToDB())
        {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO employees(username,password) VALUES(?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        	
        }
          catch (SQLException e) {
            System.out.println(e.getMessage());
          }
     }

}
