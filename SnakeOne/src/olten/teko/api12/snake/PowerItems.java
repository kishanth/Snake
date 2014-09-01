/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

import javax.swing.ImageIcon;

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
    private ImageIcon imageIcon;
    
    // Konstruktor mit Punkteübergabe von einzelnem Item
    public PowerItems(int pointUnit) {
        
        this.pointUnit = pointUnit;
        
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
    void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }        
    void setPointUnit(int pointUnit) {
        this.pointUnit = pointUnit;
    }

     // Getter
    int getX() {
        return x;
    };        
    int getPointUnit() {
        return pointUnit;
    }
    ImageIcon getImageIcon() {
        return imageIcon;
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

