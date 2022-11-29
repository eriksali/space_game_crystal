package hellofx;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;


public class Subtract extends App {

    private Label question;
    private Label answer;
    private Text flag;
    private TextField resu1lt;

    int resu1;
    int resu2=-1;

    Random rand;
    int number1;
    int number2;

    int counter = 1;
    int LEVEL = 10;

    Subtract(TextField resu1lt, Label answer, Label question, Text flag) {
        this.question = question;
        this.answer = answer;
        this.resu1lt = resu1lt;
        this.flag = flag;
    }


    public void loadText(Pane gp) {

        Label questiontxt = new Label("Question: ");
        Label answertxt = new Label("Answer: ");
        
        gp.getChildren().add(questiontxt);
        gp.getChildren().add(answertxt);
        gp.getChildren().add(question);
        gp.getChildren().add(resu1lt);
        gp.getChildren().add(answer);
        gp.getChildren().add(flag);

        questiontxt.setLayoutX(50);
        questiontxt.setLayoutY(200);
        question.setLayoutX(150);
        question.setLayoutY(200);

        answertxt.setLayoutX(50);
        answertxt.setLayoutY(230);
        answer.setLayoutX(110);
        answer.setLayoutY(230);
        flag.setLayoutX(260);
        flag.setLayoutY(245);

        resu1lt.setLayoutX(50);
        resu1lt.setLayoutY(255);

        rand = new Random(); 
        number1 = rand.nextInt(100);
        number2 = rand.nextInt(100);
        question.setText(number1 + " - " + number2);
    }

    public void submitBtn(Pane gp) {
        
        Button submit = new Button("Submit");
        TranslateTransition transition = new TranslateTransition();
        ImageView rocket = new ImageView(getClass().getResource("rocket.png").toExternalForm());

        gp.getChildren().add(submit);
        gp.getChildren().add(rocket);

        submit.setLayoutX(260);
        submit.setLayoutY(300);

    
        rocket.setLayoutX(500);
        rocket.setLayoutY(550);
        rocket.setFitHeight(110);
        rocket.setFitWidth(70);

       

        submit.setDefaultButton(true);
        submit.setOnAction(e -> {

           if(counter==LEVEL) {
            display();
        }
            if (counter < LEVEL) { 

                try {

                    if (resu1lt.getText().isEmpty()) {

                        Alert alert = new Alert(AlertType.ERROR, "Please enter a number");
                        alert.showAndWait();
                        resu2 = -1;
                        answer.setText("");
                        Platform.runLater(() -> resu1lt.requestFocus());

                    } else {
                        resu1=number1-number2;
                        resu2 = Integer.parseInt(resu1lt.getText());

                        if (resu1 == resu2) {
                                    
                            transition.setAutoReverse(false);
                            transition.setNode(rocket);
                            
                            rocket.setLayoutX(500);
                            rocket.setLayoutY(550 - 50 * counter);

                            transition.play();

                            counter++;
                            
                            answer.setText(number1 + "-" + number2 + " = " + resu1lt.getText());
                            flag.setText("Correct");
                            //flag.setStyle("-fx-color: green");
                            //flag = new Text("Correct!");
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.GREEN);
                            resu1lt.clear();
                        }
                        else if(resu1!=resu2) {
                            answer.setText(number1 + "-" + number2 + " = " + resu1lt.getText());
                            flag.setText("Incorrect");
                            flag.setFont(Font.font("Times New Roman", FontWeight.BOLD, 16));
                            flag.setFill(Color.RED);
                            resu1lt.clear();
                        } 
                    }
                    
                } catch(NumberFormatException ex){ 
                ;}
            }

            });}
            

    public void renewBtn(Pane gp) {

        Button continuebtn = new Button("Continue");
        
        continuebtn.setOnAction(e -> {
            number1 = rand.nextInt(0,100);
            number2 = rand.nextInt(0,100);
            
            resu1lt.clear();
            question.setText(number1 + " - " + number2);
            answer.setText("");
            flag.setText("");
            resu1=0;
            resu2=0;
            Platform.runLater(() -> resu1lt.requestFocus());
        });

        gp.getChildren().add(continuebtn);
        continuebtn.setLayoutX(260);
        continuebtn.setLayoutY(270);
    }

    
    public void homeBtn(Pane gp, Stage primaryStage) {

        Button btnExit = new Button("Home");
        gp.getChildren().add(btnExit);
        btnExit.setLayoutX(260);
        btnExit.setLayoutY(330);
        btnExit.setOnAction(e -> {
        primaryStage.setScene(new Scene(createContent(primaryStage)));
        primaryStage.getScene().getStylesheets().add(App.class.getResource("Main.css").toExternalForm());
        primaryStage.show();
        });
    }}



