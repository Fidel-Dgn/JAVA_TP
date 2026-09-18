package juliaset;

public class Complexe {
    private double reel;
    private double imaginaire;

    public Complexe(double reel, double imaginaire) {
        this.reel = reel;
        this.imaginaire = imaginaire;
    }

    public Complexe addition(Complexe autre) {
        return new Complexe(this.reel + autre.reel, this.imaginaire + autre.imaginaire);
    }

    public Complexe multiplication(Complexe autre) {
        double r = this.reel * autre.reel - this.imaginaire * autre.imaginaire;
        double i = this.reel * autre.imaginaire + this.imaginaire * autre.reel;
        return new Complexe(r, i);
    }

    public double module() {
        return Math.sqrt(reel * reel + imaginaire * imaginaire);
    }

    @Override
    public String toString() {
        return reel + " + " + imaginaire + "i";
    }
}