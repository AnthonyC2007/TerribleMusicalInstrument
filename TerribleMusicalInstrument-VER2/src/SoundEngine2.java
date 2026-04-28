import javax.sound.midi.*;

public class SoundEngine2 {
    public SoundEngine2() throws Exception
    {
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        channels = synth.getChannels();

        //Assign random instrument to each channel
        for(int i =0; i < 9; i++)//channel 9 is reserved for percusion
        {
            int instr = (int)(Math.random() * 128);
            channels[i].programChange(instr);
        }

        //Assign drone channel
        channels[10].programChange(49);
    }

    public void playNote(int channel, int pitch, int velocity)
    {
        channels[channel].allNotesOff();
        channels[channel].noteOn(pitch, velocity);
    }

    //Only for compatibility, playing a new note stops every currently playing notes
    public void stopNote(int channel, int pitch)
    {
        channels[channel].noteOff(pitch);
    }

    public void playForeverNote()
    {
        channels[10].noteOn(37, 50);
    }

    public void stopForeverNote()
    {
        channels[10].noteOff(37);
    }

    private MidiChannel[] channels;
}