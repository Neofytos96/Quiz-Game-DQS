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
import java.io.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class questionSetUp {
    //Stage window;
    TextField questionInput;
    TextField choiceAInput;
    TextField choiceBInput;
    TextField choiceCInput;
    TextField choiceDInput;
    TextField ansInput;
    ObservableList<questions> allQuestions, questionSelected;
    List<questions> newListQuestion = new ArrayList<>();
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";
    TableView<questions> tableQuestions;
    adminHome newBuild;
    Stage window2 = new Stage();
    public void start()  {

        //Stage window = new Stage();




        //Question column
        TableColumn<questions, String> questionColumn = new TableColumn<>("Question");
        questionColumn.setMinWidth(300);
        questionColumn.setCellValueFactory(new PropertyValueFactory<>("question"));

        //ChoiceA column
        TableColumn<questions, String> choiceAColumn = new TableColumn<>("A");
        choiceAColumn.setMinWidth(150);
        choiceAColumn.setCellValueFactory(new PropertyValueFactory<>("choiceA"));

        //ChoiceB column
        TableColumn<questions, String> choiceBColumn = new TableColumn<>("B");
        choiceBColumn.setMinWidth(150);
        choiceBColumn.setCellValueFactory(new PropertyValueFactory<>("choiceB"));

        //ChoiceC column
        TableColumn<questions, String> choiceCColumn = new TableColumn<>("C");
        choiceCColumn.setMinWidth(150);
        choiceCColumn.setCellValueFactory(new PropertyValueFactory<>("choiceC"));

        //ChoiceD column
        TableColumn<questions, String> choiceDColumn = new TableColumn<>("D");
        choiceDColumn.setMinWidth(150);
        choiceDColumn.setCellValueFactory(new PropertyValueFactory<>("choiceD"));

        //Answer column
        TableColumn<questions, String> answerColumn = new TableColumn<>("Answer");
        answerColumn.setMinWidth(150);
        answerColumn.setCellValueFactory(new PropertyValueFactory<>("correct"));

        //Question input
        questionInput = new TextField();
        questionInput.setPromptText("Question");
        questionInput.setMinWidth(150);

        //ChoiceA input
        choiceAInput = new TextField();
        choiceAInput.setPromptText("Choice A");
        choiceAColumn.setMinWidth(50);

        //ChoiceB input
        choiceBInput = new TextField();
        choiceBInput.setPromptText("Choice B");
        choiceBColumn.setMinWidth(50);


        //ChoiceC input
        choiceCInput = new TextField();
        choiceCInput.setPromptText("Choice C");
        choiceCColumn.setMinWidth(50);

        //ChoiceD input
        choiceDInput = new TextField();
        choiceDInput.setPromptText("Choice D");
        choiceDColumn.setMinWidth(50);

        //Answer input
        ansInput = new TextField();
        ansInput.setPromptText("Correct Answer");
        ansInput.setMinWidth(50);



        tableQuestions = new TableView<>();
        tableQuestions.setItems(getQuestions());
        tableQuestions.getColumns().addAll(questionColumn, choiceAColumn,choiceBColumn,choiceCColumn,choiceDColumn,answerColumn);

        // button to add question
        Button addQuestion = new Button("Add");
        addQuestion.setOnAction(e -> addQuestionClicked());

        //button to delete Question
        Button delQuestion = new Button("Delete");
        delQuestion.setOnAction(e ->delQuestionClicked() );

        //save button
        Button saveQuestion = new Button("Save");
        saveQuestion.setOnAction(e -> saveQuestionClicked());

        //edit button
        Button edidQuestion = new Button("Edit");

        // back Button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backButtonClicked());


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(questionInput, choiceAInput,choiceBInput,choiceCInput,choiceDInput,ansInput, addQuestion, delQuestion, edidQuestion,saveQuestion, backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableQuestions,hBox);


        Scene scene = new Scene(vBox);
        window2.setScene(scene);
        window2.show();


        }



    //Get all of the products
    public ObservableList<questions> getQuestions(){
        ObservableList<questions> QuestionList = FXCollections.observableArrayList();
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


        return QuestionList;
    }
//

    public void addQuestionClicked(){
        if (questionInput.getText().trim().isEmpty() || choiceAInput.getText().trim().isEmpty()
                || choiceBInput.getText().trim().isEmpty() || choiceCInput.getText().trim().isEmpty()
                || choiceDInput.getText().trim().isEmpty() || ansInput.getText().trim().isEmpty()) {
        System.out.println("Enter data in all fields");
        }
        else {

            questions Question = new questions();
            Question.setQuestion(questionInput.getText());
            Question.setChoiceA(choiceAInput.getText());
            Question.setChoiceB(choiceBInput.getText());
            Question.setChoiceC(choiceCInput.getText());
            Question.setChoiceD(choiceDInput.getText());
            Question.setCorrect(ansInput.getText());

            String question = questionInput.getText();
            String choiceA = choiceAInput.getText();
            String choiceB = choiceBInput.getText();
            String choiceC = choiceCInput.getText();
            String choiceD = choiceDInput.getText();
            String answer = ansInput.getText();
            tableQuestions.getItems().add(Question);

            newListQuestion.add(new questions(question, choiceA,choiceB, choiceC,choiceD,answer));

            questionInput.clear();
            choiceAInput.clear();
            choiceBInput.clear();
            choiceCInput.clear();
            choiceDInput.clear();
            ansInput.clear();
            System.out.println(newListQuestion);
            try {
                FileWriter fileWriter = new FileWriter("questionsData.csv", true);

                for (questions q: newListQuestion){

                    fileWriter.append(q.getQuestion());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getChoiceA());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getChoiceB());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getChoiceC());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getChoiceD());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getCorrect());
                    fileWriter.append(NEW_LINE_SEPARATOR);


                }
                fileWriter.flush();
                fileWriter.close();

                System.out.println("Question added");



            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public void saveQuestionClicked(){
        try {
            FileWriter fileWriter = new FileWriter("questionsData.csv");

            for (questions q : allQuestions){
                fileWriter.append(q.getQuestion());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(q.getChoiceA());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(q.getChoiceB());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(q.getChoiceC());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(q.getChoiceD());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(q.getCorrect());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println("Saved");


        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void delQuestionClicked(){
        allQuestions = tableQuestions.getItems();
        questionSelected = tableQuestions.getSelectionModel().getSelectedItems();

        questionSelected.forEach(allQuestions::remove);
    }

    public void backButtonClicked(){
        newBuild = new adminHome();
        newBuild.start();
        window2.close();



    }



}

//        FileWriter fileWriter = new FileWriter("src\\questionsData.csv", true);

//        Product product = new Product();
//        product.setName(nameInput.getText());
//
//        table.getItems().add(product);
//        nameInput.clear();
//        priceInput.clear();
//        quantityInput.clear();