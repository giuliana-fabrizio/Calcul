package model;

import java.util.Random;

public class Model {

    public final static Random random = new Random();
    public final static int BOUND = 5000;

    private final ModelEuclide modelEuclide;
    private final ModelPgcd modelPgcd;
    private final ModelPrimalite modelPrimalite;

    public Model() {
        this.modelEuclide = new ModelEuclide();
        this.modelPgcd = new ModelPgcd();
        this.modelPrimalite = new ModelPrimalite();
    }

    public void generate(int nb) {
        if (nb == 1)
            this.modelEuclide.generate();
        if (nb == 2)
            this.modelPgcd.generate();
        if (nb == 3)
            this.modelPrimalite.generate();
    }

    public ModelEuclide getModelEuclide() {
        return this.modelEuclide;
    }

    public ModelPgcd getModelPgcd() {
        return this.modelPgcd;
    }

    public ModelPrimalite getModelPrimalite() {
        return this.modelPrimalite;
    }
}
