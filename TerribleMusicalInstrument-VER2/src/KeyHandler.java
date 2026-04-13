import java.awt.event.*;//importing all java abstract window toolkit event libraries


public class KeyHandler implements KeyListener{ //KeyListener acts like a contract so it expects all three methods to be present

    private SoundEngine soundEngine;//creating a field for the sound engine
    private int pitchA, pitchS;
    private boolean aHeld = false, sHeld = false;//this will be used so the note will last for the duration of the key being held
    //passes in the SoundEngine into that field
    //this avoids creating two soundEngine objects which cause clashes due to 2 synthesisers being made
    public KeyHandler(SoundEngine soundEngine) { //constructor for implementing soundEngine, must share same name as class (Java Rule)
        this.soundEngine = soundEngine; //setting our field in line 6 to the soundEngine constructor in the SoundEngine class
    }

    @Override //creating my own keyPressed methods so I can tailor it towards my own logic
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A && !aHeld) {
            aHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            int pitchA = (int)(Math.random() * 128);
            int velocity = (int)(Math.random() * 101);
            soundEngine.playNote(0, pitchA, velocity);
        }
        if(key == KeyEvent.VK_S && !sHeld){
            sHeld = true; //this will stop the method repeating when the Key is pressed down, now acts like a real piano
            int pitchS = (int)(Math.random() * 128);
            int velocity = (int)(Math.random() * 101);
            soundEngine.playNote(1, pitchS, velocity);
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
    }
    @Override//must define this method as this interface acts as a contract promising all three methods will be present
    public void keyTyped(KeyEvent e){

    }

}
