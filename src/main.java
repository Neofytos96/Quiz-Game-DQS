import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

public class main extends Application {

    Stage window;
    Button buttonAdmin;
    Button buttonQuiz;
    admin  newBuild;
    quiz quizBuild;

    public static void main(String[] args) {
        launch(args);
    }

//comments to check

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Welcome to the quiz");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        // Button for taking the quiz
        buttonQuiz = new Button("Take Quiz");
        GridPane.setConstraints(buttonQuiz,10,7);
        buttonQuiz.setOnAction(e -> takeQuizClicked());


        //Button for admin use
        buttonAdmin = new Button("Admin");
        GridPane.setConstraints(buttonAdmin, 10, 10);
        buttonAdmin.setOnAction(e -> buttonAdminClicked());
        //admin.display("Hello","This is admin section"));






        grid.getChildren().addAll(buttonAdmin, buttonQuiz);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }

    public void buttonAdminClicked() {
        newBuild = new admin();
        newBuild.start();


    }

    public void takeQuizClicked(){
        quizBuild = new quiz();
        quizBuild.start();

    }

}