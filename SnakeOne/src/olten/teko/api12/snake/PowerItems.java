/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author Stefan
 */
public class PowerItems {
    
    private int x;
    private int y;
    private int duration;
    private int points = 0;
    private int pointUnit;   
    private int dots;
    private int delay;
    private Image image;
    
    // Konstruktor mit Punkteübergabe von einzelnem Item
    public PowerItems(int pointUnit, String object, int dots, int delay) {        
        this.pointUnit = pointUnit;
        this.delay = delay;
        this.dots = dots;                
        ImageIcon img = new ImageIcon(this.getClass().getResource(object + ".png"));
        image = img.getImage();
    }
    		
    // Setter         
    void setX(int x) {
        this.x = x;
    }        
    void setY(int y) {
        this.y = y;
    }        
    void setDuration(int duration) {
        this.duration = duration;
    }        
    void setPoints(int points) {
        this.points = points;
    }                
    void setPointUnit(int pointUnit) {
        this.pointUnit = pointUnit;
    }

     // Getter 
    int getDelay() {
        return delay;
    }    
    int getDots() {
        return dots;
    }    
    int getX() {
        return x;
    }        
    int getPointUnit() {
        return pointUnit;
    }
    Image getImage() {
        return image;
    }
    int getPoints() {
        return points;
    }
    int getDuration() {
        return duration;
    }
    int getY() {
        return y;
    }
}

