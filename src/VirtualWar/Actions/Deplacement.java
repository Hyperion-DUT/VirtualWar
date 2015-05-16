package VirtualWar.Actions;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Robot;

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
	public Deplacement(Robot robot, Coordonnees direction) {
		super(robot, direction);
	}

	@Override
	/** Attribue au robot de nouvelles coordonnées */
	public void agit() {
		int a, b, x, y;
		a = getDirection().getX();
		b = getDirection().getY();
		x = getRobot().getCoordonnees().getX();
		y = getRobot().getCoordonnees().getY();
		if (getRobot() instanceof Char) {
			if ((a == x) && (b == y-2 || b == y+2)) getRobot().setCoordonnees(getDirection());
			if ((b == y) &&	(a == x-2 || a == x+2)) getRobot().setCoordonnees(getDirection());
		} else {
			if ((a >= x-1 && a <= x+1) && (b >= y-1 && b <= y+1)) getRobot().setCoordonnees(getDirection());
		}
	}

}
