package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import bean.Classification;
import bean.Department;
import connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AllDepartmentDaoImplementation implements DepartmentDao {

	@Override
	public ObservableList<Department> getAllDepartment() {
		ObservableList<Department> categoryList = FXCollections.observableArrayList();
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select * from fp.skhede_departments";
				 				
				try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()){
					Department department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
					categoryList.add(department);
				}
				rs.close();
				statement.close();
				connection.close();
				conn1.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return categoryList;
	}

	
	/*
	 * public Category getCategory(int categoryId) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		String query = "select category.categoryId,categoryName";
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Category category = new Category(rs.getInt("categoryId"), rs.getString("categoryName"));
			return category;			
		}
		rs.close();
		statement.close();
		connection.close();
		connectionFactory.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
return null;
	}
	*/
	
	
	@Override
	public Department getDepartment(int department_id) {
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select * from fp.skhede_departments";
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Department department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
			return department;			
		}
		rs.close();
		statement.close();
		connection.close();
		conn1.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
return null;
	}

	@Override
	public boolean addDepartmentDetails(String classification_name, String deptName) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		
String query = "INSERT INTO fp.skhede_departments (classification_name,department_name) VALUES ('"+classification_name+"','" + deptName + "')";
		System.out.println("Inserting?");
		try {
			Statement preparedStatement = connection.createStatement();
			
			int a = preparedStatement.executeUpdate(query);
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; // as there was some error while the insert, the result is set as false
		}
		
		return result;
	}
/*


	
	@Override
	public int getCategoryId(String categoryName) {
		conn1 conn1 = new conn1();
		Connection connection = conn1.getType4Connection();
		String query = "select categoryId from categorySPV where categoryName='"+categoryName+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				return rs.getInt(1);			
			}		
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  0;
		}
		
		return 0;
	}

*/



	

	@Override
	public boolean editDepartment(int department_id, String department_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "update fp.skhede_departments set  `department_name` = ? where department_id= '"+department_id+"'" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, department_name);
			System.out.println("Department DAO IMPLEMENTATION");
			System.out.println(department_name);
			
			
			int a = preparedStatement.executeUpdate();
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; // as there was some error while the insert, the result is set as false
		}
		
		return result;
}

	@Override
	public boolean deleteDepartmentDetails(String classification_id, String department_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "delete from fp.skhede_departments where department_name = '" + department_name + "'";
		try {
			Statement statement = connection.createStatement();
			int a = statement.executeUpdate(query);
			if(a>0){
				result = true;
			}
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	
	
	
	@Override
	public Department getDepartmentName(String department_name) {
		boolean result = false;
		Connector conn1 = new Connector();
		Connection connection = conn1.getType4Connection();
		String query = "select department_name from fp.skhede_departments where department_name='"+department_name+"'";
		System.out.println("DAO dept implementation after getdeptID");
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				System.out.println("Before DEPARTMENT NAMES");
				Department department = new Department(rs.getInt("department_id"), rs.getString("department_name"));
				return department;
			}		
			statement.close();
			connection.close();
			conn1.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  null;
		}
		
		return null;
	}

	
	
	
	
	

	@Override
	public Department getDepartment1(int department_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getDepartmentId(String department_name) {
		// TODO Auto-generated method stub
		return 0;
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


}