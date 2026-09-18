
package ensembledom;


public class Domino {
    private int left;
    private int right;

    // Constructeur avec deux paramètres
    public Domino(int i, int j) {
        if (i < 0 || i > 6 || j < 0 || j > 6) {
            throw new IllegalArgumentException("Les numéros d'un domino doivent être compris entre 0 et 6.");
        }
        this.left = i;
        this.right = j;
    }

    // Constructeur par défaut (domino [0, 0])
    public Domino() {
        this(0, 0);
    }

    // Observateur : retourne le côté gauche
    public int getLeft() {
        return left;
    }

    // Observateur : retourne le côté droit
    public int getRight() {
        return right;
    }

    // Vérifie si les numéros du domino sont corrects
    public boolean isDomino() {
        return left >= 0 && left <= 6 && right >= 0 && right <= 6;
    }

    // Vérifie si le domino est un double (ex : [3, 3])
    public boolean isDouble() {
        return left == right;
    }

    // Calcule la somme des points du domino
    public int totalPoint() {
        return left + right;
    }

    // Retourne le domino en inversant ses côtés
    public void rotate() {
        int temp = left;
        left = right;
        right = temp;
    }

    // Représentation textuelle du domino (ex : "[i ; j]")
    @Override
    public String toString() {
        return "[" + left + " ; " + right + "]";
    }

    // Compare deux dominos selon les règles définies
    public int compareTo(Domino d) {
        // Côtés gauche identiques
        if (this.left == d.left) return -2;
        if (this.left == d.right) return 2;

        // Côté droit du premier domino coïncide avec le côté gauche du second
        if (this.right == d.left) return -1;
        if (this.right == d.right) return 1;

        // Aucun côté ne coïncide
        return 0;
    } 
}
