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

	
	public void insertInfo(String username, String password) {

		try (Connection connect = this.connectToDB()) {
			PreparedStatement pstmt = connect.prepareStatement("INSERT INTO employees(username,password) VALUES(?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
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
		String sql = "SELECT username, password,salaryperhour FROM employees";
		Employee employee = new Employee();
		try (Connection connect = this.connectToDB();
				Statement stmt = connect.createStatement();
				ResultSet resultSet = stmt.executeQuery(sql)) {

			// loop through the result set
			while (resultSet.next()) {
				if (resultSet.getString("username").equals(username)
						&& resultSet.getString("password").equals(password))
					employee = new Employee(username, password, resultSet.getDouble("salaryperhour"));

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

}
