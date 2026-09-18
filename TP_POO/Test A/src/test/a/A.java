
package test.a;

public class A {
    
    public int x;
    public A(int x){
    this.x=x;
    }
    public int f(){
        return x+3;
    }
    public A g(A a){
        return new A(2*x+3*a.x);
    }
    
}
