package main;

/**
 * 
 * @author noxilex
 *
 */
abstract public class Cellule {
	protected int mine;
	protected int base;
	public String image;
	private Coordonnees coord;
	private Robot robot;
	
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
	
	/**
	 * @return
	 */
	public boolean estBase(){
		return base != 0;
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
		return "Cellule [mine=" + mine + ", base=" + base + ", image=" + image
				+ ", coord=" + coord + ", robot=" + robot + "]";
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
