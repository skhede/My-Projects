package controller;

import application.Main;
import bean.Classification;
import bean.Customer;
import bean.Item;
import bean.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AllUserDaoImplementation;
import model.ClassificationDao;
import model.ClassificationDaoImp;
import model.ItemDao;
import model.ItemDaoImp;
import model.UserDao;

public class ItemController {

	@FXML TextField addItemText;
	@FXML TextArea addDescTextArea;
	@FXML TextField addItemCostText;
	@FXML TextField addItemQuantityText;
	@FXML TextField addItemRewardText;
	@FXML TextField addItemDeptText;
	@FXML TextField deleteItemTextBox;
	@FXML TextField oldItemTextBox;
	@FXML TextField newItemTextBox;
	@FXML Button addItemButton;
	@FXML Button editItemButton;
	@FXML Button deleteItemButton;
	@FXML Button viewItemButton;
	@FXML MenuItem menuItems;
	@FXML TextField buyItemId;
	
	
	@FXML public void clickBuyItemButton(ActionEvent event) throws Exception
    {
		int item_id = Integer.parseInt(buyItemId.getText().trim().toLowerCase());
		ItemDao ItemDao = new ItemDaoImp();
		Customer customer = (Customer)Main.USER_CACHE.get("user");
		Main.USER_CACHE.put("user", customer);
		customer.getShoppingCart().addItem(ItemDao.getItemInt(item_id));
	    System.out.println(customer.getShoppingCart());
	    Main.USER_CACHE.put("user", customer);
	    
	    System.out.println("In Item controller");
	    
		String department_name = addItemDeptText.getText().trim().toLowerCase();
		String item_name = addItemText.getText().trim().toLowerCase();
		String description = addDescTextArea.getText().trim().toLowerCase();
		int cost =Integer.parseInt(addItemCostText.getText().trim().toLowerCase());
		
		int quantity =Integer.parseInt(addItemQuantityText.getText().trim().toLowerCase());
		int reward_points =Integer.parseInt(addItemRewardText.getText().trim().toLowerCase());
    	ItemDao Item = new ItemDaoImp();
    	//ClassificationDao abc = new ClassificationDaoImp();
		//int checkUser = abc.getClassificationId(classification_name);
    	
    	//boolean y = Item.addItem(item_id, department_name,item_name,description,cost,quantity,reward_points);
    	
    	try {
    		AlertMessage.infoBox("Item Added to Cart Successfully !", "Add Item to Cart");

    	} catch(Exception e) {
    		AlertMessage.infoBox("Failed to add item to Cart !", "Add Item to Cart");
    		e.printStackTrace();
    	}
   }
    
	@FXML public void buttonViewItem(ActionEvent event) throws Exception
    {
		 
	 try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ViewAllItems.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	@FXML public void buttonDeleteItem(ActionEvent event) throws Exception
    {        
    	String delete_item = deleteItemTextBox.getText().trim().toLowerCase();
    	ItemDao Item = new ItemDaoImp();
    	boolean y = Item.deleteItem(delete_item);
    	
	 if (y==true){
    	try {
    		System.out.println("BEFORE DELETE CONTROLLER!!");
    		AlertMessage.infoBox("Item Deleted successfully !!", "Items !!");

		} catch(Exception e) {
			e.printStackTrace();
		}}
	 else {try {
		 AlertMessage.infoBox("Failed to delete item !!", "Items !!");

		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	 }
	 

	 }
	@FXML public void buttonEditItem(ActionEvent event) throws Exception
    {
	 
		String oldItemName = oldItemTextBox.getText().trim().toLowerCase();
    	ItemDao Item = new ItemDaoImp();
    	int itemId = Item.getItemId(oldItemName);
    	String newItemName = newItemTextBox.getText().trim().toLowerCase();
	
    	
    	
    	//String oldItem = oldItemTextBox.getText().trim().toLowerCase();
    	//String newItem = newItemTextBox.getText().trim().toLowerCase();
    	boolean y = Item.updateItem(itemId,newItemName);
    	System.out.println("Values in ITEM Controller : -- >"+itemId+oldItemName+newItemName);
 if (y==true){
    	try {
    		System.out.println("BEFORE DELETE CONTROLLER!!");
    		AlertMessage.infoBox("Item Updated successfully  !!", "Items !!");


		} catch(Exception e) {
			e.printStackTrace();
		}}
	 else {try {
		 AlertMessage.infoBox("Failed to update Item !!", "Items !!");

		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	 }

   }
	
	 @FXML public void clickMenuClassifications(ActionEvent event) throws Exception
	    {
			try {
				
				System.out.println("Admin controller Classifications Add");
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/EditClassification.fxml"));
				System.out.println("VIEW");
				
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
			}

	 @FXML public void clickMenuItems(ActionEvent event) throws Exception
	    {
			try {
				
				System.out.println("Item controller button edit items");
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/EditItem.fxml"));
				System.out.println("VIEW");
				
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
}
	 @FXML public void clickAdminMyHome(ActionEvent event) throws Exception
	    {
				 
		 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AdminHome.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
	 @FXML public void menuLogout(ActionEvent event) throws Exception
	    {
				 
		 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
	 @FXML public void clickAddDepartment(ActionEvent event) throws Exception
	    {
			try {
		
				System.out.println("In CLick ADD DEPARtment method");
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AddDepartment.fxml"));
			System.out.println("After that");
				
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
		
		@FXML public void clickEditDepartment(ActionEvent event) throws Exception
	    {
			try {
				
		
				System.out.println("In CLick edit DEPARtment method");
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/EditDepartment.fxml"));
			System.out.println("ADMIN controller !");
				
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }

		@FXML public void clickDeleteDepartment(ActionEvent event) throws Exception
	    {
			try {
				
				System.out.println("In CLick delete DEPARtment method");
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/DeleteDepartment.fxml"));
			System.out.println("DELETE");
				
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }
			@FXML public void clickViewDepartment(ActionEvent event) throws Exception
		    {
				try {
					
				//String custNameToP = AgetCustNText.getText().trim().toLowerCase();
				//Cache cache = new Cache();
				//cache.put("customerName", custNameToP);
				/*UserDao userDao = new UserDaoImp();
				//Customer getcustomerDetails = userDao.getcustomerDetails(custNameToP);*/
					System.out.println("In CLick View DEPARtment method");
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ViewDepartment.fxml"));
				System.out.println("VIEW");
					
		            Parent root1 = (Parent) fxmlLoader.load();
		            Stage stage = new Stage();
		            stage.setScene(new Scene(root1));
		            stage.show();

				} catch(Exception e) {
					e.printStackTrace();
				}

	    }
			 @FXML public void buttonAddItem(ActionEvent event) throws Exception
			    {
					try {
					
						AlertMessage.infoBox("Item Added Successfully !", "Add Item");

					} catch(Exception e) {
						AlertMessage.infoBox("Failed to add Item !", "Add Item");
						e.printStackTrace();
					}
		}
			

}
