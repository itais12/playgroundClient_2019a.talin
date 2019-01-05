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
		TextField attributeNameTextField2 = (TextField) gridPaneobservableList.get(20);
		TextField attributeValueTextField2 = (TextField) gridPaneobservableList.get(22);

		try {
			// Send new activity
			Object obj = sendNewActivityRequest(userPlaygroundTextField, emailTextField, playgroundTextField,
					idTextField, elementPlaygroundTextField, elementIdTextField, typeTextField, attributeNameTextField,
					attributeValueTextField,attributeNameTextField2,attributeValueTextField2);
			// show outcome
			ShowActivity(rightPane, obj);
		} catch (Exception e) {
			funcHelp.printToRightScreen(rightPane, "error while create new activity \n");
		}

	}

	private Object sendNewActivityRequest(TextField userPlaygroundTextField, TextField emailTextField,
			TextField playgroundTextField, TextField idTextField, TextField elementPlaygroundTextField,
			TextField elementIdTextField, TextField typeTextField, TextField attributeNameTextField,
			TextField attributeValueTextField,TextField attributeNameTextField2
			,TextField attributeValueTextField2) {
		String url = base_url + "/playground/activities/{userPlayground}/{email}";

		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";

		String playground = "2019a.talin";
		String id = "5";
		String type = "Feed";
		activityType = type;
		String elementPlayground = "2019a.talin";
		String elementId = "10";
		String attributeName = "size";
		String attributeValue = "10";
		String attributeName2 = "page";
		String attributeValue2 = "0";

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
		
		if (!attributeNameTextField2.getText().trim().isEmpty()) {
			attributeName2 = attributeNameTextField.getText();
		}

		if (!attributeValueTextField2.getText().trim().isEmpty()) {
			attributeValue2 = attributeValueTextField.getText();
		}

		Map<String, Object> attributes = new HashMap<>();
		
		if("ReadFromBoard".equalsIgnoreCase(type))
		{
			attributes.put(attributeName, Integer.parseInt(attributeValue));
			attributes.put(attributeName2, Integer.parseInt(attributeValue2) );
		}
		else
		{
			attributes.put(attributeName, attributeValue);
			attributes.put(attributeName2, attributeValue2);
		}

		
		//attributes.put("size", 10);
		//attributes.put("page", 0);

		ActivityTO activity = new ActivityTO(elementPlayground, elementId, type, userPlayground, email, attributes);
		activity.setPlayground(playground);
		activity.setId(id);

		Object rv = this.restTemplate.postForObject(url, activity, Object.class, userPlayground, email);

		return rv;
	}

	private void ShowActivity(AnchorPane rightPane, Object rv) {
		rightPane.getChildren().clear();
		
		try {
		
		if("Feed".equalsIgnoreCase(activityType)) {
			showActivityMeassage( rightPane,  rv);
			showImage(rightPane,activityType);

		}else if("Pet".equalsIgnoreCase(activityType)) {
			showActivityMeassage( rightPane,  rv);
			showImage(rightPane,activityType);

		}else if("PostMessage".equalsIgnoreCase(activityType)) {
			showActivityMeassage( rightPane,  rv);
			showImage(rightPane,activityType);
		}
		else if("ReadFromBoard".equalsIgnoreCase(activityType)) {
			showActivityMeassages( rightPane,  rv);
		}
		
		}catch (Exception e) {
			TextArea text = new TextArea();
			text.setText("can't show the result \n");

			rightPane.getChildren().add(text);
		}


	}
	
	private void showActivityMeassage(AnchorPane rightPane, Object rv) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		Message returnMessage = this.jackson.readValue(this.jackson.writeValueAsString(rv), Message.class);
		
		TextArea text = new TextArea();
		
		text.setText("message: " + returnMessage.getContent());
		text.setEditable(false);
		text.setPrefWidth(380);
		text.setPrefHeight(350);

		rightPane.getChildren().add(text);

	}
	
	private void showActivityMeassages(AnchorPane rightPane, Object rv) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException
	{
		ReadFromBoardResult returnReadFromBoardResult = this.jackson.readValue(this.jackson.writeValueAsString(rv), ReadFromBoardResult.class);
		
		TextArea text = new TextArea();
		
		int i;
		String buildText = "";
		
		if(returnReadFromBoardResult.getResults()!= null && returnReadFromBoardResult.getResults().size() > 0)
		{
			for(i=0;i<returnReadFromBoardResult.getResults().size();i++)
			{
				buildText += "message #"+ i +":"+returnReadFromBoardResult.getResults().get(i) + "\n";
			}
		}
		else
		{
			buildText = "No messages to show\n";
		}

		
		text.setText("messages: \n" + buildText);
		text.setEditable(false);
		text.setPrefWidth(380);
		text.setPrefHeight(350);

		rightPane.getChildren().add(text);

	}
	
	
	private void showImage(AnchorPane rightPane, String activityType)
	{
		Image image = null;
		try {
			if("Pet".equalsIgnoreCase(activityType)) {
				image =new Image("./catpet.jpg");
			}else if("Feed".equalsIgnoreCase(activityType)) {
				image =new Image("./feedanimal.jpg");
			}else if("PostMessage".equalsIgnoreCase(activityType)) {
				image =new Image("./board.jpg");
			}
	    //application/catpet.jpg
		}catch (Exception e) {
			e.printStackTrace();
		}
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(400);
        AnchorPane.setBottomAnchor(imageView, 0.0);
		rightPane.getChildren().add(imageView);
	}

}
