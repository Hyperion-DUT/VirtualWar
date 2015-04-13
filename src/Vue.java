public class Vue {
	private boolean estVisible;
	private Plateau plateau;
	
	public Vue(){
		
	}
	
	public Vue(Plateau plateau){
		this.plateau = plateau;
	}
	
	public Robot getRobot(Coordonnees coord){
		return plateau.getRobot(coord.getX(), coord.getY());
	}
	
	public Coordonnees getBase(int equipe){
		return plateau.getBase(equipe);
	}
	
	public boolean estMine(Coordonnees coord){
		return plateau.estMine(coord.getX(), coord.getY());
	}
	
	public boolean estRobot(Coordonnees coord){
		return plateau.estRobot(coord.getX(), coord.getY());
	}
	
	public boolean estObstacle(Coordonnees coord){
		return plateau.estObstacle(coord.getX(), coord.getY());
	}
	
	public boolean estBase(Coordonnees coord){
		return plateau.estBase(coord.getX(), coord.getY());
	}
	
	public void setMine(Coordonnees coord){
		plateau.setMine(coord.getX(), coord.getY());
	}
	
	public void setRobot(Coordonnees coord, Robot robot){
		plateau.setRobot(coord.getX(), coord.getY() ,robot);
	}
	
	public void setObstacle(Coordonnees coord){
		plateau.setObstacle(coord.getX(), coord.getY());
	}
	
	public void setBase(Coordonnees coord, int equipe){	
		plateau.setBase(coord.getX(), coord.getY(), equipe);
	}
	
	public void Vider(Coordonnees coord){
		plateau.Vider(coord.getX(),coord.getY());
	}

	public boolean estVisible() {
		return estVisible;
	}

	public void setVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}
	
	public String toString(){
		return plateau.toString();
	}
}
