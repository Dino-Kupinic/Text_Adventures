package textadventure.adv_util;

import textadventure.Music;
import textadventure.adv_menu.Menu;
import textadventure.adv_text.ConsoleText;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

import static textadventure.adv_text.ConsoleText.*;

public class Utility {
    public static void sleepThread(int time) throws InterruptedException {
        Thread.sleep(time);
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void playActionSound() {
        Music music = new Music("C:\\dkupinic IntelliJ Projects\\Text_Adventures\\src\\main\\misc\\sfx\\userinput.wav");
        music.start();
    }

    public static void displayHelp(String language) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ConsoleText consoleText = new ConsoleText();
        consoleText.setSpeaker("normal");
        if (language.equals("English")) {
            consoleText.writeText("\n\"?\" for help\n", 40);
        } else {
            consoleText.writeText("\n\"?\" fuer Hilfe\n", 40);
        }
    }


    // TODO: Implement full help catalog for en de
    public static void showHelp(String language) throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        String input;

        consoleText.setSpeaker("normal");
        if (language.equals("English")) {
            do {
                consoleText.writeText(BLUE + "\n[1] Navigation" + ANSI_RESET, 15);
                consoleText.writeText(BLUE + "\n[2] Items" + ANSI_RESET, 15);
                consoleText.writeText(BLUE + "\n[3] Player" + ANSI_RESET, 15);
                consoleText.writeAction();
                input = scan.nextLine();
            } while (!input.trim().matches("^\\d$") && !input.equals("close"));
            playActionSound();
            if (input.trim().matches("^\\d$")) {
                int inputSwitch = Integer.parseInt(input);
                switch (inputSwitch) {
                    case 1:
                        consoleText.writeText("type \"en\" or \"de\" in Options to change language\n" +
                                "type \"close\" to return one menu\n", 20);
                        do {
                            consoleText.writeAction();
                            input = scan.nextLine();
                        } while (!input.equals("close"));
                        break;
                    case 2:
                        break;
                }
            }
        } else {
            do {
                consoleText.writeText(BLUE + "\n[1] Navigation" + ANSI_RESET, 15);
                consoleText.writeText(BLUE + "\n[2] Gegenstände" + ANSI_RESET, 15);
                consoleText.writeText(BLUE + "\n[3] Spieler" + ANSI_RESET, 15);
                consoleText.writeAction();
                input = scan.nextLine();
            } while (!input.trim().matches("^\\d$") && !input.equals("Verlassen"));
            playActionSound();
            if (input.trim().matches("^\\d$")) {
                int inputSwitch = Integer.parseInt(input);
                switch (inputSwitch) {
                    case 1:
                        consoleText.writeText("Schreibe \"en\" oder \"de\" in den Optionen um die Sprache zu ändern\n" +
                                "Schreibe \"Verlassen\" um ein Menu zurückzukehren\n", 20);
                        do {
                            consoleText.writeAction();
                            input = scan.nextLine();
                        } while (!input.equals("close"));
                        break;
                    case 2:
                        break;
                }
            }
        }
        clearConsole();
        menu.displayOptions();
    }
}
