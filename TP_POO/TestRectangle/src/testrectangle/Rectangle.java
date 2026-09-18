
package testrectangle;

public class Rectangle {
    public PointR2 ext1; // Premier point de la diagonale
    public PointR2 ext2; // Deuxième point de la diagonale

    // Constructeur par défaut (rectangle réduit à l'origine)
    public Rectangle() {
        this.ext1 = new PointR2(0, 0);
        this.ext2 = new PointR2(0, 0);
    }

    // Constructeur avec deux points pour la diagonale
    public Rectangle(PointR2 p, PointR2 q) {
        this.ext1 = p;
        this.ext2 = q;
    }

    // Constructeur avec un coin inférieur gauche, longueur et hauteur
    public Rectangle(PointR2 cig, double l, double h) {
        this.ext1 = cig;
        this.ext2 = new PointR2(cig.x + l, cig.y + h);
    }

    // Méthode longueur : retourne la longueur du rectangle
    public double longueur() {
        return Math.abs(ext2.x - ext1.x);
    }

    // Méthode hauteur : retourne la hauteur du rectangle
    public double hauteur() {
        return Math.abs(ext2.y - ext1.y);
    }

    // Méthode périmètre : calcule le périmètre du rectangle
    public double perimetre() {
        return 2 * (longueur() + hauteur());
    }

    // Méthode surface : calcule la surface du rectangle
    public double surface() {
        return longueur() * hauteur();
    }

    // Méthode contient : vérifie si un point est à l'intérieur du rectangle
    public boolean contient(PointR2 p) {
        double xmin = Math.min(ext1.x, ext2.x);
        double xmax = Math.max(ext1.x, ext2.x);
        double ymin = Math.min(ext1.y, ext2.y);
        double ymax = Math.max(ext1.y, ext2.y);
        return (p.x >= xmin && p.x <= xmax) && (p.y >= ymin && p.y <= ymax);
    }

    // Méthode symétrique : retourne le rectangle symétrique par rapport à la première diagonale
    public Rectangle symetrique() {
        return new Rectangle(
            new PointR2(ext1.y, ext1.x),
            new PointR2(ext2.y, ext2.x)
        );
    }

    // Méthode toString : renvoie une représentation du rectangle
    @Override
    public String toString() {
        return "Rectangle[" + ext1 + ", " + ext2 + "]";
    }
}

