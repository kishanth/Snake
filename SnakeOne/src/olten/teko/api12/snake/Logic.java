package olten.teko.api12.snake;

import java.awt.event.ActionEvent;
import javax.swing.Timer;

public class Logic extends Map {

    // Konstruktor zum Spiel starten
    public Logic(){
        initGame();
    }
    
    // PowerItems Platzieren
    protected void locatePi(PowerItems pi){
        int r = (int) (Math.random() * RAND_POS);
        pi.setX((r * DOT_SIZE));
        
        r = (int) (Math.random() * RAND_POS);
        pi.setY((r * DOT_SIZE));
    }
    
    // Prüfen ob PowerItems getroffen wurde
    protected void checkPi(PowerItems pi) {

        if ((x[0] == pi.getX()) && (y[0] == pi.getY())) {

            locatePi(pi);
            points += pi.getPointUnit();
        }
    }
    
    
    // Prüfen ob Kollision mit Rand passiert ist
    protected void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
        
        if(!inGame) {
            timer.stop();
        }
        
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
    
    
    // Sollte ausgelagert werden
    private void initGame() {

        dots = 20;

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
