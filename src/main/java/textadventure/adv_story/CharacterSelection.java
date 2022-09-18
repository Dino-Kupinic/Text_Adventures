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
import static textadventure.adv_util.Utility.displayHelp;
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

    public void showCharacterSelectionTitle() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            consoleText.writeText("+-------------------+\n| Character Creator |\n+-------------------+\n",20);
            consoleText.writeText(YELLOW + "\nHere you will see your current stats, simply enter the number you wish to change\n" +
                    "After that simply type \"done\"\n" + ANSI_RESET, 20);
            showCharacterSelection();
        } else {
            // TODO: Translate
            consoleText.writeText("+-------------------+\n| Character Creator |\n+-------------------+\n",20);
            consoleText.writeText(YELLOW + "\nHere you will see your current stats, simply enter the number you wish to change\n" +
                    "After that simply type \"done\"\n" + ANSI_RESET, 20);
            showCharacterSelection();
        }
    }

    public void showCharacterSelection() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);
        String input;
        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            showStats();
            Utility.displayHelp("English");
            do {
                consoleText.writeAction();
                input = scan.nextLine();
                if (input.equals("?")) {
                    playActionSound();
                    Utility.showHelp("English", "CharacterSelect");
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
                    showCharacterSelection();
                }
                case 2 -> {
                    playActionSound();
                    consoleText.writeText(YELLOW + "\nYour age:" + ANSI_RESET, 20);
                    String age;
                    //do {
                        consoleText.writeAction();
                        age = scan.nextLine();
                    //} while (!age.trim().equals("^(0?[1-9]|[1-9][0-9]|[1][1-9][1-9]|200)$"));
                    int playerAge = Integer.parseInt(age);
                    player.setAge(playerAge);
                    showCharacterSelection();
                }
                case 3 -> {
                    playActionSound();
                    chooseOrigin();
                    showCharacterSelection();
                }
                case 4 -> {
                    playActionSound();
                    chooseClass();
                    showCharacterSelection();
                }
                case 5 -> {
                    playActionSound();
                    chooseWeapon();
                    showCharacterSelection();
                }
            }
        } else {
            consoleText.writeText("+---------------------+\n| Charakter Ersteller |\n+---------------------+\n", 20);

            Utility.displayHelp("Deutsch");
        }
    }
    public void chooseOrigin() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);

        consoleText.setSpeaker("normal");
        consoleText.writeText(YELLOW + "Origins: \n\n[Europe]\n[North America]\n[South America]\n[Africa]\n[Asia]\n" + ANSI_RESET, 20);
        String origin;
        do {
            consoleText.writeAction();
            origin = scan.nextLine();
        } while (!origin.equals("Europe") && !origin.equals("North America") && !origin.equals("South America") && !origin.equals("Africa") && !origin.equals("Asia"));
        playActionSound();
        player.setOrigin(origin);
    }

    public void chooseClass() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        ConsoleText consoleText = new ConsoleText();
        Scanner scan = new Scanner(System.in);
        Player player = new Player();

        consoleText.setSpeaker("normal");
        if (Language.getLanguage().equals("English")) {
            String playerOrigin = player.getOrigin();
            switch (playerOrigin) {
                case "Europe" -> {
                    consoleText.writeText(GREEN + "Classes for [Europe]:\n\n[Farmer]\n[Soldier]" + ANSI_RESET, 20);
                }
                case "North America" -> {
                    consoleText.writeText(GREEN + "Classes for [North America]:\n\n[Hunter]\n" + ANSI_RESET, 20);
                }
                case "South America" -> {
                    consoleText.writeText(GREEN + "Classes for [South America]:\n\n[Herb Gatherer]\n", 20);
                }
                case "Africa" -> {
                    consoleText.writeText(GREEN + "Classes for [Africa]:\n\n[Slave]", 20);
                }
                case "Asia" -> {
                    consoleText.writeText(GREEN + "Classes for [Asia]:\n\n[Monk]" + ANSI_RESET, 20);
                }
            }
        }
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
