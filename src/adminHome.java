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
import java.lang.reflect.Type;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


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
    List<String> resultsList = new ArrayList<>();
    List<String> schoolList = new ArrayList<>();


    public  void start() {
        //Stage window = new Stage();

        window.setWidth(500);
        window.setHeight(300);
        window.setResizable(false);

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
        comboTopic.setValue("General");
        GridPane.setConstraints(comboTopic,0,2);


        // Button to modify questions
        Button questions = new Button("Modify questions");
        GridPane.setConstraints(questions, 0, 3);
        questions.setOnAction(event -> questionButtonClicked());

        //button to get statistics
        Button getStatisticsBtn = new Button("Get Statistics");
        GridPane.setConstraints(getStatisticsBtn, 0,4);
        getStatisticsBtn.setOnAction(e-> statisticsClicked());
//        System.out.println(resultsList);

        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton,0,5);
        closeButton.setOnAction(e -> closeButtonClicked());

        //Add everything to grid
        grid.getChildren().addAll(preferencesBtn,schoolInput,schoolLabel, groupInput, groupLabel, comboTopic, questions,getStatisticsBtn,closeButton);

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
            if (schoolInput.getText().isEmpty()|| groupInput.getText().isEmpty()){
                Alert alertPreference = new Alert(AlertType.ERROR);
                alertPreference.setTitle("Preferences Not Added  ");
                alertPreference.setHeaderText("Not all the preferences are entered");
//            alert.setContentText("Preferences added successfully" );
                alertPreference.showAndWait().ifPresent(rs -> {
                    if (rs == ButtonType.OK) {
                        System.out.println("Pressed OK.");}
                });
            }else {
                try {
                    FileWriter fw = new FileWriter("results.csv", false);
                    fw.append("");
                    FileWriter fileWriter = new FileWriter("preferences.csv");
                    fileWriter.append(schoolInput.getText());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append(groupInput.getText());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                    fileWriter.append(comboTopic.getValue());

                    schoolInput.clear();
                    groupInput.clear();

                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Preferences  ");
                    alert.setHeaderText("Preferences added successfully");
//            alert.setContentText("Preferences added successfully" );
                    alert.showAndWait().ifPresent(rs -> {
                        if (rs == ButtonType.OK) {
                            System.out.println("Pressed OK.");
                        }
                    });
                    fileWriter.flush();
                    fileWriter.close();


                    // System.out.println("preferences added");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

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

    public List<String> getStatistics(){
        String fileName = "results.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()) {
                String line = inputStreams.nextLine();

                String[] splitted = line.split(NEW_LINE_SEPARATOR);
//                System.out.println(splitted[0]);
                resultsList.add(splitted[0]);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



        return resultsList;

    }


    public List<String> getSchoolYear(){
        String fileName = "preferences.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()) {
                String line = inputStreams.nextLine();

                String[] splitted = line.split(NEW_LINE_SEPARATOR);
//                System.out.println(splitted[0]);
                schoolList.add(splitted[0]);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }



        return schoolList;

    }

    public void statisticsClicked(){
        getStatistics();
        getSchoolYear();
        Integer count = 0;
        Integer total = 0;

        for (int i = 0; i < resultsList.size(); i++) {
         int sum = Integer.parseInt(resultsList.get(i));
         total += sum;
         count++;

        }
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Average mark ");
        alert.setHeaderText("This is the average mark for the students from the school of " + schoolList.get(0)+NEW_LINE_SEPARATOR+
        "Their year group is: "+ schoolList.get(1));
        alert.setContentText("The average mark is: "+(float)total/ count+"/10" );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
//System.out.println((float)total/ count);
    }

}