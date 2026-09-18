package bidule;

class Bidule{
    String s;
    Truc t;
    Bidule(Truc t){
        this.t = t;
        if(t!=null) this.s = t.s;
        else this.s = "Bonjour";
    }
    public String toString(){
        if(this.t == null) return this.s;
        else return this.t.s;
    }
    public static void main(String[] toto){
        Truc t1 = new Truc(), t2 = new Truc("Hello");
        Bidule b1 = new Bidule(t1), b2 = new Bidule(null);
        System.out.println(t1.toString());//Bonjour
        System.out.println(t2.toString());//Hello
        System.out.println(b1.toString());//Bonjour
        System.out.println(b2.toString());//Bonjour
        System.out.println(t1.equals(t2));//false car this.s n'est truc (ou peut etre autre raison)....
        System.out.println(t1.equals(b1));//false car b1 n'est un instancier de Truc
    }
    
}
