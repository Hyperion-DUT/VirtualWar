package main;

public class Case extends Cellule {
	int typeCase;
	
	public Case(int x, int y){
		super(x, y);
	}
	
	public Case(int x, int y, Robot robot){
		super(x, y);
		this.robot = robot;
	}
	
	public int getTypeCase(){
		return typeCase;
	}
	
	public void setTypeCase(int type){
		typeCase = type;
	}

	public boolean estNeutre(){
		return typeCase == 0;
	}
	
	public boolean estMine(){
		return typeCase == 1;
	}
	
	public void setObstacle(){
		obstacle = true;
	}
	
	public boolean estObstacle(){
		return typeCase == 3;
	}
	@Override
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
	public void deplaceSur(Robot robot) {
		// TODO Auto-generated method stub
		this.robot = robot;
	}
	
	//Type case: 0=Neutre, 1= Mine, 2= Robot, 3 = Obstacle

}
