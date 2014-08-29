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
    
    
    public PowerItems(int pointUnit) {
        this.pointUnit = pointUnit;
    }
		
    int getX() {
            
        return x;
        
    };
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
         int getPointUnit() {
                return pointUnit;
        }
         void setPointUnit(int pointUnit) {
                this.pointUnit = pointUnit;
        }
	}

