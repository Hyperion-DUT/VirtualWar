
package VirtualWar.Actions;
import javax.swing.JOptionPane;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.*;

/**
 * La classe Deplacement représente le déplacement effectué par un Robot, par le biais du robot sélectionné et des coordonnées saisies.
 * @author Cyrille
 */
public class Deplacement extends Action{

	/**
	 * Construit un déplacement avec des coordonnées à appliquer au robot sélectionné
	 * @param robot - le robot qui effectue le déplacement
	 * @param direction - les coordonnées de destination du robot
	 */
	public Deplacement(Robot robot, int x, int y) {
		super(robot, new Coordonnees(x, y));
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
			if (((a == x) && (b >= y-2 || b <= y+2)) || ((b == y) && (a >= x-2 || a <= x+2))) {
				getRobot().setCoordonnees(getDirection());
				return true;
			}
		} else if (getRobot() instanceof Tireur || getRobot() instanceof Piegeur) {
			if ((a >= x-1 && a <= x+1) && (b >= y-1 && b <= y+1)) {
				getRobot().setCoordonnees(getDirection());
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Déplacement non autorisé, veuillez recommencer.");	
		return false;
	}

}
