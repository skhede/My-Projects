package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import cache.Cache;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;


public class ViewClassificationController implements Initializable{
	private ObservableList<ObservableList> data;
	@FXML private TableView viewAllClassifications;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		try
		{
			viewAllClassifications.getColumns().clear();
			
			Connection conn=DriverManager
			          .getConnection("jdbc:mysql://www.papademas.net/fp?"
			                  + "user=dbfp&password=510");;
		//System.out.println("Connection Successful");

			Statement stmt=conn.createStatement();
			String sqlquery_my_events="select * from skhede_classifications";
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
				viewAllClassifications.getColumns().addAll(col);
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
			//while(rs1.next())
			//{
			//  my_reg_events_choice_box.getItems().add(rs1.getString(1)); 
		//}
			//FINALLY ADDED TO TableView
			viewAllClassifications.setItems(data);
			conn.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Unknown error occurred ! Data cannot be displayed at this time");           
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
			
		//String custNameToP = AgetCustNText.getText().trim().toLowerCase();
		//Cache cache = new Cache();
		//cache.put("customerName", custNameToP);
		/*UserDao userDao = new UserDaoImp();
		//Customer getcustomerDetails = userDao.getcustomerDetails(custNameToP);*/
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
			
		//String custNameToP = AgetCustNText.getText().trim().toLowerCase();
		//Cache cache = new Cache();
		//cache.put("customerName", custNameToP);
		/*UserDao userDao = new UserDaoImp();
		//Customer getcustomerDetails = userDao.getcustomerDetails(custNameToP);*/
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
			
		//String custNameToP = AgetCustNText.getText().trim().toLowerCase();
		//Cache cache = new Cache();
		//cache.put("customerName", custNameToP);
		/*UserDao userDao = new UserDaoImp();
		//Customer getcustomerDetails = userDao.getcustomerDetails(custNameToP);*/
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
					
					System.out.println("Admin controller Items Add");
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
	
	}
