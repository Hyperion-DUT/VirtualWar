package VirtualWar.Actions;
import VirtualWar.Plateau.Coordonnees;
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
		super.getRobot().setCoordonnees(super.getDirection());
	}

}
