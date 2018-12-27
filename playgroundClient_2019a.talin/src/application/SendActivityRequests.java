package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class SendActivityRequests {
	
	public SendActivityRequests() {
		
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
	}
	

}
