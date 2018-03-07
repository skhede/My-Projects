package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import bean.Admin;
import bean.Customer;
import bean.User;
import connector.Connector;
import controller.AlertMessage;


public class AllUserDaoImplementation implements UserDao {

	@Override
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<>();
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "select * from fp.skhede_users ";
	try {
		Statement statement = testConn2.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Customer customer = new Customer(rs.getInt("user_id"),rs.getString("username"), rs.getString("password_check"), rs.getString("is_admin"));
			usersList.add(customer);
		}
		rs.close();
		statement.close();
		testConn2.close();
		testConn.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
		return null;
	}

	@Override
	public User getUserDetails(String username) {
		// TODO Auto-generated method stub
		
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "select * from skhede_customer";
	try {
		Statement statement = testConn2.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Customer customer = new Customer(rs.getInt("user_id"),rs.getString("username"), rs.getString("password_check"), rs.getString("is_admin"));
			
		return customer;
		}
		rs.close();
		statement.close();
		testConn2.close();
		testConn.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	return null;
	}

	@Override
	public User authenticateUser(String username, String password) {
		
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "select * from skhede_users where username = '"+ username +"' and password_check = '"+ password+"'";
	try {
		Statement statement = testConn2.createStatement();
		Statement stmt2 = testConn2.createStatement();
		ResultSet rs = statement.executeQuery(query), rs1 = null;
		while(rs.next()){
			String type = rs.getString("is_admin");
			if(type.equalsIgnoreCase("Y")){
				Admin admin = new Admin(rs.getInt("user_id"),rs.getString("username"), rs.getString("password_check"), rs.getString("is_admin"));
				return admin;
			}else{
				query = "select * from skhede_customer where user_id = "+ rs.getInt("user_id");
				rs1 = stmt2.executeQuery(query);
				if(rs1.next())
				{
					Customer customer = new Customer(rs1.getInt("user_id"), username, rs1.getString("password"), "N", rs1.getString("customer_name"),
							rs1.getString("email_id"), rs1.getString("address"), rs1.getString("contact_details"), rs1.getString("total_points"));
					return customer;
				}
				return null;
			}
		}
		rs.close();
		statement.close();
		testConn2.close();
		testConn.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	return null;
	}
	
	@Override
	public boolean addCustomer(int customer_id,int user_id, String username, String customer_name, String contact_details, String address, String email_id, String total_points) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		
String query = "INSERT INTO skhede_customer (customer_id, user_id, username, customer_name, contact_details, address, email_id, total_points) VALUES ('"+ customer_id +"','" + user_id + "','"+ username +"','"+customer_name +"','" + contact_details + "','"+ address + "','"+ email_id + "','"+ total_points + "')";
		
		try {
			Statement preparedStatement = testConn2.createStatement();
			
			int a = preparedStatement.executeUpdate(query);
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			testConn2.close();
			testConn.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; 
		}
		
		return result;
	
}
	
	@Override
	public boolean updateCustomer(int customer_id,int user_id, String username, String customer_name, String contact_details, String address, String email_id, String total_points) {

		boolean result = false;
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "update skhede_customer set `username` = ?,`customer_name`= ?, `contact_details` = ?, `address` = ? , `email_id` = ?, `total_points` = ? where userId = ? " ;
		try {
			PreparedStatement preparedStatement = testConn2.prepareStatement(query);
			
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, customer_name);
			preparedStatement.setString(3, contact_details);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, email_id);
			preparedStatement.setString(6, total_points);
			
			
			int a = preparedStatement.executeUpdate();
			if(a > 0){
				result = true;
			}
				
			preparedStatement.close();
			testConn2.close();
			testConn.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; 
		}
		
		return result;
		
	}	

	@Override
	public Customer getCustomer(String customer_name) {
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "select * from skhede_customer where customer_name= '"+customer_name+"'";
	try {
		Statement statement = testConn2.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Customer customer = new Customer(rs.getInt("user_id"),rs.getString("username"), rs.getString("password_check"), rs.getString("is_admin"));
		return customer;
		}
		rs.close();
		statement.close();
		testConn2.close();
		testConn.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
	return null;

	}
	
	
	
	public static void main(String args[])
	{
		UserDao testUser= new AllUserDaoImplementation();
	}
	/*@Override
	public boolean resetPassword(String username, String password) {
		boolean result = false;
		Connector testConn = new Connector();
		Connection testConn2 = testConn.getType4Connection();
		String query = "update skhede_users SET username='"+username+"', password_check='"+password+"' where username = '" + username + "' ";
		String query2 = "update skhede_customer SET username='"+username+"', password='"+password+"' where username = '" + username + "'";
		try {
			Statement statement = testConn2.createStatement();
			Statement statement2 = testConn2.createStatement();
			int usersTable = statement.executeUpdate(query);
			int customerTable = statement2.executeUpdate(query2);
			if(usersTable>0 && customerTable>0)
			{
				System.out.println("User DAO Implementation --> Username password updated successfully");
				result = true;
			}
			statement.close();
			testConn2.close();
			testConn.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;*/
		
		@Override
		
		public boolean resetPassword(String username, String password) {
			boolean result = false;
			Customer customer = new Customer();
			int user_id= customer.user_id;
			Connector testConn = new Connector();
			Connection testConn2 = testConn.getType4Connection();
			String query = "select * from skhede_users where username = '"+ username +"' and password_check = '"+ password+"'";
		
			try
			{
			  PreparedStatement ps = (PreparedStatement) testConn2.prepareStatement("select * from fp.skhede_users where user_id=?");
			  ps.setInt (1, user_id);
			  ResultSet rs = ps.executeQuery();
			  String query2 = "update skhede_users set username = '"+ username +"' and password_check = '"+ password+"' where username = '"+ username +"'";
			  if (rs.next()) {
				  PreparedStatement preparedStatement = testConn2.prepareStatement(query2);
				  preparedStatement.setString(1, username);
				  preparedStatement.setString(2, password);
				  
				  int check = preparedStatement.executeUpdate();
					if(check > 0){
						result = true;
						System.out.println("Password Reset Success");
					}
					preparedStatement.close();
					testConn2.close();
					testConn.closeConnection();
				} else 
				{
					
					System.out.println("Failed to Reset Password");
				}
			}
			catch (SQLException e) 
				{
				e.printStackTrace();
				result = false; 
				}
			return result;

		
	}
	
	
	
	
	


	
}
