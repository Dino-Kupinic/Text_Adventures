package textadventure.adv_text;


import textadventure.adv_menu.Language;
import textadventure.adv_util.Utility;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ConsoleText {
    public static final String  ANSI_RESET          = "\u001B[0m";  // RESET COLORS
    public static final String	GREEN				= "\u001B[32m"; // HEAL / POSITIVE
    public static final String	RED					= "\u001B[31m"; // DAMAGE / NEGATIVE
    public static final String	YELLOW				= "\u001B[33m"; // HP
    public static final String	BLUE				= "\u001B[34m"; // PLAYER ACTIONS
    public static final String	MAGENTA				= "\u001B[35m"; // PLAYER STATS
    public static final String	CYAN				= "\u001B[36m"; // ACTIONS
    private String speaker;
    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public void writeText(String message, int messageSpeed) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        AudioInputStream audioStream;
        Clip clip = AudioSystem.getClip();

        switch (speaker) {
            case "normal" -> {
                File speakerNormal = new File("C:\\dkupinic IntelliJ Projects\\Text_Adventures\\src\\main\\misc\\sfx\\speakerNormal.wav");
                audioStream = AudioSystem.getAudioInputStream(speakerNormal);
                clip.open(audioStream);
            }
            case "menu" -> {
                File speakerMenu = new File("C:\\dkupinic IntelliJ Projects\\Text_Adventures\\src\\main\\misc\\sfx\\speakerMenu.wav");
                audioStream = AudioSystem.getAudioInputStream(speakerMenu);
                clip.open(audioStream);
            }
        }

        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
            try {
                if (i == ' ') {
                    Utility.sleepThread(300);
                } else {
                    Utility.sleepThread(messageSpeed);
                }
                clip.start();
                clip.loop(message.length());
            } catch (Exception e) {
                e.printStackTrace();
            }
            clip.setMicrosecondPosition(0);
        }
        clip.stop();
    }

    public void writeAction() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (Language.getLanguage().equals("English")) {
            writeText(CYAN + "\nAction >>> " + ANSI_RESET, 40);
        } else {
            writeText(CYAN + "\nAuswahl >>> " + ANSI_RESET, 40);
        }
    }
}
