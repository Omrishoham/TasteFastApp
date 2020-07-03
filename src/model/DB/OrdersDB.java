	package model.DB;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import model.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Year;

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
	
	public void insertOrder(String username,String orderID,double totalPrice,String creditCardNum,String creditCardVal,String orderTime, String orderDate)
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
            pstmt.setString(6,orderDate);
            pstmt.setString(7,orderTime);
            pstmt.executeUpdate();
        	
        }
          catch (SQLException e) {
            System.out.println(e.getMessage());
          }
	}
	//pulling all orders from database
	public ArrayList<Order> getOrdersDB(){
		String sql = "SELECT username,totalprice,orderid,ordertime,orderdate FROM orders";
		ArrayList<Order> ordersDB = new ArrayList<Order>();

		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {
			// loop through the result set
			while (resultSet.next()) {
				String username = resultSet.getString("username");
				double totalprice = resultSet.getDouble("totalprice");
				String orderid = resultSet.getString("orderid");
				String ordertime = resultSet.getString("ordertime");
				String orderdate = resultSet.getString("orderdate");
				Order order = new Order(username,totalprice,orderid,ordertime,orderdate);
				ordersDB.add(order);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ordersDB;
	}
	

}
