package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connector.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import bean.Classification;


public class AllClassificationDaoImplementation implements ClassificationDao {

	@Override
	public ObservableList<Classification> getAllClassification() {
		ObservableList<Classification> classificationList = FXCollections.observableArrayList();
		Connector conn1 = new Connector();
		Connection conn2 = conn1.getType4Connection();
		String query = "select * from skhede_classifications";
				 				
				try {
				Statement statement = conn2.createStatement();
				ResultSet rs = statement.executeQuery(query);
				while(rs.next()){
					Classification typeClassification = new Classification(rs.getInt("classification_id"), rs.getString("classification_name"));
					classificationList.add(typeClassification);
				}
				rs.close();
				statement.close();
				conn2.close();
				conn1.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		return classificationList;
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

	@Override
	public Classification getClassification(int classification_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addClassification(String classification_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClassification(String classification_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateClassification(int classification_id, String classification_name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getClassificationId(String classification_name) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*@Override
	public Classification getClassification(int classification_id, String classification_name) {
		Connector conn1 = new Connector();
		Connection conn2 = conn1.getType4Connection();
		String query = "select classification_name from skhede_classifications";
	try {
		Statement statement = conn2.createStatement();
		ResultSet rs = statement.executeQuery(query);
		while(rs.next()){
			Classification classification = new Classification(rs.getInt("classification_id"), rs.getString("classification_name"));
			return classification;			
		}
		rs.close();
		statement.close();
		conn2.close();
		conn1.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
return null;*/


	}
/*
	@Override
	public boolean addBrand( String brandName) {
		boolean result = false;
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		
String query = "INSERT INTO brandSPV ( brandName) VALUES ('" + brandName + "')";
		
		try {
			Statement preparedStatement = connection.createStatement();
			
			int a = preparedStatement.executeUpdate(query);
			if(a > 0){
				result = true;
			}
			
			preparedStatement.close();
			connection.close();
			connectionFactory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false; // as there was some error while the insert, the result is set as false
		}
		
		return result;
	}

	@Override
	public boolean deleteBrand(String brandName) {
		boolean result = false;
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		String query = "delete from brandSPV where brandName = '" + brandName + "'";
		try {
			Statement statement = connection.createStatement();
			int a = statement.executeUpdate(query);
			if(a>0){
				result = true;
			}
			statement.close();
			connection.close();
			connectionFactory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public boolean updateBrand(int brandId, String brandName) {
		boolean result = false;
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		String query = "update brandSPV set  brandName = '"+brandName+"' where brandId = '"+brandId+"'" ;
		try {System.out.println("in the dao name updateed  "+ brandName);

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		

		System.out.println("the brand name after setString 1, brandName is "+query);
		int a = preparedStatement.executeUpdate();
		System.out.println("the value of count true and false a is"+a);
		if(a > 0){
			result = true;
		}
			
		preparedStatement.close();
		connection.close();
		connectionFactory.closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
		result = false; // as there was some error while the insert, the result is set as false
	}
	
	return result;
	}

	@Override
	public int getBrandId(String brandName) {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.getType4Connection();
		String query = "select brandId from brandSPV where brandName='"+brandName+"'";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()){
				return rs.getInt(1);			
			}		
			statement.close();
			connection.close();
			connectionFactory.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return  0;
		}
		
		return 0;
	}
	*/

