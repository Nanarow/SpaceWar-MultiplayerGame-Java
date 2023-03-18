package Client.Utility;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
    private AudioInputStream audioInputStream;
    private FloatControl volume;
    private Clip clip;
    private File file;
    public Sound(String pathname) {
        try{
            file = new File(pathname);
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ignore) {
        }
    }
    public void start(){
        clip.start();
    }
    public void reset(){
        clip.setMicrosecondPosition(0);
    }
    public void stop(){
        clip.stop();
    }
    public void close(){
        clip.close();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void setVolume(float value){
        volume.setValue(value);
    }
    public float getVolume() {
        return volume.getValue();
    }
    public long length(){
        return clip.getMicrosecondLength();
    }
}
