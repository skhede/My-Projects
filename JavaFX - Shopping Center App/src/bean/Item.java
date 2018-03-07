package bean;

public class Item {
	private int item_id;
	private String department_name;
	private String item_name;
	private String description;
	private int cost;
	private String quantity;
	private String reward_points;
	
	public Item()
	{
		//default
	}
	
	public Item(int item_id, String department_name,String item_name, String description, int cost, String quantity, String reward_points)
	{
		super();
		this.item_id = item_id;
		
		this.department_name = department_name;
		this.item_name = item_name;
	this.description = description;
		this.cost = cost;
	
		this.quantity=quantity;
		this.reward_points=reward_points;
	}
	//public Item(int int1, String string) {
		// TODO Auto-generated constructor stub
//	}
	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getReward_points() {
		return reward_points;
	}

	public void setReward_points(String reward_points) {
		this.reward_points = reward_points;
	}
	

}
