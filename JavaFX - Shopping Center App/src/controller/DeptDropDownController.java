package controller;

import java.net.URL;
import java.util.ResourceBundle;

import bean.Department;
import cache.DemoStore;
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

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import model.AllDepartmentDaoImplementation;

import model.DepartmentDao;

public class DeptDropDownController<T> implements Initializable {

	
	@FXML private ChoiceBox<Department> choiceBoxDept;
	//@FXML private ChoiceBox<Classification> addDepartmentDropdown;
	@FXML Button confirmButton;
	@FXML TextField newDeptNameTextField;
	@FXML TextField oldDeptNameTextField;
	
	//Classification name for CLassification dropdown
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("begin");
		ObservableList<Department> DepartmentDetails = FXCollections.observableArrayList();
		ObservableList<String> downlist =FXCollections.observableArrayList();
		DepartmentDao trader_info = new AllDepartmentDaoImplementation();
		//ObservableList<Classification> TestList =FXCollections.observableArrayList();
		try {
			DepartmentDetails= trader_info.getAllDepartment();
			//	traderinfolist.setAll(get)	
			System.out.println("in try");
			for(int i=0;i<DepartmentDetails.size();i++)
			{
				//	AddUser_BranchId.getItems().addAll(traderinfolist.get(i).getBranchId());
				downlist.add(DepartmentDetails.get(i).getDepartmentName());
			
				System.out.println("DeptDropDownController");
				System.out.println(DepartmentDetails);
				System.out.println(downlist);
			}

			choiceBoxDept.setItems(DepartmentDetails);

		} catch (Exception e) {

			e.printStackTrace();
		}

	
	}
	
	@FXML public void clickConfirmButtonDept(ActionEvent event) throws Exception
	{
			 
		Department a=choiceBoxDept.getValue();
		String as = String.valueOf(a.getDepartmentName());
			DemoStore demo = new DemoStore();
			demo.setSt(as);
	 try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerShopByDepartment2.fxml"));
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

	
	@FXML public void clickEditProfile(ActionEvent event) throws Exception
    {

	 try {
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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/drop.fxml"));
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

@FXML public void clickAllItemsButton(ActionEvent event) throws Exception
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
@FXML public void clickBuyItemButton(ActionEvent event) throws Exception
{
		 
 try {
	 AlertMessage.infoBox("Item added to cart successfully !", "Item Cart");
	} catch(Exception e) {
		AlertMessage.infoBox("Failed to add Item to cart !", "Item Cart");
		e.printStackTrace();
	}
}
@FXML public void clickMenuViewCart(ActionEvent event) throws Exception
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
@FXML public void clickLogout(ActionEvent event) throws Exception
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

private boolean getClassificationId(String classificationName) {
	// TODO Auto-generated method stub
	return false;
}
}




