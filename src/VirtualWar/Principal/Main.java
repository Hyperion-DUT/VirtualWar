/*
* @author Jules
*/

package VirtualWar.Main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import VirtualWar.Actions.Deplacement;
import VirtualWar.Actions.Action;
import VirtualWar.Actions.Attaque;
import VirtualWar.Affichage.Fenetre;
import VirtualWar.Affichage.Plateau;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Plateau.Vue;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Piegeur;
import VirtualWar.Unites.Robot;
import VirtualWar.Unites.Tireur;

public class Main{


	private static Scanner s = new Scanner(System.in);
	

	private static final int minPlateauX = 11;
	private static final int minPlateauY = 11;


	private static Jeu j;

	private static int config_PlateauX, config_PlateauY;


	private static int joueurActuel = 1;


	private static Fenetre f;
	private static Plateau plat;


	private static Vue vue_plat;


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
	/**
	 * methode permettant de choisir entre "se deplacer" ou "attaquer" avec le robot
	 * @param robotSelectionne
	 */
	
	public static void choixAction(Robot robotSelectionne){
		int choix = 0;
		while(choix < 1 || choix > 2){
			String saisie = "";
			try{
				saisie = JOptionPane.showInputDialog("Robot Selectionne : "
						+ robotSelectionne 
						+ "\n"
						+ "Choisissez l'action du robot \n"
						+ "1.Delacement \n"
						+ "2.Tir \n");
				choix = Integer.parseInt(saisie);
				}catch(Exception e){
					if(saisie == null)
						System.exit(0);
					JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des reonses possibles." );
				}
			if(choix == 1){

				boolean deplacementPossible = false;
				while(!deplacementPossible){
					int x, y, a, b;
					String saisie1 = "";
					try{
						saisie = JOptionPane.showInputDialog("x:");
						x = Integer.parseInt(saisie);
						saisie1 = JOptionPane.showInputDialog("y:");
						y = Integer.parseInt(saisie1);
						Deplacement dep = new Deplacement(robotSelectionne, x, y);
						a = robotSelectionne.getCoordonnees().getX();
						b = robotSelectionne.getCoordonnees().getY();
						deplacementPossible = dep.canMove();
						if (deplacementPossible && (plat.estVide(x, y) || plat.estMine(x, y))) {
							if(plat.estMine(x, y)){
								plat.vider(new Coordonnees(x, y));
								plat.vider(new Coordonnees(a, b));
								Robot p = new Piegeur();
								j.robotAttaque(p, robotSelectionne);
								dep.agit();
								System.out.println(robotSelectionne.getEnergie());
								plat.setRobot(x, y, robotSelectionne);
							}
							else{
								plat.vider(new Coordonnees(a, b));
								dep.agit();
								System.out.println(robotSelectionne.getEnergie());
								plat.setRobot(x, y, robotSelectionne);
							}
							f.repaint();
						}
					}catch(Exception e){
						if(saisie == null || saisie1 == null)
							System.exit(0);
						JOptionPane.showMessageDialog(null, "Ces coordonnees ne fonctionnent pas" );
					}
				}

				f.repaint();
				
			}
			//Fonction de tir
			else{
				int choix_x = -1;
				int choix_y = -1;
				boolean peutTirer = false;
				Robot robotAttaque = new Piegeur();
				while((choix_x < 0 || choix_x > config_PlateauX || choix_y < 0 || choix_y > config_PlateauY) && !peutTirer){
					choix_x = 0;
					choix_y = 0;
					String saisie1 = "";
					try{
						saisie = JOptionPane.showInputDialog("x:");
						choix_x = Integer.parseInt(saisie);
						saisie1 = JOptionPane.showInputDialog("y:");
						choix_y = Integer.parseInt(saisie1);
						Attaque a = new Attaque(robotSelectionne, new Coordonnees(choix_x, choix_y));
						robotAttaque = plat.getRobot(choix_x, choix_y);
						peutTirer = a.peutAttaquer(robotAttaque);
					}catch(Exception e){
							if(saisie == null)
								System.exit(0);
							JOptionPane.showMessageDialog(null, "Les coordonnees ne fonctionnent pas" );
					}
					
				}
				if(peutTirer){
					if(robotSelectionne instanceof Piegeur){
						if(plat.estVide(choix_x, choix_y)) {
							plat.setMine(choix_x, choix_y);
							f.repaint();
						}
					}else{
						j.robotAttaque(robotSelectionne, robotAttaque);
					}
				}
			}
		}
	}
	/**
	 * Main
	 * @param args
	 */
	
	public static void main(String args[]) {

		// Nouveau jeu
		j = new Jeu();

		//Configuration du plateau
		config_PlateauX = j.config_TaillePlateauX();
		config_PlateauY = j.config_TaillePlateauY();

		// Cr�ation du plateau
		plat = new Plateau(config_PlateauY, config_PlateauY);
		// Cr�ation de la vue
		Vue vue_plat = new Vue(plat);

		// Acquisition des bases
		Coordonnees Base1 = plat.getBase(1);
		Coordonnees Base2 = plat.getBase(2);
		
		//Creation des equipes
		//Equipe 1
		int cx_x = 0;
		int cx_y = 0;
		joueurActuel = 1;
		Robot piegeur1 = new Piegeur(vue_plat, cx_x+1, cx_y, joueurActuel);
		plat.setRobot(cx_x+1, cx_y, piegeur1);
		j.ajouterRobot(joueurActuel, piegeur1);
		Robot tireur1 = new Tireur(vue_plat, cx_x, cx_y+1, joueurActuel);
		plat.setRobot(cx_x, cx_y+1, tireur1);
		j.ajouterRobot(joueurActuel, tireur1);
		Robot chaR1 = new Char(vue_plat, cx_x+1, cx_y+1, joueurActuel);
		plat.setRobot(cx_x+1, cx_y+1, chaR1);
		j.ajouterRobot(joueurActuel, chaR1);
		
		//Equipe 2
		cx_x = config_PlateauX-1;
		cx_y = config_PlateauY-1;
		joueurActuel = 2;
		Robot piegeur2 = new Piegeur(vue_plat, cx_x-1, cx_y, joueurActuel);
		plat.setRobot(cx_x-1, cx_y, piegeur2);
		j.ajouterRobot(joueurActuel, piegeur2);
		Robot tireur2 = new Tireur(vue_plat, cx_x, cx_y-1, joueurActuel);
		plat.setRobot(cx_x, cx_y-1, tireur2);
		j.ajouterRobot(joueurActuel, tireur2);
		Robot chaR2 = new Char(vue_plat, cx_x-1, cx_y-1, joueurActuel);
		plat.setRobot(cx_x-1, cx_y-1, chaR2);
		j.ajouterRobot(joueurActuel, chaR2);
		
		//Affichage de la fenetre
		f = new Fenetre(plat, j);
		
		// Affichage menu joueur
		joueurActuel = 1;
		JOptionPane.showMessageDialog(null, "C'est au tour du joueur " + joueurActuel);
		
		// Lancement de la partie
		while (j.partieTerminee() == 0) {

			// Affichage plateau
			f.repaint();
			
			
			// Choix 1 - Demande de l'action � executer
			int c_1 = 0;
			String saisie = "";
			// V�rification donn�es utilisateur
			while ((c_1 != 1) && (c_1 != 2) && (c_1 != 3) && (c_1 != 4)) {
				try{
				saisie = JOptionPane.showInputDialog("Que voulez vous faire ? \n "
						+ "1.S�lectionner un robot \n "
						+ "2.Afficher mes robots \n "
						+ "3.Ajouter un robot \n"
						+ "4.Changer de joueur");
				c_1 = Integer.parseInt(saisie);
				}catch(Exception e){
					if(saisie == null)
						System.exit(0);
					JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des reonses possibles." );
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
					JOptionPane.showMessageDialog(null, j.getRobots_Equipe1());
				}
				else{
					JOptionPane.showMessageDialog(null, j.getRobots_Equipe2());
				}
			}else if (c_1 == 3) {
				int cc_1 = 0;
				while ((cc_1 != 1) && (cc_1 != 2) && (cc_1 != 3)) {
					try{
					saisie = JOptionPane.showInputDialog("Quelle unit� ? \n "
							+ "1.Piegeur \n "
							+ "2.Tireur \n "
							+ "3.Char \n");
					cc_1 = Integer.parseInt(saisie);
					}catch(Exception e){
						if(saisie == null)
							System.exit(0);
						JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n ne fait pas partie des reonses possibles." );
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

							
				f.repaint();
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
		f.repaint();

	}

}
