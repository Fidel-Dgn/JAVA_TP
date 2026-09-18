import java.util.ArrayList;

public class Utilisateur {
    String nom;
    String prenom;
    String identifiant;
    Compte compte;
    ArrayList<Velo> velosLoues;

    Utilisateur(String nom, String prenom, String identifiant){
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        velosLoues = new ArrayList<>();
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
