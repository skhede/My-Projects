package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import com.mysql.jdbc.PreparedStatement;

import application.Main;
import bean.Classification;
import bean.Customer;
import bean.Item;
import connector.Connector;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.ItemDao;
import model.ItemDaoImp;

public class ViewItemController implements Initializable{
	private ObservableList<ObservableList> data;
	@FXML private TableView tableAllItems;
	@FXML Button EditDetailsButton;
	@FXML MenuItem menuShopByDept;
	@FXML MenuItem menuShopByClass;
	@FXML MenuItem menuEditProfile;
	@FXML MenuItem Logout;
	@FXML MenuItem home;
	@FXML MenuItem menuShopByItem;
	@FXML MenuItem menuMyPoints;
	@FXML Button paymentButton;
	private TableView TableCartItems;
	
	
	@FXML private ChoiceBox<Classification> choiceBox;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try
		{
			tableAllItems.getColumns().clear();
			
			Connection conn=DriverManager
			          .getConnection("jdbc:mysql://www.papademas.net/fp?"
			                  + "user=dbfp&password=510");;
		//System.out.println("Connection Successful");

			Statement stmt=conn.createStatement();
			String sqlquery_my_events="select * from fp.skhede_items";
			ResultSet rs=stmt.executeQuery(sqlquery_my_events);           
			
				

			//ResultSet rs1=stmt.executeQuery(sqlquery_my_events);

			Connection c ;
			data = FXCollections.observableArrayList();
			for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
				//We are using non property style for making dynamic table

				final int j = i;              
			TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
				col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                  
					public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                            
						return new SimpleStringProperty(param.getValue().get(j).toString());                      
					}                  
				});
				tableAllItems.getColumns().addAll(col);
				System.out.println("Column ["+i+"] ");
			}     
			while(rs.next())
			{
				//Iterate Row
				ObservableList<String> row = FXCollections.observableArrayList();
				for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
					//Iterate Column
					row.add(rs.getString(i));
				}
				
				System.out.println("Row [1] added "+row );
				data.add(row);
			}	
			tableAllItems.setItems(data);
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unknown error occurred ! Items cannot be displayed at this time");           
		}    
	}
	
	//Code not running?
	private ObservableList<Item> cartData;
	
	
	public void initialize2(URL arg0, ResourceBundle arg1)
	{
		try
		{
			System.out.println("View Item Controller <--> View cart data" );
			TableCartItems.getColumns().clear();
			Customer customer = (Customer)Main.USER_CACHE.get("user");
			Main.USER_CACHE.put("user", customer);
			
			
			List<Item> ItemList = customer.getShoppingCart().getAllItem();
			String[] columnNames = {"Item Id", "Item Name","Cost","Department","Quantity"};

			cartData = FXCollections.observableList(ItemList);
			TableColumn ItemId = new TableColumn<>("Item Id");
			ItemId.setMinWidth(100);
			ItemId.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Item Id"));
			
			TableColumn ItemName = new TableColumn<>("Item Name");
			ItemName.setMinWidth(100);
			ItemName.setCellValueFactory(new PropertyValueFactory<Item,String>("Item Name"));
			
			TableColumn Cost = new TableColumn<>("Cost");
			Cost.setMinWidth(100);
			Cost.setCellValueFactory(new PropertyValueFactory<Item,String>("Cost"));
			
			TableColumn Department = new TableColumn<>("Department");
			Department.setMinWidth(100);
			Department.setCellValueFactory(new PropertyValueFactory<Item,Integer>("Department"));
			
			TableColumn Quantity = new TableColumn<>("Quantity");
			Quantity.setMinWidth(100);
			Quantity.setCellValueFactory(new PropertyValueFactory<Item,String>("Quantity"));
			
			TableCartItems.setItems(cartData);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unable to view Cart Items !");           
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
@FXML Button buyItemButton;
@FXML Button viewCartButton;
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
	/*System.out.println("In Controller Buy Item method");
	int item_id = Integer.parseInt(buyItemId.getText().trim());

	Customer customer = (Customer)Main.USER_CACHE.get("user");
	ItemDao ItemDao = new ItemDaoImp();
	System.out.println("Customer details --> "+ customer+ " " +(Customer)Main.USER_CACHE.get("user"));

	System.out.println("Item id-->"+item_id);
	Connector conn1 = new Connector();
	Connection connection = conn1.getType4Connection();
	//String query ="select * from skhede_items where item_id ='"+item_id+"'";
	System.out.println("Check if item id present in database ? " +item_id);
	Main.USER_CACHE.put("user", customer);*/
	Connector conn1 = new Connector();
	Connection connection = conn1.getType4Connection();
	int item_id = Integer.parseInt(buyItemId.getText().trim().toLowerCase());
	ItemDao ItemDao = new ItemDaoImp();
	Customer customer = (Customer)Main.USER_CACHE.get("user");
	Main.USER_CACHE.put("user", customer);
	//customer.getShoppingCart().addItem(ItemDao.getItemInt(item_id));
    System.out.println(customer.getShoppingCart());
    Main.USER_CACHE.put("user", customer);
    
    System.out.println("In VIEW ITEM controller");
    
	//String department_name = addItemDeptText.getText().trim().toLowerCase();
	//String item_name = addItemText.getText().trim().toLowerCase();
	//String description = addDescTextArea.getText().trim().toLowerCase();
	//int cost =Integer.parseInt(addItemCostText.getText().trim().toLowerCase());
	
	//int quantity =Integer.parseInt(addItemQuantityText.getText().trim().toLowerCase());
	//int reward_points =Integer.parseInt(addItemRewardText.getText().trim().toLowerCase());
	//ItemDao Item = new ItemDaoImp();
	//ClassificationDao abc = new ClassificationDaoImp();
	//int checkUser = abc.getClassificationId(classification_name);
	
	//boolean y = Item.addItem(item_id, item_name,description,cost,quantity,reward_points);
	try {
		PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from fp.skhede_items where item_id =?");
		ps.setInt (1, item_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
		    customer.getShoppingCart().addItem(ItemDao.getItemInt(item_id));
		    System.out.println(customer.getShoppingCart());
		    
			connection.close();
			conn1.closeConnection();
			AlertMessage.infoBox("Item Added to Cart Successfully !", " Item Cart");
			Main.USER_CACHE.put("user", customer);

		} else {
		 AlertMessage.infoBox("Item ID does not exist, unable to add to cart !", "Failed to add to cart");
		}	

	} catch(Exception e) {
		AlertMessage.infoBox("Failed to add item to Cart !", "Add Item to Cart");
		e.printStackTrace();
	}
}
   	
	/*try
	{
	  PreparedStatement ps = (PreparedStatement) connection.prepareStatement("select * from fp.skhede_items where item_id =?");
ps.setInt (1, item_id);
ResultSet rs = ps.executeQuery();

if (rs.next()) {
    customer.getShoppingCart().addItem(ItemDao.getItemInt(item_id));
    System.out.println(customer.getShoppingCart());
    
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
}	}
*/

@FXML public void clickMenuViewCart(ActionEvent event) throws Exception
{
		 
 try {
	 
	 //System.out.println("In ViewItemController - ViewCart method");
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

@FXML public void tableAllProduct(ActionEvent event) throws Exception
{
		 
 try {
		
	} catch(Exception e) {
		e.printStackTrace();
	}
}

	
	}
