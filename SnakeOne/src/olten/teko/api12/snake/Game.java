/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Stefan
 */
abstract class Game extends JPanel implements ActionListener {
    
    
    protected final int B_WIDTH = 300;
    protected final int B_HEIGHT = 300;
    protected final int DOT_SIZE = 10;
    protected final int ALL_DOTS = 900;
    protected final int RAND_POS = 29;
    protected final int x[] = new int[ALL_DOTS];
    protected final int y[] = new int[ALL_DOTS];
    

    // Map und Schlangen Variablen
    protected static final long serialVersionUID = 1L;	
    protected int dots;
    
    // Timer Variablen
    protected Timer timer;
    protected int DELAY = 80;

    //Spielername
    protected String name;
    
    protected int points;

    // Richtungs Variablen
    protected boolean leftDirection = false;
    protected boolean rightDirection = true;
    protected boolean upDirection = false;
    protected boolean downDirection = false;
    protected boolean inGame = true;
    protected boolean gamePause = false;
    protected boolean gameStart = true;
    
    loadImages images = new loadImages();

    // PowerItems erzeugen -- erste Zahl = Punkte, zweite Iconname (wie bild im Explorer), drittens anzahl abzug/zunahme von dots
    // viertens Delay zunahme oder abnahme (+ = langsamer, - = schneller)
    PowerItems banana = new PowerItems(50, "banana", 0, 0);
    PowerItems apple = new PowerItems(10, "apple", 1, -1);
    PowerItems fungus = new PowerItems(-10, "fungus", -2, 0);
    PowerItems pill = new PowerItems(5, "pill", 2, 2);
    
    
    protected void gameStart(Graphics g){
        
        String msg = "To start Press 'S'";
        String startMsg = "Press 'P' to pause";
        
        Font medium = new Font("Arial", Font.BOLD, 32);
        Font small = new Font("Arial", Font.BOLD, 18);
        
        FontMetrics metr;
        g.setColor(Color.blue);
        g.setFont(small);
        metr = getFontMetrics(small);
        g.drawString("Hi " + name, (B_WIDTH - metr.stringWidth("Hi " + name)) / 2, B_HEIGHT / 2 - 35);
                
        g.setFont(medium);
        metr = getFontMetrics(medium);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
        g.setFont(small);
        metr = getFontMetrics(small);
        g.drawString(startMsg, (B_WIDTH - metr.stringWidth(startMsg)) / 2, B_HEIGHT / 2 + 30);        
    }
    
    protected void gamePause(Graphics g){
        
        String msg = "Pause";
        
        Font medium = new Font("Arial", Font.BOLD, 32);
        Font small = new Font("Arial", Font.BOLD, 18);
        
        FontMetrics metr = getFontMetrics(medium);
        g.setColor(Color.blue);
        g.setFont(medium);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
                
        g.setFont(small);
        metr = getFontMetrics(small);
        String scoreMsg = "Your current Score: " + points;
        g.drawString(scoreMsg, (B_WIDTH - metr.stringWidth(scoreMsg)) / 2, B_HEIGHT / 2+30);
        
        String pauseMsg = "Press 'C' to continue";
        g.drawString(pauseMsg, (B_WIDTH - metr.stringWidth(pauseMsg)) / 2, B_HEIGHT / 2+60);
        
    }

    protected void gameOver(Graphics g) {
        
        String msg = "Game Over";
        
        Font medium = new Font("Arial", Font.BOLD, 32);
        Font small = new Font("Arial", Font.BOLD, 18);
        FontMetrics metr = getFontMetrics(medium);

        g.setColor(Color.blue);
        
        g.setFont(medium);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        
        g.setFont(small);
        metr = getFontMetrics(small);
        String scoreMsg = "Your Score: "+points;

        g.drawString(scoreMsg, (B_WIDTH - metr.stringWidth(scoreMsg)) / 2, B_HEIGHT / 2+30);
        
    }
    
    protected void DrawObjects(Graphics g) {
        
            // Punkte umwandeln in String
            String sPoint = String.valueOf(points);
            //String sDelay = String.valueOf(DELAY);
            
            // Objekte in Feld Zeichnen
            g.drawImage(apple.getImage(), apple.getX(), apple.getY(), this);
            g.drawImage(pill.getImage(), pill.getX(), pill.getY(), this);
            g.drawImage(fungus.getImage(), fungus.getX(), fungus.getY(), this);
            g.drawImage(banana.getImage(), banana.getX(), banana.getY(), this);
            
            // Punktestand rechts oben
            g.drawString(sPoint, 265, 15);
            //g.drawString(sDelay, 240, 15);
            
            // Schlange Zeichnen
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(images.getHead(), x[z], y[z], this);
                } else {
                    g.drawImage(images.getBody(), x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();
    }
}
