package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		FXMLLoader loader;
		try {
			loader = new FXMLLoader(getClass().getResource("PlaygroundClient.fxml"));
			SplitPane root = (SplitPane)loader.load();
			// set a whitesmoke background
			root.setStyle("-fx-background-color: whitesmoke;");
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("2019a.talin playgroundClient");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
