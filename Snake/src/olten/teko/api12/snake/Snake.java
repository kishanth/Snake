package olten.teko.api12.snake;


import java.awt.EventQueue;
import javax.swing.JFrame;


public class Snake extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public Snake() {

        add(new Map());
        
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                
                JFrame snakeFrame = new Snake();
                snakeFrame.setVisible(true);                
            }
        });
    }
}