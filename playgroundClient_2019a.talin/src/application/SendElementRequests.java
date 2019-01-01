package application;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public class SendElementRequests {
	private RestTemplate restTemplate;
	private String base_url;
	private String port = "8083";

	public SendElementRequests() {
		base_url = "http://localhost:" + port;
		this.restTemplate = new RestTemplate();

	}

	private ObservableList<Node> getGridPaneObservableList(AnchorPane leftPane) {
		ObservableList<Node> anchorPaneobservableList = leftPane.getChildren();
		GridPane root = (GridPane) anchorPaneobservableList.get(0);
		return root.getChildren();
	}

	public void addNewElementRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/elements/{userPlayground}/{email}";

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		// new element

		TextField elementNameTextField = (TextField) gridPaneobservableList.get(5);
		TextField elementTypeTextField = (TextField) gridPaneobservableList.get(7);
		TextField locationTextField = (TextField) gridPaneobservableList.get(9);
		TextField attributesKeyTextField = (TextField) gridPaneobservableList.get(11);
		TextField attributesValueTextField = (TextField) gridPaneobservableList.get(13);
		TextField expirationDateTextField = (TextField) gridPaneobservableList.get(15);
		ElementTO newelement = newElementFromGUI(elementNameTextField, elementTypeTextField, locationTextField,
				attributesKeyTextField, attributesValueTextField, expirationDateTextField);

		try {
		ElementTO elementAfterPost = this.restTemplate.postForObject(url, newelement, ElementTO.class,
				userPlaygroundTextField.getText().trim(), emailTextField.getText().trim());
		ShowElement(rightPane, elementAfterPost);
		}
		catch (Exception e) {
			errorScreen( rightPane, "error while geting data \n");
		}
	}

	private ElementTO newElementFromGUI(TextField elementNameTextField, TextField elementTypeTextField,
			TextField locationTextField, TextField attributesKeyTextField, TextField attributesValueTextField,
			TextField expirationDateTextField) {
		
		ElementTO newElement = new ElementTO();
		String elementName = elementNameTextField.getText().trim();
		String elementType = elementTypeTextField.getText().trim();
		String location = locationTextField.getText().trim();
		String attributesKey = attributesKeyTextField.getText().trim();
		String attributesValue = attributesValueTextField.getText().trim();
		String expirationDate = expirationDateTextField.getText().trim();

		if (!elementName.isEmpty()) {
			newElement.setName(elementName);
		}
		if (!elementType.isEmpty()) {
			newElement.setType(elementType);
		}
		if (!location.isEmpty()) {
			String[] splitLocation = location.split(",");
			
			try {
				newElement.setLocation(new Location(Double.parseDouble(splitLocation[0]),Double.parseDouble(splitLocation[1])));
			}catch(NumberFormatException e) {
				
			}
		}
		if (!attributesKey.isEmpty()&& !attributesValue.isEmpty()) {
			newElement.addAttributes(attributesKey, attributesValue);
		}

		if (!expirationDate.isEmpty()) {
			try {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = format.parse(expirationDate);
			newElement.setExirationDate(date);
			} catch (ParseException e) {
			}
		}

		return newElement;
	}

	public void updateElementRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);
		String url = base_url + "/playground/elements/{userPlayground}/{userEmail}/{Playground}/{Id}";
	    
	    TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField elementPlaygroundTextField = (TextField) gridPaneobservableList.get(5);
		TextField IdTextField = (TextField) gridPaneobservableList.get(7);
		// new element

		TextField elementNameTextField = (TextField) gridPaneobservableList.get(10);
		TextField elementTypeTextField = (TextField) gridPaneobservableList.get(12);
		TextField locationTextField = (TextField) gridPaneobservableList.get(14);
		TextField attributesKeyTextField = (TextField) gridPaneobservableList.get(16);
		TextField attributesValueTextField = (TextField) gridPaneobservableList.get(18);
		TextField expirationDateTextField = (TextField) gridPaneobservableList.get(20);

		ElementTO updatedElement = newElementFromGUI(elementNameTextField, elementTypeTextField, locationTextField,
				attributesKeyTextField, attributesValueTextField, expirationDateTextField);
		try {
		this.restTemplate.put(url, updatedElement, userPlaygroundTextField.getText().trim(),
				emailTextField.getText().trim(), elementPlaygroundTextField.getText().trim(),
				IdTextField.getText().trim());
		ShowElement(rightPane, updatedElement);
		}
		catch (Exception e) {
			errorScreen( rightPane, "error while geting data \n");
		}
		
	}

	public void getElementsRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField elementPlaygroundField = (TextField) gridPaneobservableList.get(5);
		TextField IdField = (TextField) gridPaneobservableList.get(7);

		try {
		// get data form web
		ElementTO element = getElementFromServer(userPlaygroundTextField, emailTextField, elementPlaygroundField,
				IdField);

		// show data
		ShowElement(rightPane, element);
		}
		catch (Exception e) {
			errorScreen( rightPane, "error while geting data \n");
		}
	}

	private ElementTO getElementFromServer(TextField userPlaygroundTextField, TextField emailTextField,
			TextField elementPlaygroundField, TextField IdField) {
		String url = base_url + "/playground/elements/{userPlayground}/{email}/{playground}/{id}";
		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";
		String elementPlayground = "2019a.talin";
		String elementId = "5";

		if (!userPlaygroundTextField.getText().trim().isEmpty()) {
			userPlayground = userPlaygroundTextField.getText();
		}

		if (!emailTextField.getText().trim().isEmpty()) {
			email = emailTextField.getText();
		}

		if (!elementPlaygroundField.getText().trim().isEmpty()) {
			elementPlayground = elementPlaygroundField.getText();
		}

		if (!IdField.getText().trim().isEmpty()) {
			elementId = IdField.getText();
		}
		
		ElementTO element = this.restTemplate.getForObject(url, ElementTO.class, userPlayground, email, elementPlayground,
				elementId);
		

		return element;
	}

	private void ShowElement(AnchorPane rightPane, ElementTO element) {
		rightPane.getChildren().clear();

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);

		Text text = new Text();
		text.setText("Element: " + element.toString());
		root.add(text, 5, 0);

		rightPane.getChildren().add(root);
	}

	public void getAllElementsRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField sizeTextField = (TextField) gridPaneobservableList.get(5);
		TextField pageTextField = (TextField) gridPaneobservableList.get(7);

		try {
		// get data form web
		ElementTO[] elements = getAllElementsFromServer(userPlaygroundTextField, emailTextField, sizeTextField,
				pageTextField);

		// show data
		ShowElements(rightPane, elements);
		}
		catch (Exception e) {
			errorScreen( rightPane, "error while geting data \n");
		}

	}

	private ElementTO[] getAllElementsFromServer(TextField userPlaygroundTextField, TextField emailTextField,
			TextField sizeTextField, TextField pageTextField) {

		String url = base_url + "/playground/elements/{userPlayground}/{userEmail}/all?size={size}&page={page}";

		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";
		int size = 7;
		int page = 0;

		if (!userPlaygroundTextField.getText().trim().isEmpty()) {
			userPlayground = userPlaygroundTextField.getText();
		}

		if (!emailTextField.getText().trim().isEmpty()) {
			email = emailTextField.getText();
		}

		if (!sizeTextField.getText().trim().isEmpty()) {
			size = Integer.parseInt(sizeTextField.getText());
		}

		if (!pageTextField.getText().trim().isEmpty()) {
			page = Integer.parseInt(pageTextField.getText());
		}

		ElementTO[] elements = this.restTemplate.getForObject(url, ElementTO[].class, userPlayground, email,
				size, page);
				
		return elements;
	}

	private void ShowElements(AnchorPane rightPane, ElementTO[] elements) {

		rightPane.getChildren().clear();

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		Text text = new Text();
		String theText = "";

		if (elements != null && elements.length > 0) {
			int i;
			for (i = 0; i < elements.length; i++) {
				theText = theText + "Element + " + i + "#: " + elements[i].toString() + " \n";
			}
		} else {
			theText = "No Elements to show ";
		}

		text.setText(theText);
		root.add(text, 5, 0);

		rightPane.getChildren().add(root);
	}

	public void getAllNearElementsRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField xTextField = (TextField) gridPaneobservableList.get(5);
		TextField yTextField = (TextField) gridPaneobservableList.get(7);
		TextField distanceTextField = (TextField) gridPaneobservableList.get(9);
		TextField sizeTextField = (TextField) gridPaneobservableList.get(11);
		TextField pageTextField = (TextField) gridPaneobservableList.get(13);

		try {
		// get data form web
		ElementTO[] elements = getAllNearElementsFromServer(userPlaygroundTextField, emailTextField, xTextField,
				yTextField, distanceTextField, sizeTextField, pageTextField);

		// show data
		ShowElements(rightPane, elements);
	}
	catch (Exception e) {
		 errorScreen( rightPane, "error while geting data \n");
	}

	}

	private ElementTO[] getAllNearElementsFromServer(TextField userPlaygroundTextField, TextField emailTextField,
			TextField xTextField, TextField yTextField, TextField distanceTextField, TextField sizeTextField,
			TextField pageTextField) {

		String url = base_url
				+ "/playground/elements/{userPlayground}/{userEmail}/near/{x}/{y}/{distance}?size={size}&page={page}";

		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";
		double x = 0.0;
		double y = 0.0;
		String distance = "5.0";
		int size = 10;
		int page = 0;

		if (!userPlaygroundTextField.getText().trim().isEmpty()) {
			userPlayground = userPlaygroundTextField.getText();
		}

		if (!emailTextField.getText().trim().isEmpty()) {
			email = emailTextField.getText();
		}

		if (!xTextField.getText().trim().isEmpty()) {
			x = Double.parseDouble(xTextField.getText());
		}

		if (!yTextField.getText().trim().isEmpty()) {
			y = Double.parseDouble(yTextField.getText());
		}

		if (!distanceTextField.getText().trim().isEmpty()) {
			distance = distanceTextField.getText();
		}

		if (!sizeTextField.getText().trim().isEmpty()) {
			size = Integer.parseInt(sizeTextField.getText());
		}

		if (!pageTextField.getText().trim().isEmpty()) {
			page = Integer.parseInt( pageTextField.getText());
		}

		// go to web to get data
		ElementTO[] elements = this.restTemplate.getForObject(url, ElementTO[].class, userPlayground, email, x,
				y, distance, size, page);


		return elements;
	}

	public void getAllElementsWithAttributeRequest(AnchorPane leftPane, AnchorPane rightPane) {
		ObservableList<Node> gridPaneobservableList = getGridPaneObservableList(leftPane);

		TextField userPlaygroundTextField = (TextField) gridPaneobservableList.get(1);
		TextField emailTextField = (TextField) gridPaneobservableList.get(3);
		TextField attributeTextField = (TextField) gridPaneobservableList.get(5);
		TextField valueTextField = (TextField) gridPaneobservableList.get(7);
		TextField sizeTextField = (TextField) gridPaneobservableList.get(9);
		TextField pageTextField = (TextField) gridPaneobservableList.get(11);

		try {
		ElementTO[] elements = getAllElementsWithAttributeFromServer(userPlaygroundTextField, emailTextField,
				attributeTextField, valueTextField, sizeTextField, pageTextField);

		// show data
		ShowElements(rightPane, elements);
		}
		catch (Exception e) {
			 errorScreen( rightPane, "error while geting data \n");
		}

	}

	private ElementTO[] getAllElementsWithAttributeFromServer(TextField userPlaygroundTextField,
			TextField emailTextField, TextField attributeTextField, TextField valueTextField, TextField sizeTextField,
			TextField pageTextField) {

		String url = base_url
				+ "/playground/elements/{userPlayground}/{email}/search/{attributeName}/{value}?size={size}&page={page}";

		String userPlayground = "2019a.talin";
		String email = "demouser@mail.com";
		String attribute = "name";
		String value = "cat";
		int size = 10;
		int page = 0;

		if (!userPlaygroundTextField.getText().trim().isEmpty()) {
			userPlayground = userPlaygroundTextField.getText();
		}

		if (!emailTextField.getText().trim().isEmpty()) {
			email = emailTextField.getText();
		}

		if (!attributeTextField.getText().trim().isEmpty()) {
			attribute = attributeTextField.getText();
		}

		if (!valueTextField.getText().trim().isEmpty()) {
			value = valueTextField.getText();
		}

		if (!sizeTextField.getText().trim().isEmpty()) {
			size = Integer.parseInt(sizeTextField.getText());
		}

		if (!pageTextField.getText().trim().isEmpty()) {
			page = Integer.parseInt( pageTextField.getText());
		}

		// go to web to get data
		


		ElementTO[] elements = this.restTemplate.getForObject(url, ElementTO[].class, userPlayground, email, attribute,value,
				 size, page);

		return elements;
	}
	
	
	public void errorScreen(AnchorPane rightPane,String errorText)
	{
		rightPane.getChildren().clear();
		

		GridPane root = new GridPane();
		root.setHgap(10);
		root.setVgap(10);
		Text text = new Text();
		
		
		text.setText(errorText);
		root.add(text, 5, 0);

		rightPane.getChildren().add(root);
	}

}
