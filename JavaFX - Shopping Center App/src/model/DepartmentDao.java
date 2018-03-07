package model;


import bean.Department;
import javafx.collections.ObservableList;

public interface DepartmentDao {

	public ObservableList<Department> getAllDepartment();
	public boolean addDepartmentDetails(String classification_id, String department_name);
	public boolean editDepartment(int department_id,String department_name);
	public boolean deleteDepartmentDetails(String classification_id, String department_name);
	//public int getDepartment(String department_name);
	//public Department getDepartment(int department_id);
	public Department getDepartment1(int department_id);
	Department getDepartment(int department_id);
	public int getDepartmentId(String department_name);
	public Department getDepartmentName(String department_name);
	
}
