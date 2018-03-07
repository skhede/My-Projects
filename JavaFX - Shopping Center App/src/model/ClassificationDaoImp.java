package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Classification;
import connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ClassificationDaoImp implements ClassificationDao {

	@Override
	public ObservableList<Classification> getAllClassification() {
		ObservableList<Classification> ClassificationList = FXCollections.observableArrayList();
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "select * from fp.skhede_classifications";
				 				
				try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()){
					Classification Classification = new Classification(rs.getInt("classification_id"), rs.getString("classification_name"));
					ClassificationList.add(Classification);
				}
				rs.close();
				statement.close();
				connection.close();
				Connector.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return ClassificationList;
	}

	@Override
	public Classification getClassification(int classification_id) {
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "select skhede_classifications.classification_id,classification_name where classification_id='"+classification_id+"'";
	try {
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Classification Classification = new Classification(rs.getInt("classification_id"), rs.getString("classification_name"));
			return Classification;			
		}
		rs.close();
		statement.close();
		connection.close();
		Connector.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
return null;
	}
	
	//getClassificationName

	@Override
	public boolean addClassification( String classification_name) {
		boolean result = false;
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		
String query = "INSERT INTO skhede_classifications (classification_name) VALUES ('" + classification_name + "')";
		
		try {
			Statement preparedStatement = connection.createStatement();
			
			int a = preparedStatement.executeUpdate(query);
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			connection.close();
			Connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; 
		}
		
		return result;
	}

	@Override
	public boolean deleteClassification(String classification_name) {
		boolean result = false;
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "delete from skhede_classifications where classification_name = '" + classification_name + "'";
		try {
			Statement statement = connection.createStatement();
			int a = statement.executeUpdate(query);
			if(a>0){
				result = true;
			}
			statement.close();
			connection.close();
			Connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean updateClassification(int classification_id, String classification_name) {
		boolean result = false;
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "update skhede_classifications set  `classification_name` = ? where classification_id = '"+classification_id+"'" ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
						preparedStatement.setString(1, classification_name);
			
			int a = preparedStatement.executeUpdate();
			if(a > 0){
				result = true;
			}
				
			preparedStatement.close();
			connection.close();
			Connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; 
		}
		
		return result;
	}
	
	@Override
	public int getClassificationId(String classification_name) {
		Connector Connector = new Connector();
		Connection connection = Connector.getType4Connection();
		String query = "select classification_id from skhede_classifications where classification_name='"+classification_name+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				return rs.getInt(1);			
			}		
			statement.close();
			connection.close();
			Connector.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  0;
		}
		
		return 0;
	}

	@Override
	public Classification getClassification(int classification_id, String classification_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObservableList<Classification> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
