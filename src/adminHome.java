import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class adminHome  {
    //Stage window;
    questionSetUp addBuild;
    main mainBuild;
    Stage window = new Stage();
    TextField schoolInput;
    TextField groupInput;
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    ComboBox<String> comboTopic;
    ObservableList<questions> QuestionList = FXCollections.observableArrayList();
    List<String> topicList = new ArrayList<>();


    public  void start() {
        //Stage window = new Stage();

        getQuestions();
        for (int i = 0; i < QuestionList.size(); i++) {
           // System.out.println(QuestionList.get(i).getTopic());
            if (!topicList.contains(QuestionList.get(i).getTopic())){
                topicList.add(QuestionList.get(i).getTopic());
            }
        }
        System.out.println(topicList);
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
        schoolInput = new TextField("");
        GridPane.setConstraints(schoolInput, 1, 0);

        //Year group attending label
        Label groupLabel = new Label("Year group attending:");
        GridPane.setConstraints(groupLabel, 0, 1);

        //Year group attending input
        groupInput = new TextField("");
        GridPane.setConstraints(groupInput, 1, 1);

        //Button to set preferences
        Button preferencesBtn = new Button("Set Preferences");
        GridPane.setConstraints(preferencesBtn, 2, 1);
        preferencesBtn.setOnAction(e -> preferencesBtnClicked());

        //Combo Box to select topic
        comboTopic = new ComboBox<>();
        comboTopic.getItems().add("General");
        for (int i = 0; i < topicList.size(); i++)
            comboTopic.getItems().add(topicList.get(i));
        GridPane.setConstraints(comboTopic,0,2);


        // Button to modify questions
        Button questions = new Button("Modify questions");
        GridPane.setConstraints(questions, 0, 3);
        questions.setOnAction(event -> questionButtonClicked());

        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,0,4);
        closeButton.setOnAction(e -> closeButtonClicked());

        //Add everything to grid
        grid.getChildren().addAll(preferencesBtn,schoolInput,schoolLabel, groupInput, groupLabel, comboTopic, questions,closeButton);

        Scene scene = new Scene(grid, 500, 300);
        window.setScene(scene);
        window.show();
    }

    public void questionButtonClicked() {
        addBuild = new questionSetUp();
        addBuild.start();
        }

    public void closeButtonClicked() {
        window.close();

    }

    public void preferencesBtnClicked(){
        try {
            FileWriter fileWriter = new FileWriter("preferences.csv");
            fileWriter.append(schoolInput.getText());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(groupInput.getText());
            fileWriter.append(NEW_LINE_SEPARATOR);
            fileWriter.append(comboTopic.getValue());


            fileWriter.flush();
            fileWriter.close();

            System.out.println("preferences added");

    }catch (Exception e){
            System.out.println(e.getMessage());
        }



}
    public ObservableList<questions> getQuestions(){
        String fileName = "QuestionsData.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()){
                String line = inputStreams.nextLine();

                String[] splitted = line.split(",");
                QuestionList.add(new questions(splitted[0],splitted[1], splitted[2],splitted[3], splitted[4], splitted[5], splitted[6]));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(QuestionList);


        return QuestionList;
    }
}