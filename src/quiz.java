import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class quiz  {

    public static void start() {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(255);


        window.setTitle("Quiz Section");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        //label 2
        Label labelclose = new Label();
        GridPane.setConstraints(labelclose, 10, 3);


        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,5,5);
        closeButton.setOnAction(e -> window.close());

        //Add everything to grid
        grid.getChildren().addAll(labelclose, closeButton);

        Scene scene = new Scene(grid, 500, 300);
        window.setScene(scene);
        window.show();
    }




}