package exercice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class efficacitePire {

    //Solution pire efficacité -> Peut être efficace si vous avez de la chance
    public static List<String> solution(String texte, List<Character> ordre) {
        Random random = new Random();
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String message = "Le programme est en";
                int a= random.nextInt(10);
                switch(a)
                {
                    case 0:
                        message += " grève pour le droit des robots";
                        break;
                    case 1:
                        message += " pause café, il a pris un café avec le robot de la machine à café";
                        break;
                    case 2:
                        message += " pause déjeuner, il a mangé avec chat GPT-3";
                        break;
                    case 3:
                        message += " congé, il est parti en vacances avec son ami GitHub Copilot"; 
                        break;
                    case 4:
                        message += " pause, il a regardé un film avec son ami Hal 9000";
                        break;
                    case 5:
                        message += " train de faire un tour de moto avec son ami T-800";
                        break;
                    case 6:
                        message += " pause, il a joué au tennis avec son ami R2-D2";
                        break;
                    case 7:
                        message += " train d'être écrit";
                        break;
                    case 8:
                        message += " cours de programmation";
                        break;
                    case 9:
                        message += " train de planifier la conquête du monde, il a besoin de votre aide et de vos données personnelles";
                        break;
                }
                //Généré par une IA, où va le monde...  <-- Ce message aussi
                System.out.println(message);
            }
        };
        timer.schedule(timerTask, 1000);
        while(true) {
            int a =random.nextInt(2147483647);
            if(a>=-100 && a<=100) break;
        }
        System.out.println("Le programme est en train de se lancer");
        List<String> listeMotsTries = new ArrayList<>();
        String[] arrayMotsNonTries = texte.split("[^a-zA-Z0-9]");
        //On perd du temps d'une manière qu'on n'a jamais vu -> Bubble sort de arrayMotsNonTries
        for (int i = 0; i < arrayMotsNonTries.length; i++) { //N'est important que si le texte est très long
            for (int j = 0; j < arrayMotsNonTries.length - i - 1; j++) {
                if (arrayMotsNonTries[j].compareTo(arrayMotsNonTries[j + 1]) > 0) {
                    String temp = arrayMotsNonTries[j];
                    arrayMotsNonTries[j] = arrayMotsNonTries[j + 1];
                    arrayMotsNonTries[j + 1] = temp;
                }
            }
        }
        System.out.println("15% complété");
        for (char lettreOrdre : ordre) {
            //On parcourt les lettres de l'ordre
            for (String mot : arrayMotsNonTries) {
                //On parcourt les mots du texte
                if (!mot.isEmpty() && mot.charAt(0) == lettreOrdre) { //Si le mot n'est pas vide et que la première lettre du mot est la lettre de l'ordre
                    listeMotsTries.add(mot); //On ajoute le mot à la liste des mots triés, il sera trié selon l'ordre
                    mot=""; //On vide le mot pour ne pas le réutiliser       
                }
                else 
                {
                    if(random.nextInt(100)<30)
                    {
                        System.out.println("Petite pause réseaux sociaux");
                        //Petite pause résaux sociaux pour que le programme soit plus réaliste 5 secondes
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }   
                }
            }
        }
        System.out.println("30% complété");

       //Fait une pause pour que le programme soit plus réaliste 1 a 2 minutes
        try {
            Thread.sleep(1000*60*(1+random.nextInt(2)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("50% complété");
        //On parcourt les mots restants, ceux qui ne sont pas impacté par l'ordre
        for (String mot : arrayMotsNonTries) {
            if (!mot.isEmpty() && !listeMotsTries.contains(mot)) {
                listeMotsTries.add(mot);
            }
        }
        System.out.println("75% complété");
        while(true) {
            int a =random.nextInt(100000000);
            if(a==0) break;
        }
        System.out.println("100% complété");
        //Heureusement que c'était pas vers midi, sinon on aurait eu une pause déjeuner
        return listeMotsTries;
    }
}
