package hellofx;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class App extends Application {
   @Override
    public void start(Stage primaryStage) throws Exception {
    primaryStage.setScene(new Scene(createContent(primaryStage)));
    primaryStage.getScene().getStylesheets().add(App.class.getResource("Main.css").toExternalForm());
    primaryStage.show();
    }
    public int resu1;
    public int resu2 = -1;
    public int number1;
    public int number2;
    public int counter = 1;
    public int LEVEL = 9;
    public Parent createContent(Stage primaryStage) {
      
      Menu menu = new Menu("Click for Options!");
      //Creating menu Items
      MenuItem item1 = new MenuItem("Addition");
      MenuItem item2 = new MenuItem("Subtraction");
      MenuItem item3 = new MenuItem("Multiplication");
      MenuItem item4 = new MenuItem("Division");
      Label welcome = new Label("Welcome to Space Game");
      welcome.setId("welcome");
      //welcome.setStyle("-fx-text-fill: white;-fx-font-size: 20px;");
     // welcome.setFont(Font.font ("Verdana", 20));
      //Adding all the menu items to the menu
      menu.getItems().addAll(item1, item2,item3,item4);
      
      //Creating a menu bar and adding menu to it.
      MenuBar menuBar = new MenuBar(menu);
      menuBar.setTranslateX(220);
      menuBar.setTranslateY(350);
      
      welcome.setTranslateX(130);
      welcome.setTranslateY(270);
     
      item1.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            TextField result = new TextField();
            Text flag = new Text();
            Addition addition = new Addition(result, answer, question, flag);
            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();

            addition.loadText(pane);
            addition.submitBtn(pane);
            addition.renewBtn(pane);
            addition.homeBtn(pane, primaryStage);
        }
     });
        
     item2.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            Text flag = new Text();
            TextField result = new TextField();
            Subtract subtraction = new Subtract(result, answer, question, flag);

            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();
            subtraction.loadText(pane);
            subtraction.submitBtn(pane);
            subtraction.renewBtn(pane);
            subtraction.homeBtn(pane, primaryStage);

         }
      });
      item3.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            Text flag = new Text();
            TextField result = new TextField();
            Multiplication multiply = new Multiplication(result, answer, question, flag);

            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();

            multiply.loadText(pane);
            multiply.submitBtn(pane);
            multiply.renewBtn(pane);
            multiply.homeBtn(pane, primaryStage);
         }
      });
      item4.setOnAction(new EventHandler<ActionEvent>() {
         public void handle(ActionEvent event) {
            
            Pane pane = new Pane();
            Label question = new Label();
            question.setText("");
            Label answer = new Label();
            TextField result = new TextField();
            Text flag = new Text(); 
            Division divide = new Division(result,answer, question, flag); 

            Scene scene = new Scene(pane, 600, 700);
            scene.getStylesheets().add(App.class.getResource("Game.css").toExternalForm());
            primaryStage.setTitle("Space game!");
            primaryStage.setScene(scene);
            primaryStage.show();

            divide.loadText(pane);
            divide.submitBtn(pane);
            divide.renewBtn(pane);
            divide.homeBtn(pane, primaryStage);
         }
      }); 
      var root = new Pane(menuBar, welcome);
      root.setPrefSize(600, 700);
      return root;
   }

   public static void display() {
        Stage popupwindow=new Stage();
            
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Finish Line");      
            
        Label label= new Label(""); 
        //label.setStyle("-fx-color: blue");
        label.setFont(new Font("Arial", 30)); 
        label.setTextFill(Color.color(0, 0, 1));    
        label.setText("Excellent!");   
            
        Button button= new Button("OK");   
        button.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);
        Scene scene1= new Scene(layout, 250, 160);
        popupwindow.setScene(scene1);
        popupwindow.showAndWait(); 
    }

   public static void main(String args[]){
      launch(args);
   }
}