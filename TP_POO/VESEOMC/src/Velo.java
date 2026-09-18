import java.util.ArrayList;

public class Velo {
    String empreinte;
    double distanceGSM = 0.0;
    String antenneGSM = "";
    boolean disponible = true;
    ArrayList<Utilisateur> loueurs;

    Velo(String empreinte){
        this.empreinte = empreinte;
        loueurs = new ArrayList<>();
    }

    public String getEmpreinte() {
        return empreinte;
    }

    public void setEmpreinte(String empreinte) {
        this.empreinte = empreinte;
    }

    public double getDistanceGSM() {
        return distanceGSM;
    }

    public void setDistanceGSM(double distanceGSM) {
        this.distanceGSM = distanceGSM;
    }

    public String getAntenneGSM() {
        return antenneGSM;
    }

    public void setAntenneGSM(String antenneGSM) {
        this.antenneGSM = antenneGSM;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getPosition() {
        return getAntenneGSM()+getDistanceGSM();
    }
}
