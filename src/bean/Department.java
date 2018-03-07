package bean;

public class Department {


private int department_id;
private int classification_id;
private String department_name;

public Department()
{
//This is a default constructor
}



public Department(int department_id, String department_name) {
	super();
	this.department_id = department_id;
	this.classification_id = classification_id;
	this.department_name = department_name;
}

public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public int getClassification_id() {
	return classification_id;
}
public void setClassification_id(int classification_id) {
	this.classification_id = classification_id;
}
public String getDepartment_name() {
	return department_name;
}
public void setDepartment_name(String department_name) {
	this.department_name = department_name;
}
public Department getDepartment(int department_id) {
	// TODO Auto-generated method stub
	return null;
}
public String getDepartmentName() {
	return department_name;
}
public String getAllDepartment() {
	// TODO Auto-generated method stub
	return null;
}

}