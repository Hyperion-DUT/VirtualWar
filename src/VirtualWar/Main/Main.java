package VirtualWar.Main;
import java.util.Scanner;

import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Plateau.Plateau;
import VirtualWar.Plateau.Vue;
import VirtualWar.Unites.Robot;
import VirtualWar.Unites.Tireur;

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
	
	public static boolean testDeplacement(Coordonnees robot, Coordonnees arrive){
		
		return true;
	}
	public static void main(String args[]) {

		// Nouveau jeu
		Jeu j = new Jeu();
		System.out.println("");
		System.out.println("Veuillez renseigner la taille du plateau (min X : "
				+ minPlateauX + " - minY : " + minPlateauY + ")");
		System.out.println("");
		// VÔøΩrification plateau
		while (config_PlateauX < minPlateauX || config_PlateauY < minPlateauY) {
			// Config -> Plateau
			config_PlateauX = j.config_TaillePlateauX();
			config_PlateauY = j.config_TailleTableauY();
		}

		// CrÔøΩation du plateau
		plat = new Plateau(config_PlateauY, config_PlateauY);
		// CrÔøΩation de la vue
		Vue vue_plat = new Vue(plat);

		// Acquisition des bases
		Coordonnees Base1 = plat.getBase(1);
		Coordonnees Base2 = plat.getBase(2);

		// CrÔøΩation des robots
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
			System.out.println("1.SÈlectionner un robot");
			System.out.println("2.Afficher mes robots");
			System.out.println("3.Changer de joueur");

			// Choix 1 - Demande de l'action ÔøΩ executer
			int c_1 = 0;
			// VÔøΩrification donnÔøΩes utilisateur
			while ((c_1 != 1) && (c_1 != 2) && (c_1 != 3)) {
				System.out.println("");
				System.out.println("Saisie -> ");
				// Saisie utilisateur
				c_1 = s.nextInt();
			}

			// Actions
			if (c_1 == 1) {
				/*
				 *S√©lection des coordonn√©es du Robot 
				 */
				Robot robotSelectionne;
				int c_x = 0;
				int c_y = 0;
				while(plat.getRobot(c_x,c_y) == null){
					System.out.println("x:");
					c_x = s.nextInt();
					System.out.println("y:");
					c_y = s.nextInt();
				}
				robotSelectionne = plat.getRobot(c_x,c_y);
				
				/* tant que aucun choix n'a √©t√© fait, saisir un choix
				 * Si le choix en d√©placement, saisir les coordonnees
				 * Si le choix est tir/pi√®ge, v√©rifier la possibilit√© du tir, puis tirer
				 */
				int choix = 0;
				while(choix < 1 || choix > 2){
					System.out.println("Choisissez l'action du robot:");
					System.out.println("1.DÈplacement");
					System.out.println("2.Tir");
					choix = s.nextInt();
					if(choix == 1){
						boolean deplacementNonPossible = true;
						while(deplacementNonPossible){
							System.out.println("Saisissez les coordonnÈes de dÈplacement:");
							System.out.println("x:");
							int choix_x = s.nextInt();
							System.out.println("y:");
							int choix_y = s.nextInt();
							//TODO
							Coordonnees newCoord = new Coordonnees(choix_x, choix_y);
							if(testDeplacement(robotSelectionne.getCoordonnees(), newCoord )){
								robotSelectionne.setCoordonnees(newCoord);
							}
							else{
								System.out.println("DÈplacement impossible");
							}
						}
					}
					else{
						
					}
				}
			} else if (c_1 == 2) {
				if(joueurActuel == 1){
					System.out.println(j.getRobots_Equipe1());
				}
				else{
					System.out.println(j.getRobots_Equipe2());
				}
			} else if (c_1 == 3) {
				// Changement du joueur
				if (joueurActuel == 1)
					joueurActuel = 2;
				else if (joueurActuel == 2)
					joueurActuel = 1;
			}
			s.nextLine();
			System.out.println("Appuyer sur entrÈe pour continuer...");
			s.nextLine();



		}

		// Affichage plateau
		System.out.println(vue_plat);

	}

}
