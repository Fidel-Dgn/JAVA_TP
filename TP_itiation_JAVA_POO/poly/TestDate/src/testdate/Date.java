
package testdate;

public class Date {
    public int jour;
    public int mois;
    public int an;

    public final static Date mardi010102 = new Date(1, 1, 2002);
    public final static String[] semaine = {"dim", "lundi", "mardi", "merc", "jeudi", "vend", "sam"};

    // Constructeur : initialise une date avec jour, mois et année
    public Date(int j, int m, int a) {
        if (m < 1 || m > 12 || j < 1 || j > nbJoursMois(j, m, a)) {
            throw new IllegalArgumentException("Date invalide");
        }
        this.jour = j;
        this.mois = m;
        this.an = a;
    }

    // Vérifie si une année est bissextile
    public static boolean biss(int a) {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    // Renvoie le nombre de jours dans un mois donné
    public static int nbJoursMois(int j, int m, int a) {
        switch (m) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return biss(a) ? 29 : 28;
            default:
                return 31;
        }
    }

    // Nombre de jours écoulés depuis le 1er janvier 1600
    public int nbJoursDepuis1600() {
        int total = 0;
        for (int year = 1600; year < this.an; year++) {
            total += biss(year) ? 366 : 365;
        }
        for (int month = 1; month < this.mois; month++) {
            total += nbJoursMois(this.jour, month, this.an);
        }
        total += this.jour - 1;
        return total;
    }

    // Distance entre deux dates en jours
    public int distance(Date d) {
        return this.nbJoursDepuis1600() - d.nbJoursDepuis1600();
    }

    // Numéro du jour de la semaine
    public int numJourDeLaSemaine() {
        int joursDepuis2002 = this.distance(mardi010102);
        return (joursDepuis2002 % 7 + 7) % 7; // Modulo pour gérer les négatifs
    }

    // Compare deux dates
    public int compareTo(Date d) {
        if (this.an != d.an) return Integer.compare(this.an, d.an);
        if (this.mois != d.mois) return Integer.compare(this.mois, d.mois);
        return Integer.compare(this.jour, d.jour);
    }

    // Représentation en chaîne de caractères
    public String toString() {
        return jour + "/" + mois + "/" + an;
    }

    // Affichage du calendrier du mois
    public void afficheCal() {
        System.out.println("Calendrier de " + mois + "/" + an);
        for (String jourSemaine : semaine) {
            System.out.print(jourSemaine + "\t");
        }
        System.out.println();

        int premierJour = new Date(1, mois, an).numJourDeLaSemaine();
        for (int i = 0; i < premierJour; i++) {
            System.out.print("\t");
        }

        int joursDansMois = nbJoursMois(jour, mois, an);
        for (int j = 1; j <= joursDansMois; j++) {
            System.out.print(j + "\t");
            if ((j + premierJour) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}