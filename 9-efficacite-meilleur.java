package exercice;

import java.util.ArrayList;
import java.util.List;

public class Exercice {
    public static List<String> solution(String str, List<Character> ordre) {
        // Liste des mots classés dans l'ordre
        List<String> solution = new ArrayList<>();
        // On vérifie si le string rentré est vide, cela permet d'éviter de perdre du temps à parcourir toutes les boucles si le string est vide
        if (!str.isEmpty()) {
            // Liste des mots séparés
            List<String> stringToWordList = new ArrayList<>();
            // Mot que l'on va append
            StringBuilder stringBuilder = new StringBuilder();
            // On parcours tout le string renseigné avec une for each
            for (char c : str.toCharArray()) {
                // Si le caractère courant est un espace ou un apostrophe on termine le mot et on l'ajoute à la liste
                if (!isAlphanumeric(c)) {
                    if(!stringBuilder.isEmpty()){
                        stringToWordList.add(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    }
                } else {
                    stringBuilder.append(c);
                }
            }
            // On ajoute le dernier mot à la liste
            stringToWordList.add(stringBuilder.toString());
            // On crée une nouvelle liste qui contient en premier lieu tous les mots non classés
            List<String> unsorted = new ArrayList<>();
            unsorted.addAll(stringToWordList);
            System.out.println(stringToWordList);
            // On parcours tous les caractères de l'ordre donné
            for (char c : ordre) {
                // on parcours tous les mots de la liste
                for (String s : stringToWordList) {
                    // Si le premier caractère du mot correspond alors on l'ajoute et on le retire de la liste des non classés pour ne finir qu'avec ceux qui ne le sont pas
                    if (s.charAt(0) == c) {
                        solution.add(s);
                        unsorted.remove(s);
                    }
                }
            }
            // On ajoute à la fin tous les mots non classés dans l'ordre dans lequel ils sont arrivés dans la liste de mots initiale
            solution.addAll(unsorted);



        }
        // Si le string de base est vide on renvoie simplement un liste vide.
        else{
            solution = List.of();
        }

        return solution;
    }



    // Méthode permettant de vérifier si un caractère est alphanumérique
    private static boolean isAlphanumeric(char c){
        return (Character.isLetter(c) || Character.isDigit(c));
    }
}
