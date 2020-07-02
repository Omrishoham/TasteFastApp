package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesDB extends Database {
	private static EmployeesDB instance = null;

	private EmployeesDB() {
	
	}
		

	public static EmployeesDB getInstance() // use singleton design pattern
	{
		if (instance == null) {
			instance = new EmployeesDB();
		}
		return instance;
	}

	
	public void addEmployee(String username,String password,boolean ismanager,double salaryperhour,double salarysum,String firstname,String lastname) {

		try (Connection connect = this.connectToDB()) {
			PreparedStatement pstmt = connect.prepareStatement("INSERT INTO employees(username,password,ismanager,salaryperhour,salarysum,firstname,lastname) VALUES(?,?,?,?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setBoolean(3, ismanager);
			pstmt.setDouble(4, salaryperhour);
			pstmt.setDouble(5, salarysum);
			pstmt.setString(6, firstname);
			pstmt.setString(7, lastname);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	// remove employee with the exactly username
	public void removeEmployee(String username) {
        String sql = "DELETE FROM employees WHERE username = ?";
        
        try (Connection conn = this.connectToDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, username);
            // execute the delete statement
            pstmt.executeUpdate();
			}
		 catch (SQLException e) {
			System.out.println(e.getMessage());
		}
}


		
		//check if username exist in database
	public boolean ifExist(String username) {
		String sql = "SELECT username FROM employees";

		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {
			// loop through the result set
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(username))
					return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	

	// gets userName and pass strings and checks they got a match in login table
	public boolean loginAuthentication(String username, String password) {
		String sql = "SELECT username, password FROM employees";

		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {

			// loop through the result set
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(username)
						&& resultSet.getString("password").equals(password))
					return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Employee placeValues(String username, String password) {
		String sql = "SELECT username, password,ismanager,salaryperhour,salarysum,firstname,lastname FROM employees";
		Employee employee = new Employee();
		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {

			// loop through the result set
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(username)
						&& resultSet.getString("password").equals(password))
					employee = new Employee(username, password,resultSet.getBoolean("ismanager"),resultSet.getDouble("salaryperhour"),resultSet.getDouble("salarysum"),resultSet.getString("firstname"),resultSet.getString("lastname"));

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return employee;
	}

	public boolean isManager(String username, String password) {
		String sql = "SELECT username, password,ismanager FROM employees";

		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {

			// loop through the result set
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)
						&& resultSet.getBoolean("ismanager") == true)
					return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public void updateToManager(String username,double newsalaryperhour) {
		 String sql = "UPDATE employees SET ismanager = ? ,salaryperhour=? "
	                + "WHERE userName = ?";
	 
	        try (Connection conn = this.connectToDB();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setBoolean(1, true);
	            pstmt.setDouble(2, newsalaryperhour);
	            pstmt.setString(3, username);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           
	        }
	      
	}
	
	public void updateSalary(String username, double salaryPerHour) {
		 String sql = "UPDATE employees SET salaryperhour=? "
	                + "WHERE userName = ?";
	 
	        try (Connection conn = this.connectToDB();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	 
	            // set the corresponding param
	            pstmt.setDouble(1,salaryPerHour);
	            pstmt.setString(2, username);
	            // update 
	            pstmt.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	           
	        }
		
	}
	
    //After an employee logged out,this will update their total income
    public void updateTotalSalary(String username,double todayIncome)
    {
        String sql = "UPDATE employees SET salarysum =salarysum+ ?  "
                + "WHERE username = ?";
        
        try (Connection conn = this.connectToDB();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setDouble(1, todayIncome);
            pstmt.setString(2, username);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    
        public double getSalaryCount(String username) {
    	String sql = "SELECT username,salarySum FROM employees";
        try (Connection conn = this.connectToDB();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
        	
        	while (rs.next()) {
        		if(rs.getString("username").equals(username))
        		{
        			return rs.getDouble("salarysum");
        		}
        	}
               

           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
        return -1;
    	
    }

}
