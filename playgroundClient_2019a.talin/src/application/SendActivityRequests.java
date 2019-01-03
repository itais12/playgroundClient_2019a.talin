package application;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SendActivityRequests {

	private RestTemplate restTemplate;
	private String base_url;
	private String port = "8083";
	private ObjectMapper jackson;
	FunctionHelper funcHelp;
	String activityType;
	
	public SendActivityRequests() {
		base_url = "http://localhost:" + port;
		this.restTemplate = new RestTemplate();
		jackson = new ObjectMapper();
		this.funcHelp = new FunctionHelper();
	}

	private ObservableList<Node> getGridPaneObservableList(AnchorPane leftPane) {
		ObservableList<Node> anchorPaneobservableList = leftPane.getChildren();
		GridPane root = (GridPane) anchorPaneobservableList.get(0);
		return root.getChildren();
	}

	public void createNewActivityRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField playgroundTextField = (TextField) gridPaneobservableList.get(6);
		TextField idTextField = (TextField) gridPaneobservableList.get(8);
		TextField elementPlaygroundTextField = (TextField) gridPaneobservableList.get(10);
		TextField elementIdTextField = (TextField) gridPaneobservableList.get(12);
		TextField typeTextField = (TextField) gridPaneobservableList.get(14);
		TextField attributeNameTextField = (TextField) gridPaneobservableList.get(16);
		TextField attributeValueTextField = (TextField) gridPaneobservableList.get(18);

		try {
			// Send new activity
			Object obj = sendNewActivityRequest(userPlaygroundTextField, emailTextField, playgroundTextField,
					idTextField, elementPlaygroundTextField, elementIdTextField, typeTextField, attributeNameTextField,
					attributeValueTextField);
			// show outcome
			ShowActivity(rightPane, obj);
		} catch (Exception e) {
			funcHelp.printToRightScreen(rightPane, "error while create new activity \n");
		}

	}

	private Object sendNewActivityRequest(TextField userPlaygroundTextField, TextField emailTextField,
			TextField playgroundTextField, TextField idTextField, TextField elementPlaygroundTextField,
			TextField elementIdTextField, TextField typeTextField, TextField attributeNameTextField,
			TextField attributeValueTextField) {
		String url = base_url + "/playground/activities/{userPlayground}/{email}";

		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";

		String playground = "2019a.talin";
		String id = "5";
		String type = "Feed";
		activityType = type;
		String elementPlayground = "2019a.talin";
		String elementId = "10";
		String attributeName = "eat";
		String attributeValue = "meat";

		if (!userPlaygroundTextField.getText().trim().isEmpty()) {
			userPlayground = userPlaygroundTextField.getText();
		}

		if (!emailTextField.getText().trim().isEmpty()) {
			email = emailTextField.getText();
		}

		if (!playgroundTextField.getText().trim().isEmpty()) {
			playground = playgroundTextField.getText();
		}

		if (!idTextField.getText().trim().isEmpty()) {
			id = idTextField.getText();
		}

		if (!elementPlaygroundTextField.getText().trim().isEmpty()) {
			elementPlayground = elementPlaygroundTextField.getText();
		}

		if (!elementIdTextField.getText().trim().isEmpty()) {
			elementId = elementIdTextField.getText();
		}

		if (!typeTextField.getText().trim().isEmpty()) {
			type = typeTextField.getText();
			activityType=type;
		}

		if (!attributeNameTextField.getText().trim().isEmpty()) {
			attributeName = attributeNameTextField.getText();
		}

		if (!attributeValueTextField.getText().trim().isEmpty()) {
			attributeValue = attributeValueTextField.getText();
		}

		Map<String, Object> attributes = new HashMap<>();
		//attributes.put(attributeName, attributeValue);
		
		attributes.put("size", 10);
		attributes.put("page", 0);

		ActivityTO activity = new ActivityTO(elementPlayground, elementId, type, userPlayground, email, attributes);
		activity.setPlayground(playground);
		activity.setId(id);

		Object rv = this.restTemplate.postForObject(url, activity, Object.class, userPlayground, email);

		return rv;
	}

	private void ShowActivity(AnchorPane rightPane, Object rv) {
		rightPane.getChildren().clear();
        Image image ;
		ImageView imageView =new ImageView();
		
		
		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		TextArea text = new TextArea();
		text.setEditable(false);
		Map<String, Object> rvMap = null;

		try {
			rvMap = this.jackson.readValue(this.jackson.writeValueAsString(rv), Map.class);
			System.out.println(rvMap);
		} catch (Exception e) {

		}
		
		if (rvMap != null) {

		if("Feed".equalsIgnoreCase(activityType)) {
			image=new Image("feedanimal.jpg");
			//imageView.setImage(image);
			
			text.setText("message : " + rvMap.get("content"));

		}else if("Pet".equalsIgnoreCase(activityType)) {
			text.setText("message : " + rvMap.get("content"));

		}else if("PostMessage".equalsIgnoreCase(activityType)) {
			text.setText("message : " + rvMap.get("content"));
		}
		else if("ReadFromBoard".equalsIgnoreCase(activityType)) {
			text.setText(""+rvMap);
		}

		root.add(text, 0, 0);
		//root.add(imageView, 0, 3);

		rightPane.getChildren().add(root);

		} else {
			text.setText("can't show the result \n");
			root.add(text, 0, 0);

			rightPane.getChildren().add(root);
		}

	}

}
