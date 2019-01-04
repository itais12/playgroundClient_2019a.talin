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
	public void addNewElement() {
		leftPane.getChildren().clear();

		SendElementRequests elementRequests = new SendElementRequests();

		Button SendButton = new Button();
		SendButton.setText("create new element");

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.addNewElementRequest(leftPane, rightPane);

			}
		});

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text userPlaygroundText = new Text();
		userPlaygroundText.setText("Enter user playground");

		Text emailText = new Text();
		emailText.setText("Enter Email");

		Text elementNameText = new Text();
		elementNameText.setText("Enter Element name");

		Text elementTypeText = new Text();
		elementTypeText.setText("Enter Element type");

		Text locationText = new Text();
		locationText.setText("Enter Element location x,y");

		Text attributesKeyText = new Text();
		attributesKeyText.setText("Enter Element attribute name ");

		Text attributesValueText = new Text();
		attributesValueText.setText("Enter Element attribute value");

		Text expirationDateText = new Text();
		expirationDateText.setText("Enter Element expiration Date: (format= \"January 2, 2010\"");

		// create all the TextField
		TextField userPlaygroundTextField = new TextField();
		TextField emailTextField = new TextField();
		TextField elementNameTextField = new TextField();
		TextField elementTypeTextField = new TextField();
		TextField locationTextField = new TextField();
		TextField attributesKeyTextField = new TextField();
		TextField attributesValueTextField = new TextField();
		TextField expirationDateTextField = new TextField();

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(elementNameText, 5, 4);
		root.add(elementNameTextField, 5, 5);

		root.add(elementTypeText, 5, 6);
		root.add(elementTypeTextField, 5, 7);

		root.add(locationText, 5, 8);
		root.add(locationTextField, 5, 9);

		root.add(attributesKeyText, 5, 10);
		root.add(attributesKeyTextField, 5, 11);

		root.add(attributesValueText, 5, 12);
		root.add(attributesValueTextField, 5, 13);

		root.add(expirationDateText, 5, 14);
		root.add(expirationDateTextField, 5, 15);

		root.add(SendButton, 5, 16);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void updateElement() {
		leftPane.getChildren().clear();

		SendElementRequests elementRequests = new SendElementRequests();

		Button SendButton = new Button();
		SendButton.setText("update Element");

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				elementRequests.updateElementRequest(leftPane, rightPane);

			}
		});

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text userPlaygroundText = new Text();
		userPlaygroundText.setText("Enter user play ground");

		Text emailText = new Text();
		emailText.setText("Enter Email");

		Text elementPlaygroundText = new Text();
		elementPlaygroundText.setText("Enter Element Playground");

		Text IdText = new Text();
		IdText.setText("Enter Element ID");

		Text updateText = new Text();
		updateText.setText("Enter update element:");

		Text elementNameText = new Text();
		elementNameText.setText("Enter Element name");

		Text elementTypeText = new Text();
		elementTypeText.setText("Enter Element type");

		Text locationText = new Text();
		locationText.setText("Enter Element location x,y");

		Text attributesKeyText = new Text();
		attributesKeyText.setText("Enter Element attribute name ");

		Text attributesValueText = new Text();
		attributesValueText.setText("Enter Element attribute value");

		Text expirationDateText = new Text();
		expirationDateText.setText("Enter Element expiration Date");

		// create all the TextField
		TextField userPlaygroundTextField = new TextField();
		TextField emailTextField = new TextField();
		TextField elementPlaygroundTextField = new TextField();
		TextField IdTextField = new TextField();
		TextField elementNameTextField = new TextField();
		TextField elementTypeTextField = new TextField();
		TextField locationTextField = new TextField();
		TextField attributesKeyTextField = new TextField();
		TextField attributesValueTextField = new TextField();
		TextField expirationDateTextField = new TextField();

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(elementPlaygroundText, 5, 4);
		root.add(elementPlaygroundTextField, 5, 5);

		root.add(IdText, 5, 6);
		root.add(IdTextField, 5, 7);

		root.add(updateText, 5, 8);

		root.add(elementNameText, 5, 9);
		root.add(elementNameTextField, 5, 10);

		root.add(elementTypeText, 5, 11);
		root.add(elementTypeTextField, 5, 12);

		root.add(locationText, 5, 13);
		root.add(locationTextField, 5, 14);

		root.add(attributesKeyText, 5, 15);
		root.add(attributesKeyTextField, 5, 16);

		root.add(attributesValueText, 5, 17);
		root.add(attributesValueTextField, 5, 18);

		root.add(expirationDateText, 5, 19);
		root.add(expirationDateTextField, 5, 20);

		root.add(SendButton, 5, 21);

		leftPane.getChildren().add(root);
	}

	@FXML
	public void getElement() {
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
		userPlaygroundText.setText("Enter user playground");
		TextField userPlaygroundTextField = new TextField();

		Text emailText = new Text();
		emailText.setText("Enter Email");
		Text elementPlaygroundText = new Text();
		elementPlaygroundText.setText("Enter Element Playground");
		Text IdText = new Text();
		IdText.setText("Enter Element ID");

		// create all the TextField
		TextField emailTextField = new TextField();
		TextField elementPlaygroundField = new TextField();
		TextField IdField = new TextField();

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(elementPlaygroundText, 5, 4);
		root.add(elementPlaygroundField, 5, 5);

		root.add(IdText, 5, 6);
		root.add(IdField, 5, 7);

		root.add(SendButton, 5, 8);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void getAllElement() {
		leftPane.getChildren().clear();

		SendElementRequests elementRequests = new SendElementRequests();

		Button SendButton = new Button();
		SendButton.setText("get all Elements ");

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
		userPlaygroundText.setText("Enter user playground");
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

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(sizeText, 5, 4);
		root.add(sizeTextField, 5, 5);

		root.add(pageText, 5, 6);
		root.add(pageTextField, 5, 7);

		root.add(SendButton, 5, 8);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void getAllNearElement() {
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
		userPlaygroundText.setText("Enter user playground");
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

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(xText, 5, 4);
		root.add(xTextField, 5, 5);

		root.add(yText, 5, 6);
		root.add(yTextField, 5, 7);

		root.add(distanceText, 5, 8);
		root.add(distanceTextField, 5, 9);

		root.add(sizeText, 5, 10);
		root.add(sizeTextField, 5, 11);

		root.add(pageText, 5, 12);
		root.add(pageTextField, 5, 13);

		root.add(SendButton, 5, 14);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void getAllElementWithAttribute() {
		leftPane.getChildren().clear();
		Button SendButton = new Button();
		SendButton.setText("get all the elements with attribute");

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
		userPlaygroundText.setText("Enter user playground");
		TextField userPlaygroundTextField = new TextField();

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

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(attributeText, 5, 4);
		root.add(attributeTextField, 5, 5);

		root.add(valueText, 5, 6);
		root.add(valueTextField, 5, 7);

		root.add(sizeText, 5, 8);
		root.add(sizeTextField, 5, 9);

		root.add(pageText, 5, 10);
		root.add(pageTextField, 5, 11);

		root.add(SendButton, 5, 12);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void createNewUser() {
		leftPane.getChildren().clear();
		Button SendButton = new Button();
		SendButton.setText("create new user");

		SendUserRequest userRequests = new SendUserRequest();

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				userRequests.createNewUserRequest(leftPane, rightPane);

			}
		});

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text emailText = new Text();
		emailText.setText("Enter Email");

		Text usernameText = new Text();
		usernameText.setText("Enter user name");

		Text avatarText = new Text();
		avatarText.setText("Enter avatar");

		Text roleText = new Text();
		roleText.setText("Enter user role ");

		TextField emailTextField = new TextField();
		TextField usernameTextField = new TextField();
		TextField avatarTextField = new TextField();
		TextField roleTextField = new TextField();

		root.add(emailText, 5, 0);
		root.add(emailTextField, 5, 1);

		root.add(usernameText, 5, 2);
		root.add(usernameTextField, 5, 3);

		root.add(avatarText, 5, 4);
		root.add(avatarTextField, 5, 5);

		root.add(roleText, 5, 6);
		root.add(roleTextField, 5, 7);

		root.add(SendButton, 5, 8);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void updateUser() {
		leftPane.getChildren().clear();
		Button SendButton = new Button();
		SendButton.setText("update user");

		SendUserRequest userRequests = new SendUserRequest();

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				userRequests.updateUserRequest(leftPane, rightPane);
			}
		});
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text playgroundText = new Text();
		playgroundText.setText("Enter playground ");

		Text emailText = new Text();
		emailText.setText("Enter Email");

		Text userUpdateText = new Text();
		userUpdateText.setText("Enter user update:");

		Text usernameText = new Text();
		usernameText.setText("Enter user name");

		Text avatarText = new Text();
		avatarText.setText("Enter avatar");

		Text roleText = new Text();
		roleText.setText("Enter user role ");

		TextField playgroundTextField = new TextField();
		TextField emailTextField = new TextField();
		TextField usernameTextField = new TextField();
		TextField avatarTextField = new TextField();
		TextField roleTextField = new TextField();

		root.add(playgroundText, 5, 0);
		root.add(playgroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(userUpdateText, 5, 4);

		root.add(usernameText, 5, 5);
		root.add(usernameTextField, 5, 6);

		root.add(avatarText, 5, 7);
		root.add(avatarTextField, 5, 8);

		root.add(roleText, 5, 9);
		root.add(roleTextField, 5, 10);

		root.add(SendButton, 5, 11);

		leftPane.getChildren().add(root);
	}

	@FXML
	public void verifyUser() {
		leftPane.getChildren().clear();
		Button SendButton = new Button();
		SendButton.setText("verify user");

		SendUserRequest userRequests = new SendUserRequest();

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				userRequests.verifyUser(leftPane, rightPane);
			}
		});

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text playgroundText = new Text();
		playgroundText.setText("Enter playground ");
		TextField playgroundTextField = new TextField();

		Text emailText = new Text();
		emailText.setText("Enter Email");
		TextField emailTextField = new TextField();

		Text codeText = new Text();
		codeText.setText("Enter code");
		TextField codeTextField = new TextField();

		root.add(playgroundText, 5, 0);
		root.add(playgroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(codeText, 5, 5);
		root.add(codeTextField, 5, 6);

		root.add(SendButton, 5, 11);

		leftPane.getChildren().add(root);

	}

	@FXML
	public void userLogin() {
		leftPane.getChildren().clear();
		Button SendButton = new Button();
		SendButton.setText("login");

		SendUserRequest userRequests = new SendUserRequest();

		SendButton.setOnAction(new EventHandler() {
			@Override
			public void handle(Event arg0) {
				userRequests.userLogin(leftPane, rightPane);
			}
		});

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text playgroundText = new Text();
		playgroundText.setText("Enter playground ");
		TextField playgroundTextField = new TextField();

		Text emailText = new Text();
		emailText.setText("Enter Email");
		TextField emailTextField = new TextField();

		root.add(playgroundText, 5, 0);
		root.add(playgroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(SendButton, 5, 11);

		leftPane.getChildren().add(root);
	}

	@FXML
	public void createNewActivity() {
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
		userPlaygroundText.setText("Enter user playground");
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
		
		
		Text attributeNameText2 = new Text();
		attributeNameText2.setText("Enter attribute name");
		TextField attributeNameTextField2 = new TextField();

		Text attributeValueText2 = new Text();
		attributeValueText2.setText("Enter attribute value");
		TextField attributeValueTextField2 = new TextField();

		root.add(userPlaygroundText, 5, 0);
		root.add(userPlaygroundTextField, 5, 1);

		root.add(emailText, 5, 2);
		root.add(emailTextField, 5, 3);

		root.add(activityText, 5, 4);

		root.add(playgroundText, 5, 5);
		root.add(playgroundTextField, 5, 6);

		root.add(idText, 5, 7);
		root.add(idTextField, 5, 8);

		root.add(elementPlaygroundText, 5, 9);
		root.add(elementPlaygroundTextField, 5, 10);

		root.add(elementIdText, 5, 11);
		root.add(elementIdTextField, 5, 12);

		root.add(typeText, 5, 13);
		root.add(typeTextField, 5, 14);

		root.add(attributeNameText, 5, 15);
		root.add(attributeNameTextField, 5, 16);

		root.add(attributeValueText, 5, 17);
		root.add(attributeValueTextField, 5, 18);
		
		root.add(attributeNameText2, 5, 19);
		root.add(attributeNameTextField2, 5, 20);

		root.add(attributeValueText2, 5, 21);
		root.add(attributeValueTextField2, 5, 22);

		root.add(SendButton, 5, 23);

		leftPane.getChildren().add(root);

	}

}
