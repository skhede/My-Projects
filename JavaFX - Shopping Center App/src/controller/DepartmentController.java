package controller;

import java.net.URL;
import java.util.ResourceBundle;

import bean.Classification;
import bean.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AllClassificationDaoImplementation;
import model.AllDepartmentDaoImplementation;
import model.ClassificationDao;
import model.DepartmentDao;



public class DepartmentController<T> implements Initializable {

	@FXML TextField addDeptartmentTextBox;
	@FXML private ChoiceBox<String> addDepartmentDropdown;
	@FXML private ChoiceBox<String> editDepartmentDropdown;
	@FXML Button editDepartmentButton;
	@FXML TextField newDeptNameTextField;
	@FXML TextField oldDeptNameTextField;
	
	public void initialize2(URL arg0, ResourceBundle arg1) {

		System.out.println("begin");
		ObservableList<Department> dptName = FXCollections.observableArrayList();
		ObservableList<String> downlist1 =FXCollections.observableArrayList();
		DepartmentDao trader_info = new AllDepartmentDaoImplementation();
		//ObservableList<Classification> TestList =FXCollections.observableArrayList();
		try {
			dptName= trader_info.getAllDepartment();
			//	traderinfolist.setAll(get)	
			System.out.println("in try");
			for(int i=0;i<dptName.size();i++)
			{
				//	AddUser_BranchId.getItems().addAll(traderinfolist.get(i).getBranchId());
				downlist1.addAll(dptName.get(i).getDepartment_name());
			
				System.out.println("IN dept controller");
				System.out.println(dptName);
				System.out.println(downlist1);
			}

			editDepartmentDropdown.setItems(downlist1);

		} catch (Exception e) {

			e.printStackTrace();
		
		}
	}
	
		@FXML public void clickEditDepartment(ActionEvent event) throws Exception
		{
			
			/*
			 * String NewCategoryName = updateCatText.getText().trim().toLowerCase();
	    	CategoryDao Category = new CategoryDaoImp();
	    	int cId = Category.getCategoryId(NewCategoryName);
	    	String NewcatName = newcatnametext.getText().trim().toLowerCase();
	    	boolean y = Category.updateCategory(cId, NewcatName);
	    	if (y == true)
	    {
		 try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CategoryDetailUpdateSuccess.fxml"));
	            Parent root1 = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root1));
	            stage.show();

			} catch(Exception e) {
				e.printStackTrace();
			}
	    }    }
*/			
			String deptName = oldDeptNameTextField.getText().trim().toLowerCase();
			DepartmentDao Department = new AllDepartmentDaoImplementation();
			String newDeptName = newDeptNameTextField.getText().trim().toLowerCase();
			int department_id = Department.getDepartmentId(deptName);
			boolean update = Department.editDepartment(department_id, newDeptName);
	    	
			//Cache cache = new Cache();
			//cache.put("customerName", custNameToP);
			//DepartmentDao deptDao = new AllDepartmentDaoImplementation();
			//deptDao.editDepartmentDetails(classificationName, deptName);
			//boolean editDept = editDepartmentDetails (classificationName, deptName);
			{
			if (update == true)
	{
	 try {
		
			AlertMessage.infoBox("Department Edited Successfully !!", "Edit Department");
			
		 } catch(Exception e) {
			e.printStackTrace();
		}
	}
		else
		{
			 try {
					AlertMessage.infoBox("Failed to edit department !!", "Edit Department");
					
				} catch(Exception e) {
					e.printStackTrace();
				}
		}
	    }
		}

	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
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
	




