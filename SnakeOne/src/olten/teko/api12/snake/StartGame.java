package olten.teko.api12.snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
    
    private class Menue extends Frame implements ActionListener {
        
        //Dialog dia = new Dialog();
        
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
                Dialog dia = new Dialog();
            }
            
            
        }
    }
    
    private class Dialog extends JFrame {
        
        JDialog myDialog = new JDialog();
        JTextField tf = new JTextField();
        
        public Dialog() {
            myDialog.setTitle("New Player");
            myDialog.setSize(250, 100);
            myDialog.setModal(true);
            myDialog.setVisible(true);
            myDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myDialog.add(tf);
            
        }
        
        
        
    }
}


