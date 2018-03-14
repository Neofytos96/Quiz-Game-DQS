import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class admin  {
   // Stage window;
    adminHome newBuild;
    public  void start() {
        Stage window = new Stage();


        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);

        window.setMinWidth(240);


        window.setTitle("Admin Section");

        //GridPane with 10px padding around edge
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Name Label - constrains use (child, column, row)
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name Input
        TextField nameInput = new TextField("Admin");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password Label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password Input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //Login
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
            if (passInput.getText().equals("a")){
                System.out.println("passcorrect");
                //adminHome.display("Hello","This is quiz section");
                loginButtonClicked();
                window.close();

            }
        });

        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,5,5);
        closeButton.setOnAction(e -> window.close());

        //Add everything to grid
        grid.getChildren().addAll(nameLabel,closeButton, nameInput, passLabel, passInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }

    public void loginButtonClicked() {
        newBuild = new adminHome();
        newBuild.start();




    }


}