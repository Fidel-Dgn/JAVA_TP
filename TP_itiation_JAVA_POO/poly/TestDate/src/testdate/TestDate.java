
package testdate;


public class TestDate {

    public static void main(String[] args) {
        Date d1 = new Date(15, 1, 2025);
        Date d2 = new Date(1, 1, 2025);

        System.out.println("Date 1 : " + d1);
        System.out.println("Date 2 : " + d2);

        System.out.println("Distance entre les deux dates : " + d1.distance(d2));
        System.out.println("Jour de la semaine pour " + d1 + " : " + Date.semaine[d1.numJourDeLaSemaine()]);

        d1.afficheCal();
    }    
}
