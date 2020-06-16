package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB extends Database
{
	private static LoginDB instance=null;
	
	private LoginDB() {}
	
	public static LoginDB getInstance()//use singleton design pattern
	{
		if(instance==null) {
			instance=new LoginDB();
		}
		return instance;
	}
	
	//insert new login info to database-by manager in event of adding a new employee
    public void insertLoginInfo(String username, String password)
    {
        String sql = "INSERT INTO clients(username,password) VALUES(?,?)";
 
        try (Connection connect = this.connectToDB();
            PreparedStatement pstmt = connect.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
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
