package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PlaygroundController {
	@FXML
	AnchorPane leftPane;
	
	@FXML
	AnchorPane rightPane;
	
	@FXML
	public void addNewElement()
	{
		System.out.println("addNewElement");
		
	    leftPane.getChildren().clear();
	    
	    
		Button SendButton = new Button();
	    SendButton.setText("create new element");
	    leftPane.getChildren().add(SendButton);
	}
	
	@FXML
	public void getElement()
	{
	    leftPane.getChildren().clear();
	    
		SendElementRequests elementRequests = new SendElementRequests();

		Button SendButton = new Button();
		SendButton.setText("get element");
		
		
		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.getElementsRequest(leftPane, rightPane);
				
			}
		});
	    
	    
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
	    
	    
	    Text userPlaygroundText = new Text();
	    userPlaygroundText.setText("Enter user play ground");
	    TextField userPlaygroundTextField = new TextField ();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    Text elementPlaygroundText = new Text();
	    elementPlaygroundText.setText("Enter Element Playground");
	    Text IdText = new Text();
	    IdText.setText("Enter Element ID");
	    
	    //create all the TextField
	    TextField emailTextField = new TextField ();
	    TextField elementPlaygroundField = new TextField ();
	    TextField IdField = new TextField ();
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(elementPlaygroundText,5,4);
	    root.add(elementPlaygroundField,5,5);
	    
	    root.add(IdText,5,6);
	    root.add(IdField,5,7);
	    
	    root.add(SendButton, 5, 8);
	    
	    
	    leftPane.getChildren().add(root);	
	    
	}
	
	@FXML
	public void getAllElement()
	{
	    leftPane.getChildren().clear();
	    
		SendElementRequests elementRequests = new SendElementRequests();
	    
		Button SendButton = new Button();
	    SendButton.setText("get all Element");

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.getAllElementsRequest(leftPane, rightPane);
				
			}
		});

	    
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
	    
	    
	    Text userPlaygroundText = new Text();
	    userPlaygroundText.setText("Enter user play ground");
	    TextField userPlaygroundTextField = new TextField ();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField ();
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(SendButton, 5, 4);
	    
	    leftPane.getChildren().add(root);
	    
	}
	
	@FXML
	public void getAllNearElement()
	{
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("get all the near elements");
	    
		SendElementRequests elementRequests = new SendElementRequests();
	    
		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.getAllNearElementsRequest(leftPane, rightPane);
				
			}
		});
	    
		
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
	    
	    
	    Text userPlaygroundText = new Text();
	    userPlaygroundText.setText("Enter user play ground");
	    TextField userPlaygroundTextField = new TextField ();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField ();
	    
	    Text xText = new Text(); 
	    xText.setText("Enter x");
	    TextField xTextField = new TextField ();
	    
	    Text yText = new Text(); 
	    yText.setText("Enter y");
	    TextField yTextField = new TextField ();
	    
	    Text distanceText = new Text(); 
	    distanceText.setText("Enter distance");
	    TextField distanceTextField = new TextField ();
	    
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(xText,5,4);
	    root.add(xTextField,5,5);
	    
	    root.add(yText,5,6);
	    root.add(yTextField,5,7);
	     
	    root.add(distanceText,5,8);
	    root.add(distanceTextField,5,9);
	        
	    root.add(SendButton, 5, 10);
	    
	    leftPane.getChildren().add(root);

	}
	
	@FXML
	public void getAllElementWithAttribute()
	{
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("get all the element with attribute");

		SendElementRequests elementRequests = new SendElementRequests();
	    
		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.getAllElementsWithAttributeRequest(leftPane, rightPane);
				
			}
		});
		
		
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
	    
	    
	    Text userPlaygroundText = new Text();
	    userPlaygroundText.setText("Enter user play ground");
	    TextField userPlaygroundTextField = new TextField ();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField ();
	    
	    Text attributeText = new Text(); 
	    attributeText.setText("Enter attribute name");
	    TextField attributeTextField = new TextField ();
	    
	    Text valueText = new Text(); 
	    valueText.setText("Enter attribute value");
	    TextField valueTextField = new TextField ();
	    
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(attributeText,5,4);
	    root.add(attributeTextField,5,5);
	    
	    root.add(valueText,5,6);
	    root.add(valueTextField,5,7);
	    
	    root.add(SendButton, 5, 8);
	    
	    leftPane.getChildren().add(root);

	    
	}
	
	@FXML
	public void createNewUser()
	{
		System.out.println("create New User");
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("create new user");
	    leftPane.getChildren().add(SendButton);
	}
	
	@FXML
	public void updateUser()
	{
		System.out.println("Update User");
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("update user");
	    leftPane.getChildren().add(SendButton);
	}
	
	@FXML
	public void verifyUser()
	{
		System.out.println("Verify User");
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("verify user");
	    leftPane.getChildren().add(SendButton);
	}
	
	@FXML
	public void userLogin()
	{
		System.out.println("user Login");
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("login");
	    leftPane.getChildren().add(SendButton);
	}
	
	@FXML
	public void createNewActivity()
	{
		System.out.println("create New Activity");
	    leftPane.getChildren().clear();
		Button SendButton = new Button();
	    SendButton.setText("create new activity");
	    leftPane.getChildren().add(SendButton);
	}
	
	
	@FXML
	public void clickSend()
	{

		 
	}
	
	
}
