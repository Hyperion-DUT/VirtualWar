/**
 * 
 * @author noxilex
 *
 */
abstract public class Cellule {
	protected int mine;
	protected int base;
	protected boolean obstacle;
	public String image;
	private Coordonnees coord;
	protected Robot robot;
	
	/**
	 * 
	 * @param X
	 * @param Y
	 */
	public Cellule(int X, int Y){
		coord = new Coordonnees(X,Y);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean estMine(){
		return mine != 0;
	}
	
	public int getBase(){
		return base;
	}
	
	/**
	 * @return
	 */
	public boolean estBase(){
		return base != 0;
	}
	
	public boolean estObstacle(){
		return obstacle;
	}
	
	public boolean estRobot(){
		return robot != null;
	}

	public boolean estVide(){
		if(estMine() == false && estRobot() == false && estObstacle() == false && estBase() == false){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public Coordonnees getCoordonnees(){
		return coord;
	}
	
	/**
	 * 
	 * @return
	 */
	public Robot getContenu(){
		return robot;
	}
	
	@Override
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
