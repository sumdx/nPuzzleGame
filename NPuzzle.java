import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.Group;
import javafx.scene.layout.*;

public class NPuzzle extends Application
{
    public static void main(String args){
        launch(args);
    }    
    
    public void start(Stage primaryStage){
        
        Board board = new Board();
        Scene scene = new Scene(board.getVBox());
        primaryStage.setTitle("nPuzzle");
        primaryStage.setScene(scene);
        primaryStage.show(); 
                
    }
}
