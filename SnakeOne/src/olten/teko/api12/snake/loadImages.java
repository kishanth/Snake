
package olten.teko.api12.snake;

import java.awt.Image;
import javax.swing.ImageIcon;


public class loadImages {
    
    private final Image apple;
    private final Image body;    
    private final Image pill;
    private final Image head;
    private final Image fungus;
    private final Image banana;
    
    public loadImages(){
        ImageIcon imgBan = new ImageIcon(this.getClass().getResource("banana.png"));
        this.banana = imgBan.getImage();
        
        ImageIcon imgDot = new ImageIcon(this.getClass().getResource("dot.png"));
        this.body = imgDot.getImage();

        ImageIcon imgHead = new ImageIcon(this.getClass().getResource("head.png"));
        this.head = imgHead.getImage();
        
        ImageIcon imgPill = new ImageIcon(this.getClass().getResource("pill.png"));
        this.pill = imgPill.getImage();
        
        ImageIcon imgFungus = new ImageIcon(this.getClass().getResource("fungus.png"));
        this.fungus = imgFungus.getImage();
        
        ImageIcon imgApple = new ImageIcon(this.getClass().getResource("apple.png"));
        this.apple = imgApple.getImage();
    }

    public Image getApple() {
        return apple;
    }

    public Image getBody() {
        return body;
    }

    public Image getPill() {
        return pill;
    }

    public Image getHead() {
        return head;
    }

    public Image getFungus() {
        return fungus;
    }

    public Image getBanana() {
        return banana;
    }
    
    
    
}
