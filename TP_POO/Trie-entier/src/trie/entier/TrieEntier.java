
package trie.entier;

import java.util.Random;

public class TrieEntier {

    public static void main(String[] args) {
        int[] tableau = genererTableauAleatoire(10); // Génère un tableau de 10 entiers aléatoires
        System.out.println("Tableau avant tri :");
        afficherTableau(tableau);

        trierParSelection(tableau);

        System.out.println("\nTableau après tri :");
        afficherTableau(tableau);
    }

    public static int trouverIndiceMin(int[] tab, int debut) {
        int indiceMin = debut;
        for (int i = debut + 1; i < tab.length; i++) {
            if (tab[i] < tab[indiceMin]) {
                indiceMin = i;
            }
        }
        return indiceMin;
    }

    public static void trierParSelection(int[] tab) {
        for (int i = 0; i < tab.length - 1; i++) {
            int indiceMin = trouverIndiceMin(tab, i);
            // Échanger les éléments à l'indice i et à l'indiceMin
            int temp = tab[i];
            tab[i] = tab[indiceMin];
            tab[indiceMin] = temp;
        }
    }

    public static void afficherTableau(int[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(tab[i] + " ");
        }
        System.out.println();
    }

    public static int[] genererTableauAleatoire(int taille) {
        int[] tab = new int[taille];
        Random rand = new Random();
        for (int i = 0; i < taille; i++) {
            tab[i] = rand.nextInt(100); // Génère des nombres aléatoires entre 0 et 99
        }
        return tab;
    }
}


    

