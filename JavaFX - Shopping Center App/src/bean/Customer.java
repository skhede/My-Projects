package bean;

import java.util.List;



public class Customer extends User
{
	public int user_id;	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	private String customer_name;
	private String email_id;
	private String address;
	private String contact_details;
	private String total_points;
	private ShoppingCart cart;
	
	public Customer() 
	{
		cart = new ShoppingCart();
	}
	
	public Customer(int user_id, String username, String password_check, String is_admin,String customer_name,String email_id,String address,String contact_details,String total_points) {
		super(user_id, username, password_check, is_admin);
		cart = new ShoppingCart();
		this.customer_name = customer_name;
		this.email_id = email_id;
		this.address = address;
		this.contact_details = contact_details;
		this.total_points = total_points;
		// TODO Auto-generated constructor stub

	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact_details() {
		return contact_details;
	}

	public void setContact_details(String contact_details) {
		this.contact_details = contact_details;
	}

	public String getTotal_points() {
		return total_points;
	}

	public void setTotal_points(String total_points) {
		this.total_points = total_points;
	}

	/*public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}
*/


	
	public Customer(int int1, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public ShoppingCart getShoppingCart(){
		return cart;
	}
	
	
}
