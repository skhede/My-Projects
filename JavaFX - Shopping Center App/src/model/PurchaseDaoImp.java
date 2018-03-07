package model;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import bean.Customer;
import bean.Item;
import bean.PurchaseDetails;
import connector.Connector;

public class PurchaseDaoImp implements PurchaseDao {

	@Override
	public List<PurchaseDetails> getAllPurchase() {
		List<PurchaseDetails> PurchaseList = new ArrayList<>();
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select * from fp.skhede_orders";
				 				
				try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()){
					PurchaseDetails Purchase = new PurchaseDetails(rs.getInt("order_id"),rs.getInt("customer_id"), rs.getInt("item_id"),rs.getDate("order_date"), rs.getDouble("quantity"), rs.getInt("purchaseAmount"));
					PurchaseList.add(Purchase);
				}
				rs.close();
				statement.close();
				connection.close();
				conn1.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return PurchaseList;
	}
	List<Item> itemList = new ArrayList<>();
	public List<Item> getAllItem() {
		
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select fp.skhede_items.item_id,department_name,item_name,description,cost,quantity,reward_points ";
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
	public boolean addPurchase(int customerId,  double purchaseAmount) {
		Customer customer = (Customer)Main.USER_CACHE.get("user");
        Main.USER_CACHE.put("user", customer);
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		System.out.println("This is customer ID who purchased the product --> " +customer.getUserId());
		
String query = "INSERT INTO skhede_orders (customer_id,quantity,purchase_amount) VALUES ('" + customer.getUserId() + "',1,'"+purchaseAmount+"')";
		
		try {
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
	public boolean deletePurchase(int tId) {
		// TODO Auto-generated method stub
		return false;
	}

/*	@Override
	public boolean deletePurchase(int tId) {
		boolean result = false;
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		String query = "delete from PurchaseSPV where tId = '" + tId + "'";
		try {
			Statement statement = connection.createStatement();
			int a = statement.executeUpdate(query);
			if(a>0){
				result = true;
			}
			statement.close();
			connection.close();
			connectionFactory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
*/
	

}
