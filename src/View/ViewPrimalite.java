package View;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Model;

public class ViewPrimalite {

    private final Model model;
    private GridPane gridPane;
    private TextField nbre;
    private ToggleGroup toggleGroup;
    private RadioButton primaire, pasPrimaire;

    public ViewPrimalite(Model model) {
        this.model = model;
        this.init();
        this.addToScene();
    }

    public void clear() {
        this.primaire.setSelected(true);
    }

    public void init() {
        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setHgap(10);
        this.gridPane.setHgap(10);

        this.nbre = new TextField("");
        this.nbre.setEditable(false);

        this.toggleGroup = new ToggleGroup();

        this.primaire = new RadioButton("Premier");
        this.primaire.setSelected(true);
        this.pasPrimaire = new RadioButton("Pas premier");

        this.primaire.setToggleGroup(toggleGroup);
        this.pasPrimaire.setToggleGroup(toggleGroup);
    }

    public void update() {
        this.nbre.setText(String.valueOf(this.model.getModelPrimalite().getNb()));
    }

    public void addToScene() {
        this.gridPane.add(this.nbre, 1, 0);
        this.gridPane.add(this.primaire, 0, 1);
        this.gridPane.add(this.pasPrimaire, 2, 1);
    }

    public GridPane getGridPane() {
        return this.gridPane;
    }

    public RadioButton getPrimaire() {
        return this.primaire;
    }

    public RadioButton getPasPrimaire() {
        return this.pasPrimaire;
    }
}
