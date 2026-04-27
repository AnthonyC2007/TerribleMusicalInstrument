import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;

public class App implements ActionListener {

    private SoundEngine soundEngine;

    public App(SoundEngine soundEngine){
        this.soundEngine = soundEngine;
    }

    JButton volButton; //making our button a global variables
    JButton muteButton;
    JButton scaleButton;
    JButton tuneButton;
    JButton settingButton;
    public static void main(String[] args) throws Exception {
        
        SoundEngine soundEngine = new SoundEngine();
        KeyHandler keyHandler = new KeyHandler(soundEngine);//implements the soundEngine to keyHandler constructor
        Border border = BorderFactory.createLineBorder(Color.black,3);

        Font titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("TerribleMusicalInstrument-VER2/resources/WhimsyTT.ttf")).deriveFont(35f);
        Font regularFont = Font.createFont(Font.TRUETYPE_FONT, new File("TerribleMusicalInstrument-VER2/resources/WhimsyTT.ttf")).deriveFont(20f);

        ImageIcon muteIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/muteIcon.png");
        ImageIcon settingIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/settingsCog.jpg");
        ImageIcon tuneIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/splatter.png");

        JFrame frame = new JFrame();//creates a frame
        JPanel titlePanel = new JPanel();
        JPanel volPanel = new JPanel();
        JPanel mutePanel = new JPanel();
        JPanel keysPanel = new JPanel();
        JPanel scalePanel = new JPanel();
        JPanel tunePanel = new JPanel();


        App app = new App(soundEngine);//creating a constructor for app so we can use functions such as ActionListner
        app.volButton = new JButton();
        app.muteButton = new JButton();
        app.scaleButton = new JButton();
        app.tuneButton = new JButton();
        app.settingButton = new JButton();
        JButton volButton = app.volButton;
        JButton muteButton = app.muteButton;
        JButton scaleButton = app.scaleButton;
        JButton tuneButton = app.tuneButton;
        JButton settingButton = app.settingButton;

        //volButton.setVerticalAlignment(JButton.CENTER);
        //volButton.setHorizontalAlignment(JButton.CENTER);
        volButton.setBounds(100,100,200,100);
        volButton.setFont(regularFont);
        volButton.setText("Change Vol");
        volButton.addActionListener(app);

        muteButton.setIcon(muteIcon);
        muteButton.setBounds(150,100,100,100);
        muteButton.addActionListener(e -> frame.requestFocusInWindow());//returns focus to window to keep playing the keys

        scaleButton.setBounds(100,100,200,100);
        scaleButton.setFont(regularFont);
        scaleButton.setText("Play Scale");
        scaleButton.addActionListener(app);
        scaleButton.addActionListener(e -> frame.requestFocusInWindow());

        tuneButton.setIcon(tuneIcon);
        tuneButton.setText("Tune");
        tuneButton.setHorizontalTextPosition(JButton.CENTER);
        tuneButton.setVerticalTextPosition(JButton.CENTER);
        tuneButton.setFont(regularFont);
        tuneButton.setBounds(100, 150, 200, 100);
        tuneButton.addActionListener(keyHandler); //sends the action to the keyHandler class
        tuneButton.addActionListener(e -> frame.requestFocusInWindow());
        keyHandler.setTuneButton(tuneButton);

        settingButton.setIcon(settingIcon);
        settingButton.setBounds(150, 25, 100, 100);
        settingButton.addActionListener(app);
        settingButton.addActionListener(e -> frame.requestFocusInWindow());

        frame.setSize(1200,900);//sets dimenstion
        titlePanel.setLayout(new BorderLayout());//creates a border for each panel so labels can be moved around them
        titlePanel.setBounds(400, 0, 400, 300);
        //titlePanel.setLayout(null);

        //volPanel.setLayout(new BorderLayout());
        volPanel.setLayout(null);
        volPanel.setBackground(Color.orange);
        volPanel.setBounds(800,0,400,300);
        volPanel.add(volButton);

        mutePanel.setLayout(null);
        mutePanel.setBackground(Color.GREEN);
        mutePanel.setBounds(0,0,400,300);
        mutePanel.add(muteButton);

        keysPanel.setLayout(null);
        keysPanel.setBackground(Color.PINK);
        keysPanel.setBounds(0,300,1200,300);

        scalePanel.setLayout(null);
        scalePanel.setBackground(Color.YELLOW);
        scalePanel.setBounds(400,600,400,300);
        scalePanel.add(scaleButton);

        tunePanel.setLayout(null);
        tunePanel.setBackground(Color.MAGENTA);
        tunePanel.setBounds(0,600,400,300);
        tunePanel.add(tuneButton);
        tunePanel.add(settingButton);


        JLabel titleLabel = new JLabel();//creates a label
        titleLabel.setText("The Amazing Piano!");
        //titleLabel.setBounds(0, 0, 400, 60);
        //titleLabel.setBorder(border);
        titleLabel.setVerticalAlignment(JLabel.CENTER);//set text/image to top of label
        titleLabel.setHorizontalAlignment(JLabel.CENTER);//set text/image to center of label
        //titleLabel.setBounds(JLabel.CENTER,JLabel.TOP,250,100);
        //titleLabel.setHorizontalTextPosition(JLabel.CENTER);
        //titleLabel.setVerticalTextPosition(JLabel.TOP); used to put text on top of an image
        //titleLabel.setForeground(new Color(0,0,0));
        titleLabel.setFont(titleFont); //set font of text
        //titleLabel.setIconTextGap(50); //set gap of text to image
        //titleLabel.setBackground(Color.black);
        //titleLabel.setOpaque(true);
        titlePanel.add(titleLabel);


        JLabel kLabel = new JLabel();
        JLabel fLabel = new JLabel();
        JLabel aLabel = new JLabel();
        JLabel lLabel = new JLabel();
        JLabel dLabel = new JLabel();
        JLabel semiLabel = new JLabel();
        JLabel sLabel = new JLabel();
        JLabel jLabel = new JLabel();

        kLabel.setBounds(25,50,100,200);
        kLabel.setLayout(new BorderLayout());
        kLabel.setVerticalAlignment(JLabel.CENTER);
        kLabel.setHorizontalAlignment(JLabel.CENTER);
        kLabel.setText("K");
        kLabel.setFont(titleFont);
        kLabel.setBorder(border);

        fLabel.setBounds(150,50,100,200);
        fLabel.setLayout(new BorderLayout());
        fLabel.setVerticalAlignment(JLabel.CENTER);
        fLabel.setHorizontalAlignment(JLabel.CENTER);
        fLabel.setText("F");
        fLabel.setFont(titleFont);
        fLabel.setBorder(border);

        aLabel.setBounds(300,50,100,200);
        aLabel.setLayout(new BorderLayout());
        aLabel.setVerticalAlignment(JLabel.CENTER);
        aLabel.setHorizontalAlignment(JLabel.CENTER);
        aLabel.setText("A");
        aLabel.setFont(titleFont);
        aLabel.setBorder(border);

        lLabel.setBounds(450,50,100,200);
        lLabel.setLayout(new BorderLayout());
        lLabel.setVerticalAlignment(JLabel.CENTER);
        lLabel.setHorizontalAlignment(JLabel.CENTER);
        lLabel.setText("L");
        lLabel.setFont(titleFont);
        lLabel.setBorder(border);

        dLabel.setBounds(600,50,100,200);
        dLabel.setLayout(new BorderLayout());
        dLabel.setVerticalAlignment(JLabel.CENTER);
        dLabel.setHorizontalAlignment(JLabel.CENTER);
        dLabel.setText("D");
        dLabel.setFont(titleFont);
        dLabel.setBorder(border);

        semiLabel.setBounds(750,50,100,200);
        semiLabel.setLayout(new BorderLayout());
        semiLabel.setVerticalAlignment(JLabel.CENTER);
        semiLabel.setHorizontalAlignment(JLabel.CENTER);
        semiLabel.setText(":");
        semiLabel.setFont(titleFont);
        semiLabel.setBorder(border);

        sLabel.setBounds(900,50,100,200);
        sLabel.setLayout(new BorderLayout());
        sLabel.setVerticalAlignment(JLabel.CENTER);
        sLabel.setHorizontalAlignment(JLabel.CENTER);
        sLabel.setText("S");
        sLabel.setFont(titleFont);
        sLabel.setBorder(border);

        jLabel.setBounds(1050,50,100,200);
        jLabel.setLayout(new BorderLayout());
        jLabel.setVerticalAlignment(JLabel.CENTER);
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setText("J");
        jLabel.setFont(titleFont);
        jLabel.setBorder(border);

        keysPanel.add(kLabel);
        keysPanel.add(fLabel);
        keysPanel.add(aLabel);
        keysPanel.add(lLabel);
        keysPanel.add(dLabel);
        keysPanel.add(semiLabel);
        keysPanel.add(sLabel);
        keysPanel.add(jLabel);




        frame.setTitle("The Amazing Piano!");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//tricks the user into closing the application
        frame.addKeyListener(keyHandler);//connects the keyHandler class directly to the frame
        frame.setFocusable(true);//so we can interact with the frame
        frame.add(titlePanel);//adds the title panel to the frame
        frame.add(volPanel);
        frame.add(mutePanel);
        frame.add(keysPanel);
        frame.add(scalePanel);
        frame.add(tunePanel);
        frame.setVisible(true);//ensures we can actually see the frame
        //frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == volButton){ //if the button clicked was the vol button
            System.exit(0);//will close the program
        }
        if(e.getSource() == scaleButton){
            int[] pitches = {60, 62, 64, 65, 67, 69, 71, 73};
            int noteLength = 500;
            for(int i = 0; i < pitches.length; i++){
                int pitch = pitches[i];
                int delay = i * 600; // timer works by delaying after the button is pressed so this ensure they dont 
                //run at the same time
                Timer timer = new Timer(delay, event -> soundEngine.playNote(8, pitch, 100));
                timer.setRepeats(false);
                timer.start();
                Timer stopTimer = new Timer(delay + noteLength, event -> soundEngine.stopNote(8,pitch));
                stopTimer.setRepeats(false);
                stopTimer.start();
            }
            }
        if(e.getSource() == settingButton){
            String characters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
            String randomString = "";
            for(int i = 0; i < 10; i++){
                randomString += characters.charAt((int)(Math.random() * characters.length()));
            }

            String input = JOptionPane.showInputDialog(null, "Are you a robot? Copy this to verify: " + randomString);
            if(input != null){
                input = input.trim();
                if(input.equals(randomString)){
                    JOptionPane.showMessageDialog(null, "Correct");
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect");
                }
            } else{
                JOptionPane.showMessageDialog(null, "No entry given");
            }
        }
    }
}

