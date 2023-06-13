package main.java.exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercice {
	public static List<String> solution(String texte, List<Character> ordre) {
        List<String> mots = Arrays.asList(texte.split("\\s+"));
        Map<Character, Integer> orderMap = new HashMap<>();
        
        for (int i = 0; i < ordre.size(); i++) {
            orderMap.put(ordre.get(i), i);
        }

        Collections.sort(mots, (a, b) -> {
            int minLength = Math.min(a.length(), b.length());
            
            for (int i = 0; i < minLength; i++) {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                
                if (charA != charB) {
                    int indexA = orderMap.getOrDefault(charA, ordre.size());
                    int indexB = orderMap.getOrDefault(charB, ordre.size());
                    
                    return Integer.compare(indexA, indexB);
                }
            }
            
            return Integer.compare(a.length(), b.length());
        });
        
        return mots;
    }
    
}
