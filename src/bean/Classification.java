package bean;

public class Classification {
private int classification_id;
private String classification_name;

public Classification()
 {
	//default constructor
 }
public Classification(int classification_id, String classification_name) {
	super();
	this.classification_id = classification_id;
	this.classification_name = classification_name;
}

public int getClassification_id() {
	return classification_id;
}

public void setClassification_id(int classification_id) {
	this.classification_id = classification_id;
}

public String getClassificationName() {
	return classification_name;
}

public void setClassification_name(String classification_name) {
	this.classification_name = classification_name;
}
public String getAllClassification() {
	// TODO Auto-generated method stub
	return null;
}
public char[] getClassificationId() {
	// TODO Auto-generated method stub
	return null;
}

public Classification getClassificationName2() {
	return null;
}

public void setCategoryName(String categoryName) {
	this.classification_name = classification_name;
}
 
@Override
public String toString() {
	return classification_name;
}
}
