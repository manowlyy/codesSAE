package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exercice {

    public static List<String> solution(String str, List<Character> ordre) {
        List<String> listeTrier = new ArrayList<>();
        List<String> mots = new ArrayList<>();
        List<String> inconnus = new ArrayList<>();

        if (str.length() == 0) {
            return List.of();
        }

        mots = new ArrayList<>(Arrays.asList(str.split("[^a-zA-Z0-9]+")));
        inconnus.addAll(mots);

        Comparator<String> comparator = (a, b) -> {
            char firstCharA = a.charAt(0);
            char firstCharB = b.charAt(0);

            int indexA = ordre.indexOf(firstCharA);
            int indexB = ordre.indexOf(firstCharB);

            if (indexA != -1 && indexB != -1) {
                if (indexA < indexB) {
                    return -1;
                } else if (indexA > indexB) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (indexA != -1) {
                return -1;
            } else if (indexB != -1) {
                return 1;
            } else {
                return 0;
            }
        };

        mots.sort(comparator);

        listeTrier.addAll(mots);

        return listeTrier;
    }

}