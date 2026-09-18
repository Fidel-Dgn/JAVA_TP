
package test.a;

public class TestA {
    
    public static void main(String[] args) {
        A u=new A(1);
        System.out.println(u.f());
        A v=new A(4);
        System.out.println(v.f());
        A w=u.g(v);
        System.out.println(w.f());
        w.x=3;
        System.out.println(w.f());
        A T=new A(2);
        System.out.println(T);
    }
    
}
