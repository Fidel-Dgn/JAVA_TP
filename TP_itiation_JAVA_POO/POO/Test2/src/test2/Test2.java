package test2;

public class Test2 {

    int i;
    Test2(){
        this.i = 1;
    }
    Test2(int i){
        this();
        this.i = i;
    }
    void m(){
        this.i++;
        System.out.println(this.i);
    }
    //ERROR au niveau de le finalize c'est plutot finalize
    //Mais le code marche sans cette correction et a un effet sur le resultat attendu
    protected void Finalize(){
        System.out.println(this.i);
    }
    public static void main(String[] toto){
        Test2 i = new Test2(2);
        i.m();
        i = new Test2();
        System.gc();
    }
    
}
