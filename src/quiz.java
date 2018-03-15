import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;
import javafx.scene.text.*;


public class quiz  {

    ObservableList<questions> QuestionList = FXCollections.observableArrayList();
    Label questionLabel;
    Button choiceABtn;
    Button choiceBBtn;
    Button choiceCBtn;
    Button choiceDBtn;



    public void start() {
        getQuestions();
        Stage window = new Stage();


        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(255);
        window.setTitle("Quiz Section");

        //label Question
        questionLabel = new Label(QuestionList.get(0).getQuestion());

        //Asnwer Buttons
        choiceABtn = new Button(QuestionList.get(0).getChoiceA());
        choiceBBtn = new Button(QuestionList.get(0).getChoiceB());
        choiceCBtn = new Button(QuestionList.get(0).getChoiceC());
        choiceDBtn = new Button(QuestionList.get(0).getChoiceD());


        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,10,10);
        closeButton.setOnAction(e -> window.close());


        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(questionLabel, choiceABtn, choiceBBtn, choiceCBtn, choiceDBtn, closeButton);

        vBox.setAlignment(Pos.CENTER);





        //Add everything to grid

        Scene scene = new Scene(vBox, 500, 300);
        window.setScene(scene);
        window.show();
    }

    //Get all of the products
    public  ObservableList<questions> getQuestions(){
        String fileName = "QuestionsData.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()){
                String line = inputStreams.nextLine();

                String[] splitted = line.split(",");
                QuestionList.add(new questions(splitted[0],splitted[1], splitted[2],splitted[3], splitted[4], splitted[5]));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(QuestionList);


        return QuestionList;
    }




}