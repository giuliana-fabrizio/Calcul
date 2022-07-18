package control;

import View.View;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import model.Model;

public class ControlButton extends Control {
    private int var;

    public ControlButton(Model model, View view) {
        super(model, view);
        this.var = 0;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        // ============================================================================================================= valider
        if (actionEvent.getSource() == this.view.getBtn_valider()) {
            boolean reussite = false;

            if (var == 1)
                this.view.alert(Alert.AlertType.WARNING, "Triche", "Vous avez triché 😶");

            else {
                if (this.view.getNb() == 1 && verifEuclide()) {
                    if (this.model.getModelEuclide().verifReponse(this.view.getViewEuclide().getTf_quotient(), this.view.getViewEuclide().getTf_reste()))
                        reussite = true;
                }
                if (this.view.getNb() == 2 && verifPgcd()) {
                    if (this.model.getModelPgcd().verifReponse(this.view.getViewPgcd().getTf_pgcd()))
                        reussite = true;
                }
                if (this.view.getNb() == 3) {
                    boolean reponse = ((RadioButton)this.view.getViewPrimalite().getPrimaire().getToggleGroup().getSelectedToggle()).getText().equals("Premier");
                    if (this.model.getModelPrimalite().verifReponse(reponse))
                        reussite = true;
                }

                if (reussite)
                    this.view.alert(Alert.AlertType.CONFIRMATION, "Bravo", "Vôtre résultat est correct. Bravo !!!");
                else
                    this.view.alert(Alert.AlertType.ERROR, "Echec", "Veuillez ré-essayer.");
            }

        }

        // ============================================================================================================= effacer
        if (actionEvent.getSource() == this.view.getBtn_effacer())
            this.view.clear();

        // ============================================================================================================= resultat
        if (actionEvent.getSource() == this.view.getBtn_resultat()) {
            var = 1;
            if (this.view.getNb() == 1) {
                this.view.getViewEuclide().setTf_quotient(String.valueOf(this.model.getModelEuclide().getQuotient()));
                this.view.getViewEuclide().setTf_reste(String.valueOf(this.model.getModelEuclide().getReste()));
            }

            if (this.view.getNb() == 2)
                this.view.getViewPgcd().setTf_pgcd(String.valueOf(this.model.getModelPgcd().getPgcd()));

            if (this.view.getNb() == 3) {
                if (this.model.getModelPrimalite().isPrimaire())
                    this.view.getViewPrimalite().getPrimaire().setSelected(true);
                else
                    this.view.getViewPrimalite().getPasPrimaire().setSelected(true);
            }
        }

        // ============================================================================================================= nouveau
        if (actionEvent.getSource() == this.view.getBtn_nouveau()) {
            var = 0;
            this.view.clear();
            this.model.generate(this.view.getNb());
            this.view.update(this.view.getNb());
        }
    }

    public boolean verifEuclide() {
        try {
            this.view.getViewEuclide().getTf_quotient();
        } catch (Exception e) {
//            this.view.alert(Alert.AlertType.ERROR, "Erreur de saisie", "Champs quotient invalide.");
            return false;
        }
        try {
            this.view.getViewEuclide().getTf_reste();
        } catch (Exception e) {
//            this.view.alert(Alert.AlertType.ERROR, "Erreur de saisie", "Champs reste invalide.");
            return false;
        }
        return true;
    }

    public boolean verifPgcd() {
        try {
            this.view.getViewPgcd().getTf_pgcd();
        } catch (Exception e) {
//            this.view.alert(Alert.AlertType.ERROR, "Erreur de saisie", "Champs pgcd invalide.");
            return false;
        }
        return true;
    }
}
