package model;

public class ModelPgcd {

    private int grand;
    private int petit;
    private int pgcd;

    public ModelPgcd() {
        this.grand = 0;
        this.petit = 0;
        this.pgcd = 0;
    }

    public void generate() {
        this.grand = Model.random.nextInt(-Model.BOUND, Model.BOUND);
        this.petit = Model.random.nextInt(-Model.BOUND, Model.BOUND);

        if (abs(this.grand) < abs(this.petit)) {
            int var = this.grand;
            this.grand = this.petit;
            this.petit = var;
        }

        if (this.petit == 0)
            this.petit ++;

        this.pgcd = abs(this.petit);
        this.pgcd = reponse();
    }

    public int reponse() {
        while (this.pgcd > 0 && !((this.grand % this.pgcd == 0) && (this.petit % this.pgcd == 0)))
            this.pgcd --;
        return this.pgcd;
    }

    public int abs(int nb) {
        if (nb < 0)
            return -nb;
        return nb;
    }

    public boolean verifReponse(int nb) {
        return this.pgcd == nb;
    }

    public int getGrand() {
        return this.grand;
    }

    public int getPetit() {
        return this.petit;
    }

    public int getPgcd() {
        return this.pgcd;
    }
}
