import Personnage.*;
import java.util.Scanner;

public class jeuPersonnage {

   public static void main(String args[]) {

      Scanner scanner = new Scanner(System.in);

      System.out.println("Entrez le nom du premier personnage : ");
      String nomPerso1 = scanner.nextLine();

      System.out.println("Entrez le nom du deuxième personnage : ");
      String nomPerso2 = scanner.nextLine();

      Personnage perso1 = new Personnage(nomPerso1, 70);
      Personnage perso2 = new Personnage(nomPerso2, 100);

      System.out.println("Le nom du premier personnage = " + perso1.LeNom());
      System.out.println("Le nom du deuxième personnage = " + perso2.LeNom());

      System.out.println("La vie de "  +  nomPerso1 +  " est à "  + perso1.LaVie());
      System.out.println("La vie de " + nomPerso2 +  " est à "  + perso2.LaVie());

      perso1.AugmenterVie(10);
      System.out.println("Après l'augmentation, la vie de " + nomPerso1 + " est passée à " + perso1.LaVie());

      while (perso1.LaVie() > 0 && perso2.LaVie() > 0) {
         System.out.println("Le jeu continue...");

         double random = Math.random();
         int degats  = (int) (Math.random()* 50 ) +1;

         if(random  <= 0.5){
            System.out.println(nomPerso1 + " attaque " + nomPerso2);
            perso1.Attaque(perso2, degats);
         } else{
            System.out.println(nomPerso2 + " attaque " + nomPerso1);
            perso2.Attaque(perso1, degats);
         }

         System.out.println("La vie de "  +  nomPerso1 +  " est à "  + perso1.LaVie());
         System.out.println("La vie de " + nomPerso2 +  " est à "  + perso2.LaVie());
      }

      if (perso1.LaVie() <= 0) {
         System.out.println("Le " + nomPerso1 + " est mort. Le " + nomPerso2 + " gagne !");
      } else {
         System.out.println("Le " + nomPerso2 + " est mort. Le " + nomPerso1 + " gagne !");
      }
   }
}
