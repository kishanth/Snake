

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
        onePlayer.setName(name);
        initGame();
    }
    
    // Methode Ausführung überschreiben
    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {
            
            movePill();
            
            for (PowerItems item : coll.items) {
                checkPi(item);          
            }

            checkCollision();
            move();
        }

        repaint();
    }        
    
    private void initGame() {
        
        dots = 3;
        
    // 1. Name von Bilddatei ohne erweiterung  2. zu/abnahme von Punkten 3. zu/abnahme dots von Schlange 4. zu/abnahme von Zeit (-) schneller (+) langsamer
        coll.addApple("apple", 10, 1, -1);
        coll.addApple("apple", 10, 1, -1);
        coll.addApple("apple", 10, 1, -1);
        coll.addBanana("banana", 50, 0, 0);
        coll.addFungus("fungus", -10, -2, -2);
        coll.addFungus("fungus", -10, -2, -2);
        coll.addFungus("fungus", -10, -2, -2);
        coll.addFungus("fungus", -10, -2, -2);
        coll.addPill("pill", 20, 2, 2);
        

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        for (PowerItems item : coll.items) {
            locatePi(item);          
        }

        timer = new Timer(DELAY, this);
        
    }

    
        
    }

  
