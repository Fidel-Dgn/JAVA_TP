/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exo2;


public class Exo2 {

    Exo2 e;
    public Exo2(Exo2 e) {
        //omission de '.e' apres le this dans le code initial
        this.e= e;
    }
    public Exo2() {
        super();
    }
    @Override
    //omission de @Override avant la methode tostring()
    public String toString() {
        if(this.e == null) return "NULL";
        else return "LLUN";
    }
    Exo2 m1() {
        System.out.println("Bonjour le monde");
        return this;//permet de retourner l'objet lui meme
    }
    void m2(Exo2 e) {
        this.e = null;
        this.m1();//affichage du texte et apres avoir retourner l'objet initialise sont etat
        e.e = this;
        System.out.println(this);
    }
    public static void main(String[] truc) {
        //new Exo2(); ---- ligne de code inutile
        new Exo2();//creaction d'un objet exo 2 qui appartient a la categorie des ordures 'garbage' car n'est pas stocker dans une variable
        Exo2 e = new Exo2();//creaction d'un nouvel objet exo2 stocker dans e
        e.m2(e);
        Exo2 f = new Exo2(e);//creaction d'un nouvel objet exo2 stocker dans f et qui a pour attribut l'obet e
        e.m2(f);//creaction d'une reference circulaire entre e et f par appelation de la methode m2()
        
    }
}
