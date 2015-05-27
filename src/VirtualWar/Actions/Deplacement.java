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

	/** Attribue au robot de nouvelles coordonnées */
	public void agit() {
		Robot r = getRobot();
		if (r instanceof Char) {
			r.setCoordonnees(getDirection());
			r.setEnergie(r.getEnergie()-coutEnergie);
		} else {
			r.setCoordonnees(getDirection());
			r.setEnergie(r.getEnergie()-coutEnergie);
		}
	}
	
	/**
	 * Retourne vrai si le robot peut se déplacer à la position demandée, sinon retourne faux
	 * @return
	 */
	public boolean canMove() {
		Robot r = getRobot();
		int a, b, x, y;
		a = getDirection().getX();
		b = getDirection().getY();
		x = r.getCoordonnees().getX();
		y = r.getCoordonnees().getY();
		if (r instanceof Char) {
			if (r.getEnergie() > coutEnergie && ((a == x) && (b >= y-r.getDepMax() && b <= y+r.getDepMax())) || ((b == y) && (a >= x-r.getDepMax() && a <= x+r.getDepMax())) ) {
				return true;
			}
		} else {
			if (r.getEnergie() > coutEnergie && (a >= x-r.getDepMax() && a <= x+r.getDepMax()) && (b >= y-r.getDepMax() && b <= y+r.getDepMax()) ) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "Déplacement non autorisé, veuillez recommencer.");
		return false;
	}

}
