package application;
	
import cache.Cache;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/LoginPage.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1));
			stage.setTitle("Shopping Center Application");
			stage.show();
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Cache USER_CACHE = null;
	
	public static void main(String[] args) {
		launch(args);
	}
}
