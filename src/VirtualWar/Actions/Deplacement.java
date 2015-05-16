package VirtualWar.Actions;

import javax.swing.JOptionPane;

import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Robot;



/**
 * La classe Deplacement représente le déplacement effectué par un Robot, par le biais du robot sélectionné et des coordonnées saisies.
 * @author Cyrille
 */
public class Deplacement extends Action {

	private int portee;
	private int coutEnergie;
	
	/**
	 * Construit un déplacement avec des coordonnées à appliquer au robot sélectionné
	 * @param robot - le robot qui effectue le déplacement
	 * @param direction - les coordonnées de destination du robot
	 */
	public Deplacement(Robot robot, int x, int y) {
		super(robot, new Coordonnees(x,y));
		portee = robot.getDepMax();
		coutEnergie = robot.getCoutDep();
	}

	public void agit() {
		move();
	}
	
	/** Attribue au robot de nouvelles coordonnées */
	public boolean move() {
		Robot r = getRobot();
		int a, b, x, y;
		a = getDirection().getX();
		b = getDirection().getY();
		x = r.getCoordonnees().getX();
		y = r.getCoordonnees().getY();
		if (r instanceof Char) {
			if (((a == x) && (b >= y-r.getDepMax() || b <= y+r.getDepMax())) || ((b == y) && (a >= x-r.getDepMax() || a <= x+r.getDepMax()))) {
				r.setCoordonnees(getDirection());
				r.setEnergie(r.getEnergie()-coutEnergie);
				return true;
			}
		} else {
			if ((a >= x-r.getDepMax() && a <= x+r.getDepMax()) && (b >= y-r.getDepMax() && b <= y+r.getDepMax())) {
				r.setCoordonnees(getDirection());
				r.setEnergie(r.getEnergie()-coutEnergie);
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Déplacement non autorisé, veuillez recommencer.");
		return false;
	}

}
