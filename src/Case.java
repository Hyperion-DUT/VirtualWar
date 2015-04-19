public class Case extends Cellule {
	/**
	 * Cnitialisation d'une variable definissant le type de la case.
	 */
	int typeCase;
	/**
	 * Construit les coordonnées de la case
	 */
	public Case(int x, int y){
		super(x, y);
	}
	/**
	 * Construit les coordonnées de la case et prend en parametre le robot se situant dessus.
	 */
	public Case(int x, int y, Robot robot){
		super(x, y);
		this.robot = robot;
	}
	/**
	 * Renvoie le type de la case caracterisée par la valeur numerique qui lui correspond.
	 */
	public int getTypeCase(){
		return typeCase;
	}
	/**
	 * Modifie le type de la case.
	 */
	public void setTypeCase(int type){
		typeCase = type;
	}
	/**
	 * Retourne vrai si la case est neutre(pas d'equipe ni d'obstacle).
	 */
	public boolean estNeutre(){
		return typeCase == 0;
	}
	/**
	 * Retourne vrai si la case est une mine.
	 */
	public boolean estMine(){
		return typeCase == 1;
	}
	/**
	 * Definie la case comme etant un obstacle.
	 */
	public void setObstacle(){
		obstacle = true;
	}
	/**
	 * Renvoie vrai si la case est un obstacle.
	 */
	public boolean estObstacle(){
		return typeCase == 3;
	}
	@Override
	/**
	 * rend la case neutre et supprime l'obstacle si il y en a un.
	 */
	public void videCase() {
		// TODO Auto-generated method stub
			typeCase = 0;
			base = 0;
			mine = 0;
			robot = null;
			obstacle = false;
			image = "";
	}

	@Override
	public void ajoute(int equipe) {
		// TODO Auto-generated method stub

	}

	@Override
	/**
//	 * Place le robot en parametre sur la case.
	 */
	public void deplaceSur(Robot robot) {
		// TODO Auto-generated method stub
		this.robot = robot;
	}
	
	//Type case: 0=Neutre, 1= Mine, 2= Robot, 3 = Obstacle

}
