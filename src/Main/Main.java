package Main;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[]args){
        JFrame window = new JFrame(("Simple Tetris"));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);


        GamePanel gp = new GamePanel();
        window.add(gp);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gp.launchGames();

    }
}
