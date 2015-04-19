public class Vue {
	/**
	 * booleen qui donne ou non la visibilité sur un unité.
	 */
	private boolean estVisible;
	
	private Plateau plateau;
	
	public Vue(){
		
	}
	/**
	 * 
	 * @param plateau
	 */
	public Vue(Plateau plateau){
		this.plateau = plateau;
	}
	/**
	 * Retourne le robot sur la case dont les coordonnées sont placées en paramatre
	 * @param coord contient deux int correspondant à l'abscisse et à l'ordonnée de la case.
	 * @return
	 */
	public Robot getRobot(Coordonnees coord){
		return plateau.getRobot(coord.getX(), coord.getY());
	}
	/**
	 * Retourne les coordonnées de la base d'une equipe
	 * @param equipe l'equipe à laquelle appartient la base.
	 * @return ensemble de 2 int donnant les coordoonées.(x puis y)
	 */
	public Coordonnees getBase(int equipe){
		return plateau.getBase(equipe);
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonnées placée en paramatre contient une mine.
	 * @param coord
	 * @return vrai si la case contient une  mine, faux sinon.
	 */
	public boolean estMine(Coordonnees coord){
		return plateau.estMine(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonnées placée en paramatre contient un robot.
	 * @param coord
	 * @return vrai si la case contient un robot, faux sinon.
	 */
	public boolean estRobot(Coordonnees coord){
		return plateau.estRobot(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonnées placée en paramatre contient un robot.
	 * @param coord
	 * @return vrai si la case contient un obstacle, faux sinon.
	 */
	public boolean estObstacle(Coordonnees coord){
		return plateau.estObstacle(coord.getX(), coord.getY());
	}
	/**
	 * Retourne un booleen indiquant si la case de coordonnées placée en paramatre contient une base.
	 * @param coord
	 * @return vrai si la case contient une base, faux sinon.
	 */
	public boolean estBase(Coordonnees coord){
		return plateau.estBase(coord.getX(), coord.getY());
	}
	/**
	 * Pose une mine sur la case dont les coordonnées sont placées en parametre.
	 * @param coord
	 */
	public void setMine(Coordonnees coord){
		plateau.setMine(coord.getX(), coord.getY());
	}
	/**
	 * Place le robot placé en parametre sur la case de coordonnées placées en parametre.
	 * @param coord
	 * @param robot
	 */
	public void setRobot(Coordonnees coord, Robot robot){
		plateau.setRobot(coord.getX(), coord.getY() ,robot);
	}
	/**
	 * Place un obstacle sur la case dont les coordonnées sont placées en parametre.
	 * @param coord
	 */
	public void setObstacle(Coordonnees coord){
		plateau.setObstacle(coord.getX(), coord.getY());
	}
	/**
	 * Place la base de l'equipe placée en parametre sur la case de coordonnées placées en parametre.
	 * @param coord
	 * @param equipe
	 */
	public void setBase(Coordonnees coord, int equipe){	
		plateau.setBase(coord.getX(), coord.getY(), equipe);
	}
	/**
	 * vide la case dont les coordonnées sont placées en parametre.
	 * @param coord
	 */
	public void Vider(Coordonnees coord){
		plateau.Vider(coord.getX(),coord.getY());
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
