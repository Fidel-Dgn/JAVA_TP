
package maindomino;


public class MainDomino {
    public static void main(String[] args) {
        Partie partie = new Partie("Alice", "Bob");
        System.out.println("Début de la partie :");
        System.out.println(partie);
        partie.partieDomino();
    }
}
