package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
	    TextField userPlaygroundTextField = new TextField();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    Text elementPlaygroundText = new Text();
	    elementPlaygroundText.setText("Enter Element Playground");
	    Text IdText = new Text();
	    IdText.setText("Enter Element ID");
	    
	    //create all the TextField
	    TextField emailTextField = new TextField();
	    TextField elementPlaygroundField = new TextField();
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
	    TextField userPlaygroundTextField = new TextField();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField();
	    
	    
	    Text sizeText = new Text();
	    sizeText.setText("Enter the number of the element you waht to see ");
	    TextField sizeTextField = new TextField();
	    
	    Text pageText = new Text();
	    pageText.setText("Enter the page you waht to see ");
	    TextField pageTextField = new TextField();
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(sizeText,5,4);
	    root.add(sizeTextField,5,5);
	    
	    root.add(pageText,5,6);
	    root.add(pageTextField,5,7);
	    
	    root.add(SendButton, 5, 8);
	    
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
	    TextField userPlaygroundTextField = new TextField();
	    
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField();
	    
	    Text xText = new Text(); 
	    xText.setText("Enter x");
	    TextField xTextField = new TextField();
	    
	    Text yText = new Text(); 
	    yText.setText("Enter y");
	    TextField yTextField = new TextField();
	    
	    Text distanceText = new Text(); 
	    distanceText.setText("Enter distance");
	    TextField distanceTextField = new TextField();
	    
	    Text sizeText = new Text();
	    sizeText.setText("Enter the number of the element you waht to see ");
	    TextField sizeTextField = new TextField();
	    
	    Text pageText = new Text();
	    pageText.setText("Enter the page you waht to see ");
	    TextField pageTextField = new TextField();
	    
	    
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
	    
	    root.add(sizeText,5,10);
	    root.add(sizeTextField,5,11);
	    
	    root.add(pageText,5,12);
	    root.add(pageTextField,5,13);
	    
	        
	    root.add(SendButton, 5, 14);
	    
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
	    TextField emailTextField = new TextField();
	    
	    Text attributeText = new Text(); 
	    attributeText.setText("Enter attribute name");
	    TextField attributeTextField = new TextField();
	    
	    Text valueText = new Text(); 
	    valueText.setText("Enter attribute value");
	    TextField valueTextField = new TextField();
	    
	    Text sizeText = new Text();
	    sizeText.setText("Enter the number of the element you waht to see ");
	    TextField sizeTextField = new TextField();
	    
	    Text pageText = new Text();
	    pageText.setText("Enter the page you waht to see ");
	    TextField pageTextField = new TextField();
	    
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(attributeText,5,4);
	    root.add(attributeTextField,5,5);
	    
	    root.add(valueText,5,6);
	    root.add(valueTextField,5,7);
	    
	    root.add(sizeText,5,8);
	    root.add(sizeTextField,5,9);
	    
	    root.add(pageText,5,10);
	    root.add(pageTextField,5,11);
	    
	    root.add(SendButton, 5, 12);
	    
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
	    leftPane.getChildren().clear();  
		Button SendButton = new Button();
	    SendButton.setText("create new activity");
	    
	    SendActivityRequests activityRequests = new SendActivityRequests();
	    
		SendButton.setOnAction(new EventHandler() {
			
			@Override
			public void handle(Event arg0) {
				activityRequests.createNewActivityRequest(leftPane, rightPane);		
			}
		});
		
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
		
	    Text userPlaygroundText = new Text();
	    userPlaygroundText.setText("Enter user play ground");
	    TextField userPlaygroundTextField = new TextField();
	    
	    Text emailText = new Text(); 
	    emailText.setText("Enter Email");
	    TextField emailTextField = new TextField();
	    
	    
	    Text activityText = new Text(); 
	    activityText.setText("Enter Activity:");
	    
	    
	    Text playgroundText = new Text(); 
	    playgroundText.setText("Enter playground");
	    TextField playgroundTextField = new TextField();
	    
	    
	    Text idText = new Text(); 
	    idText.setText("Enter id");
	    TextField idTextField = new TextField();
	    
	    Text elementPlaygroundText = new Text(); 
	    elementPlaygroundText.setText("Enter element Playground");
	    TextField elementPlaygroundTextField = new TextField();
	    
	    Text elementIdText = new Text(); 
	    elementIdText.setText("Enter element Id");
	    TextField elementIdTextField = new TextField();
	    
	    Text typeText = new Text(); 
	    typeText.setText("Enter type");
	    TextField typeTextField = new TextField();
	    
	    Text attributeNameText = new Text(); 
	    attributeNameText.setText("Enter attribute name");
	    TextField attributeNameTextField = new TextField();
	    
	    Text attributeValueText = new Text(); 
	    attributeValueText.setText("Enter attribute value");
	    TextField attributeValueTextField = new TextField();
	    
	    
	    root.add(userPlaygroundText,5,0);
	    root.add(userPlaygroundTextField,5,1);
	    
	    root.add(emailText,5,2);
	    root.add(emailTextField,5,3);
	    
	    root.add(activityText,5,4);
	    
	    root.add(playgroundText,5,5);
	    root.add(playgroundTextField,5,6);
	    
	    root.add(idText,5,7);
	    root.add(idTextField,5,8);
	    
	    root.add(elementPlaygroundText,5,9);
	    root.add(elementPlaygroundTextField,5,10);
	    
	    root.add(elementIdText,5,11);
	    root.add(elementIdTextField,5,12);
	    
	    root.add(typeText,5,13);
	    root.add(typeTextField,5,14);
	    
	    root.add(attributeNameText,5,15);
	    root.add(attributeNameTextField,5,16);
	    
	    root.add(attributeValueText,5,17);
	    root.add(attributeValueTextField,5,18);
	    
	    root.add(SendButton, 5, 19);
	    
	    leftPane.getChildren().add(root);

	    
	}
	
	
}
