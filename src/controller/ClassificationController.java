package controller;

import java.net.URL;
import java.util.ResourceBundle;

import bean.Classification;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AllClassificationDaoImplementation;
import model.AllDepartmentDaoImplementation;
import model.ClassificationDao;
import model.DepartmentDao;



public class ClassificationController<T> implements Initializable {

	@FXML TextField addDeptartmentTextBox;
	@FXML private ChoiceBox<String> addDepartmentDropdown;
	@FXML private ChoiceBox<String> editDepartmentDropdown;
	@FXML Button editDepartmentButton;
	@FXML TextField newDeptNameTextField;
	public void initialize(URL arg0, ResourceBundle arg1) {

		System.out.println("begin");
		ObservableList<Classification> classificationDetails = FXCollections.observableArrayList();
		ObservableList<String> downlist =FXCollections.observableArrayList();
		ClassificationDao trader_info = new AllClassificationDaoImplementation();
		//ObservableList<Classification> TestList =FXCollections.observableArrayList();
		try {
			classificationDetails= trader_info.getAllClassification();
			//	traderinfolist.setAll(get)	
			System.out.println("in try");
			for(int i=0;i<classificationDetails.size();i++)
			{
				//	AddUser_BranchId.getItems().addAll(traderinfolist.get(i).getBranchId());
				downlist.add(classificationDetails.get(i).getClassificationName());
			
				System.out.println("in loop");
				System.out.println(classificationDetails);
				System.out.println(downlist);
			}

			addDepartmentDropdown.setItems(downlist);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@FXML public void clickAddDepartment(ActionEvent event) throws Exception
	{
		
		String deptName = addDeptartmentTextBox.getText().trim().toLowerCase();
		String classificationName = addDepartmentDropdown.getValue();
		//Cache cache = new Cache();
		//cache.put("customerName", custNameToP);
		DepartmentDao deptDao = new AllDepartmentDaoImplementation();
		deptDao.addDepartmentDetails(classificationName, deptName);
		
		
		boolean addDept = addDepartmentDetails (classificationName, deptName);
		System.out.println("Value in choicebox -"+addDepartmentDropdown.getValue());
		System.out.println("Check -"+addDept);
		{
		if (addDept == true)
{
 try {
	
		AlertMessage.infoBox("Department Added Successfully !!", "Add Department");
		
	 } catch(Exception e) {
		e.printStackTrace();
	}
}
	else
	{
		 try {
				AlertMessage.infoBox("Failed to add department !!", "Add Department");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
	}
    }
	}


	private boolean addDepartmentDetails(String classificationName, String deptName) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	@FXML public void clickConfirmButton(ActionEvent event) throws Exception
	{
		
		String deptName = addDeptartmentTextBox.getText().trim().toLowerCase();
		String classificationName = addDepartmentDropdown.getValue();
		//Cache cache = new Cache();
		//cache.put("customerName", custNameToP);
		DepartmentDao deptDao = new AllDepartmentDaoImplementation();
		deptDao.addDepartmentDetails(classificationName, deptName);
		boolean addDept = addDepartmentDetails (classificationName, deptName);
		{
		if (addDept == true)
{
 try {
	
		AlertMessage.infoBox("Department Added Successfully !!", "Add Department");
		
	 } catch(Exception e) {
		e.printStackTrace();
	}
}
	else
	{
		 try {
				AlertMessage.infoBox("Failed to add department !!", "Add Department");
				
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

@FXML public void onClickHome(ActionEvent event) throws Exception
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}
@FXML public void clickViewCartButton(ActionEvent event) throws Exception
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