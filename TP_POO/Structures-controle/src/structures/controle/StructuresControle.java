package structures.controle;

import java.util.Scanner;

public class StructuresControle {
    
    public static void main(String[] args) {
        //creaction de l'objet scanner
        Scanner scanner= new Scanner(System.in);
        
        System.out.println("Entrer le nombre min :");
        int min = scanner.nextInt();
        
        System.out.println("Entrer le nombre max :");
        int max = scanner.nextInt();
        for (int i=min;i<=max;i++){
            
            if (i%5==0 && i%7==0){
                System.out.println("fizzbuzz");
                
            }
            else{
                
                if (i%5==0 || i%7==0){
                    if (i%5==0 ){
                    System.out.println("fizz");
                    }
                    else{
                        System.out.println("buzz");
                    }
                }
                else{
                    System.out.println(i);
                    
                }
            }
        }
            
    }
    
}
