package a;

public class A {

    int i;
    A a;
    A(int i){
        if(i<=0){
        this.i = i;
        this.a = new A(i-1);
        }
        else this.i = i;
    }
    void passeATonVoisin(){
        this.i++;
        if(this.a!=null) this.a.passeATonVoisin();
        else System.out.println(this.i);
    }
    public static void main(String[] t){
        A a = new A(10);
        a.passeATonVoisin();
    }
    
}
