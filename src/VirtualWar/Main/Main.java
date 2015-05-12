package VirtualWar.Main;
import java.util.Scanner;

import javax.swing.JOptionPane;

import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Plateau.Plateau;
import VirtualWar.Plateau.Vue;
import VirtualWar.Unites.*;

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
	
	public static void choixAction(Robot robotSelectionne){
		int choix = 0;
		while(choix < 1 || choix > 2){
			String saisie = "";
			try{
				saisie = JOptionPane.showInputDialog("Choisissez l'action du robot \n"
						+ "1.Déplacement \n"
						+ "2.Tir \n");
				choix = Integer.parseInt(saisie);
				}catch(Exception e){
					if(saisie == null)
						System.exit(0);
					JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des réponses possibles." );
				}
			if(choix == 1){
				boolean deplacementNonPossible = true;
				while(deplacementNonPossible){
					System.out.println("Saisissez les coordonnées de déplacement:");
					int choix_x = 0;
					int choix_y = 0;
					String saisie1 = "";
					try{
						saisie = JOptionPane.showInputDialog("x:");
						choix_x = Integer.parseInt(saisie);
						saisie1 = JOptionPane.showInputDialog("y:");
						choix_y = Integer.parseInt(saisie1);
						}catch(Exception e){
							if(saisie == null)
								System.exit(0);
							JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
						}
					//TODO
					Coordonnees newCoord = new Coordonnees(choix_x, choix_y);
					if(testDeplacement(robotSelectionne.getCoordonnees(), newCoord )){
						robotSelectionne.setCoordonnees(newCoord);
						deplacementNonPossible = false;
					}
				}
			}
			else{
				//TODO
			}
		}
	}
	public static void main(String args[]) {

		// Nouveau jeu
		Jeu j = new Jeu();

		//Configuration du plateau
		config_PlateauX = j.config_TaillePlateauX();
		config_PlateauY = j.config_TaillePlateauY();

		// Crï¿½ation du plateau
		plat = new Plateau(config_PlateauY, config_PlateauY);
		// Crï¿½ation de la vue
		Vue vue_plat = new Vue(plat);
		
		//TODO
		//Fenetre f = new Fenetre(vue_plat1);

		// Acquisition des bases
		Coordonnees Base1 = plat.getBase(1);
		Coordonnees Base2 = plat.getBase(2);

		// Crï¿½ation des robots
		Robot tireur_eq1 = new Tireur(vue_plat, Base1.getX(), Base1.getY(), 1);
		plat.setRobot(Base1.getX(), Base1.getY(), tireur_eq1);

		Robot tireur_eq2 = new Tireur(vue_plat, Base2.getX(), Base2.getY(), 2);
		plat.setRobot(Base2.getX(), Base2.getY(), tireur_eq2);

		// Ajout des robots
		j.ajouterRobot(1, tireur_eq1);
		j.ajouterRobot(2, tireur_eq2);
		
		// Affichage menu joueur
		JOptionPane.showMessageDialog(null, "C'est au tour du joueur " + joueurActuel);
		
		// Lancement de la partie
		while (j.partieTerminee() == 0) {

			// Affichage plateau
			System.out.println(vue_plat);

;
			
			// Choix 1 - Demande de l'action ï¿½ executer
			int c_1 = 0;
			String saisie = "";
			// Vï¿½rification donnï¿½es utilisateur
			while ((c_1 != 1) && (c_1 != 2) && (c_1 != 3)) {
				try{
				saisie = JOptionPane.showInputDialog("Que voulez vous faire ? \n "
						+ "1.Sélectionner un robot \n "
						+ "2.Afficher mes robots \n "
						+ "3.Changer de joueur");
				c_1 = Integer.parseInt(saisie);
				}catch(Exception e){
					if(saisie == null)
						System.exit(0);
					JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des réponses possibles." );
				}
			}

			// Actions
			if (c_1 == 1) {
				/*
				 * Création d'un faux robot (Test)
				 */
				
				Robot char1 = new Char(vue_plat, Base1.getX(), Base1.getY(), 1);
				plat.setRobot(3, 3, char1);
				/*
				 *Selection des coordonnees du Robot 
				 */
				Robot robotSelectionne;
				int c_x = 0;
				int c_y = 0;
				String saisie1;
				while(plat.getRobot(c_x,c_y) == null){
					try{
						saisie = JOptionPane.showInputDialog("x:");
						c_x = Integer.parseInt(saisie);
						saisie1 = JOptionPane.showInputDialog("y:");
						c_y = Integer.parseInt(saisie1);
						}catch(Exception e){
							if(saisie == null)
								System.exit(0);
							JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
						}
				}
				robotSelectionne = plat.getRobot(c_x,c_y);
				
				/* tant que aucun choix n'a ete fait, saisir un choix
				 * Si le choix en deplacement, saisir les coordonnees
				 * Si le choix est tir/piege, verifier la possibilite du tir, puis tirer
				 */
				
				choixAction(robotSelectionne);
				
				
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
				
				// Affichage menu joueur
				JOptionPane.showMessageDialog(null, "C'est au tour du joueur " + joueurActuel);
			}

		}

		// Affichage plateau
		System.out.println(vue_plat);

	}

}
