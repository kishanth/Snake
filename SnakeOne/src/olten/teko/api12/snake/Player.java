/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package olten.teko.api12.snake;

/**
 *
 * @author Stefan
 */
public class Player {
    private String name;
    private int points = 0;
    
    public Player () {        

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = this.points + points;
    }
    
    
    
}
