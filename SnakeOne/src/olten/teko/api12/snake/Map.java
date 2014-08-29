package olten.teko.api12.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import olten.teko.api12.snake.Logic;



public class Map extends JPanel implements ActionListener {
	


    private static final long serialVersionUID = 1L;	
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = 29;
    private int DELAY = 80;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots;
    private int points;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    
    
    // Bilder laden
    loadImages images = new loadImages();
    
    
    // PowerItems erzeugen	
    PowerItems banana = new PowerItems();
    PowerItems apple = new PowerItems();
    PowerItems fungus = new PowerItems();
    PowerItems pill = new PowerItems();


    public Map() {
    	
   	
    	banana.setPointUnit(50);
 
    	addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        initGame();
       
    }
    
 
    private void initGame() {

        dots = 20;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }

        locateApple();
        locatePill();
        locateFungus();
        
        locate(banana);

        timer = new Timer(DELAY, this);
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (inGame) {

            g.drawImage(images.getApple(), apple.getX(), apple.getY(), this);
            g.drawImage(images.getPill(), pill.getX(), pill.getY(), this);
            g.drawImage(images.getFungus(), fungus.getX(), fungus.getY(), this);
            g.drawImage(images.getBanana(), banana.getX(), banana.getY(), this);

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

    private void gameOver(Graphics g) {
        
        String msg = "Game Over";
        
        Font medium = new Font("Arial", Font.BOLD, 32);
        Font small = new Font("Arial", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(medium);

        g.setColor(Color.red);
        
        g.setFont(medium);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
        g.setFont(small);
        metr = getFontMetrics(small);
        String scoreMsg = "Your Score: "+points;

        g.drawString(scoreMsg, (B_WIDTH - metr.stringWidth(scoreMsg)) / 2, B_HEIGHT / 2+30);
        
    }

    private void checkApple() {

        if ((x[0] == apple.getX()) && (y[0] == apple.getY())) {

        	if(DELAY > 30){
        		DELAY = DELAY -5;
        		timer.setDelay(DELAY);
        	}
        	
            dots++;
            locateApple();
            points+=10;
        }
    }
    
    private void checkPill() {

        if ((x[0] == pill.getX()) && (y[0] == pill.getY())) {

            dots--;
            locatePill();
            points+=5;
        }
    }
    
    private void checkFungus() {

        if ((x[0] == fungus.getX()) && (y[0] == fungus.getY())) {

            locateFungus();
            points-=10;
        }
    }
    
    private void checkPi(PowerItems pi) {

        if ((x[0] == pi.getX()) && (y[0] == pi.getY())) {

            locate(pi);
            points += pi.getPointUnit();
        }
        

    }

    private void move() {

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
        
        
//        pill_y +=5;
//        
//        if (pill_y>1000)
//        	pill_y=-10;
//
//		pill_x += 2;
//
//		if (pill_x > 1000)
//			pill_x = -10;
        
    }

    private void checkCollision() {
/*
    	if (dots !=-5)
    		return;*/

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

    private void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        apple.setX((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple.setY((r * DOT_SIZE));

    }
    
    private void locatePill() {
        int r = (int) (Math.random() * RAND_POS);
        pill.setY((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        pill.setX((r * DOT_SIZE));
        
	}

	private void locateFungus() {
		int r = (int) (Math.random() * RAND_POS);
                fungus.setX((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
                fungus.setY((r * DOT_SIZE));
		
	}
	
	private void locate(PowerItems pi) {
		int r = (int) (Math.random() * RAND_POS);
		pi.setX((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		pi.setY((r * DOT_SIZE));

	}

	@Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkPill();
            checkFungus();
            
            checkPi(banana);

            checkCollision();
            move();
        }

        repaint();
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
            }
            
            if(key == KeyEvent.VK_P){
            	timer.stop();
            }
            
            if(key == KeyEvent.VK_F){
            	timer.start();
            }
            
        }
               
    }
}