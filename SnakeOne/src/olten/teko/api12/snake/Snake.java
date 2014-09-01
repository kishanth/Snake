package olten.teko.api12.snake;


import java.awt.EventQueue;
import javax.swing.JFrame;


public class Snake {
    
        
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {  
                 
                JFrame snakeFrame = new StartGame();
           
                snakeFrame.setVisible(true);                
            }
        });
        
        
    }
}