	package model;

import java.sql.Connection;
import java.util.Date;
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
	
	public void insertOrder(String username,String orderID,double totalPrice,String creditCardNum,String creditCardVal,Date orderTime )
	{
		Connection connect = connectToDB();
        try
        {
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO orders(username,orderid,totalprice,creditcardnum,creditcardval,orderdate,ordertime) VALUES(?,?,?,?,?,?,?)");
            pstmt.setString(1, username);
            pstmt.setString(2, orderID);
            pstmt.setDouble(3,totalPrice);
            pstmt.setString(4, creditCardNum);
            pstmt.setString(5, creditCardVal);
            pstmt.setString(6, orderTime.getHours()+":"+orderTime.getMinutes());
            pstmt.setString(7, orderTime.getDay()+"/"+orderTime.getMonth()+"/"+orderTime.getYear());
            pstmt.executeUpdate();
        	
        }
          catch (SQLException e) {
            System.out.println(e.getMessage());
          }
	}

}
