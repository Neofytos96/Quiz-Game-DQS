import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class questionSetUp {


    public void start()  {

        TableView<questions> tableQuestions;
        Stage window = new Stage();
        String COMMA_DELIMITER = ",";
        String NEW_LINE_SEPARATOR = "\n";





        //Question column
        TableColumn<questions, String> questionColumn = new TableColumn<>("Question");
        questionColumn.setMinWidth(200);
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));

        //ChoiceA column
        TableColumn<questions, String> choiceAColumn = new TableColumn<>("A");
        choiceAColumn.setMinWidth(50);
        choiceAColumn.setCellValueFactory(new PropertyValueFactory<>("choiceA"));

        //ChoiceB column
        TableColumn<questions, String> choiceBColumn = new TableColumn<>("B");
        choiceBColumn.setMinWidth(50);
        choiceBColumn.setCellValueFactory(new PropertyValueFactory<>("choiceB"));

        //ChoiceC column
        TableColumn<questions, String> choiceCColumn = new TableColumn<>("C");
        choiceCColumn.setMinWidth(50);
        choiceCColumn.setCellValueFactory(new PropertyValueFactory<>("choiceC"));

        //ChoiceD column
        TableColumn<questions, String> choiceDColumn = new TableColumn<>("D");
        choiceDColumn.setMinWidth(50);
        choiceDColumn.setCellValueFactory(new PropertyValueFactory<>("choiceD"));

        //Answer column
        TableColumn<questions, String> answerColumn = new TableColumn<>("Answer");
        answerColumn.setMinWidth(50);
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("correct"));

        tableQuestions = new TableView<>();
        tableQuestions.setItems(getQuestions());
        tableQuestions.getColumns().addAll(questionColumn, choiceAColumn,choiceBColumn,choiceCColumn,choiceDColumn,answerColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableQuestions);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();


        }

    //Get all of the products
    public ObservableList<questions> getQuestions(){
        ObservableList<questions> Question = FXCollections.observableArrayList();
        String fileName = "src//QuestionsData.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()){
                String line = inputStreams.nextLine();

                String[] splitted = line.split(",");
                Question.add(new questions(splitted[0],splitted[1], splitted[2],splitted[3], splitted[4], splitted[5]));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        return Question;
    }



}