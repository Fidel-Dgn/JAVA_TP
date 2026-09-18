
package joueur;


public class Joueur {
    private final String name;
    private final EnsembleDom jeu;

    // Constructeur : initialise le nom et crée un ensemble vide de dominos
    public Joueur(String name) {
        this.name = name;
        this.jeu = new EnsembleDom();
    }

    // Retourne le nom du joueur
    public String getName() {
        return name;
    }

    // Vérifie si le joueur a gagné (plus de dominos dans son jeu)
    public boolean gagne() {
        return jeu.isEmpty();
    }

    // Le joueur pioche un domino, retourne 1 si réussi, 0 si la pioche est vide
    public int piocher(EnsembleDom pioche) {
        if (!pioche.isEmpty()) {
            Domino piocher = pioche.remove();
            jeu.add(piocher);
            return 1;
        }
        return 0;
    }

    // Initialise le jeu du joueur avec 7 dominos
    public void init(EnsembleDom pioche) {
        for (int i = 0; i < 7; i++) {
            if (!pioche.isEmpty()) {
                piocher(pioche);
            }
        }
    }

    // Choisit un premier domino jouable dans le jeu
    public Domino choixPremierDom(ChaineDom cd) {
        for (int i = 0; i < jeu.taille(); i++) {
            Domino d = jeu.getDom(i);
            if (cd.jouable(d) != 0) {
                jeu.remove(i); // Retire le domino jouable
                return d;
            }
        }
        return null; // Aucun domino jouable
    }

    // Affiche les caractéristiques du joueur
    @Override
    public String toString() {
        return "Joueur: " + name + ", Jeu: " + jeu.toString();
    }

    // Méthode main pour tester la classe
    public static void main(String[] args) {
        EnsembleDom pioche = new EnsembleDom();
        Joueur j = new Joueur("Toto");

        pioche.consTotal();
        pioche.melanger();

        System.out.println("Pioche initiale: " + pioche);
        j.init(pioche);
        System.out.println("Après initialisation: " + j);
        j.piocher(pioche);
        System.out.println("Après pioche: " + j);
        System.out.println("Pioche restante: " + pioche);
    }
}
