package VirtualWar.Actions;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.Robot;

/**
 * 
 * @author Jules
 *
 */
public abstract class Action {

	/** Direction de l'action */
	private Coordonnees direction;

	/** Robot qui est source de l'action */
	private Robot robot;

	/**
	 * Constructeur -> Avec un robot et une direction
	 * 
	 * @param robot
	 * @param dir
	 */
	public Action(Robot robot, Coordonnees direction) {
		this.robot = robot;
		this.direction = direction;
	}

	/**
	 * M�thode -> Pour r�cup�rer le robot qui est source de l'action
	 * 
	 * @return
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * M�thode -> Pour r�cup�rer la direction de l'action
	 * 
	 * @return
	 */
	public Coordonnees getDirection() {
		return direction;
	}

	/**
	 * M�thode -> Pour �x�cuter l'action
	 */
	abstract void agit();

}