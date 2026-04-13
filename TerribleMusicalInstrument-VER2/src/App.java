import javax.swing.JFrame;
public class App {
    public static void main(String[] args) throws Exception {
        
        SoundEngine soundEngine = new SoundEngine();
        KeyHandler keyHandler = new KeyHandler(soundEngine);//implements the soundEngine to keyHandler constructor
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(keyHandler);//connects the keyHandler class directly to the frame
        frame.setFocusable(true);
        frame.setVisible(true);
    }
}
