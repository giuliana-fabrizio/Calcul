package model;

public class ModelPrimalite {

    private int nb;
    private boolean primaire;

    public ModelPrimalite() {
        this.nb = 0;
        this.primaire = true;
    }

    public void generate() {
        this.nb = Model.random.nextInt(-Model.BOUND, Model.BOUND);
        this.primaire = nbPrimaire(this.nb);
    }

    public boolean nbPrimaire(int nb) {
        if (nb % 2 == 0)
            return false;
        for (int i = 3; i < Math.sqrt(abs(nb))+1; i+=2) {
            if (abs(nb) % i == 0 && abs(nb) != i)
                return false;
        }
        return true;
    }

    public int abs(int nb) {
        if (nb < 0)
            return -nb;
        return nb;
    }

    public boolean verifReponse(boolean primaire) {
        return this.primaire == primaire;
    }

    public int getNb() {
        return this.nb;
    }

    public boolean isPrimaire() {
        return this.primaire;
    }
}
