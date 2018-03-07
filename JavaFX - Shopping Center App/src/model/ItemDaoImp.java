package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Department;
import bean.Item;
import connector.Connector;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

public class ItemDaoImp implements ItemDao {

	String department_name;
	@Override
	public List<Item> getAllItem() {
		List<Item> itemList = new ArrayList<>();
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select fp.skhede_items.item_id,department_name,item_name,description,cost,quantity,reward_points";
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()){
					Item item = new Item(rs.getInt("item_id"), rs.getString("department_name"), rs.getString("item_name"), rs.getString("description"), rs.getInt("cost"),rs.getString("quantity"),rs.getString("reward_points"));
					itemList.add(item);
				}
				rs.close();
				statement.close();
				connection.close();
				conn1.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return itemList;
	}

	
	@Override
	public int getItemId(String item_name) {
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "select item_id from skhede_items where item_name='"+item_name+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				return rs.getInt(1);			
			}		
			statement.close();
			connection.close();
			Connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  0;
		}
		
		return 0;
	}
	public Department getDepartmentName(String department_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select department_id from fp.skhede_departments where department_name='"+department_name+"'";
		System.out.println("DAO dept implementation after getdeptID");
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				System.out.println("Before DEPARTMENT ID method");
				Department department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
				return department;
			}		
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  null;
		}
		
		return null;
	}

	
	@Override
	public boolean addItem(int item_id, String department_name,String item_name, String description, int cost, int quantity, int reward_points) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		
		String query = "INSERT INTO fp.skhede_items (item_id, department_name, item_name, description, cost, quantity, reward_points) VALUES ('"+ item_id +"','"+ department_name +"','"+ item_name +"','" + description + "','" + cost + "','" + quantity + "','" + reward_points + "')";
		try {
			System.out.println(department_name + item_name + description + cost +  quantity + reward_points);
			Statement preparedStatement = connection.createStatement();
			int a = preparedStatement.executeUpdate(query);
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; 
		}
		
		return result;
	}

	@Override
	public boolean deleteItem(String item_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "delete from skhede_items where item_name = '" + item_name + "'";
		try {
			Statement statement = connection.createStatement();
			int a = statement.executeUpdate(query);
			if(a>0){
				result = true;
			}
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean updateItem(int item_id, String item_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "update fp.skhede_items set  `item_name` = ? where item_id='"+item_id+"'";
		System.out.println("Values in ITEM DAO IMPLEMENTATION : -- >"+item_name);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, item_name);
			//preparedStatement.setString(4, description);
			//preparedStatement.setString(5, cost);
			//preparedStatement.setString(6, quantity);
			//preparedStatement.setString(7, reward_points);
			//preparedStatement.setString(5, );
			
			int a = preparedStatement.executeUpdate();
			if(a > 0){
				result = true;
			}
				
			preparedStatement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; // as there was some error while the insert, the result is set as false
		}
		
		return result;
	}

	@Override
	public Item getItemInt(int item_id) {
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select * from fp.skhede_items where item_id="+item_id+"";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				Item Item = new Item(rs.getInt("item_id"), rs.getString("department_name"), rs.getString("item_name"), rs.getString("description"), rs.getInt("cost"),rs.getString("quantity"),rs.getString("reward_points"));
				System.out.println("Query data --> "+Item);
				System.out.println("Query data --> "+Item.getCost() + Item.getDepartment_name()
				+Item.getDescription() + Item.getItem_id() +Item.getItem_name() + Item.getQuantity() +Item.getReward_points());
				return Item;
			}
			rs.close();
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		System.out.println("No value from ItemDaoImplementation");
		return null;
	}





}
	