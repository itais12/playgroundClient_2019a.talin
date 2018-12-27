package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SendActivityRequests {
	
	
	private String base_url;
	private String port = "8083";
	
	public SendActivityRequests() {
		base_url = "http://localhost:" + port;
	}
	
	private ObservableList<Node> getGridPaneObservableList(AnchorPane leftPane)
	{
		 ObservableList<Node> anchorPaneobservableList =  leftPane.getChildren();
		 GridPane root = (GridPane) anchorPaneobservableList.get(0);
		 return root.getChildren();
	}
	
	
	public void createNewActivityRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
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
		 
		 System.out.println(userPlaygroundTextField.getText());
		 
		 
		 //Send new activity
		 Object obj = sendNewActivityRequest( userPlaygroundTextField, emailTextField,
					 playgroundTextField,  idTextField, 
					 elementPlaygroundTextField,  elementIdTextField,
					 typeTextField ,  attributeNameTextField,
					 attributeValueTextField);
		 
		 // show outcome
		 ShowActivity( rightPane, obj);
	}
	
	private Object sendNewActivityRequest(TextField userPlaygroundTextField,TextField emailTextField,
			TextField playgroundTextField, TextField idTextField, 
			TextField elementPlaygroundTextField, TextField elementIdTextField,
			TextField typeTextField , TextField attributeNameTextField,
			TextField attributeValueTextField)
	{
		String url = base_url + "/playground/activities/{userPlayground}/{email}";
		
		String userPlayground = "talin2019";
		String email = "user@mail.com";
		String playground = "eat";
		String id = "meat";
		String type = "meat";
		String elementPlayground = "0";
		String elementId = "meat";
		String attributeName = "0";
		String attributeValue = "0";
		
		
		if(!userPlaygroundTextField.getText().trim().isEmpty())
		{
			userPlayground = userPlaygroundTextField.getText();
		}
		
		if(!emailTextField.getText().trim().isEmpty())
		{
			email = emailTextField.getText();
		}
		if(!playgroundTextField.getText().trim().isEmpty())
		{
			playground = playgroundTextField.getText();
		}
		
		if(!idTextField.getText().trim().isEmpty())
		{
			id = idTextField.getText();
		}
		
		if(!elementPlaygroundTextField.getText().trim().isEmpty())
		{
			elementPlayground = elementPlaygroundTextField.getText();
		}
		
		if(!elementIdTextField.getText().trim().isEmpty())
		{
			elementId = elementIdTextField.getText();
		}
		
		if(!typeTextField.getText().trim().isEmpty())
		{
			type = typeTextField.getText();
		}
		
		if(!attributeNameTextField.getText().trim().isEmpty())
		{
			attributeName = attributeNameTextField.getText();
		}
		
		if(!attributeValueTextField.getText().trim().isEmpty())
		{
			attributeValue = attributeValueTextField.getText();
		}
		
		
		
		return null;
	}
	
	private void ShowActivity(AnchorPane rightPane,Object obj)
	{
		rightPane.getChildren().clear();
	}
	
	
	

}
