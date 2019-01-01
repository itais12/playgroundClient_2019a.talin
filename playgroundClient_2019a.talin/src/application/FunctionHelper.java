package application;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FunctionHelper {

	public void printToRightScreen(AnchorPane rightPane, String errorText) {
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
