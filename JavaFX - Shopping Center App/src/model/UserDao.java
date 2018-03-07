package model;

import java.util.List;

import bean.Admin;
import bean.Customer;
//import bean.Customer;
import bean.User;

public interface UserDao 
{
	public List<User> getAllUsers();
	public User getUserDetails(String username);
	public User authenticateUser(String username, String password);
	public boolean addCustomer(int customer_id,int user_id, String username, String customer_name, String contact_details, String address, String email_id, String total_points);
	public boolean updateCustomer(int customer_id,int user_id, String username, String customer_name, String contact_details, String address, String email_id, String total_points);
	
	public Customer getCustomer(String custName);
	//public Customer getcustomerDetails(String custName);
	public boolean resetPassword(String username, String password);
}
