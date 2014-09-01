package olten.teko.api12.snake;


abstract class Logic extends Map {

    
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
            
            if(pi == apple && DELAY > 30){                
                    DELAY = DELAY - 1;
                    timer.setDelay(DELAY);
            }

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
}
