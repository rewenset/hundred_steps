package ua.training;

import ua.training.controllers.Controller;
import ua.training.models.Model;
import ua.training.views.View;


/**
 * Created by Andriy on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        //Initialization
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        //Run
        controller.processUser();
    }
}
