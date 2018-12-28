package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SendElementRequests {
	
	private String base_url;
	private String port = "8083";
	
	
	public SendElementRequests() {
		base_url = "http://localhost:" + port;
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
		 
		 //get data form web
		 ElementTO element = getElementFromServer( userPlaygroundTextField, emailTextField
					, elementPlaygroundField, IdField);
		 
		 //show data 
		 ShowElement(rightPane,element);
	}
	
	private ElementTO getElementFromServer(TextField userPlaygroundTextField,TextField emailTextField
			,TextField elementPlaygroundField,TextField IdField)
	{
		String url = base_url + "/playground/elements/{userPlayground}/{email}/{playground}/{id}";
		String userPlayground = "talin2019";
		String email = "user@mail.com";
		String elementPlayground = "2019a.talin";
		String elementId = "0";
		
		
		if(!userPlaygroundTextField.getText().trim().isEmpty())
		{
			userPlayground = userPlaygroundTextField.getText();
		}
		
		if(!emailTextField.getText().trim().isEmpty())
		{
			email = emailTextField.getText();
		}
		
		if(!elementPlaygroundField.getText().trim().isEmpty())
		{
			elementPlayground = elementPlaygroundField.getText();
		}
		
		if(!IdField.getText().trim().isEmpty())
		{
			elementId = IdField.getText();
		}
		
		
		
		return new ElementTO();
	}
	
	private void ShowElement(AnchorPane rightPane,ElementTO element)
	{
		rightPane.getChildren().clear();
		
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
		
		Text text = new Text();
		text.setText("Element: "+element.toString());
	    root.add(text, 5, 0);
		
		rightPane.getChildren().add(root);
	}
	
	public void getAllElementsRequest(AnchorPane leftPane,	AnchorPane rightPane)
	{
		 ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		 
		 TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		 TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		 TextField sizeTextField = (TextField) gridPaneobservableList.get(5);
		 TextField pageTextField = (TextField) gridPaneobservableList.get(7);
		 
		 
		 //get data form web
		 ElementTO[] elements = getAllElementsFromServer(userPlaygroundTextField, emailTextField
					, sizeTextField,  pageTextField);
		 
		 //show data 
		 ShowElements( rightPane, elements);
		 
	}
	
	private ElementTO[] getAllElementsFromServer(TextField userPlaygroundTextField,TextField emailTextField
			,TextField sizeTextField, TextField pageTextField)
	{
		
		String url = base_url + "/playground/elements/{userPlayground}/{userEmail}/all?size={size}&page={page}";
		
		String userPlayground = "talin2019";
		String email = "user@mail.com";
		String size = "0";
		String page = "0";
		
		
		if(!userPlaygroundTextField.getText().trim().isEmpty())
		{
			userPlayground = userPlaygroundTextField.getText();
		}
		
		if(!emailTextField.getText().trim().isEmpty())
		{
			email = emailTextField.getText();
		}
		
		if(!sizeTextField.getText().trim().isEmpty())
		{
			size = sizeTextField.getText();
		}
		
		if(!pageTextField.getText().trim().isEmpty())
		{
			page = pageTextField.getText();
		}
		
		
		
		ElementTO[] elements = new ElementTO[10];
		elements[0] = new ElementTO();
		elements[1] = new ElementTO();
		elements[2] = new ElementTO();
		elements[3] = new ElementTO();
		elements[4] = new ElementTO();
		elements[5] = new ElementTO();
		elements[6] = new ElementTO();
		elements[7] = new ElementTO();
		elements[8] = new ElementTO();
		elements[9] = new ElementTO();	
		return elements;
	}
	
	private void ShowElements(AnchorPane rightPane,ElementTO[] elements)
	{
		
		rightPane.getChildren().clear();
		
	    GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
		Text text = new Text();
	    String theText = "";
		
		if(elements != null && elements.length > 0)
		{
		    int i;
		    for(i = 0; i < elements.length; i++)
		    {
		    	theText = theText + "Element + " + i + "#: " + elements[i].toString() + " \n";
		    }
		}
		else
		{
			theText = "No Elements to show ";
		}

		text.setText(theText);
	    root.add(text, 5, 0);
		
		rightPane.getChildren().add(root);
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
		 
		 //get data form web
		 ElementTO[] elements = getAllNearElementsFromServer( userPlaygroundTextField, emailTextField
					, xTextField , yTextField ,
					 distanceTextField,
					 sizeTextField , pageTextField );
		 
		 //show data 
		 ShowElements(rightPane, elements);
		 
	}
	
	private ElementTO[] getAllNearElementsFromServer(TextField userPlaygroundTextField,TextField emailTextField
			,TextField xTextField ,TextField yTextField ,
			TextField distanceTextField,
			TextField sizeTextField ,TextField pageTextField )
	{
		
		String url = base_url + "/playground/elements/{userPlayground}/{userEmail}/near/{x}/{y}/{distance}?size={size}&page={page}";
		
		
		String userPlayground = "talin2019";
		String email = "user@mail.com";
		String x = "0.0";
		String y = "0.0";
		String distance = "5.0";
		String size = "0";
		String page = "0";
		
		
		if(!userPlaygroundTextField.getText().trim().isEmpty())
		{
			userPlayground = userPlaygroundTextField.getText();
		}
		
		if(!emailTextField.getText().trim().isEmpty())
		{
			email = emailTextField.getText();
		}
		
		if(!xTextField.getText().trim().isEmpty())
		{
			x = xTextField.getText();
		}
		
		if(!yTextField.getText().trim().isEmpty())
		{
			y = yTextField.getText();
		}
		
		if(!distanceTextField.getText().trim().isEmpty())
		{
			distance = distanceTextField.getText();
		}
		
		if(!sizeTextField.getText().trim().isEmpty())
		{
			size = sizeTextField.getText();
		}
		
		if(!pageTextField.getText().trim().isEmpty())
		{
			page = pageTextField.getText();
		}
		
		
		
		//go to web to get data
		ElementTO[] elements = new ElementTO[7];
		elements[0] = new ElementTO();
		elements[1] = new ElementTO();
		elements[2] = new ElementTO();
		elements[3] = new ElementTO();
		elements[4] = new ElementTO();
		elements[5] = new ElementTO();
		elements[6] = new ElementTO();


		return elements;
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
		 
		 ElementTO[] elements = getAllElementsWithAttributeFromServer( userPlaygroundTextField, emailTextField,
					 attributeTextField,  valueTextField,
					 sizeTextField, pageTextField);
		 
		 //show data 
		 ShowElements(rightPane, elements);
		 
	}
	
	private ElementTO[] getAllElementsWithAttributeFromServer(TextField userPlaygroundTextField,TextField emailTextField,
			TextField attributeTextField, TextField valueTextField,
			TextField sizeTextField,TextField pageTextField)
	{
		
		String url = base_url + "/playground/elements/{userPlayground}/{email}/search/{attributeName}/{value}?size={size}&page={page}";
		
		
		String userPlayground = "talin2019";
		String email = "user@mail.com";
		String attribute = "eat";
		String value = "meat";
		String size = "0";
		String page = "0";
		
		
		if(!userPlaygroundTextField.getText().trim().isEmpty())
		{
			userPlayground = userPlaygroundTextField.getText();
		}
		
		if(!emailTextField.getText().trim().isEmpty())
		{
			email = emailTextField.getText();
		}
		
		if(!attributeTextField.getText().trim().isEmpty())
		{
			attribute = attributeTextField.getText();
		}
		
		if(!valueTextField.getText().trim().isEmpty())
		{
			value = valueTextField.getText();
		}
		
		if(!sizeTextField.getText().trim().isEmpty())
		{
			size = sizeTextField.getText();
		}
		
		if(!pageTextField.getText().trim().isEmpty())
		{
			page = pageTextField.getText();
		}
		
		
		
		//go to web to get data
		ElementTO[] elements = new ElementTO[5];
		elements[0] = new ElementTO();
		elements[1] = new ElementTO();
		elements[2] = new ElementTO();
		elements[3] = new ElementTO();
		elements[4] = new ElementTO();

		return elements;
	}

	public void addNewElementRequest(AnchorPane leftPane, AnchorPane rightPane) {
		// TODO Auto-generated method stub
		
	}

	public void updateElementRequest(AnchorPane leftPane, AnchorPane rightPane) {
		// TODO Auto-generated method stub
		
	}
	

}
