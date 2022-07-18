package control;

import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Model;

public class Control implements EventHandler<ActionEvent>  {

    protected Model model;
    protected View view;
    protected int nb;

    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        this.nb = 0;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
