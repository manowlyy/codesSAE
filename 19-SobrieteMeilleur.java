package src.main.java.exercice;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe contient une méthode pour trier les mots d'un texte selon un ordre spécifié.
 */
public class SobrieteMeilleur {

    /**
     * Classe interne représentant un noeud dans un arbre binaire de recherche.
     */
    public static class Arbre {
        private Arbre gauche;
        private Arbre droite;
        private String valeur;

        /**
         * Constructeur de la classe Arbre.
         * @param valeur la valeur associée au noeud
         */
        public Arbre(String valeur) {
            this.valeur = valeur;
            gauche = null;
            droite = null;
        }
    }

    /**
     * Trie les mots d'un texte selon l'ordre spécifié.
     * @param texte le texte contenant les mots à trier
     * @param ordre l'ordre spécifié des caractères
     * @return une liste des mots triés selon l'ordre spécifié
     */
    public static List<String> sortWords(String texte, List<Character> ordre) {
        List<String> mots = new ArrayList<>();

        ArrayList<String> motsArray = textToList(texte);

        Arbre root = null;

        for (String mot : motsArray) {
            char premierCaractere = mot.charAt(0);
            if (ordre.contains(premierCaractere)) {
                root = ajouterNoeud(root, mot, ordre);
            } else {
                mots.add(mot);
            }
        }

        getSortedWords(root, mots);

        return mots;
    }

    /**
     * Convertit une chaîne de caractères en une liste de mots.
     * @param str la chaîne de caractères à convertir
     * @return une liste des mots extraits de la chaîne
     */
    public static ArrayList<String> textToList(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]+", " ").trim();
        String mot = "";
        ArrayList<String> motsep = new ArrayList<String>();
        for (int index = 0; index < str.length(); index++) {
            char car = str.charAt(index);
            if (car == ' ') {
                motsep.add(mot.trim());
                mot = "";
            }
            mot += car;
        }
        if (mot != "") {
            motsep.add(mot.trim());
        }
        return motsep;
    }

    private static Arbre ajouterNoeud(Arbre racine, String mot, List<Character> ordre) {
        if (racine == null) {
            return new Arbre(mot);
        }

        char premierCaractere = mot.charAt(0);
        char rootPremierCaractere = racine.valeur.charAt(0);

        if (ordre.indexOf(premierCaractere) <= ordre.indexOf(rootPremierCaractere)) {
            racine.gauche = ajouterNoeud(racine.gauche, mot, ordre);
        } else {
            racine.droite = ajouterNoeud(racine.droite, mot, ordre);
        }

        return racine;
    }

    private static void getSortedWords(Arbre node, List<String> mots) {
        if (node != null) {
            getSortedWords(node.gauche, mots);
            mots.add(node.valeur);
            getSortedWords(node.droite, mots);
        }
    }

    /**
     * Cette méthode trie les mots d'un texte selon l'ordre spécifié.
     * @param str le texte contenant les mots à trier
     * @param ordre l'ordre spécifié des caractères
     * @return une liste des mots triés selon l'ordre spécifié
     */
    public static List<String> solution(String str, List<Character> ordre) {
        List<String> result = sortWords(str, ordre);
        if (result.size() == 0)
            return List.of("");
        return result;
    }
}
