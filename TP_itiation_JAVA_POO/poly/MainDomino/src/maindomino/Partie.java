
package maindomino;


public class Partie {
    private final EnsembleDom pioche;
    private final Joueur[] jr;
    private final ChaineDom cd;

    // Constructeur : initialise la partie avec deux joueurs, la pioche et la chaîne de dominos
    public Partie(String nomA, String nomB) {
        this.pioche = new EnsembleDom();
        this.pioche.consTotal();
        this.pioche.melanger();

        this.jr = new Joueur[2];
        this.jr[0] = new Joueur(nomA);
        this.jr[1] = new Joueur(nomB);

        for (Joueur joueur : jr) {
            joueur.init(pioche);
        }

        // Premier domino pour initialiser la chaîne
        Domino premierDom = pioche.remove();
        this.cd = new ChaineDom(premierDom);
    }

    // Affiche les caractéristiques de la partie
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pioche: ").append(pioche.toString()).append("\n");
        for (Joueur joueur : jr) {
            sb.append(joueur.toString()).append("\n");
        }
        sb.append("Chaîne de dominos: ").append(cd.toString());
        return sb.toString();
    }

    // Permet à un joueur de jouer un tour
    public int unTour(int i) {
        Joueur joueur = jr[i];
        Domino d = joueur.choixPremierDom(cd);

        if (d != null) { // Si un domino jouable est trouvé
            if (cd.jouable(d) < 0) {
                cd.addLeft(d);
            } else {
                cd.addRight(d);
            }
            if (joueur.gagne()) {
                return 2; // Joueur a gagné
            }
            return 1; // Joueur a joué
        }

        // Si aucun domino jouable, le joueur pioche
        if (pioche.isEmpty()) {
            return 0; // Aucun mouvement possible
        } else {
            joueur.piocher(pioche);
            return 0;
        }
    }

    // Gère une partie complète
    public void partieDomino() {
        int tour = 0;
        while (true) {
            System.out.println("Tour du joueur: " + jr[tour % 2].getName());
            int resultat = unTour(tour % 2);

            System.out.println(this); // Affiche l'état de la partie

            if (resultat == 2) {
                System.out.println("Le joueur " + jr[tour % 2].getName() + " a gagné !");
                break;
            }

            if (pioche.isEmpty() && jr[0].gagne() && jr[1].gagne()) {
                System.out.println("Partie nulle : aucun joueur ne peut plus jouer !");
                break;
            }

            tour++;
        }
    }

    // Méthode main pour tester la classe Partie
    public static void main(String[] args) {
        Partie p = new Partie("Martine", "Robert");
        System.out.println("État initial de la partie :");
        System.out.println(p);
        p.partieDomino();
    }
}
