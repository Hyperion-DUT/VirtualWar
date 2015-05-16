package VirtualWar.Unites;
import VirtualWar.Plateau.Vue;

/**
 * 
 * @author Alexandre
 **/


public class Tireur extends Robot {

	int x;
	int y;
	int equipe;
	
	/**
	 * Construit un tireur avec ses caracteristiques de base en fonction de la vue du robot ses coordonnées et son equipe.
	 * @param vue_robot la vue du robot crée
	 * @param X abscisse de la case du robot
	 * @param Y ordonnée de la case du robot
	 * @param Equipe l'equipe à laquelle appartient le robot.
	 */
	public Tireur(Vue vue_robot,int x, int y, int equipe){
		super(vue_robot, x, y, equipe);
		setEnergieInitiale(40);
		setEnergie(40);
		setPortee(3);
		setDepMax(1);
		setRegenBase(2);
		setCoutTir(2);
		setCoutDep(1);
		setDegats(3);
		super.typeRobot = "t";
	}

	@Override
	/**
	 * Retourne vrai si le robot a suffisament d'énergie pour tirer.
	 */
	public boolean peutTirer() {
	 return getEnergie() >= 2;
	}

	@Override
	/**
	 * Retourne le coût de l'action du robot
	 */
	public int getCoutAction() {
		return 2;
	}

	@Override
	/**
	 * Retourne le cout de déplacement du robot.
	 */
	public int getCoutDep() {
		return 1;
	}
	
	@Override
	/**
	 * Retourne les dégats du tir du robot.
	 */
	public int getDegatTir() {
		return 2;
	}
	
	@Override
	public int getDegatMine() {
		return 0;
	}
	
}
