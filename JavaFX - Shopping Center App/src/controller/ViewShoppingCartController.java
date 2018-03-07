package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import org.w3c.dom.stylesheets.LinkStyle;

import application.Main;
import bean.Customer;
import bean.Item;
import cache.Cache;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ItemDao;
import model.ItemDaoImp;

public class ViewShoppingCartController implements Initializable 
{

	private ObservableList<Item> data;
	@FXML
	private TableView TableCartItems;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try
		{
			System.out.println("In ShoppingCartController - ViewCart ");
			
			TableCartItems.getColumns().clear();
			Customer customer = (Customer)Main.USER_CACHE.get("user");
			Main.USER_CACHE.put("user", customer);
			System.out.println("Customer --> " +customer);
			
			
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
			item_name.setCellValueFactory(new PropertyValueFactory<Item,String>("item_name"));
			
			TableColumn description = new TableColumn<>("description");
			description.setMinWidth(100);
			description.setCellValueFactory(new PropertyValueFactory<Item,Integer>("description"));
			
			TableColumn cost = new TableColumn<>("cost");
			cost.setMinWidth(100);
			cost.setCellValueFactory(new PropertyValueFactory<Item,String>("cost"));
			
			TableColumn quantity = new TableColumn<>("quantity");
			quantity.setMinWidth(100);
			quantity.setCellValueFactory(new PropertyValueFactory<Item,String>("quantity"));
			
			TableColumn reward_points = new TableColumn<>("reward_points");
			reward_points.setMinWidth(100);
			reward_points.setCellValueFactory(new PropertyValueFactory<Item,String>("reward_points"));
			TableCartItems.getColumns().addAll(item_id,department_name,item_name,description,cost,quantity,reward_points);
			
			
			TableCartItems.setItems(data);
			System.out.println("Item List --> "+ItemList);
			System.out.println("LIST --> "+department_name +item_id );
			System.out.println(ItemList.get(0));
			System.out.println(columnNames);
			System.out.println(data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unable to view Cart Items !");           
		}    
		}
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
	
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ShopByItemPayment.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML TextField buyItemId;
@FXML Button buyItemButton;
@FXML Button viewCartButton;

@FXML public void clickBuyItemButton(ActionEvent event) throws Exception
{
	
	
	System.out.println("In Controller Buy Item method");
	int item_id = Integer.parseInt(buyItemId.getText().trim());

	Customer customer = (Customer)Main.USER_CACHE.get("user");
	ItemDao ItemDao = new ItemDaoImp();
	System.out.println(ItemDao +" <--ItemDao -- Customer --> "+ customer+ " " +(Customer)Main.USER_CACHE.get("user"));
	System.out.println(buyItemId.getText());
	System.out.println("tem id:"+item_id);
	System.out.println("item:"+ItemDao.getItemInt(item_id));
	customer.getShoppingCart()
	.addItem(ItemDao.
			getItemInt
			(item_id));
	Main.USER_CACHE.put("user", customer);  
	
	try {
		AlertMessage.infoBox("Item Added to Cart Successfully !", " Item Cart");

	} catch(Exception e) {
		AlertMessage.infoBox("Failed to add Item to Cart !", " Item Cart");
		e.printStackTrace();
	}
}
@FXML public void clickViewCartButton(ActionEvent event) throws Exception
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

@FXML public void clickViewAllItemsButton(ActionEvent event) throws Exception
{
		 
 try {
		
	} catch(Exception e) {
		e.printStackTrace();
	}
}

@FXML public void clickMenuViewCart(ActionEvent event) throws Exception
{
		 
 try {
	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ViewShoppingCart.fxml"));
     Parent root1 = (Parent) fxmlLoader.load();
     Stage stage = new Stage();
     stage.setScene(new Scene(root1));
     stage.show();
	 
	} catch(Exception e) {
		e.printStackTrace();
	}
}



	
}
