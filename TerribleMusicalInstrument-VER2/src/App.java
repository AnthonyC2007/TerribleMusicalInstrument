import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.Border;

public class App implements ActionListener {

    public App() throws Exception{
        soundEngine = new SoundEngine();
        soundEngine.playForeverNote();

        keyHandler = new KeyHandler(soundEngine);

        //Load resources
        titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("TerribleMusicalInstrument-VER2/resources/WhimsyTT.ttf")).deriveFont(35f);
        regularFont = Font.createFont(Font.TRUETYPE_FONT, new File("TerribleMusicalInstrument-VER2/resources/WhimsyTT.ttf")).deriveFont(20f);
        muteIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/muteIcon.png");
        settingIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/settingsCog.jpg");
        tuneIcon = new ImageIcon("TerribleMusicalInstrument-VER2/resources/splatter.png");
        gifImage = new ImageIcon("TerribleMusicalInstrument-VER2/resources/subwaysurf.gif");

        //GUI
        border = BorderFactory.createLineBorder(Color.black, 3);
        frame = new JFrame();
        initButtons();

        JPanel titlePanel = createTitlePanel();
        JPanel volPanel = createVolumePanel();
        JPanel mutePanel = createMutePanel();
        JPanel keysPanel = createKeysPanel();
        JPanel scalePanel = createScalePanel();
        JPanel tunePanel = createTunePanel();
        JPanel gifPanel = createGifPanel();

        frame.setSize(1200, 900);
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
        frame.add(gifPanel);
        frame.setVisible(true);//ensures we can actually see the frame
        //frame.pack();
    }

    private void initButtons()
    {
        volButton = new JButton();
        muteButton = new JButton();
        scaleButton = new JButton();
        tuneButton = new JButton();
        settingButton = new JButton();
        //volButton.setVerticalAlignment(JButton.CENTER);
        //volButton.setHorizontalAlignment(JButton.CENTER);
        volButton.setBounds(100,100,200,100);
        volButton.setFont(regularFont);
        volButton.setText("Change Vol");
        volButton.addActionListener(this);

        muteButton.setIcon(muteIcon);
        muteButton.setBounds(150,100,100,100);
        muteButton.addActionListener(e -> frame.requestFocusInWindow());//returns focus to window to keep playing the keys

        scaleButton.setBounds(100,100,200,100);
        scaleButton.setFont(regularFont);
        scaleButton.setText("Play Scale");
        scaleButton.addActionListener(this);
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
        settingButton.addActionListener(this);
        settingButton.addActionListener(e -> frame.requestFocusInWindow());
    }

    //App specific
    private SoundEngine soundEngine;
    private KeyHandler keyHandler;

    //Resources
    private ImageIcon muteIcon;
    private ImageIcon settingIcon;
    private ImageIcon tuneIcon;
    private ImageIcon gifImage;
    private Font regularFont;
    private Font titleFont;

    //GUI elements
    private Border border;
    private JFrame frame;
    private JButton volButton; //making our button a global variables
    private JButton muteButton;
    private JButton scaleButton;
    private JButton tuneButton;
    private JButton settingButton;

    private JPanel createTitlePanel()
    {
        JPanel panel = new JPanel();
        JLabel titleLabel = new JLabel();//creates a label
        
        panel.setLayout(new BorderLayout());//creates a border for each panel so labels can be moved around them
        panel.setBounds(400, 0, 400, 300);
        //panel.setLayout(null);
        
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
        panel.add(titleLabel);

        return panel;
    }

    private JPanel createVolumePanel()
    {
        JPanel panel = new JPanel();

        //panel.setLayout(new BorderLayout());
        panel.setLayout(null);
        panel.setBackground(Color.orange);
        panel.setBounds(800,0,400,300);
        panel.add(volButton);

        return panel;
    }

    private JPanel createMutePanel()
    {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.GREEN);
        panel.setBounds(0,0,400,300);
        panel.add(muteButton);

        return panel;
    }

    private JPanel createKeysPanel()
    {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.PINK);
        panel.setBounds(0,300,1200,300);

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

        panel.add(kLabel);
        panel.add(fLabel);
        panel.add(aLabel);
        panel.add(lLabel);
        panel.add(dLabel);
        panel.add(semiLabel);
        panel.add(sLabel);
        panel.add(jLabel);

        return panel;
    }

    private JPanel createScalePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.YELLOW);
        panel.setBounds(400,600,400,300);
        panel.add(scaleButton);

        return panel;
    }

    private JPanel createTunePanel()
    {
        JPanel panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.MAGENTA);
        panel.setBounds(0,600,400,300);
        panel.add(tuneButton);
        panel.add(settingButton);

        return panel;
    }

    private JPanel createGifPanel()
    {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(gifImage);

        //label.setIcon(gifImage);
        label.setBounds(40,30,320,180);
        label.setLayout(null);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        panel.setLayout(null);
        panel.setBounds(800, 600, 400, 300);
        panel.add(label);

        return panel;
    } 
    public static void main(String[] args) throws Exception {
        App app = new App();//creating a constructor for app so we can use functions such as ActionListner
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
            String characters = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz0123456789#%$£*?<>:;}{][~!()^,./|S";
            String randomString = "";
            for(int i = 0; i < 10; i++){
                randomString += characters.charAt((int)(Math.random() * characters.length()));
            }

            String input = JOptionPane.showInputDialog(null, "Are you a robot? Copy this to verify: " + randomString);
            if(input != null){
                input = input.trim();
                if(input.equals(randomString)){
                    JOptionPane.showMessageDialog(null, "Correct");
                    JDialog loadingDialog = new JDialog(); //creates a new popup window to hold the loading bar
                    loadingDialog.setTitle("Loading...");
                    loadingDialog.setSize(300, 100);
                    loadingDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); //cannot be closed
                    loadingDialog.setLocationRelativeTo(null); //center the box to the center of the screen

                    JProgressBar progressBar = new JProgressBar(); //creates the loading bar object
                    progressBar.setIndeterminate(true);//means it will never complete
                    loadingDialog.add(progressBar);
                    loadingDialog.setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect");
                }
            } else{
                JOptionPane.showMessageDialog(null, "No entry given");
            }
        }
    }
}

