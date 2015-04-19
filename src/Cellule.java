/**
 * 
 * @author noxilex
 *
 */
abstract public class Cellule {
	/**
	 * Definition des variables definissant les mines et les bases. Ce sont des réels
	 */
	protected int mine;
	protected int base;
	/**
	 * Définition de la variable qui renvoie si la case est un obstacle ou non. C'est un booleen.
	 */
	protected boolean obstacle;
	/**
	 * 
	 */
	public String image;
	/**
	 * Coordonnées de la cellule.
	 */
	private Coordonnees coord;
	/**
	 * robot se trouvant sur la cellule
	 */
	protected Robot robot;
	
	/**
	 * Construit la cellule de coordonnées (x,y).
	 * @param X abscisse de la cellule.
	 * @param Y ordonnée de la cellule.
	 */
	public Cellule(int X, int Y){
		coord = new Coordonnees(X,Y);
	}
	
	/**
	 * Renvoie vrai si la cellule contient une mine.
	 * @return booleen
	 */
	public boolean estMine(){
		return mine != 0;
	}
	
	/**
	 * Retourne la valeur de la variable base.
	 */
	public int getBase(){
		return base;
	}
	
	/**Retourne vrai si la cellule contient une base
	 * @return booleen
	 */
	public boolean estBase(){
		return base != 0;
	}
	
	/**
	 * Retourne obstacle(qui est un booleen) pour savoir si la cellule contient un obstacle.
	 */
	public boolean estObstacle(){
		return obstacle;
	}
	
	/**
	 * Retourne vrai si la cellule contient un robot
	 */
	public boolean estRobot(){
		return robot != null;
	}
	
	/**
	 *Retourne vrai si la case est vide(ni mine, ni robot, ni base, ni obstacle). 
	 */
	public boolean estVide(){
		if(estMine() == false && estRobot() == false && estObstacle() == false && estBase() == false){
			return true;
		}
		return false;
	}
	/**
	 * Retourne les coordonnées de la cellule
	 * @return
	 */
	public Coordonnees getCoordonnees(){
		return coord;
	}
	
	/**
	 * retourne le robot contenu par la cellule (si il y en a un). 
	 * @return
	 */
	public Robot getContenu(){
		return robot;
	}
	
	@Override
	/**
	 * Affiche un "#" si la case est un obstacle, un "b" si la case est une base appartenant à l'équipe 1, un "B" si la cellule contient une base appartenant à l'equipe 2, une * si la cellule contient une mine,
	 * le caractere assigné à chaque type de robot en majuscule ou minuscule en fonction de l'equipe et du type de robot.
	 * Affiche une blanc si la case est vide.
	 */
	public String toString() {
		if(this.estObstacle()){
			return "#";
		}
		else if(this.estBase()){
			if(base == 1){
				return "b";
			}
			else{
				return "B";
			}
		}
		else if(this.estMine()){
			return "*";
		}
		else if(this.estRobot()){
			if(robot.getEquipe() == 1){
				return robot.toString().toLowerCase();
			}
			else{
				return robot.toString().toUpperCase();
			}
			
		}
		else{
			return " ";
		}
	}
	
	/**
	 * 
	 */
	abstract public void videCase();
	
	/**
	 * 
	 * @param equipe
	 */
	abstract public void ajoute(int equipe);
	
	/**
	 * 
	 * @param robot
	 */
	abstract public void deplaceSur(Robot robot);
}
