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
		if(robot == arrive){
			return true;
		}
		return true;
		/*else{
			if(arrive.getX()-robot.getX() >= arrive.getY()-robot.getY()){
				
			}
		}*/
	}
	
	public static void choixAction(Robot robotSelectionne){
		int choix = 0;
		while(choix < 1 || choix > 2){
			String saisie = "";
			try{
				saisie = JOptionPane.showInputDialog("Robot Selectionne : "
						+ robotSelectionne 
						+ "\n"
						+ "Choisissez l'action du robot \n"
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
						plat.Vider(robotSelectionne.getCoordonnees().getX(), robotSelectionne.getCoordonnees().getY());
						plat.setRobot(choix_x, choix_y, robotSelectionne);
						deplacementNonPossible = false;
						System.out.println(vue_plat);
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
		
		// Affichage menu joueur
		JOptionPane.showMessageDialog(null, "C'est au tour du joueur " + joueurActuel);
		
		// Lancement de la partie
		while (j.partieTerminee() == 0) {

			// Affichage plateau
			System.out.println(vue_plat);
			
			// Choix 1 - Demande de l'action ï¿½ executer
			int c_1 = 0;
			String saisie = "";
			// Vï¿½rification donnï¿½es utilisateur
			while ((c_1 != 1) && (c_1 != 2) && (c_1 != 3) && (c_1 != 4)) {
				try{
				saisie = JOptionPane.showInputDialog("Que voulez vous faire ? \n "
						+ "1.Sélectionner un robot \n "
						+ "2.Afficher mes robots \n "
						+ "3.Ajouter un robot \n"
						+ "4.Changer de joueur");
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
				 *Selection des coordonnees du Robot 
				 */
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

				
				/* tant que aucun choix n'a ete fait, saisir un choix
				 * Si le choix en deplacement, saisir les coordonnees
				 * Si le choix est tir/piege, verifier la possibilite du tir, puis tirer
				 */
				choixAction(plat.getRobot(c_x,c_y));
				
				
			} else if (c_1 == 2) {
				if(joueurActuel == 1){
					System.out.println(j.getRobots_Equipe1());
				}
				else{
					System.out.println(j.getRobots_Equipe2());
				}
			}else if (c_1 == 3) {
				int cc_1 = 0;
				while ((cc_1 != 1) && (cc_1 != 2) && (cc_1 != 3)) {
					try{
					saisie = JOptionPane.showInputDialog("Quelle unité ? \n "
							+ "1.Piegeur \n "
							+ "2.Tireur \n "
							+ "3.Char \n");
					System.out.println(Integer.parseInt(saisie));
					cc_1 = Integer.parseInt(saisie);
					}catch(Exception e){
						if(saisie == null)
							System.exit(0);
						JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des réponses possibles." );
					}
				}
				
				if(cc_1 == 1){
					int choix_x = -1;
					int choix_y = -1;
					
					while((choix_x < 0 || choix_x > config_PlateauX) || (choix_y < 0 || choix_y > config_PlateauY)){
						String s = "";
						String s1 = "";
						try{
							s = JOptionPane.showInputDialog("x:");
							choix_x = Integer.parseInt(s);
							s1 = JOptionPane.showInputDialog("y:");
							choix_y = Integer.parseInt(s1);
							}catch(Exception e){
								if(saisie == null)
									System.exit(0);
								JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
							}
					}
					if(plat.estVide(choix_x, choix_y)){
						Robot piegeur = new Piegeur(vue_plat, choix_x, choix_y, joueurActuel);
						plat.setRobot(choix_x, choix_y, piegeur);
						j.ajouterRobot(joueurActuel, piegeur);
					}
				} else if(cc_1 == 2){
					int choix_x = -1;
					int choix_y = -1;
					
					while((choix_x < 0 || choix_x > config_PlateauX) || (choix_y < 0 || choix_y > config_PlateauY)){
						String s = "";
						String s1 = "";
						try{
							s = JOptionPane.showInputDialog("x:");
							choix_x = Integer.parseInt(s);
							s1 = JOptionPane.showInputDialog("y:");
							choix_y = Integer.parseInt(s1);
							}catch(Exception e){
								if(saisie == null)
									System.exit(0);
								JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
							}
					}
					if(plat.estVide(choix_x, choix_y)){
						Robot tireur = new Tireur(vue_plat, choix_x, choix_y, joueurActuel);
						plat.setRobot(choix_x, choix_y, tireur);
						j.ajouterRobot(joueurActuel, tireur);
					}
				} else if(cc_1 == 3){
					int choix_x = -1;
					int choix_y = -1;
					
					while((choix_x < 0 || choix_x > config_PlateauX) || (choix_y < 0 || choix_y > config_PlateauY)){
						String s = "";
						String s1 = "";
						try{
							s = JOptionPane.showInputDialog("x:");
							choix_x = Integer.parseInt(s);
							s1 = JOptionPane.showInputDialog("y:");
							choix_y = Integer.parseInt(s1);
							}catch(Exception e){
								if(saisie == null)
									System.exit(0);
								JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
							}
					}
					if(plat.estVide(choix_x, choix_y)){
						Robot chaR = new Char(vue_plat, choix_x, choix_y, joueurActuel);
						plat.setRobot(choix_x, choix_y, chaR);
						j.ajouterRobot(joueurActuel, chaR);
					}
				}

							
				System.out.println(vue_plat);
			} else if (c_1 == 4) {
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

/*
 * 				
*	Création d'un faux robot (Test)			  
*				 
*				
*				
*/
