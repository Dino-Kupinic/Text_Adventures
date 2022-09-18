package textadventure;

import textadventure.adv_menu.*;
import javax.sound.sampled.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Menu menu = new Menu();

        menu.displayMenu();
    }
}
