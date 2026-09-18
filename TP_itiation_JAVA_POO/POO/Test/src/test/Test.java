package test;

public class Test {
    protected int i;
    public Test(int i) {
        this.i=12;
    }
    public void Afficheri(){
        //dans le code principal il y avait une erreur de nomination de la variable locale 
        Test a=new Test(3);
        System.out.println(a.i);
    }
    public static void main(String[] args) {
        Test i=new Test(34);
        //le code ci apres permet juste de creer un objet de type test et ne retourne rien comme resultat
        
        i.Afficheri();
    }
    
}
