import java.io.File;

import javax.sound.sampled.*;

public class Sound {

    public static void playSound(String audioFile) {
        File file = new File(audioFile);

        Clip clip = null;
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
        } catch (Exception e){
            e.printStackTrace();
        }

        if (clip != null) {
            clip.start();
            while (!clip.isRunning()) {
                // Menunggu hingga klip dimulai
                Thread.yield();
            }
            while (clip.isRunning()) {
                // Menunggu hingga klip selesai
                Thread.yield();
            }
            clip.close();
        }
    }
}