package control;

import View.View;
import javafx.event.ActionEvent;
import model.Model;

public class ControlMenu extends Control {

    public ControlMenu(Model model, View view) {
        super(model, view);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == this.view.getEuclide())
            this.nb = 1;
        else if (actionEvent.getSource() == this.view.getPgcd())
            this.nb = 2;
        else
            this.nb = 3;

        this.model.generate(this.nb);
        this.view.update(this.nb);
        this.view.addToSceneCalcul(this.nb);
    }
}
