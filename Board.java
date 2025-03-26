import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.Button;

public class Board 
{
    private Cell[][] board;
    private GridPane gridPane;
    VBox vBox;
    private int NSIZE;
    int moves;   
    Text count;
    
    public Board(int NSIZE){
           
        this.NSIZE=NSIZE;
        final int HIGHEST = (NSIZE*NSIZE) - 1 ;
        
        board = new Cell[NSIZE][NSIZE];
        gridPane = new GridPane();
        gridPane.setPrefSize(NSIZE*100,NSIZE*100);
        
        int labels = 1;   
        moves = 0;
        
        for(int j = 0; j < NSIZE; j++)
        {
            for(int i = 0; i < NSIZE; i++)
            {
                if(labels <= HIGHEST){
                    board[i][j] = new Cell(String.valueOf(labels), i , j);
                    board[i][j].setPrefSize(100,100);
                    board[i][j].setStyle("-fx-background-color: SkyBlue; -fx-font-size:20; -fx-border-color: Black; ");
                    board[i][j].setOnAction(this::processClick);
                    gridPane.add(board[i][j], i, j);
                }else{
                    board[i][j] = new Cell("", i , j);
                    board[i][j].setPrefSize(100,100);
                    
                    //board[i][j].setStyle("-fx-background-color: SkyBlue; -fx-border-color: Black;");
                    board[i][j].setOnAction(this::processClick);
                    gridPane.add(board[i][j], i, j);
                }
                labels++;
            }
        }
       
        Text countText = new Text(100,100, "No, of moves");
        count = new Text(String.valueOf(moves));
        
        Button restartButton = new Button("Restart");
        restartButton.setStyle("-fx-font-size: 20px; -fx-padding: 10px 20px;");
        restartButton.setOnAction(this::processNewGameClick);
        
        
        FlowPane pane = new FlowPane(0,50,countText, count, restartButton);
        pane.setStyle("-fx-font-size: 20px; -fx-padding: 10px 20px;");
        
        vBox = new VBox(gridPane, pane);
        
        moves = -1;
        shuffle();
        moves = 0;
    }
    
    
    
    private void processNewGameClick(ActionEvent event){
        
        shuffle();
        moves = 0;
        count.setText(String.valueOf(moves));
    }
    
    private void processClick(ActionEvent event){
        Cell clicked = (Cell) event.getSource();
        int x = clicked.getX();
        int y = clicked.getY(); 
        
        
        if (isValid(x, y - 1) && board[x][y - 1].isEmpty()) { 
            swap(x, y, x, y - 1);
        } else if (isValid(x, y + 1) && board[x][y + 1].isEmpty()) { 
            swap(x, y, x, y + 1);
        } else if (isValid(x - 1, y) && board[x - 1][y].isEmpty()) { 
            swap(x, y, x - 1, y);
        } else if (isValid(x + 1, y) && board[x + 1][y].isEmpty()) { 
            swap(x, y, x + 1, y);
        }
       
    }
    
    private void swap(int x0, int y0, int x1, int y1){
        
        Cell temp = board[x0][y0];
        gridPane.getChildren().remove(temp);
        gridPane.getChildren().remove(board[x1][y1]);
        
        gridPane.add(board[x0][y0], x1, y1);
        gridPane.add(board[x1][y1], x0, y0);
        
        board[x0][y0] = board[x1][y1];
        
 
        board[x0][y0].setX(x0);
        board[x0][y0].setY(y0);
        board[x1][y1] = temp;
        board[x1][y1].setX(x1);
        board[x1][y1].setY(y1);

        if(moves >= 0){
            moves++;
            count.setText(String.valueOf(moves));
        }
        
        
    
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < NSIZE && y >= 0 && y < NSIZE;
    }
    
    private void shuffle(){
        int x = NSIZE-1; 
        int y = NSIZE-1; 
        for (int i = 0; i<1000; i++){
            
            int direction = (int)(Math.random() * (NSIZE+1)); 
       
            if(direction==0){
                
                if(isValid(x-1, y)){
                    swap(x, y, x - 1, y);
                    x=x-1;
                    y= y;
                }
                
            }else if(direction==1){
                
                if(isValid(x, y +1  )){
                    swap(x, y, x, y + 1);
                    x = x;
                    y = y + 1;
                }
            }else if(direction==2){
                if(isValid(x + 1, y)){
                    swap(x, y, x + 1, y);
                    x=x+1;
                    y= y;
                }
            }else if(direction==3){
                if(isValid(x, y - 1)){
                    swap(x, y, x, y - 1);
                    x=x;
                    y= y-1;
                }
            }
           
            
        }
        
        
    }
    
    public VBox getVBox(){
        
        return vBox;
        
    }
    
    
    public GridPane getGridPane(){
        return gridPane;
    }
    
}
