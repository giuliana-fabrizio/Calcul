package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Model;

public class ViewEuclide {
    private final Model model;
    private GridPane gridPane_tf;
    private TextField tf_dividende, tf_diviseur, tf_quotient, tf_reste;
    private Label egal, mult, add;

    public ViewEuclide(Model model) {
        this.model = model;
        this.init();
        this.addToScene();
    }

    public void clear() {
        this.setTf_quotient("");
        this.setTf_reste("");
    }

    private void init() {
        this.gridPane_tf = new GridPane();
        this.gridPane_tf.setAlignment(Pos.CENTER);
        this.gridPane_tf.setHgap(10);
        this.gridPane_tf.setVgap(10);

        this.tf_dividende = new TextField("");
        this.tf_dividende.setEditable(false);
        this.tf_diviseur = new TextField("");
        this.tf_diviseur.setEditable(false);

        this.tf_quotient = new TextField("");
        this.tf_reste = new TextField("");

        this.egal = new Label("=");
        this.mult = new Label("x");
        this.add = new Label("+");
    }

    public void update() {
        this.tf_dividende.setText(String.valueOf(this.model.getModelEuclide().getDividende()));
        this.tf_diviseur.setText(String.valueOf(this.model.getModelEuclide().getDiviseur()));
    }

    public void addToScene() {
        this.gridPane_tf.add(this.tf_dividende, 0, 0);
        this.gridPane_tf.add(this.egal, 1, 0);
        this.gridPane_tf.add(this.tf_diviseur, 2, 0);
        this.gridPane_tf.add(this.mult, 3, 0);
        this.gridPane_tf.add(this.tf_quotient, 4, 0);
        this.gridPane_tf.add(this.add, 5, 0);
        this.gridPane_tf.add(this.tf_reste, 6, 0);
    }

    public GridPane getGridPane_tf() {
        return this.gridPane_tf;
    }

    public int getTf_quotient() {
        return Integer.parseInt(tf_quotient.getText());
    }

    public void setTf_quotient(String tf_quotient) {
        this.tf_quotient.setText(tf_quotient);
    }

    public int getTf_reste() {
        return Integer.parseInt(tf_reste.getText());
    }

    public void setTf_reste(String tf_reste) {
        this.tf_reste.setText(tf_reste);
    }
}
