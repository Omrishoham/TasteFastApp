package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientsDB extends Database
{
	private static ClientsDB instance=null;
	
	private ClientsDB() {}
	
	public static ClientsDB getInstance()//use singleton design pattern
	{
		if(instance==null) {
			instance=new ClientsDB();
		}
		return instance;
	}
	
	//insert new login info to database-by manager in event of adding a new employee
    public void insertInfo(String username, String password, String email,String firstName,String lastName)
    {
 
        try (Connection connect = this.connectToDB())
        {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO clients(username,password,email,firstName,lastName) VALUES(?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            pstmt.setString(4, firstName);
            pstmt.setString(5, lastName);
            pstmt.executeUpdate();
        	
        }
          catch (SQLException e) {
            System.out.println(e.getMessage());
          }
     }
    
  //gets userName and pass strings and checks they got a match in login table
    public boolean loginAuthentication(String username,String password)
    {
        String sql = "SELECT username, password FROM clients";
        
        try (Connection connect = this.connectToDB();
             Statement stmt  = connect.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (resultSet.next()) {
            	if(resultSet.getString("username").equals(username)&&resultSet.getString("password").equals(password))
            		return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
    }
}
