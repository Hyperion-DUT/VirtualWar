/**
 * 
 * @author Jules
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {

	/**
	 * Entrée utilistauer
	 */
	private Scanner s = new Scanner(System.in);

	/**
	 * Nombre de robots présents sur le plateau durant la partie
	 */
	private int nbRobots;

	/**
	 * Equipes -> Robots
	 */
	private ArrayList<Robot> r_eq1 = new ArrayList<Robot>();
	private ArrayList<Robot> r_eq2 = new ArrayList<Robot>();

	/**
	 * Constructeur par défaut
	 */
	public Jeu() {
		// Message de bienvenue
		System.out.println("Bienvenue dans VirtualWar - Version 1 - Console ");
		System.out.println(" ");
		System.out.println("Lancement de la partie ...");
		System.out.println(" ");
	}

	/**
	 * Fonction pour attaquer un robot (r1 -> robot attaquant, r2-> robot
	 * touché)
	 * 
	 * @param r1
	 * @param r2
	 * @return
	 */
	public boolean robotAttaque(Robot r1, Robot r2) {
		if (r1.getEquipe() != r2.getEquipe()) {
			if (r1 instanceof Tireur || r1 instanceof Char)
				r2.subitTir();
			else if (r1 instanceof Piegeur)
				r2.subitMine();
			return true;
		} else {
			System.out.println("[ATTAQUE] Vous ne pouvez pas attaquer un robot de votre équipe");
		}
		return false;
	}

	/**
	 * Fonction pour déterminer si la partie est terminée et retourner l'équipe gagnante 
	 * @return
	 */
	public int partieTerminee() {
		int equipe_gagnante = 0 ;
		if (r_eq1.isEmpty()) equipe_gagnante = 1;
		else if(r_eq2.isEmpty()) equipe_gagnante = 2;
		return equipe_gagnante;
	}

	/**
	 * Fonction pour ajouter un robot dans une équipe
	 * 
	 * @param equipe
	 * @param r
	 */
	public void ajouterRobot(int equipe, Robot r) {
		if (equipe == 1) {
			r_eq1.add(r);
		} else if (equipe == 2) {
			r_eq2.add(r);
		}
	}

	/**
	 * Fonction pour retirer un robot d'une equipe spécifique
	 * 
	 * @param equipe
	 * @param r
	 */
	public void supprimerRobot(int equipe, Robot r) {
		if (equipe == 1) {
			r_eq1.remove(r);
		} else if (equipe == 2) {
			r_eq2.remove(r);
		}
	}

	/**
	 * Fonction pour retourner les robots de l'equipe 1
	 * 
	 * @return
	 */
	public ArrayList<Robot> getRobots_Equipe1() {
		return r_eq1;
	}

	/**
	 * Fonction pour retourner les robots de l'equipe 2
	 * 
	 * @return
	 */
	public ArrayList<Robot> getRobots_Equipe2() {
		return r_eq2;
	}

	/**
	 * Config -> Demander la taille X du plateau
	 * 
	 * @return
	 */
	public int config_TaillePlateauX() {
		// Init
		int s_x = 0;
		// Tant que la saisie n'est pas valide
		while (s_x == 0 || s_x == 1) {
			try {
				// Demande utilisateur
				System.out
						.println("Veuillez entrer la largeur du plateau (X) -> ");
				// Saisie
				s_x = s.nextInt();
				// Vérification saisie
				if (s_x == 0 || s_x == 1)
					System.out.println("Erreur, veuillez reessayez!");
			} catch (Exception e) {
				// Erreur lors de la saisie
				System.out.println("Erreur, veuillez reessayez!");
			}
		}
		// Retourne la largeur
		return s_x;
	}

	/**
	 * Config -> Demander la taille Y du plateau
	 * 
	 * @return
	 */
	public int config_TailleTableauY() {
		// Init
		int s_y = 0;
		// Tant que la saisie n'est pas valide
		while (s_y == 0 || s_y == 1) {
			try {
				// Demande utilisateur
				System.out
						.println("Veuillez entrer la largeur du plateau (Y) -> ");
				// Saisie
				s_y = s.nextInt();
				// Vérification saisie
				if (s_y == 0 || s_y == 1)
					System.out.println("Erreur, veuillez reessayez!");
			} catch (Exception e) {
				// Erreur lors de la saisie
				System.out.println("Erreur, veuillez reessayez!");
			}
		}
		// Retourne la hauteur
		return s_y;
	}

}
