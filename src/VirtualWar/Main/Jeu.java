package VirtualWar.Main;
/**
 * 
 * @author Jules
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import VirtualWar.Actions.Deplacement;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Piegeur;
import VirtualWar.Unites.Robot;
import VirtualWar.Unites.Tireur;

public class Jeu extends JFrame{

	/**
	 * Entrée utilisateur
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
	}

	/**
	 * Fonction pour attaquer un robot (r1 -> robot attaquant, r2-> robot ciblé)
	 * 
	 * @param r1
	 * @param r2
	 * @return
	 */
	public boolean robotAttaque(Robot r1, Robot r2) {
		if (r1.getEquipe() != r2.getEquipe()) {
			if (r1 instanceof Tireur || r1 instanceof Char)
				r2.subitTir(r1);
			else if (r1 instanceof Piegeur)
				r2.subitMine();
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "[ATTAQUE] Vous ne pouvez pas attaquer un robot de votre �quipe");
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
		String saisie = "";
		// Tant que la saisie n'est pas valide
		while (s_x == 0 || s_x == 1) {
			try {
				// Saisie
				saisie = JOptionPane.showInputDialog("Veuillez entrer la largeur du plateau (X): \n Attention ! (La taille minimum est de 11)");
				s_x = Integer.parseInt(saisie);
				// V�rification saisie
				if (s_x < 11)
					JOptionPane.showMessageDialog(null, "Attention ! (La taille minimum est de 11)");
				if (saisie == null){
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				// Erreur lors de la saisie
				
				if(saisie == null)
					System.exit(0);
				JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n n'est pas un nombre r�el" );
				
			} catch(Exception e){
				e.printStackTrace();
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
	public int config_TaillePlateauY() {
		// Init
		int s_y = 0;
		String saisie = "";
		// Tant que la saisie n'est pas valide3
		while (s_y == 0 || s_y == 1) {
			try {
				// Demande utilisateur
				saisie = JOptionPane.showInputDialog("Veuillez entrer la largeur du plateau (Y): \n Attention ! (La taille minimum est de 11)");
				s_y = Integer.parseInt(saisie);
				// V�rification saisie
				if (s_y < 11)
					JOptionPane.showMessageDialog(null, "Attention ! (La taille minimum est de 11)");
			} catch (Exception e) {
				// Erreur lors de la saisie
				if(saisie == null)
					System.exit(0);
				JOptionPane.showMessageDialog(null, "Erreur ! \n '" + saisie + "' \n n'est pas un nombre r�el" );
			}
		}
		// Retourne la hauteur
		return s_y;
	}

}
