package model;


import bean.Classification;
import javafx.collections.ObservableList;

public interface ClassificationDao {
	public ObservableList<Classification> getAllClassification();
	public Classification getClassification(int classification_id, String classification_name);
	public ObservableList<Classification> getAllCategory();
	public Classification getClassification(int classification_id);
	public boolean addClassification(String classification_name);
	public boolean deleteClassification(String classification_name);
	public boolean updateClassification(int classification_id,String classification_name);
	public int getClassificationId(String classification_name);

}
