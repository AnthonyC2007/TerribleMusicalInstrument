import java.awt.event.*;//importing all java abstract window toolkit event libraries
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class KeyHandler implements KeyListener, ActionListener{ //KeyListener acts like a contract so it expects all three methods to be present

    private SoundEngine soundEngine;//creating a field for the sound engine
    private int pitchA, pitchS, pitchD, pitchF, pitchJ, pitchK, pitchL, pitchSemi;
    private boolean aHeld = false, sHeld = false, dHeld = false, fHeld = false, jHeld = false, kHeld = false, lHeld = false, semiHeld = false;//this will be used so the note will last for the duration of the key being held
    private int velocity = 100;
    private JButton tuneButton;
    //passes in the SoundEngine into that field
    //this avoids creating two soundEngine objects which cause clashes due to 2 synthesisers being made
    public KeyHandler(SoundEngine soundEngine) { //constructor for implementing soundEngine, must share same name as class (Java Rule)
        this.soundEngine = soundEngine; //setting our field in line 6 to the soundEngine constructor in the SoundEngine class
    }
    public void setTuneButton(JButton tuneButton){//creating a setter for the tuneButton
        this.tuneButton = tuneButton;
    }

    @Override //creating my own keyPressed methods so I can tailor it towards my own logic
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A && !aHeld) {
            aHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchA = (int)(Math.random() * 128);
            soundEngine.playNote(0, pitchA, velocity);
        }
        if(key == KeyEvent.VK_S && !sHeld){
            sHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchS = (int)(Math.random() * 128);
            soundEngine.playNote(1, pitchS, velocity);
        }
        if(key == KeyEvent.VK_D && !dHeld){
            dHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchD = (int)(Math.random() * 128);
            soundEngine.playNote(2, pitchD, velocity);
        }
        if(key == KeyEvent.VK_F && !fHeld){
            fHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchF = (int)(Math.random() * 128);
            soundEngine.playNote(3, pitchF, velocity);
        }
        if(key == KeyEvent.VK_J && !jHeld){
            jHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchJ = (int)(Math.random() * 128);
            soundEngine.playNote(4, pitchJ, velocity);
        }
        if(key == KeyEvent.VK_K && !kHeld){
            kHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchK = (int)(Math.random() * 128);
            soundEngine.playNote(5, pitchK, velocity);
        }
        if(key == KeyEvent.VK_L && !lHeld){
            lHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchL = (int)(Math.random() * 128);
            soundEngine.playNote(6, pitchL, velocity);
        }
        if(key == KeyEvent.VK_SEMICOLON && !semiHeld){
            semiHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            pitchSemi = (int)(Math.random() * 128);
            soundEngine.playNote(7, pitchSemi, velocity);
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A) {
            aHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(0, pitchA );
        }
        if(key == KeyEvent.VK_S){
            sHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(1, pitchS);
        }
        if(key == KeyEvent.VK_D){
            dHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(2, pitchD);
        }
        if(key == KeyEvent.VK_F){
            fHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(3, pitchF);
        }
        if(key == KeyEvent.VK_J){
            jHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(4, pitchJ);
        }
        if(key == KeyEvent.VK_K){
            kHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(5, pitchK);
        }
        if(key == KeyEvent.VK_L){
            lHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(6, pitchL);
        }
        if(key == KeyEvent.VK_SEMICOLON){
            semiHeld = false; //once key is lifted resets the variable so the logic true again for KeyPressed
            soundEngine.stopNote(7, pitchSemi);
        }
    }
    @Override//must define this method as this interface acts as a contract promising all three methods will be present
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == tuneButton){
            int a = (int)(Math.random() * 100) + 1; //random numbers for eqn
            int b = (int)(Math.random() * 100) + 1;
            String[] ops = {"+", "-", "*"}; //array of operators that can be used
            String op = ops[(int)(Math.random() * 3)]; //picks a random operator to be used
            int answer;
            if(op.equals("+")){ //calculates answer based on operands and operator
                answer = a + b;
            } else if(op.equals("-")){
                answer = a - b;
            } else {
                answer = a * b;
            }

            String input = JOptionPane.showInputDialog(null, "Solve: " + a + "" + op + "" + b + " = ? ");
            if(input != null){
                try {
                    if(Integer.parseInt(input.trim()) == answer){
                        velocity = (int)(Math.random() * 101);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong volumen unchanged");
                    }    
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Input");
                }
            }
        }

    }

}
