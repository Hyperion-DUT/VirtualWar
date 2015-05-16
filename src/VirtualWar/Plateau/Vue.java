package VirtualWar.Plateau;
import VirtualWar.Unites.Robot;

public class Vue {
	/**
	 * booleen qui donne ou non la visibilit� sur un unit�.
	 */
	private boolean estVisible;
	
	private Plateau plateau;
	
	public Vue(){
		
	}
	/**
	 * 
	 * @param plat
	 */
	public Vue(Plateau plat){
		this.plateau = plat;
	}
	/**
	 * Retourne le robot sur la case dont les coordonn�es sont plac�es en paramatre
	 * @param coord contient deux int correspondant � l'abscisse et � l'ordonn�e de la case.
	 * @return
	 */
	public Robot getRobot(Coordonnees coord){
		return plateau.getRobot(coord.getX(), coord.getY());
	}
	/**
	 * Retourne les coordonn�es de la base d'une equipe
	 * @param equipe l'equipe � laquelle appartient la base.
	 * @return ensemble de 2 int donnant les coordoon�es.(x puis y)
	 */
	public Coordonnees getBase(int equipe){
		return plateau.getBase(equipe);
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonn�es plac�e en paramatre contient une mine.
	 * @param coord
	 * @return vrai si la case contient une  mine, faux sinon.
	 */
	public boolean estMine(Coordonnees coord){
		return plateau.estMine(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonn�es plac�e en paramatre contient un robot.
	 * @param coord
	 * @return vrai si la case contient un robot, faux sinon.
	 */
	public boolean estRobot(Coordonnees coord){
		return plateau.estRobot(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonn�es plac�e en paramatre contient un robot.
	 * @param coord
	 * @return vrai si la case contient un obstacle, faux sinon.
	 */
	public boolean estObstacle(Coordonnees coord){
		return plateau.estObstacle(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonn�es plac�e en paramatre contient une base.
	 * @param coord
	 * @return vrai si la case contient une base, faux sinon.
	 */
	public boolean estBase(Coordonnees coord){
		return plateau.estBase(coord.getX(), coord.getY());
	}
	/**
	 * Pose une mine sur la case dont les coordonn�es sont plac�es en parametre.
	 * @param coord
	 */
	public void setMine(Coordonnees coord){
		plateau.setMine(coord.getX(), coord.getY());
	}
	/**
	 * Place le robot plac� en parametre sur la case de coordonn�es plac�es en parametre.
	 * @param coord
	 * @param robot
	 */
	public void setRobot(Coordonnees coord, Robot robot){
		plateau.setRobot(coord.getX(), coord.getY() ,robot);
	}
	/**
	 * Place un obstacle sur la case dont les coordonn�es sont plac�es en parametre.
	 * @param coord
	 */
	public void setObstacle(Coordonnees coord){
		plateau.setObstacle(coord.getX(), coord.getY());
	}
	/**
	 * Place la base de l'equipe plac�e en parametre sur la case de coordonn�es plac�es en parametre.
	 * @param coord
	 * @param equipe
	 */
	public void setBase(Coordonnees coord, int equipe){	
		plateau.setBase(coord.getX(), coord.getY(), equipe);
	}
	/**
	 * vide la case dont les coordonn�es sont plac�es en parametre.
	 * @param coord
	 */
	public void vider(Coordonnees c){
		plateau.vider(c);
	}
	/**
	 *
	 * @return
	 */
	public boolean estVisible() {
		return estVisible;
	}
	/**
	 * 
	 * @param estVisible
	 */
	public void setVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}
	/**
	 * 
	 */
	public String toString(){
		return plateau.toString();
	}
}
