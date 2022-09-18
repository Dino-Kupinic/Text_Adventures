package textadventure.adv_story;

import textadventure.adv_menu.Language;
import textadventure.adv_player.Player;
import textadventure.adv_text.ConsoleText;
import textadventure.adv_util.Utility;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

import static textadventure.adv_text.ConsoleText.*;
import static textadventure.adv_util.Utility.playActionSound;

public class CharacterSelection {
    Player player = new Player();
    public void displayCharacterSelection() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();

        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            consoleText.writeText("+-------------------+\n| Character Creator |\n+-------------------+\n" +
                    "\nHere you will create your playable character!" + RED +
                    "\n\n!! Keep in mind some of these stats will not be changeable later on !!" + ANSI_RESET, 20);
        } else {
            consoleText.writeText("+---------------------+\n| Charakter Ersteller |\n+---------------------+\n" +
                    "\nHier wirst du deinen spielbaren Charakter erstellen!" + RED +
                    "\n\n!! Vergiss nicht, dass manche Dinge später nicht geändert werden können !!" + ANSI_RESET, 20);
        }
        Utility.sleepThread(5000);
        Utility.clearConsole();
    }

    // TODO: Finish Character Selection and translate

    public void showCharacterSelection() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);
        String input;
        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            consoleText.writeText("+-------------------+\n| Character Creator |\n+-------------------+\n",20);
            consoleText.writeText(YELLOW + "\nHere you will see your current stats, simply enter the number you wish to change\n" +
                    "After that simply type \"done\"\n" + ANSI_RESET, 20);
            showStats();
            Utility.displayHelp("English");
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                if (input.equals("?")) {
                    playActionSound();
                    Utility.showHelp("English");
                }
            } while (!input.trim().matches("^[1-5]$") && !input.equals("done"));
            int inputSwitch = Integer.parseInt(input);
            switch (inputSwitch) {
                case 1 -> {
                    playActionSound();
                    consoleText.writeText(YELLOW + "\nYour name:" + ANSI_RESET, 20);
                    consoleText.writeAction();
                    String name = scan.nextLine();
                    player.setName(name);
                    showStats();
                }
                case 2 -> {
                    playActionSound();
                    consoleText.writeText(YELLOW + "\nYour age:" + ANSI_RESET, 20);
                    String age;
                    do {
                        consoleText.writeAction();
                        age = scan.nextLine();
                    } while (!age.trim().equals("\\d"));
                    int playerAge = Integer.parseInt(age);
                    player.setAge(playerAge);
                    showStats();
                }
                case 3 -> {
                    playActionSound();
                    chooseOrigin();
                    showStats();
                }
                case 4 -> {
                    playActionSound();
                    chooseClass();
                    showStats();
                }
                case 5 -> {
                    playActionSound();
                    chooseWeapon();
                    showStats();
                }
            }
        } else {
            consoleText.writeText("+---------------------+\n| Charakter Ersteller |\n+---------------------+\n", 20);

            Utility.displayHelp("Deutsch");
        }
    }

    public void chooseOrigin() {

    }

    public void chooseClass() {

    }

    public void chooseWeapon() {

    }

    public void showStats() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ConsoleText consoleText = new ConsoleText();
        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            consoleText.writeText(MAGENTA + "\n[1] Name : " + player.getName() + ANSI_RESET, 20);
            consoleText.writeText(MAGENTA + "\n[2] Age : " + player.getAge() + ANSI_RESET, 20);
            consoleText.writeText(MAGENTA + "\n[3] Origin : " + player.getOrigin() + ANSI_RESET, 20);
            consoleText.writeText(MAGENTA + "\n[4] Class : " + player.getRole() + ANSI_RESET, 20);
            consoleText.writeText(MAGENTA + "\n[5] Weapon : " + player.getStarterWeapon() + ANSI_RESET + "\n", 20);
        }
    }
}
