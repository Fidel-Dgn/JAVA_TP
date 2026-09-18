
package controle.ordre;

public class ControleOrdre {

    public static void main(String[] args) {
        
       //Affichage des argument dans l'ordre inverse
       for(int i= args.length - 1; i>=0;i--){
           System.out.println(args[i]);
        }
       //Affichage des arguments a l'envers
       for( String arg : args){
           for(int j = arg.length() - 1; j>=0 ;j--){
               System.out.print(arg.charAt(j));
           }
           System.out.println();
       }
       
       
       
       
    }
    
}
