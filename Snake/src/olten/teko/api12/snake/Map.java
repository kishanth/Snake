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


// will den scheiß nur mal testen!!!

public class Map extends JPanel implements ActionListener {
	
	
	public class PowerItem {
		private int x;
		private int y;
		private int duration;
		private int points = 0;
		private int pointUnit;
		private ImageIcon imageIcon;
		
		int getX() {
			return x;
		}
		void setX(int x) {
			this.x = x;
		}
		int getY() {
			return y;
		}
		void setY(int y) {
			this.y = y;
		}
		int getDuration() {
			return duration;
		}
		void setDuration(int duration) {
			this.duration = duration;
		}
		int getPoints() {
			return points;
		}
		void setPoints(int points) {
			this.points = points;
		}
		ImageIcon getImageIcon() {
			return imageIcon;
		}
		void setImageIcon(ImageIcon imageIcon) {
			this.imageIcon = imageIcon;
		}
		private int getPointUnit() {
			return pointUnit;
		}
		private void setPointUnit(int pointUnit) {
			this.pointUnit = pointUnit;
		}
	}

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
    
    private int apple_x;
    private int apple_y;
    
    private int pill_x;
    private int pill_y;
    
    private int fungus_x;
    private int fungus_y;
    
    private int points;

    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;

    private Timer timer;
    private Image body;
    private Image apple;
    private Image pill;
    private Image head;
    private Image fungus;
    
	PowerItem banana = new PowerItem();


    public Map() {
    	
   	
    	banana.imageIcon = new ImageIcon(this.getClass().getResource("banana.png"));
    	banana.pointUnit=50;
 
    	addKeyListener(new TAdapter());
        setBackground(Color.white);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
       
    }
    
    

    private void loadImages() {
    	

        ImageIcon imgDot = new ImageIcon(this.getClass().getResource("dot.png"));
        body = imgDot.getImage();

        ImageIcon imgApple = new ImageIcon(this.getClass().getResource("apple.png"));
        apple = imgApple.getImage();

        ImageIcon imgHead = new ImageIcon(this.getClass().getResource("head.png"));
        head = imgHead.getImage();
        
        ImageIcon imgPill = new ImageIcon(this.getClass().getResource("pill.png"));
        pill = imgPill.getImage();
        
        ImageIcon imgFungus = new ImageIcon(this.getClass().getResource("fungus.png"));
        fungus = imgFungus.getImage();
        
        
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

            g.drawImage(apple, apple_x, apple_y, this);
            g.drawImage(pill, pill_x, pill_y, this);
            g.drawImage(fungus, fungus_x, fungus_y, this);
                        
            g.drawImage(banana.imageIcon.getImage(), banana.x, banana.y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(body, x[z], y[z], this);
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

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

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

        if ((x[0] == pill_x) && (y[0] == pill_y)) {

            dots--;
            locatePill();
            points+=5;
        }
    }
    
    private void checkFungus() {

        if ((x[0] == fungus_x) && (y[0] == fungus_y)) {

            locateFungus();
            points-=10;
        }
    }
    
    private void checkPi(PowerItem pi) {

        if ((x[0] == pi.x) && (y[0] == pi.y)) {

            locate(pi);
            points += pi.pointUnit;
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
        
        
        pill_y+=5;
        
        if (pill_y>1000)
        	pill_y=-10;

		pill_x += 2;

		if (pill_x > 1000)
			pill_x = -10;
        
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
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));

    }
    
    private void locatePill() {
        int r = (int) (Math.random() * RAND_POS);
        pill_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        pill_y = ((r * DOT_SIZE));
        
	}

	private void locateFungus() {
		int r = (int) (Math.random() * RAND_POS);
		fungus_x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		fungus_y = ((r * DOT_SIZE));

	}
	
	private void locate(PowerItem pi) {
		int r = (int) (Math.random() * RAND_POS);
		pi.x = ((r * DOT_SIZE));

		r = (int) (Math.random() * RAND_POS);
		pi.y = ((r * DOT_SIZE));

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