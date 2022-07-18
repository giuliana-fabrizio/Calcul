import View.View;
import control.Control;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Model;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View(model);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
