package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import bean.Customer;
import bean.Item;
import connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.ItemDao;
import model.ItemDaoImp;
import model.PurchaseDao;
import model.PurchaseDaoImp;;


public class ItemPaymentController implements Initializable{

	private ObservableList<Item> data;
	@FXML private TableView tableItemPayment;
	@FXML Label totalAmount;
	@FXML TextField cardDetailsText;
	@FXML Button CardOKButton ;
	@FXML Button Cancelbutton;
	double purchaseAmount = 0;
	@FXML TextField ItemIDremCartText;
	@FXML Button OkcartRemoveButton;
	@FXML TextField buyItemId;
	@FXML TextField itemIdToRemoveText;
	public  int item_id;
	Customer customer = (Customer)Main.USER_CACHE.get("user");
	List<Item> ItemList2 = customer.getShoppingCart().getAllItem();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try
		{
			tableItemPayment.getColumns().clear();
		
			Customer customer = (Customer)Main.USER_CACHE.get("user");
			
			System.out.println("Item Payment controller cust --> " +customer);
			
			
			List<Item> ItemList = customer.getShoppingCart().getAllItem();
			
			String[] columnNames = {"item_id","department_name","item_name","description","cost","quantity","reward_points"};

			data = FXCollections.observableList(ItemList);
			TableColumn item_id = new TableColumn<>("item_id");
			item_id.setMinWidth(100);
			item_id.setCellValueFactory(new PropertyValueFactory<Item,Integer>("item_id"));
			
			TableColumn department_name = new TableColumn<>("department_name");
			department_name.setMinWidth(100);
			department_name.setCellValueFactory(new PropertyValueFactory<Item,String>("department_name"));
			
			TableColumn item_name = new TableColumn<>("item_name");
			item_name.setMinWidth(100);
			item_name.setCellValueFactory(new PropertyValueFactory<Item,Integer>("item_name"));
			
			TableColumn description = new TableColumn<>("description");
			description.setMinWidth(100);
			description.setCellValueFactory(new PropertyValueFactory<Item,String>("description"));
			

			TableColumn cost = new TableColumn<>("cost");
			cost.setMinWidth(100);
			cost.setCellValueFactory(new PropertyValueFactory<Item,Integer>("cost"));
			
			TableColumn quantity = new TableColumn<>("quantity");
			quantity.setMinWidth(100);
			quantity.setCellValueFactory(new PropertyValueFactory<Item,String>("quantity"));
			
			TableColumn reward_points = new TableColumn<>("reward_points");
			reward_points.setMinWidth(100);
			reward_points.setCellValueFactory(new PropertyValueFactory<Item,String>("reward_points"));
			
			tableItemPayment.getColumns().addAll(item_id,department_name,item_name,description,cost,quantity,reward_points);
			
			tableItemPayment.setItems(data);
			
			for(int i=0;i<ItemList.size();i++){
				Item Item = ItemList.get(i);
				purchaseAmount +=Item.getCost();
			}
			
			totalAmount.setText("Total Amount: $" +String.valueOf(purchaseAmount));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unable to get data from cart !");           
		}    
		}
	
	public int getItem_id()
	{
		return this.getItem_id();
	}
	public int getquantity()
	{
		return this.getquantity();
	}
	
	@FXML public void clickRemoveCartButton(ActionEvent event) throws Exception
	 {	 
	 		try {
	 	 		
	 	 		int ItemId = Integer.parseInt(itemIdToRemoveText.getText());
	 	 		Customer customer = (Customer)Main.USER_CACHE.get("user");
	 			customer.getShoppingCart().removeItem(ItemId);
	 			AlertMessage.infoBox("Item removed from cart !", "Cart Update");

	 			} catch(Exception e) {
	 				e.printStackTrace();
	 			}	 
	 }	
	
	@FXML public void clickpayNowButton(ActionEvent event) throws Exception
    {
		//Item newItem = new Item();
        Customer customer = (Customer)Main.USER_CACHE.get("user");
        Main.USER_CACHE.put("user", customer);
		System.out.println("Customer in Payment Controller --> " +customer);
		//List<Item> Item = customer.getCart().getAllItem();
		System.out.println(ItemList2.get(item_id));
       //int Myitem=Integer.parseInt(ItemList2.get(item_id).toString());
		
       
        PurchaseDao puchase = new PurchaseDaoImp();
        puchase.addPurchase(customer.getUser_id(), purchaseAmount);
       // int customerId, int itemId, Date orderDate, Double quantity, Double purchaseAmount
        try {
        	AlertMessage.infoBox("Payment went through successfully !!", "Payment");

		} catch(Exception e) {
			AlertMessage.infoBox("Error while making the payment, Please try again !!", "Payment");
			e.printStackTrace();
		}
    }

 @FXML public void clickCancelPayButton(ActionEvent event) throws Exception
    {
			 
    	try {
    		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerHome.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
 
 //Other controllers
 
 @FXML public void clickEditProfile(ActionEvent event) throws Exception
 {

	 try {
		 ((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustEditProfile.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
 }

@FXML public void clickShopByDept(ActionEvent event) throws Exception
 {
			 
	 try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerShopByDepartment.fxml"));
      Parent root1 = (Parent) fxmlLoader.load();
      Stage stage = new Stage();
      stage.setScene(new Scene(root1));
      stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}

 }
@FXML public void clickShopByClass(ActionEvent event) throws Exception
 {
			 
 	try {
 		
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerShopByClassification.fxml"));
         Parent root1 = (Parent) fxmlLoader.load();
         Stage stage = new Stage();
         stage.setScene(new Scene(root1));
         stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
 }

@FXML public void clickHome(ActionEvent event) throws Exception
{
		 
try {
	 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerHome.fxml"));
     Parent root1 = (Parent) fxmlLoader.load();
     Stage stage = new Stage();
     stage.setScene(new Scene(root1));
     stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML public void clickLogout(ActionEvent event) throws Exception
{
		 
try {
	 	Main.USER_CACHE = null;
	 	System.out.println("Logout successfull !");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
     Parent root1 = (Parent) fxmlLoader.load();
     Stage stage = new Stage();
     stage.setScene(new Scene(root1));
     stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML public void clickPaymentButton(ActionEvent event) throws Exception
{
		 
try {
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/.fxml"));
     Parent root1 = (Parent) fxmlLoader.load();
     Stage stage = new Stage();
     stage.setScene(new Scene(root1));
     stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}

@FXML Button buyItemButton;
@FXML Button viewCartButton;

@FXML public void clickBuyItemButton(ActionEvent event) throws Exception
{
	System.out.println("In Controller Buy Item method");
	int item_id = Integer.parseInt(buyItemId.getText().trim());

	Customer customer = (Customer)Main.USER_CACHE.get("user");
	ItemDao ItemDao = new ItemDaoImp();
	System.out.println("Customer details --> "+ customer+ " " +(Customer)Main.USER_CACHE.get("user"));

	System.out.println("Item id-->"+item_id);
	Connector conn1 = new Connector();
	Connection connection = conn1.getType4Connection();
	//String query ="select * from skhede_items where item_id ='"+item_id+"'";
	System.out.println("Check if item id present in database ? " +item_id);
	
	try
	{
	  PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from skhede_items where item_id =?");
ps.setInt (1, item_id);
ResultSet rs = ps.executeQuery();

if (rs.next()) {
 customer.getShoppingCart().addItem(ItemDao.getItemInt(item_id));
	connection.close();
	conn1.closeConnection();
	AlertMessage.infoBox("Item Added to Cart Successfully !", " Item Cart");
	Main.USER_CACHE.put("user", customer);
} else {
AlertMessage.infoBox("Item ID does not exist, unable to add to cart !", "Failed to add to cart");
}
}
catch (Exception e) 
	{
	 
		AlertMessage.infoBox("Failed to add item to cart  !", " Item Cart");
	}

}	
@FXML public void clickMenuViewCart(ActionEvent event) throws Exception
{
		 
try {
	 
	 System.out.println("In ViewItemController - ViewCart method");
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ViewShoppingCart.fxml"));
     Parent root1 = (Parent) fxmlLoader.load();
     Stage stage = new Stage();
     stage.setScene(new Scene(root1));
     stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML public void clickMenuLogout(ActionEvent event) throws Exception
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
@FXML public void clickShopByItem(ActionEvent event) throws Exception
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
 
 
 
}
