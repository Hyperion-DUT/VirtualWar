import java.util.Scanner;

public class Main {

	// **Saisie utilisateur**//
	private static Scanner s = new Scanner(System.in);

	// **Constantes d'execution**/
	private static final int minPlateauX = 11;
	private static final int minPlateauY = 11;

	// **Variables d'execution**//

	/**
	 * Config -> Taille du plateau
	 */
	private static int config_PlateauX, config_PlateauY;

	/**
	 * Jeu -> Joueur courrant
	 */
	private static int joueurActuel = 1;

	/**
	 * Plateau de jeu
	 */
	private static Plateau plat;

	/**
	 * Vue du plateau
	 */
	private static Vue vue_plat;

	/**
	 * _main
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		// Nouveau jeu
		Jeu j = new Jeu();
		System.out.println("");
		System.out.println("Veuillez renseigner la taille du plateau (min X : "
				+ minPlateauX + " - minY : " + minPlateauY + ")");
		System.out.println("");
		// V�rification plateau
		while (config_PlateauX < minPlateauX || config_PlateauY < minPlateauY) {
			// Config -> Plateau
			config_PlateauX = j.config_TaillePlateauX();
			config_PlateauY = j.config_TailleTableauY();
		}

		// Cr�ation du plateau
		plat = new Plateau(config_PlateauY, config_PlateauY);
		// Cr�ation de la vue
		Vue vue_plat = new Vue(plat);

		// Acquisition des bases
		Coordonnees Base1 = plat.getBase(1);
		Coordonnees Base2 = plat.getBase(2);

		// Cr�ation des robots
		Robot tireur_eq1 = new Tireur(vue_plat, Base1.getX(), Base1.getY(), 1);
		plat.setRobot(Base1.getX(), Base1.getY(), tireur_eq1);

		Robot tireur_eq2 = new Tireur(vue_plat, Base2.getX(), Base2.getY(), 2);
		plat.setRobot(Base2.getX(), Base2.getY(), tireur_eq2);

		// Ajout des robots
		j.ajouterRobot(1, tireur_eq1);
		j.ajouterRobot(2, tireur_eq2);

		// Lancement de la partie
		while (j.partieTerminee() == 0) {

			// Affichage plateau
			System.out.println(vue_plat);

			// Affichage menu joueur
			System.out.println("");
			System.out.println("---------------------------------------");
			System.out.println("C'est au tour du joueur " + joueurActuel);
			System.out.println("---------------------------------------");
			System.out.println("");
			System.out.println("Que voulez vous faire ?");
			System.out.println("1.Sélectionner un robot");
			System.out.println("2.Afficher mes robots");
			System.out.println("3.Ne rien faire");

			// Choix 1 - Demande de l'action � executer
			int c_1 = 0;
			// V�rification donn�es utilisateur
			while ((c_1 != 1) && (c_1 != 2) && (c_1 != 3)) {
				System.out.println("");
				System.out.println("Saisie -> ");
				// Saisie utilisateur
				c_1 = s.nextInt();
			}

			// Actions
			if (c_1 == 1) {

			} else if (c_1 == 2) {

			} else if (c_1 == 3) {

			}

			// Changement du joueur
			if (joueurActuel == 1)
				joueurActuel = 2;
			else if (joueurActuel == 2)
				joueurActuel = 1;

		}

		// Affichage plateau
		System.out.println(vue_plat);

	}

}
