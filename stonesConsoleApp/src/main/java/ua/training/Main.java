package ua.training;

import ua.training.model.Necklace;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        //Initialization
        View view = new View();
        Necklace model = new Necklace();
        Controller controller = new Controller(model, view);
        //Run
        controller.processUser();
    }
}
