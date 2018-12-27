package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SendElementRequests {
	
	
	public SendElementRequests() {
		
	}
	
	private ObservableList<Node> getGridPaneObservableList(AnchorPane leftPane)
	{
		 ObservableList<Node> anchorPaneobservableList =  leftPane.getChildren();
		 GridPane root = (GridPane) anchorPaneobservableList.get(0);
		 return root.getChildren();
	}
	
	
	public void getElementsRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
		 ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		 
		 
		 TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		 TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		 TextField elementPlaygroundField = (TextField) gridPaneobservableList.get(5);
		 TextField IdField = (TextField) gridPaneobservableList.get(7);

		 
		 System.out.println(userPlaygroundTextField.getText());	 
	}
	
	public void getAllElementsRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
		 ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		 
		 TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		 TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		 TextField sizeTextField = (TextField) gridPaneobservableList.get(5);
		 TextField pageTextField = (TextField) gridPaneobservableList.get(7);
		 
		 System.out.println(userPlaygroundTextField.getText());
	}
	
	
	public void getAllNearElementsRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
		 ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		 
		 TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		 TextField emailTextField = (TextField) gridPaneobservableList.get(3); 
		 TextField xTextField= (TextField) gridPaneobservableList.get(5);
		 TextField yTextField = (TextField) gridPaneobservableList.get(7);
		 TextField distanceTextField = (TextField) gridPaneobservableList.get(9);
		 TextField sizeTextField = (TextField) gridPaneobservableList.get(11);
		 TextField pageTextField = (TextField) gridPaneobservableList.get(13);
		 
		 System.out.println(userPlaygroundTextField.getText());
	}
	
	public void getAllElementsWithAttributeRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
		 ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		 
		 
		 TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		 TextField emailTextField = (TextField) gridPaneobservableList.get(3); 
		 TextField attributeTextField= (TextField) gridPaneobservableList.get(5);
		 TextField valueTextField = (TextField) gridPaneobservableList.get(7);
		 TextField sizeTextField = (TextField) gridPaneobservableList.get(9);
		 TextField pageTextField = (TextField) gridPaneobservableList.get(11);
		 
		 System.out.println(userPlaygroundTextField.getText());
		 
	}

}
