
package maindomino;


import java.util.ArrayList;
import java.util.Collections;

public class EnsembleDom {
    private final ArrayList<Domino> dominos;

    // Constructeur : crée un ensemble vide
    public EnsembleDom() {
        this.dominos = new ArrayList<>();
    }

    // Ajoute un domino à l'ensemble
    public void add(Domino d) {
        dominos.add(d);
    }

    // Vérifie si l'ensemble est vide
    public boolean isEmpty() {
        return dominos.isEmpty();
    }

    // Retire et retourne le dernier domino de l'ensemble
    public Domino remove() {
        if (dominos.isEmpty()) {
            throw new IllegalStateException("L'ensemble est vide.");
        }
        return dominos.remove(dominos.size() - 1);
    }

    // Retire et retourne le domino à l'index donné
    public Domino remove(int i) {
        if (i < 0 || i >= dominos.size()) {
            throw new IndexOutOfBoundsException("Index hors limites.");
        }
        return dominos.remove(i);
    }

    // Construit l'ensemble complet des 28 dominos
    public void consTotal() {
        dominos.clear();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                dominos.add(new Domino(i, j));
            }
        }
    }

    // Représentation sous forme de chaîne de l'ensemble
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Domino d : dominos) {
            sb.append(d.toString()).append(" ");
        }
        return sb.toString().trim();
    }

    // Retourne la taille de l'ensemble
    public int taille() {
        return dominos.size();
    }

    // Retourne le domino à l'index donné sans le retirer
    public Domino getDom(int i) {
        if (i < 0 || i >= dominos.size()) {
            throw new IndexOutOfBoundsException("Index hors limites.");
        }
        return dominos.get(i);
    }

    // Mélange l'ensemble des dominos
    public void melanger() {
        Collections.shuffle(dominos);
    }

    // Méthodes auxiliaires pour récupérer les valeurs extrêmes
    public int getLeft() {
        if (dominos.isEmpty()) {
            throw new IllegalStateException("L'ensemble est vide.");
        }
        return dominos.get(0).getLeft();
    }

    public int getRight() {
        if (dominos.isEmpty()) {
            throw new IllegalStateException("L'ensemble est vide.");
        }
        return dominos.get(dominos.size() - 1).getRight();
    }
}
