package View;

import control.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Model;

public class View extends Stage {

    private final Model model;
    private GridPane gridPane, gridPane_btn;
    private Menu menu;
    private MenuBar menuBar;
    private MenuItem euclide, pgcd, primalite;
    private Button btn_valider, btn_effacer, btn_resultat, btn_nouveau;

    private int nb;

    private final ViewEuclide viewEuclide;
    private final ViewPgcd viewPgcd;
    private final ViewPrimalite viewPrimalite;

    public View(Model model) {
        this.model = model;
        this.viewEuclide = new ViewEuclide(this.model);
        this.viewPgcd = new ViewPgcd(this.model);
        this.viewPrimalite = new ViewPrimalite(this.model);

        this.nb = 0;

        this.setTitle("Révisions maths");
        this.initMenu();
        this.init();
        this.addListenners();
        this.addToSceneCalcul(this.nb);
        this.display();
    }

    public void update(int nb) {
        this.nb = nb;
        if (this.nb == 1)
            this.viewEuclide.update();
        if (this.nb == 2)
            this.viewPgcd.update();
        if (this.nb == 3)
            this.viewPrimalite.update();
    }

    public void alert(Alert.AlertType alertType, String title, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public void clear() {
        this.viewEuclide.clear();
        this.viewPgcd.clear();
        this.viewPrimalite.clear();
    }

    public void initMenu() {
        this.menu = new Menu("Menu 😃");
        this.euclide = new MenuItem("Division Euclidienne");
        this.pgcd = new MenuItem("PGCD");
        this.primalite = new MenuItem("Test de primalité");

        this.menu.getItems().addAll(this.euclide, this.pgcd, this.primalite);
        this.menuBar = new MenuBar(this.menu);
    }

    public void init() {
        this.gridPane_btn = new GridPane();
        this.gridPane_btn.setAlignment(Pos.CENTER);
        this.gridPane_btn.setHgap(20);
        this.gridPane_btn.setVgap(20);

        this.btn_valider = new Button("Valider");
        this.btn_valider.setStyle("-fx-background-color: #86ce86; -fx-background-radius: 10px; -fx-border-color: #035203; -fx-border-radius: 10px");
        this.btn_effacer = new Button("Effacer");
        this.btn_effacer.setStyle("-fx-background-color: #fd5050; -fx-background-radius: 10px; -fx-border-color: #6e0000; -fx-border-radius: 10px");
        this.btn_resultat = new Button("Résultat");
        this.btn_resultat.setStyle("-fx-background-color: #eeb0da; -fx-background-radius: 10px; -fx-border-color: #930065; -fx-border-radius: 10px");
        this.btn_nouveau = new Button("Nouveau");
        this.btn_nouveau.setStyle("-fx-background-color: #c9c9c9; -fx-background-radius: 10px; -fx-border-color: #595959; -fx-border-radius: 10px");
    }

    public void addListenners() {
        ControlMenu controlMenu = new ControlMenu(this.model, this);
        this.euclide.setOnAction(controlMenu);
        this.pgcd.setOnAction(controlMenu);
        this.primalite.setOnAction(controlMenu);

        ControlButton controlButton = new ControlButton(this.model, this);
        this.btn_valider.setOnAction(controlButton);
        this.btn_effacer.setOnAction(controlButton);
        this.btn_resultat.setOnAction(controlButton);
        this.btn_nouveau.setOnAction(controlButton);
    }

    public void addToSceneCalcul(int nb) {
        this.nb = nb;

        VBox vbox = new VBox(this.menuBar);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(5);

        this.gridPane = new GridPane();
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);

        if (this.nb == 0) {
            this.gridPane_btn.add(this.btn_valider, 0, 1);
            this.gridPane_btn.add(this.btn_effacer, 1, 1);
            this.gridPane_btn.add(this.btn_resultat,2, 1);
            this.gridPane_btn.add(this.btn_nouveau, 3, 1);
        }

        else {
            this.initFramework();

            if (this.nb == 1)
                this.gridPane.add(this.viewEuclide.getGridPane_tf(), 0, 0);
            if (this.nb == 2)
                this.gridPane.add(this.viewPgcd.getGridPane(), 0, 0);
            if (this.nb == 3)
                this.gridPane.add(this.viewPrimalite.getGridPane(), 0, 0);
            this.gridPane.add(this.gridPane_btn, 0, 1);
        }

        vbox.getChildren().add(this.gridPane);

        Scene scene = new Scene(vbox);
        this.setScene(scene);
    }

    public void initFramework() {
        this.gridPane.setStyle("-fx-background-color: #024d4f, -fx-background ;" +
                " -fx-background-insets: 4, 5 ;" +
                " -fx-padding : 10 ;");
    }

    public void display() {
        this.show();
    }

    public int getNb() {
        return this.nb;
    }

    public ViewEuclide getViewEuclide() {
        return this.viewEuclide;
    }

    public ViewPgcd getViewPgcd() {
        return this.viewPgcd;
    }

    public ViewPrimalite getViewPrimalite() {
        return this.viewPrimalite;
    }

    public MenuItem getEuclide() {
        return this.euclide;
    }

    public MenuItem getPgcd() {
        return this.pgcd;
    }

    public Button getBtn_valider() {
        return this.btn_valider;
    }

    public Button getBtn_effacer() {
        return this.btn_effacer;
    }

    public Button getBtn_resultat() {
        return this.btn_resultat;
    }

    public Button getBtn_nouveau() {
        return this.btn_nouveau;
    }
}
