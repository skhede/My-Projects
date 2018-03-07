package model;

import java.util.List;

import bean.Item;
import javafx.collections.ObservableList;

public interface ItemDao {
	public List<Item> getAllItem();
	
	public boolean addItem(int item_id, String department_name,String item_name, String description, int cost,int quantity, int reward_points);
	public boolean deleteItem(String item_name);
	public boolean updateItem(int item_id,String item_name);
	public int getItemId(String item_name);
	public Item getItemInt(int item_id);
	/*
	 * public List<Products> getAllproducts();
	public Products getProduct(int productId);
	public boolean addProduct(int productId, String productName, int brandID, int categoryId, double productCost);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(int productId, String productName, int brandID, int categoryId, double productCost);
	*/
}
