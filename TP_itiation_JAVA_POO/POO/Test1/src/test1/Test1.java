
package test1;

public class Test1 {
    int i;
    Test1 (Test1 t){
        // synthaxe vrai mais un peu exagerer pour le if dans le code initial
        if(t == null){
            this.i = 12;
        }
        else{
            t.m();
            this.i = t.i;
        }
    }
    void m(){
        this.i++;
        System.out.println(this.i);
    }
    
    public static void main(String[] args) {
        //error due a une allocation excessive d'objets: creaction d'un grande nombre d'objets sans les liberer correctement....ceci a comduire a un OutOfMemoryError
        Test1 f=new Test1(null);
        
        Test1 i = new Test1(f);
        i.m();/*
        explication: d'abord le resultat obtenu sera 13 et 14
        13: i.m(); cette ligne de code va permettre d'appeler la methode m sur l'objet i qui
        a pour attribut l'objet Test1 f.Primo,etant donne que l'attribut de i est different de null
        alors le constructeur va d'abord executer t.m(); qui conduira a l'affichage de 13 car au cours de la creaction de l'objet 
        f son element i a ete initialise a 12(attribut null)....secondo l'attribut de i etant non null alors il
        y a execution des lignes suivantes t.m(); this.i = t.i; la seconde ligne de code va permettre d'initialiser l'element i de l'objet i
        a l'element i de l'ojet f qui actuellement 13 apres l'execution de la premiere ligne de code...Ainsi par suite la methode m
        va prendre fin par l'affichage de 14.
        */
        
    }
    
}
