
package toto;

public class Toto {
    int toto = 0;
    public Toto() {
        this.toto = this.toto + 1;}
    public int getToto() {
        return this.toto ;
    }
    
    public static void main(String[] args) {
        Toto t1 = new Toto();
        Toto t2 = new Toto();
        System.out.println("Toto1 : " + t1.getToto());
        System.out.println("Toto2 : " + t2.getToto());
    }
}
