package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Model;

public class ViewPgcd {

    private final Model model;
    private GridPane gridPane;
    private int grand, petit;
    private TextField tf_pgcd;
    private Label phrase;

    public ViewPgcd(Model model) {
        this.model = model;
        this.init();
        this.addToScene();
    }

    public void clear() {
        this.tf_pgcd.setText("");
    }

    public void init() {
        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);

        this.grand = 0;
        this.petit = 0;

        this.tf_pgcd = new TextField("");

        this.phrase = new Label("PGCD ("+this.grand+" ; "+this.petit+" ) = ");
    }

    public void update() {
        this.grand = this.model.getModelPgcd().getGrand();
        this.petit = this.model.getModelPgcd().getPetit();
        this.phrase.setText("PGCD ("+this.grand+" ; "+this.petit+" ) = ");
    }

    public void addToScene() {
        this.gridPane.add(this.phrase, 0, 0);
        this.gridPane.add(this.tf_pgcd, 1, 0);
    }

    public GridPane getGridPane() {
        return this.gridPane;
    }

    public int getTf_pgcd() {
        return Integer.parseInt(this.tf_pgcd.getText());
    }

    public void setTf_pgcd(String tf_pgcd) {
        this.tf_pgcd.setText(tf_pgcd);
    }
}
