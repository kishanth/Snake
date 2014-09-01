package olten.teko.api12.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


abstract class Map extends Game {
	

    public Map() {

    	addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {
            
            if(gameStart){                
                gameStart(g);                
            }
            
            if(gamePause){
                timer.stop();
                gamePause(g);
                
            }
            
            // Punkte umwandeln in String
            String wert = String.valueOf(points);
            
            g.drawImage(images.getApple(), apple.getX(), apple.getY(), this);
            g.drawImage(images.getPill(), pill.getX(), pill.getY(), this);
            g.drawImage(images.getFungus(), fungus.getX(), fungus.getY(), this);
            g.drawImage(images.getBanana(), banana.getX(), banana.getY(), this);
            
            // Punktestand rechts oben
            g.drawString(wert, 280, 15);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(images.getHead(), x[z], y[z], this);
                } else {
                    g.drawImage(images.getBody(), x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }        
    }
    
    protected void movePill(){
        pill.setY(pill.getY() + 5);        
        
        if(pill.getY() > 1000){
            pill.setY(pill.getY() - 10);
        }
        
        pill.setX(pill.getX() + 5);
        
        
        if(pill.getX() > 1000){
            pill.setX(pill.getX() - 10);
        }
    }

    protected void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        
        movePill();
    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            
            if(key == KeyEvent.VK_S){
                timer.start();
            	gameStart = false;
            }
            
            if(key == KeyEvent.VK_P){
            	gamePause = true;                
            }
            
            if(key == KeyEvent.VK_C){
            	gamePause = false;
                timer.start();
            }                         
        
        }               
    }
}