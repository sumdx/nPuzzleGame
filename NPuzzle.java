import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class NPuzzle extends Application
{
    Stage primaryStage;
    public static void main(String args){
        launch(args);
    }    
    
    public void start(Stage primaryStage){
        this.primaryStage =primaryStage;
        
        
        showMainMenu();        
    }
    
    public void showMainMenu(){
        
        Button startButton = new Button("Start Game");
        startButton.setStyle("-fx-font-size: 20px; -fx-padding: 10px 20px;");

        startButton.setOnAction(e -> showGameStart());

        StackPane startLayout = new StackPane(startButton);
        startLayout.setStyle("-fx-background-color: lightblue;"); 

        Scene startScene = new Scene(startLayout, 300, 300);
        primaryStage.setScene(startScene);
        primaryStage.setTitle("Puzzle Game");
        primaryStage.show();
    
    }
    
    public void showGameStart(){
        
        int n = 3;
        Board board = new Board(n);
        Scene scene = new Scene(board.getVBox(),(n*100),(n*100));
        primaryStage.setTitle("nPuzzle");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
    }
}
