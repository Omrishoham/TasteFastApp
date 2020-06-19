package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersDB extends Database
{
	private static OrdersDB instance=null;
	
	private OrdersDB() {}
	
	public static OrdersDB getInstance()//use singleton design pattern
	{
		if(instance==null) {
			instance=new OrdersDB();
		}
		return instance;
	}
	
	public void insertOrder(String username,int orderNumber,double totalPrice,String creditCardNum,String creditCardVal)
	{
		Connection connect = connectToDB();
        try
        {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO orders(username,orderNumber,totalPrice,creditCardNum,creditCardVal) VALUES(?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setInt(2, orderNumber);
            pstmt.setDouble(3,totalPrice);
            pstmt.setString(4, creditCardNum);
            pstmt.setString(5, creditCardVal);
            pstmt.executeUpdate();
        	
        }
          catch (SQLException e) {
            System.out.println(e.getMessage());
          }
	}

}
