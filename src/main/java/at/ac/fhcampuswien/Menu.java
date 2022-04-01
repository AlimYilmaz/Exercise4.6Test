package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {

    private AppController controller = new AppController();                     // controller that will be used to handle all requests for our app
    private static final String INVALID_INPUT_MESSAGE = "Invalid input! Please choose a valid option!";
    private static final String EXIT_MESSAGE = "Thank you for using our service! Bye!";


    // prints Menu and lets you put in your option.
    public void start() {
        printMenu();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();                                      // waits on the input

        while (true){
            if (input.equals("q")){
                handleInputString(input);                                       // carries out the case for "q"
                break;                                                          // ends the endless loop
            }
            handleInputString(input);                                           // carries out the cases for everything but for "q"
            start();                                                            // restarts menu
            break;                                                              // ends the endless loop
        }
    }


    private void handleInputString(String input) {

        switch (input) {

            case "a":
                getTopHeadlinesAustria(controller);
                break;
            case "b":
                getAllNewsBitcoin(controller);
                break;
            case "y":
                getArticleCount(controller);
                break;
            case "q":
                printExitMessage();
                System.exit(0);                                            // to end the program
            default:                                                             // if an invalid letter is chosen
                printInvalidInputMessage();
        }
    }


    private void getArticleCount(AppController ctrl) {
        int numOfArticles = ctrl.getArticleCount();
        String out  = "Number of articles = " + numOfArticles;
        System.out.println(out);
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(ctrl.getTopHeadlinesAustria().toString());
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println(ctrl.getAllNewsBitcoin().toString());
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