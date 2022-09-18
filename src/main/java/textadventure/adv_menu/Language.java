package textadventure.adv_menu;

public class Language {
    private static String language = "English";

    public static void setLanguage(String language) {
        Language.language = language;
    }

    public static String getLanguage() {
        return Language.language;
    }
}
