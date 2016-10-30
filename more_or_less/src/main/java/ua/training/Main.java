package ua.training;

/**
 * Contains entry point of the game.
 * Initialize model, view and controller and run the game.
 *
 * @author Andriy Zakurenyi
 */
public class Main {
    public static void main(String[] args) {
        //Initialization
        View view = new View();
        Model model = new Model(view);
        Controller controller = new Controller(model, view);
        //Run
        controller.processUser();
    }
}
