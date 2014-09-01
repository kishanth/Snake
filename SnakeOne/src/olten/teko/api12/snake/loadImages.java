
package olten.teko.api12.snake;

import java.awt.Image;
import javax.swing.ImageIcon;


public class loadImages {
        
    private final Image body;        
    private final Image head;
            
    public loadImages(){

        ImageIcon imgDot = new ImageIcon(this.getClass().getResource("dot.png"));
        this.body = imgDot.getImage();

        ImageIcon imgHead = new ImageIcon(this.getClass().getResource("head.png"));
        this.head = imgHead.getImage();
    }


    public Image getBody() {
        return body;
    }

    public Image getHead() {
        return head;
    }
        
}
