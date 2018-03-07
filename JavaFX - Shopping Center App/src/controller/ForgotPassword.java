package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import cache.Cache;
import connector.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.UserDao;
import model.AllUserDaoImplementation;
import javafx.scene.Node;

public class ForgotPassword {

	@FXML TextField username;
	@FXML TextField password;
	@FXML Button submitButton;
	@FXML Button cancelButton;


	@FXML
	public void clickSubmit(ActionEvent event) throws Exception {

	String name = username.getText();
	String pass = password.getText();
	Connector testConn = new Connector();
	Connection testConn2 = testConn.getType4Connection();
	Statement statement = testConn2.createStatement();
	String status=null;
	String query= "select * from fp.skhede_users where username='"+name+"'";
	ResultSet rs = statement.executeQuery(query);
	UserDao userDao = new AllUserDaoImplementation();
	userDao.resetPassword(name,pass);
	//String checkUser=rs.getString(1);
    //String checkPass=rs.getString(2);
	
	System.out.println("In forgot password Controller !");
	
	
try{
			if ((name.length()==0))
			{
					AlertMessage.infoBox("Username cannot be blank!", "Incorrect Username");
			}
			else
			{
					if (pass.length()==0)
					{
						AlertMessage.infoBox("Password cannot be blank !", "Incorrect Username");
					}
						else
						{
							AlertMessage.infoBox("Password Reset successfully !", "Reset Password");
							((Node)event.getSource()).getScene().getWindow().hide();
							FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
							Parent root1 = (Parent) fxmlLoader.load();
							Stage stage = new Stage();
							stage.setScene(new Scene(root1));
							stage.show();
						}
					}
			
		} catch (Exception e) {
			AlertMessage.infoBox("Failed to reset password !", "Reset Password");
			e.printStackTrace();
		}
	}

	@FXML
	public void clickCancel(ActionEvent event) throws Exception {

		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
