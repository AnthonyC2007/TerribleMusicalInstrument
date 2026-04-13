import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Font;
import java.io.File;

public class App {
    public static void main(String[] args) throws Exception {
        
        SoundEngine soundEngine = new SoundEngine();
        KeyHandler keyHandler = new KeyHandler(soundEngine);//implements the soundEngine to keyHandler constructor
        //Border border = BorderFactory.createLineBorder(Color.green,3);

        Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("TerribleMusicalInstrument-VER2/WhimsyTT.ttf")).deriveFont(35f);
        JFrame frame = new JFrame();//creates a frame
        JPanel titlePanel = new JPanel();
        frame.setSize(1200,900);//sets dimenstion

        titlePanel.setBounds(400, 0, 400, 300);

        titlePanel.setLayout(null);

        JLabel label = new JLabel();//creates a label
        label.setText("The Amazing Piano!");
        label.setBounds(0, 0, 400, 60);
        //label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP);//set text/image to top of label
        label.setHorizontalAlignment(JLabel.CENTER);//set text/image to center of label
        //label.setBounds(JLabel.CENTER,JLabel.TOP,250,100);
        //label.setHorizontalTextPosition(JLabel.CENTER);
        //label.setVerticalTextPosition(JLabel.TOP);
        //label.setForeground(new Color(0,0,0));
        label.setFont(customFont); //set font of text
        //label.setIconTextGap(50); //set gap of text to image
        //label.setBackground(Color.black);
        //label.setOpaque(true);
        titlePanel.add(label);


        frame.setTitle("The Amazing Piano!");
        frame.setLayout(null);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//tricks the user into closing the application
        frame.addKeyListener(keyHandler);//connects the keyHandler class directly to the frame
        frame.setFocusable(true);
        frame.add(titlePanel);
        frame.setVisible(true);//ensures we can actually see the frame
        //frame.pack();
    }
}
