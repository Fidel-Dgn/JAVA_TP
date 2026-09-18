import java.util.ArrayList;

/**
 * Classe principale du système
 */
class VESEO {

    ArrayList<Velo> velos = new ArrayList<>();
    ArrayList<Utilisateur> cyclistes = new ArrayList<>();
    ArrayList<Location> locations = new ArrayList<>();

    Velo tempVelo; // Pour stocker le vélo concerné par la demande de location
    Utilisateur tempUtilisateur; // Pour stocker l'utilisateur qui fait la demande de location
    Compte tempCompte; // Pour stocker le compte lié à l'utilisateur

    /**
     * Methode principale du système pour simuler la location de vélo.
     */
    public static void main(String[] args){
        VESEO veseo = new VESEO();
        veseo.initialiserDonnees();
        veseo.locationVelo("123456789","123456789A");
        veseo.locationVelo("123456789","123456789B");
    }

    /**
     * Location d'un vélo par un cycliste. On retrouve les deux interactions du cycliste : insererCarte puis confirmerLocation.
     * @param numeroCarte le numéro de carte du cycliste.
     * @param empreinte l'empreinte numérique du vélo concerné.
     */
    void locationVelo(String numeroCarte, String empreinte){
        if(insererCarte(numeroCarte,empreinte)) {
            System.out.println("La location du vélo " + empreinte + " est possible. On passe à l'étape suivante.");
            confirmerLocation();
        } else {
            System.out.println("La location pour le vélo " + empreinte + " n'est pas possible.");
        }
    }

    /**
     * Première étape de la location de vélo.
     * @param numeroCarte le numéro de carte du cycliste.
     * @param empreinteVelo l'empreinte numérique du vélo concerné.
     * @return vrai si on peut continuer le processus de location, faux sinon (voir vérifications dans le diagramme
     * de séquences UML).
     */
    boolean insererCarte(String numeroCarte, String empreinteVelo) {
        boolean ok = false;
        /*
         * Lors du déroulé de cette séquence, vous allez devoir stocker l'utilisateur, le compte et le vélo dans les
         * variables tempUtilisateur, tempCompte et tempVelo.
         * Ces variables seront utilisées dans la seconde séquence pour enregistrer la location.
         */
        tempUtilisateur = identifierCycliste(numeroCarte);
        tempCompte = tempUtilisateur.getCompte();
        if(!tempCompte.isDesactive()) {
            tempVelo = rechercheVelo(empreinteVelo);
            ok = tempVelo.isDisponible();
        }
        return ok;
    }

    /**
     * Seconde étape de la location de vélo.
     * On utilise les variables temporaires tempUtilisateur, tempCompte et tempVelo si besoin d'accéder aux objets
     * identifiés lors de la première étape.
     * Affiche un message pour confirmer la location du vélo.
     */
    void confirmerLocation() {
        String numCarte = tempCompte.getNumeroCarte();
        String position = tempVelo.getPosition();
        Location newLoc = new Location(numCarte,position);
        tempVelo.setDisponible(false);
        locations.add(newLoc);
        System.out.println("Une nouvelle location a été enregistrée par "+tempCompte.getProprietaire().getNom()+" pour le vélo "+tempVelo.getEmpreinte());
    }

    /**
     * Recherche un utilisateur par son numéro de carte.
     * @param numeroCarte le numéro recherché.
     * @return un Utilisateur si le numéro existe, null sinon.
     */
    Utilisateur identifierCycliste(String numeroCarte) {
        Utilisateur u = null;
        boolean found = false;
        int i = 0;
        while(!found && i < cyclistes.size()){
            if(cyclistes.get(i).getIdentifiant().equals(numeroCarte)) {
                found = true;
            } else {
                i++;
            }
        }
        if(found){
            u = cyclistes.get(i);
        }
        return u;
    }

    /**
     * Recherche un vélo par son empreinte numérique.
     * @param empreinteVelo l'empreinte numérique recherchée.
     * @return un Velo si l'empreinte numérique existe, null sinon.
     */
    Velo rechercheVelo(String empreinteVelo) {
        Velo v = null;
        boolean found = false;
        int i = 0;
        while(!found && i < velos.size()){
            if(velos.get(i).getEmpreinte().equals(empreinteVelo)) {
                found = true;
            } else {
                i++;
            }
        }
        if(found){
            v = velos.get(i);
        }
        return v;
    }

    /**
     * Initialise les données du système (Utilisateurs, Vélo, Compte) pour simuler une location de vélo.
     */
    void initialiserDonnees() {
        Velo unVeloLibre = new Velo("123456789A");
        Velo unVeloPasLibre = new Velo("123456789B");
        unVeloPasLibre.setDisponible(false);
        Utilisateur unUtilisateur = new Utilisateur("René","Jean","123456789");
        Compte unCompte = new Compte("123456789");
        unUtilisateur.setCompte(unCompte);
        unCompte.setProprietaire(unUtilisateur);
        velos.add(unVeloLibre);
        velos.add(unVeloPasLibre);
        cyclistes.add(unUtilisateur);
    }
}