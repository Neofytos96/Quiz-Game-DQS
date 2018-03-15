import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Random;

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
    Integer questionCount = 0;
    Integer score = 0;
    Random random = new Random();
    ArrayList<String> preferencesList = new ArrayList<String>();


    public void start() {

        try {
            readPreferences();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getQuestions();
        System.out.println(preferencesList);

        Stage window = new Stage();
        getRelatedQuestions();


        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(255);
        window.setTitle("Quiz Section");

//        int randomGen = random.nextInt(QuestionList.size());
//        System.out.println(randomGen);


        //label Question
        questionLabel = new Label(newQuestionList.get(indexQuestion).getQuestion());

        choiceABtn = new Button(newQuestionList.get(indexQuestion).getChoiceA());
        choiceBBtn = new Button(newQuestionList.get(indexQuestion).getChoiceB());
        choiceCBtn = new Button(newQuestionList.get(indexQuestion).getChoiceC());
        choiceDBtn = new Button(newQuestionList.get(indexQuestion).getChoiceD());

        choiceABtn.setOnAction(e -> {
            if (choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");
                System.out.println("Thank you fagot");
                score++;
                indexQuestion++;
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                indexQuestion++;
                window.close();
                start();

            } else if (!(choiceABtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                indexQuestion++;
                System.out.println("Thank you fagot");

                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");

                indexQuestion++;
                window.close();
                start();
            }

        });

        choiceBBtn.setOnAction(e -> {
            if (choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");
                System.out.println("Thank you fagot");
                score++;
                indexQuestion++;
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                indexQuestion++;
                window.close();
                start();

            } else if (!(choiceBBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                indexQuestion++;
                System.out.println("Thank you fagot");

                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");

                indexQuestion++;
                window.close();
                start();
            }

        });

        choiceCBtn.setOnAction(e -> {
            if (choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");
                System.out.println("Thank you fagot");
                score++;
                indexQuestion++;
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                indexQuestion++;
                window.close();
                start();

            } else if (!(choiceCBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                indexQuestion++;
                System.out.println("Thank you fagot");

                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");

                indexQuestion++;
                window.close();
                start();
            }

        });

        choiceDBtn.setOnAction(e -> {
            if (choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect()) && indexQuestion.equals(4)) {
                System.out.println("Correct");
                System.out.println("Thank you fagot");
                score++;
                indexQuestion++;
                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();


            } else if (choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) {
                System.out.println("Correct");
                score++;
                indexQuestion++;
                window.close();
                start();

            } else if (!(choiceDBtn.getText().equals(newQuestionList.get(indexQuestion).getCorrect())) && indexQuestion.equals(4)) {
                System.out.println("Wrong");
                indexQuestion++;
                System.out.println("Thank you fagot");

                System.out.println("Your score is: " + score + "/" + indexQuestion);
                window.close();
            } else {
                System.out.println("Wrong");

                indexQuestion++;
                window.close();
                start();
            }

        });


        //button to return to home screen
        Button closeButton = new Button("Back");
        GridPane.setConstraints(closeButton, 10, 10);
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
        }
        scanner.close();

    }

    public ObservableList<questions> getRelatedQuestions() {
        for (int i = 0; i < QuestionList.size(); i++) {
            if (QuestionList.get(i).getTopic().equals(preferencesList.get(2))){
                newQuestionList.add(QuestionList.get(i));
            }
return newQuestionList;

        }
        return null;
    }
}