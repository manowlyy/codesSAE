package exercice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import meilleur.EfficaciteMeilleur;

public class Exercice {

	public static List<String> solution(String str, List <Character> ordre) {
		   String[] tabMot;

	        tabMot = str.split("[^a-zA-Z0-9]+"); //Expression r�guli�re : lettres min, maj et chiffres

	        List<String> liste = Arrays.asList(tabMot);
	        
	        Random random = new Random();
	        
	        
	        //echange deux elements de la liste al�atoirement a chaque tour, jusqu'a que ce soit le bon ordre
	        while (!liste.equals(EfficaciteMeilleur.solution(str, ordre))) {
	        	 int index1 = random.nextInt(liste.size());
	        	    int index2 = random.nextInt(liste.size());

	        	    String element1 = liste.get(index1);
	        	    String element2 = liste.get(index2);

	        	    liste.set(index1, element2);
	        	    liste.set(index2, element1);
	        	}
	        	
	    	

	    	return liste;
	        
	
	}
}
