package VirtualWar.Actions;
import javax.swing.JOptionPane;

import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Robot;

/**
 * La classe Deplacement représente le déplacement effectué par un Robot, par le biais du robot sélectionné et des coordonnées saisies.
 * @author Cyrille
 */
public class Deplacement extends Action{

	int porteeDeplacement;
	int coutDeplacement;
	
	/**
	 * Construit un déplacement avec des coordonnées à appliquer au robot sélectionné
	 * @param robot - le robot qui effectue le déplacement
	 * @param direction - les coordonnées de destination du robot
	 */
	public Deplacement(Robot robot, int x, int y) {
		super(robot, new Coordonnees(x,y));
		porteeDeplacement = robot.getDepMax();
		coutDeplacement = robot.getCoutDep();
	}

	public void agit() {
		move();
	}
	
	/** Attribue au robot de nouvelles coordonnées */
	public boolean move() {
		int a, b, x, y;
		a = getDirection().getX();
		b = getDirection().getY();
		x = getRobot().getCoordonnees().getX();
		y = getRobot().getCoordonnees().getY();
		if (getRobot() instanceof Char) {
			if ((a-x <= porteeDeplacement && b-y == 0) || (a-x == 0 && b-y <= porteeDeplacement)) {
				getRobot().setCoordonnees(getDirection());
				return true;
			}
		} else {
			if ((a >= x-1 && a <= x+1) && (b >= y-1 && b <= y+1)) {
				getRobot().setCoordonnees(getDirection());
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Déplacement non autorisé, veuillez recommencer.");
		return false;
	}

}
