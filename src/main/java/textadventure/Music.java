package textadventure;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {
    private final Clip clipMusic;

    public Music(String filename){
        File audioPlayer = new File(filename);
        AudioInputStream audioStream;
        try{
            audioStream = AudioSystem.getAudioInputStream(audioPlayer);
            clipMusic = AudioSystem.getClip();
            clipMusic.open(audioStream);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public void start(){
        clipMusic.start();
    }

    public void loop(){
        clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clipMusic.stop();
    }
}
