import javafx.scene.control.Button;

public class Cell extends Button
{
    private int x, y;
    private String content;
    
    public Cell(String content, int x, int y){
        
        super(content);
        this.x = x;
        this.y = y;
        this.content = content;
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public boolean isEmpty(){
        return content.isEmpty();
    }
}
