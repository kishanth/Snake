package olten.teko.api12.snake;


abstract class Logic extends Map {

    
    // PowerItems Platzieren
    protected void locatePi(PowerItems pi){
        int r = (int) (Math.random() * RAND_POS);
        pi.setX((r * DOT_SIZE));
        
        r = (int) (Math.random() * RAND_POS);
        pi.setY((r * DOT_SIZE));
    }
    
    // Prüfen ob PowerItems getroffen wurde, Timer erhöhen
    protected void checkPi(PowerItems pi) {

        if ((x[0] == pi.getX()) && (y[0] == pi.getY())) {
            
            if(dots + pi.getDots() >= 3){
                dots = dots + pi.getDots();
            }
            if(DELAY > 30){
                DELAY = DELAY + pi.getDelay();
                timer.setDelay(DELAY);
            }            

            locatePi(pi);
            
            onePlayer.setPoints(pi.getPointUnit()); 
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
