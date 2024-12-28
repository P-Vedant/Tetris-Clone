package Main;
import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 720;
    final int FPS = 60;
    Thread gameThread;
    PlayManager pm;

    public GamePanel(){

        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        //Implement KeyListener
        this.addKeyListener((new KeyHandler()));
        this.setFocusable(true);

        pm = new PlayManager();
    }
public void launchGames(){
        gameThread = new Thread(this);
        gameThread.start();

}

    public void run() {
        double drawInterval = 1000000000 / FPS; //frames change every 0.16666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta +=  (currentTime-lastTime)/drawInterval;
            lastTime=currentTime;

            if(delta>=1){
                update();//1 UPDATE: update information such as character positions
                repaint();//2 DRAW: draw the screen with the updated information
                delta--;
            }
        }
    }
    public void update(){
        if(KeyHandler.pausePressed == false) {
            pm.update();
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        pm.draw(g2);
    }
}
