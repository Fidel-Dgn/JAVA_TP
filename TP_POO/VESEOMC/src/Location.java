public class Location {
    String numeroCarteUtilisateur;
    String positionVelo;

    Location(String numero, String position){
        this.numeroCarteUtilisateur = numero;
        this.positionVelo = position;
    }

    public String getNumeroCarteUtilisateur() {
        return numeroCarteUtilisateur;
    }

    public void setNumeroCarteUtilisateur(String numeroCarteUtilisateur) {
        this.numeroCarteUtilisateur = numeroCarteUtilisateur;
    }

    public String getPositionVelo() {
        return positionVelo;
    }

    public void setPositionVelo(String positionVelo) {
        this.positionVelo = positionVelo;
    }
}
