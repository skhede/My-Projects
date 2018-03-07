package controller;

import java.io.IOException;

import application.Main;
import bean.Admin;
import bean.Customer;
import bean.User;
import cache.Cache;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.UserDao;
import model.AllUserDaoImplementation;

import javafx.scene.control.Alert;
public class Login_Controller {

	@FXML
	Button LoginButton;
	@FXML
	TextField Username;
	@FXML
	Button ResetButton;
	@FXML
	PasswordField Pwd;
	@FXML 
	Hyperlink ForgotPwd;
	@FXML 
	Hyperlink NewUser;
	
	public void initialize() {	
		System.out.println("Test Login Form !");
		System.out.println("Successfully Entered in Login_Controller !");
	}

	@FXML
	public void login(ActionEvent event) throws Exception {
		String username = Username.getText().trim().toLowerCase();
		String password = Pwd.getText().trim();
		UserDao testUser = new AllUserDaoImplementation();
		User checkUser = testUser.authenticateUser(username, password);
		System.out.println("This is login controller -- > "+checkUser);
		Main.USER_CACHE = new Cache();
		if (checkUser == null) {
			try {
				
				AlertMessage.infoBox("Incorrect login details ! Please check Username/Password Pair !!", "Invalid Username/Password ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Main.USER_CACHE.put("user", checkUser);
			try {
				if (checkUser instanceof Customer) {
					((Node)event.getSource()).getScene().getWindow().hide();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/CustomerHome.fxml"));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.show();
				}else if(checkUser instanceof Admin){
					((Node)event.getSource()).getScene().getWindow().hide();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/AdminHome.fxml"));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root1));
					stage.show();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	public void ForgotPwd(ActionEvent event) throws Exception {

		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/ForgotPassword.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	public void resetOnClick(ActionEvent event) throws Exception {

		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void NewUserLink(ActionEvent event) throws Exception {

		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/Registration.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
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
	        }
	        catch (Exception e) {
				e.printStackTrace();
			}
	}
}