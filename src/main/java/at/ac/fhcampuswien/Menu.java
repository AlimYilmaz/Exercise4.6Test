package at.ac.fhcampuswien;

public class Menu {

    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "Invalid input! Please choose a valid option!";
    private static final String EXIT_MESSAGE = "Thank you for using our service! Bye!";

    public void start() {
        Menu.printMenu();
    }
     private void handleInputString(String input) {
       throw new UnsupportedOperationException("Not implemented yet");
}


    private void getArticleCount(AppController ctrl) {

    }

    private void getTopHeadlinesAustria(AppController ctrl) {

    }

    private void getAllNewsBitcoin(AppController ctrl) {

    }

    public static void printMenu() {

        System.out.println("**************************");
        System.out.println("*   Welcome to NewsApp   *");
        System.out.println("**************************");
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines Austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }

    private static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}