import javax.sound.midi.*;

public class SoundEngine {

    private MidiChannel[] channels; //declaring are private channels for the sound Engine

    public SoundEngine() throws Exception{//creating a constructor to set up the synthesiser

        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        channels = synth.getChannels();
        MidiChannel droneChannel = channels[2];
        droneChannel.programChange(49);//changes instrument
        droneChannel.noteOn(37, 50);//note plays forever in background
    }
    public void playNote(int channelIndex, int pitch, int velocity){//creating a general method for midi channels instead of hard coding
        channels[channelIndex].noteOn(pitch, velocity);
    }
    public void stopNote(int channelIndex, int pitch){//creating a general method for stopping channels instead of hard coding
        channels[channelIndex].noteOff(pitch);
    }
}
