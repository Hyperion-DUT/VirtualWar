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
	 * Méthode -> Pour récupérer le robot qui est source de l'action
	 * 
	 * @return
	 */
	public Robot getRobot() {
		return robot;
	}

	/**
	 * Méthode -> Pour récupérer la direction de l'action
	 * 
	 * @return
	 */
	public Coordonnees getDirection() {
		return direction;
	}

	/**
	 * Méthode -> Pour éxécuter l'action
	 */
	abstract void agit();

}