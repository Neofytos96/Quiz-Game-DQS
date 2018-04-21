import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javafx.scene.control.TableColumn.CellEditEvent;
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
    TextField topicInput;
    ObservableList<questions> allQuestions = FXCollections.observableArrayList();
    ObservableList<questions> questionSelected;
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

        //topic column
        TableColumn<questions, String> topicColumn = new TableColumn<>("Topic");
        topicColumn.setMinWidth(150);
        topicColumn.setCellValueFactory(new PropertyValueFactory<>("topic"));

        //updated question column
        questionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        questionColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setQuestion(
                                        event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated choiceA column
        choiceAColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        choiceAColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setChoiceA(
                                event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated choiceB column
        choiceBColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        choiceBColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setChoiceB(
                                event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated choiceC column
        choiceCColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        choiceCColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setChoiceC(
                                event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated choiceD column
        choiceDColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        choiceDColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setChoiceD(
                                event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated answer column
        answerColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        answerColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setCorrect(
                                event.getNewValue());
                        System.out.println("question changed");
                    }
                });

        //updated topic column
        topicColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        topicColumn.setOnEditCommit(
                new EventHandler<CellEditEvent<questions, String>>() {
                    @Override
                    public void handle(CellEditEvent<questions, String> event) {
                        ((questions) event.getTableView().getItems().get(
                                event.getTablePosition().getRow())).setTopic(
                                event.getNewValue());
                        System.out.println("topic changed");
                    }
                });




        //Question input
                questionInput = new TextField();
        questionInput.setPromptText("Question");
        questionInput.setMinWidth(100);
        questionInput.setPrefWidth(10);

        //ChoiceA input
        choiceAInput = new TextField();
        choiceAInput.setPromptText("Choice A");
        choiceAInput.setMinWidth(30);
        choiceAColumn.setPrefWidth(10);


        //ChoiceB input
        choiceBInput = new TextField();
        choiceBInput.setPromptText("Choice B");
        choiceBInput.setMinWidth(30);
        choiceBColumn.setPrefWidth(10);


        //ChoiceC input
        choiceCInput = new TextField();
        choiceCInput.setPromptText("Choice C");
        choiceCInput.setMinWidth(30);
        choiceCColumn.setPrefWidth(10);

        //ChoiceD input
        choiceDInput = new TextField();
        choiceDInput.setPromptText("Choice D");
        choiceDInput.setMinWidth(30);
        choiceDColumn.setPrefWidth(10);

        //Answer input
        ansInput = new TextField();
        ansInput.setPromptText("Correct Answer");
        ansInput.setMinWidth(30);
        ansInput.setPrefWidth(100);

        //topic input
        topicInput = new TextField();
        topicInput.setPromptText("Topic");
        topicInput.setMinWidth(30);
        topicInput.setPrefWidth(100);



        tableQuestions = new TableView<>();
        tableQuestions.setItems(getQuestions());
        tableQuestions.getColumns().addAll(questionColumn, choiceAColumn,choiceBColumn,choiceCColumn,choiceDColumn,answerColumn, topicColumn);

        // button to add question
        Button addQuestion = new Button("Add");
        addQuestion.setOnAction(e -> addQuestionClicked());

        //button to delete Question
        Button delQuestion = new Button("Delete");
        delQuestion.setOnAction(e ->delQuestionClicked() );

        //save button
//        Button saveQuestion = new Button("Save");
//        saveQuestion.setOnAction(e -> saveQuestionClicked());
//        saveQuestion.setOnAction(e -> savedBox() );


        //edit button
        Button edidQuestion = new Button("Edit");
        edidQuestion.setOnAction(new editQuestions());

        // back Button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> backButtonClicked());




        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(questionInput, choiceAInput,choiceBInput,choiceCInput,choiceDInput,ansInput,topicInput, addQuestion, delQuestion, edidQuestion, backButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tableQuestions,hBox);


        Scene scene = new Scene(vBox);
        window2.setScene(scene);
        window2.show();


        }



    //Get all of the products
    public ObservableList<questions> getQuestions(){
        String fileName = "QuestionsData.csv";
        File file = new File (fileName);
        try {
            Scanner inputStreams = new Scanner(file);
            while (inputStreams.hasNext()){
                String line = inputStreams.nextLine();

                String[] splitted = line.split(",");
                allQuestions.add(new questions(splitted[0],splitted[1], splitted[2],splitted[3], splitted[4], splitted[5], splitted[6]));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }


        return allQuestions;
    }
//

    public void addQuestionClicked(){
        if (questionInput.getText().trim().isEmpty() || choiceAInput.getText().trim().isEmpty()
                || choiceBInput.getText().trim().isEmpty() || choiceCInput.getText().trim().isEmpty()
                || choiceDInput.getText().trim().isEmpty() || ansInput.getText().trim().isEmpty() || topicInput.getText().trim().isEmpty()) {
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
            Question.setTopic(topicInput.getText());

            String question = questionInput.getText();
            String choiceA = choiceAInput.getText();
            String choiceB = choiceBInput.getText();
            String choiceC = choiceCInput.getText();
            String choiceD = choiceDInput.getText();
            String answer = ansInput.getText();
            String topic = topicInput.getText();
            tableQuestions.getItems().add(Question);

            newListQuestion.add(new questions(question, choiceA,choiceB, choiceC,choiceD,answer,topic));
            //allQuestions.add(new questions(question, choiceA,choiceB, choiceC,choiceD,answer));

            questionInput.clear();
            choiceAInput.clear();
            choiceBInput.clear();
            choiceCInput.clear();
            choiceDInput.clear();
            ansInput.clear();
            topicInput.clear();
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
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(q.getTopic());
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
            FileWriter filesaver = new FileWriter("questionsData.csv");
            System.out.println("Saved button pressed");
            System.out.println(allQuestions);
            for (questions q : allQuestions){
                filesaver.append(q.getQuestion());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getChoiceA());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getChoiceB());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getChoiceC());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getChoiceD());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getCorrect());
                filesaver.append(COMMA_DELIMITER);
                filesaver.append(q.getTopic());
                filesaver.append(NEW_LINE_SEPARATOR);
            }
            filesaver.flush();
            filesaver.close();
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
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Save before exit  ");
//        alert.setHeaderText("Do you want to save your changes before leaving?");
//            alert.setContentText("Preferences added successfully" );
//        alert.showAndWait().ifPresent(rs -> {
//            if (rs == ButtonType.OK) {
                saveQuestionClicked();
                newBuild = new adminHome();
                newBuild.start();
                window2.close();


//        });
//        newBuild = new adminHome();
//        newBuild.start();
//        window2.close();



    }
public void savedBox() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Save  ");
    alert.setHeaderText("Questions saved successfully");
//            alert.setContentText("Preferences added successfully" );
    alert.showAndWait().ifPresent(rs -> {
        if (rs == ButtonType.OK) {
            System.out.println("Pressed OK.");
        }
    });
}

    private class editQuestions implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e ){
            tableQuestions.setEditable(true);
        }
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