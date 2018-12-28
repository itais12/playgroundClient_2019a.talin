package application;

import org.springframework.web.client.RestTemplate;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SendUserRequest {
	private RestTemplate restTemplate ;
	private String base_url;
	private String port = "8083";

	public SendUserRequest() {
		base_url = "http://localhost:" + port;
		this.restTemplate = new RestTemplate();
	}
	
	private ObservableList<Node> getGridPaneObservableList(AnchorPane leftPane) {
		ObservableList<Node> anchorPaneobservableList = leftPane.getChildren();
		GridPane root = (GridPane) anchorPaneobservableList.get(0);
		return root.getChildren();
	}
	
	public void createNewUserRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/users";
		   
	    TextField emailTextField = (TextField) gridPaneobservableList.get(1);
		TextField usernameTextField = (TextField) gridPaneobservableList.get(3);
		TextField avatarTextField = (TextField) gridPaneobservableList.get(5);
		TextField roleTextField = (TextField) gridPaneobservableList.get(7);
		
		NewUserForm newUser = newUserFromGUI(emailTextField, usernameTextField, avatarTextField,
				roleTextField);

		UserTO registerUser= this.restTemplate.postForObject(url, newUser, UserTO.class);
		ShowUser(rightPane, registerUser);
	}

	

	public void updateUserRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/users/{playground}/{email}";
	    TextField playgroundTextField = (TextField) gridPaneobservableList.get(1);
	    TextField emailTextField = (TextField) gridPaneobservableList.get(3);
	    
	    
	    TextField usernameTextField = (TextField) gridPaneobservableList.get(6);
	    TextField avatarTextField =(TextField) gridPaneobservableList.get(8);
	    TextField roleTextField = (TextField) gridPaneobservableList.get(10);
		NewUserForm updateUser = newUserFromGUI(null, usernameTextField, avatarTextField,
				roleTextField);
		
		this.restTemplate.put(url, updateUser, playgroundTextField.getText().trim(), emailTextField.getText().trim());
	    
	}

	public void verifyUser(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/users/confirm/{playground}/{email}/{code}";
		
	    TextField playgroundTextField = (TextField) gridPaneobservableList.get(1);
	    TextField emailTextField = (TextField) gridPaneobservableList.get(3);
	    TextField codeTextField = (TextField) gridPaneobservableList.get(6);
		
		UserTO actualUser = this.restTemplate.getForObject(url, UserTO.class, playgroundTextField.getText().trim(),
															emailTextField.getText().trim(), codeTextField.getText().trim());
		ShowUser(rightPane, actualUser);
	}

	public void userLogin(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/users/login/{playground}/{email}";
	    TextField playgroundTextField = (TextField) gridPaneobservableList.get(1);
	    TextField emailTextField = (TextField) gridPaneobservableList.get(3);
	    
		UserTO actualUser = this.restTemplate.getForObject(url, UserTO.class, playgroundTextField.getText().trim(),
				emailTextField.getText().trim());
		
		ShowUser(rightPane, actualUser);

	}
	
	
	
	private void ShowUser(AnchorPane rightPane, UserTO registerUser) {
		rightPane.getChildren().clear();

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text text = new Text();
		text.setText("User: " + registerUser.toString());
		root.add(text, 5, 0);

		rightPane.getChildren().add(root);		
	}

	private NewUserForm newUserFromGUI(TextField emailTextField, TextField usernameTextField, TextField avatarTextField,
			TextField roleTextField) {
		NewUserForm newUser=new NewUserForm();
		String email = emailTextField.getText().trim();
		String userName = usernameTextField.getText().trim();
		String avatar = avatarTextField.getText().trim();
		String role = roleTextField.getText().trim();
		 
		if(!email.isEmpty()) {
			newUser.setEmail(email);
		}
		if(!userName.isEmpty()) {
			newUser.setUsername(userName);
		}
		if(!avatar.isEmpty()) {
			newUser.setAvatar(avatar);
		}
		if(!role.isEmpty()) {
			newUser.setRole(role);
		}
		return newUser;
	}
}
