package olten.teko.api12.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class StartGame extends JFrame{
    
    String name;
    
    Menue menu = new Menue();

    
    public StartGame() {
        
        
        if(!testName(name)){
            name = (String)JOptionPane.showInputDialog(rootPane, "Namen Eingeben", "");            
        }
        
        setMenuBar(menu.getMenuBar());
        add(new Init(name));
        setResizable(false);        
        pack();

        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
    }
    
    private boolean testName(String name){
        return name != null;
        
    }
 
}