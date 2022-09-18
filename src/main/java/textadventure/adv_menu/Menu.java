package textadventure.adv_menu;

import textadventure.Music;
import textadventure.adv_story.Story;
import textadventure.adv_text.ConsoleText;
import textadventure.adv_util.Utility;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

import static textadventure.adv_text.ConsoleText.*;
import static textadventure.adv_util.Utility.displayHelp;
import static textadventure.adv_util.Utility.playActionSound;

public class Menu {
    public void displayMenu() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);
        Music music = new Music("C:\\dkupinic IntelliJ Projects\\Text_Adventures\\src\\main\\misc\\music\\Menu.wav");
        Story story = new Story();

        String input;
        String gameVersion = "v0.03";

        // TODO: Add Save Game and Load
        // TODO after finishing project: Gather feedback and improve

        music.loop();
        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            consoleText.writeText("+----------------+\n| Text Adventure |\n+----------------+\n", 20);
            consoleText.writeText(GREEN+"\n> Play"+YELLOW+"\n> Options"+ RED+"\n> Exit\n"+ANSI_RESET, 20);
            consoleText.writeText("\nGame version: " + gameVersion, 30);
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                switch (input) {
                    case "Play" -> {
                        music.stop();
                        playActionSound();
                        story.displayPrologue();
                    }
                    case "Options" -> {
                        music.stop();
                        playActionSound();
                        displayOptions();
                    }
                    case "Exit" -> System.exit(0);
                }
            } while (!input.equals("Play") && !input.equals("Options"));
        } else {
            consoleText.writeText("+----------------+\n| Text Abenteuer |\n+----------------+\n", 20);
            consoleText.writeText(GREEN+"\n> Spielen"+YELLOW+"\n> Optionen"+ RED+"\n> Verlassen\n"+ANSI_RESET, 20);
            consoleText.writeText("\nSpielversion: " + gameVersion, 30);
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                switch (input) {
                    case "Spielen" -> {
                        music.stop();
                        playActionSound();
                        story.displayPrologue();
                    }
                    case "Optionen" -> {
                        music.stop();
                        playActionSound();
                        displayOptions();
                    }
                    case "Verlassen" -> System.exit(0);
                }
            } while (!input.equals("Spielen") && !input.equals("Optionen"));
        }
    }

    public void displayOptions() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);

        String input;
        consoleText.setSpeaker("normal");

        if (Language.getLanguage().equals("English")) {
            consoleText.writeText(YELLOW + "\nLanguage: "+ ANSI_RESET + Language.getLanguage() +"\n", 40);
            displayHelp("English");
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                if (input.equals("?")) {
                    playActionSound();
                    Utility.showHelp("English");
                }
                if (input.equals("de")) {
                    playActionSound();
                    Language.setLanguage("Deutsch");
                    consoleText.writeText("language changed to: " + Language.getLanguage() + "\n", 40);
                }
            } while (!input.equals("close"));
            playActionSound();
        } else {
            consoleText.writeText(YELLOW + "\nSprache: " + ANSI_RESET + Language.getLanguage() +"\n", 40);
            displayHelp("Deutsch");
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                if (input.equals("?")) {
                    playActionSound();
                    Utility.showHelp("Deutsch");
                }
                if (input.equals("en")) {
                    playActionSound();
                    Language.setLanguage("English");
                    consoleText.writeText("language changed to: " + Language.getLanguage() + "\n", 40);
                }
            } while (!input.equals("Verlassen"));
            playActionSound();
        }
        Utility.clearConsole();
        displayMenu();
    }
}
