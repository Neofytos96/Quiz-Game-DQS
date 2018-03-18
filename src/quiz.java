import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ProgressBar;

public class quiz {


    ObservableList<questions> QuestionList = FXCollections.observableArrayList();
    ObservableList<questions> newQuestionList = FXCollections.observableArrayList();

    Label questionLabel;
    Button choiceABtn;
    Button choiceBBtn;
    Button choiceCBtn;
    Button choiceDBtn;
    ArrayList<Integer> list = new ArrayList<Integer>();
    Integer indexQuestion = 0;
    Integer indexSearchQuestion = 0;
    Integer searchIndexQuestion = 0;
    Integer questionCount = 0;
    Integer score = 0;
    Random random = new Random();
    ArrayList<String> preferencesList = new ArrayList<String>();
    String COMMA_DELIMITER = ",";
    String NEW_LINE_SEPARATOR = "\n";


    public void start() {
        if (indexQuestion.equals(0)) {
            try {
                readPreferences();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            getQuestions();
            getRelatedQuestions();
        }
//        getRelatedQuestions();

//        System.out.println(preferencesList);


        Stage window = new Stage();





        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(255);
        window.setTitle("Quiz Section");


        questionLabel = new Label(newQuestionList.get(indexQuestion).getQuestion());

        choiceABtn = new Button(newQuestionList.get(indexQuestion).getChoiceA());
        choiceBBtn = new Button(newQuestionList.get(indexQuestion).getChoiceB());
        choiceCBtn = new Button(newQuestionList.get(indexQuestion).getChoiceC());
        choiceDBtn = new Button(newQuestionList.get(indexQuestion).getChoiceD());


        choiceABtn.setOnAction(e -> {
            if (choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");

                score++;
                messageBoxLastCorrect();
                quizFinished();
                indexQuestion++;

//                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                messageBoxCorrect();
                indexQuestion++;

                window.close();
                start();

            } else if (!(choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                messageBoxLastWrong();
                indexQuestion++;
                quizFinished();


                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");
                messageBoxWrong();
                indexQuestion++;

                window.close();
                start();
            }

        });

        choiceBBtn.setOnAction(e -> {
            if (choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");

                indexQuestion++;
                messageBoxLastCorrect();
                score++;

                quizFinished();

                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                messageBoxCorrect();
                indexQuestion++;

                window.close();
                start();

            } else if (!(choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                messageBoxLastWrong();
                indexQuestion++;
                quizFinished();



                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");
                messageBoxWrong();
                indexQuestion++;

                window.close();
                start();
            }

        });

        choiceCBtn.setOnAction(e -> {
            if (choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");

                score++;
                messageBoxLastCorrect();
                indexQuestion++;

                quizFinished();
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");

                score++;
                messageBoxCorrect();
                indexQuestion++;

                window.close();
                start();

            } else if (!(choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                messageBoxLastWrong();
                indexQuestion++;

                quizFinished();
                System.out.println("Your score is: " + score + "/" + indexQuestion);

                window.close();
            } else {
                System.out.println("Wrong");

                messageBoxWrong();
                indexQuestion++;

                window.close();
                start();
            }

        });

        choiceDBtn.setOnAction(e -> {
            if (choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");

                score++;
                messageBoxLastCorrect();
                indexQuestion++;

                quizFinished();
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                messageBoxCorrect();

                indexQuestion++;
                window.close();
                start();

            } else if (!(choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                messageBoxLastWrong();

                indexQuestion++;

                quizFinished();
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");
                messageBoxWrong();
                indexQuestion++;
//                searchIndexQuestion++;
                window.close();
                start();
            }

        });

        ProgressBar pb = new ProgressBar(((float)indexQuestion/10)+0.1);
        ProgressIndicator pi = new ProgressIndicator(((float)indexQuestion/10)+0.1);


        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton, 10, 10);
        closeButton.setOnAction(e -> window.close());

        //button to restart the quiz
        Button restartBtn = new Button("Restart Quiz");
        GridPane.setConstraints(restartBtn, 10,10);
        restartBtn.setOnAction(e->{
            indexQuestion = 0;
            score = 0;
            newQuestionList.clear();
            window.close();
            start();
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(closeButton,restartBtn);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(questionLabel, choiceABtn, choiceBBtn, choiceCBtn, choiceDBtn,pb,pi, hBox);

        vBox.setAlignment(Pos.CENTER);


        //Add everything to grid

        Scene scene = new Scene(vBox, 500, 300);
        window.setScene(scene);
        window.show();
    }
//        else{indexSearchQuestion++;
//        start();}

//    }


    //Get all of the products
    public ObservableList<questions> getQuestions() {
        String fileName = "QuestionsData.csv";
        File file = new File(fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()) {
                String line = inputStreams.nextLine();

                String[] splitted = line.split(",");
                QuestionList.add(new questions(splitted[0], splitted[1], splitted[2], splitted[3], splitted[4], splitted[5], splitted[6]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(QuestionList);


        return QuestionList;
    }


    public void readPreferences() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("preferences.csv"));
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            preferencesList.add(scanner.next());
//            System.out.println("passed ftom readpreferences");
        }
        scanner.close();

    }

    public void getRelatedQuestions() {
        for (int i = 0; i < QuestionList.size(); i++) {
            if (QuestionList.get(i).getTopic().equals(preferencesList.get(2))) {
                newQuestionList.add(QuestionList.get(i));
            }
            else if (preferencesList.get(2).equals("General")){
                newQuestionList.add(QuestionList.get(i));
            }

        }
    }

    public void quizFinished(){
        try {
            FileWriter filesaver = new FileWriter("results.csv", true);
            System.out.println("results saved");
//            System.out.println(allQuestions);

                filesaver.append(score.toString());

                filesaver.append(NEW_LINE_SEPARATOR);

            filesaver.flush();
            filesaver.close();
            System.out.println("Saved");


        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void messageBoxLastCorrect(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("End of the quiz ");
        alert.setHeaderText("Good news! You have completed the quiz!");
        alert.setContentText("Your correct answers are: " + score + "/10" );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }
    public void messageBoxLastWrong(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("End of the quiz ");
        alert.setHeaderText("Good news! You have completed the quiz! The answer to the last question was: "+newQuestionList.get(indexQuestion).getCorrect());
        alert.setContentText("Your mark is: " + score + "/10");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public void messageBoxCorrect(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Question Feedback ");
        alert.setHeaderText("Good news! You have answered correctly!");
        alert.setContentText("Your correct answers are: " + score );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

    public void messageBoxWrong(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Question Feedback ");
        alert.setHeaderText("Bad news! You gave a wrong answer! The correct answer was: "+ newQuestionList.get(indexQuestion).getCorrect());
        alert.setContentText("Your correct answers are: " + score );
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Pressed OK.");
            }
        });
    }

}