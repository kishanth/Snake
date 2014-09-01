/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

/**
 *
 * @author Stefan
 */
public class Init extends Logic {
    
    // Konstruktor zum Aufrufen vom Spiel
    Init(String name){
        this.name = name;
        initGame();
    }
    
    // Methode Ausführung überschreiben
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            
            checkPi(apple);
            checkPi(pill);
            checkPi(fungus);
            checkPi(banana);

            checkCollision();
            move();
        }

        repaint();
    }
        

    private void initGame() {
        
        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locatePi(apple);
        locatePi(pill);
        locatePi(fungus);
        locatePi(banana);

        timer = new Timer(DELAY, this);
        
    }

    
        
    }

  
