package View;

public class MenuTemplates {
    static String text;


    public MenuTemplates(String textMenu) {
        text = textMenu;

    }

    /**
     * the method of printing the menu header
     **/
    static void printMenuTitle(String textMenu) {
        text = textMenu;
        System.out.println(
                "==========================================\n" +
                        "          " + text + ":\n" +
                        "==========================================");
    }

    static void printMenuBody(String textMenu) {
        text = textMenu;
        System.out.println(text);
    }


    /**
     * the method of printing the dividing line of the menu
     **/
    static void printMenuLine() {
        System.out.println("" +
                "==========================================");
    }


    /**
     * response format method
     **/
    static void printResponseTemplate(String textMenu) {
        text = textMenu;
        System.out.println(
                "-----------" + text + "------------"
        );
    }
}

