/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Stefan
 */
public class Menue extends Frame implements ActionListener {
        
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
        m1.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == m1){   
            JFrame snakeFrame = new StartGame();
            snakeFrame.setVisible(true);
        }


    }
}
