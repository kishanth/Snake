/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import java.awt.*;
import javax.swing.JFrame;

/**
 *
 * @author Stefan
 */
public class StartGame extends JFrame{
    
    Menue menu = new Menue();
    
    public StartGame() {
        
        setMenuBar(menu.getMenuBar());
        add(new Init());
        setResizable(false);        
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private class Menue extends Frame {
        
        MenuBar mbar;
        Menu menu,submenu;
        MenuItem m1;
        
        public Menue(){
            
            mbar = new MenuBar();
            menu = new Menu("Datei");
            m1 = new MenuItem("Neues Spiel");
            
            
            menu.add(m1);
            mbar.add(menu);
            setMenuBar(mbar);
            
        }
    }
}


