import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class adminHome  {
    questionSetUp addBuild;
    public  void start() {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(250);

        window.setTitle("Quiz Preferences Section");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        //School attending label
        Label schoolLabel = new Label("School attending:");
        GridPane.setConstraints(schoolLabel, 0, 0);

        //School attending input
        TextField schoolInput = new TextField("");
        GridPane.setConstraints(schoolInput, 1, 0);

        //Year group attending label
        Label groupLabel = new Label("Year group attending:");
        GridPane.setConstraints(groupLabel, 0, 1);

        //Year group attending input
        TextField groupInput = new TextField("");
        GridPane.setConstraints(groupInput, 1, 1);

        //Button to set preferences
        Button preferencesBtn = new Button("Set Preferences");
        GridPane.setConstraints(preferencesBtn, 2, 1);

        // Button to modify questions
        Button questions = new Button("Modify questions");
        GridPane.setConstraints(questions, 0, 2);
        questions.setOnAction(event -> questionButtonClicked());

        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,0,3);
        closeButton.setOnAction(e -> window.close());

        //Add everything to grid
        grid.getChildren().addAll(preferencesBtn,schoolInput,schoolLabel, groupInput, groupLabel, questions,closeButton);

        Scene scene = new Scene(grid, 500, 300);
        window.setScene(scene);
        window.show();
    }

    public void questionButtonClicked() {
        addBuild = new questionSetUp();
        addBuild.start();

    }



}