
package chainedom;

import java.util.LinkedList;

public class ChaineDom {
    private LinkedList<Domino> chaine;

    // Constructeur : initialise la chaîne avec un seul domino
    public ChaineDom(Domino d) {
        this.chaine = new LinkedList<>();
        this.chaine.add(d);
    }

    // Retourne la valeur à l'extrémité gauche de la chaîne
    public int left() {
        return chaine.getFirst().getLeft();
    }

    // Retourne la valeur à l'extrémité droite de la chaîne
    public int right() {
        return chaine.getLast().getRight();
    }

    // Vérifie si un domino peut être joué (0 : non jouable, -2/-1 : gauche, 2/1 : droite)
    public int jouable(Domino d) {
        int leftComparison = d.compareTo(chaine.getFirst());
        int rightComparison = d.compareTo(chaine.getLast());
        if (leftComparison < 0) {
            return leftComparison; // Jouable à gauche
        } else if (rightComparison > 0) {
            return rightComparison; // Jouable à droite
        }
        return 0; // Non jouable
    }

    // Ajoute un domino à gauche de la chaîne
    public void addLeft(Domino d) {
        if (jouable(d) < 0) {
            if (d.getRight() != left()) {
                d.rotate(); // Faire correspondre les valeurs
            }
            chaine.addFirst(d);
        } else {
            throw new IllegalArgumentException("Le domino ne peut pas être ajouté à gauche.");
        }
    }

    // Ajoute un domino à droite de la chaîne
    public void addRight(Domino d) {
        if (jouable(d) > 0) {
            if (d.getLeft() != right()) {
                d.rotate(); // Faire correspondre les valeurs
            }
            chaine.addLast(d);
        } else {
            throw new IllegalArgumentException("Le domino ne peut pas être ajouté à droite.");
        }
    }

    // Représente la chaîne sous forme de chaîne de caractères
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Domino d : chaine) {
            sb.append(d.toString()).append(" ");
        }
        return sb.toString().trim();
    }

    // Méthode main pour tester la classe
    public static void main(String[] args) {
        Domino d1 = new Domino(2, 3);
        ChaineDom cd = new ChaineDom(d1);

        Domino d2 = new Domino(3, 6);
        Domino d3 = new Domino(2, 5);

        System.out.println(cd.jouable(d2)); // Devrait afficher une valeur > 0
        System.out.println(cd.jouable(d3)); // Devrait afficher une valeur < 0

        cd.addRight(d2); // Ajout à droite
        cd.addLeft(d3);  // Ajout à gauche

        System.out.println(cd); // Affiche la chaîne actuelle
    }
}
