
package testrectangle;


public class PointR2 {
    public double x;
    public double y;

    // Constructeur par défaut (point origine)
    public PointR2() {
        this.x = 0;
        this.y = 0;
    }

    // Constructeur avec coordonnées (a, b)
    public PointR2(double a, double b) {
        this.x = a;
        this.y = b;
    }

    // Méthode distance : calcule la distance euclidienne entre deux points
    public double distance(PointR2 p) {
        return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
    }

    // Méthode equals : compare deux points pour vérifier s'ils ont les mêmes coordonnées
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointR2 point = (PointR2) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    // Méthode toString : renvoie une représentation sous forme de chaîne de caractères
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
