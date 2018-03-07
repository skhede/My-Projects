package bean;

public abstract class User {

 public int user_id;
 private String username;
 private String password_check;
 private String is_admin;
 
 	public User()
	{
	//default constructor	
	}
	
	

	public User(int user_id, String username,String password_check, String is_admin) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password_check = password_check;
		this.is_admin = is_admin;
		
	}



	public int getUserId() {
		return user_id;
	}



	public void setUserId(int user_id) {
		this.user_id = user_id;
	}



	public String getpassword() {
		return password_check;
	}



	public void setpassword(String password) {
		this.password_check = password_check;
	}



	public String getUserType() {
		return is_admin;
	}



	public void setUserType(String userType) {
		this.is_admin = is_admin;
	}



	public String getUserName() {
		return username;
	}



	public void setUserName(String userName) {
		this.username = username;
	}



	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password_check=" + password_check + ", is_admin=" + is_admin + ", username="+ username + "]";
	}
	

}
