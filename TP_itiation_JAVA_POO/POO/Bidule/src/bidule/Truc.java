package bidule;

public class Truc {
    
    String s;
    Truc(){
    this.s = "Bonjour";
    }
    Truc(String s){
        this.s = s;
    }
    public String toString(){
        return this.s;
    }
    public boolean equals(Object o){
        return o instanceof Truc && this.s.equals(((Truc) o).s);
    }
}
