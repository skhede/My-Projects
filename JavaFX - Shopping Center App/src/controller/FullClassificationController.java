package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ClassificationDao;
import model.ClassificationDaoImp;

public class FullClassificationController {

	@FXML TextField addClassificationTextBox;
	@FXML TextField deleteClassificationTextBox;
	@FXML TextField oldClassificationTextBox;
	@FXML TextField newClassificationTextBox;
	@FXML Button addClassificationButton;
	@FXML Button editClassificationButton;
	@FXML Button deleteClassificationButton;
	@FXML Button viewClassificationButton;
	
	
	@FXML public void buttonAddClassification(ActionEvent event) throws Exception
    {
    	String NewClassificationName = addClassificationTextBox.getText().trim().toLowerCase();
    	ClassificationDao Classification = new ClassificationDaoImp();
    	boolean y = Classification.addClassification(NewClassificationName);
    	if (y == true)
    {
	 try {
		 AlertMessage.infoBox("Classification Added Successfully !", "Classification");

		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    	else
    	{
    		 try {
    				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/processFailed.fxml"));
    	            Parent root1 = (Parent) fxmlLoader.load();
    	            Stage stage = new Stage();
    	            stage.setScene(new Scene(root1));
    	            stage.show();

    			} catch(Exception e) {
    				e.printStackTrace();
    			}
   	}
   }
    
	@FXML public void buttonViewClassification(ActionEvent event) throws Exception
    {
		 
	 try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ViewAllClassifications.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           Stage stage = new Stage();
           stage.setScene(new Scene(root1));
           stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
   }
	@FXML public void buttonDeleteClassification(ActionEvent event) throws Exception
    {        
    	String ClassificationToDelete = deleteClassificationTextBox.getText().trim().toLowerCase();
    	ClassificationDao Classification = new ClassificationDaoImp();
    	boolean y = Classification.deleteClassification(ClassificationToDelete);
    	
	 if (y==true){
    	try {
    		System.out.println("BEFORE DELETE CONTROLLER!!");
    		AlertMessage.infoBox("Deleted successfully !!", "Classifications !!");

		} catch(Exception e) {
			e.printStackTrace();
		}}
	 else {try {
		 AlertMessage.infoBox("Failed to delete  !!", "Classifications !!");

		} catch(Exception e) {
			e.printStackTrace();
		}
		 
	 }
	 
	 
	 
	 }
	 @FXML public void buttonEditClassification(ActionEvent event) throws Exception
	    {
	    	String oldCategoryName = oldClassificationTextBox.getText().trim().toLowerCase();
	    	ClassificationDao Classification = new ClassificationDaoImp();
	    	int classify = Classification.getClassificationId(oldCategoryName);
	    	String NewClassificationName = newClassificationTextBox.getText().trim().toLowerCase();
	    	boolean y = Classification.updateClassification(classify, NewClassificationName);
	
	 if (y==true){
	    	try {
	    		System.out.println("BEFORE DELETE CONTROLLER!!");
	    		AlertMessage.infoBox("Classification Updated successfully  !!", "Classifications !!");


			} catch(Exception e) {
				e.printStackTrace();
			}}
		 else {try {
			 AlertMessage.infoBox("Failed to update classification !!", "Classifications !!");

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
