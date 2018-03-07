package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class CustomerController {
	@FXML Button EditDetailsButton;
	@FXML Button BuyBrandButton;
	@FXML Button ByCtegoryButton;
	@FXML MenuItem menuShopByDept;
	@FXML MenuItem menuShopByClass;
	@FXML MenuItem menuEditProfile;
	@FXML Menu Logout;

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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/allproductViewC.fxml"));
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
	
	
	
}
