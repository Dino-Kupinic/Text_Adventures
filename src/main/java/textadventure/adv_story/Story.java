package textadventure.adv_story;

import textadventure.adv_menu.Language;
import textadventure.adv_text.ConsoleText;
import textadventure.adv_util.Utility;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static textadventure.adv_text.ConsoleText.ANSI_RESET;
import static textadventure.adv_text.ConsoleText.YELLOW;

public class Story {
    public void displayPrologue() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        ConsoleText consoleText = new ConsoleText();
        CharacterSelection characterSelection = new CharacterSelection();
        consoleText.setSpeaker("normal");

        if (Language.getLanguage().equals("English")) {
            consoleText.writeText("\nWelcome to Text Adventure!", 30);
            consoleText.writeText("\nThis is a" + YELLOW + " text-based RPG " + ANSI_RESET +
                    "where you explore a mysterious world and defeat enemies!\n" + YELLOW +
                    "\nMade in Java by Dino Kupinic" + ANSI_RESET, 20);
            Utility.sleepThread(4000);
            Utility.clearConsole();
            consoleText.writeText("+----------+\n| Prologue |\n+----------+\n", 20);
            consoleText.writeText("\n...\n", 450);
            consoleText.writeText("Uhhh we forgot to create a character! Hurry up and create one first...", 50);

        } else {
            consoleText.writeText("\nWillkommen zum Text Abenteuer!", 30);
            consoleText.writeText("\nEs ist ein " + YELLOW + " text-basiertes RPG " + ANSI_RESET +
                    "in welchem man eine mysteriöse Welt entdeckt und Monster bekämpft!\n" + YELLOW +
                    "\nErstellt in Java von Dino Kupinic" + ANSI_RESET, 20);
            Utility.sleepThread(4000);
            Utility.clearConsole();
            consoleText.writeText("+--------+\n| Prolog |\n+--------+\n", 20);
            consoleText.writeText("\n...\n", 450);
            consoleText.writeText("Ehmmm wir haben vergessen einen Charakter zu erstellen! Beeil dich und erstell einen...", 50);
        }
        Utility.sleepThread(3000);
        Utility.clearConsole();
        characterSelection.displayCharacterSelection();
        characterSelection.showCharacterSelection();
    }
}
