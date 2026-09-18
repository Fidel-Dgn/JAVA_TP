
package c1;


public class C1 {
    C2 c;
    int i;
    public C1(int i,C2 c) {
        if (c==null) this.c=new C2(i+1,this);
        else this.c = c;
        this.i = i;
    }
    
    public static void main(String[] args) {
        C1 c = new C1(1,null);
        C2 d = new C2(c.i,c);
        C1 e = new C1(d.i,d);
        System.out.println(e.i + "," + e.c.i + "," + e.c.c.i + "," + e.c.c.c.i);
    }
      
    
}
