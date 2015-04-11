package main;

public class Case extends Cellule {
	int typeCase;
	
	public Case(int x, int y){
		super(x, y);
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
	
	public boolean estRobot(){
		return typeCase == 2;
	}
	
	public boolean estObstacle(){
		return typeCase == 3;
	}
	@Override
	public void videCase() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ajoute(int equipe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deplaceSur(Robot robot) {
		// TODO Auto-generated method stub
		
	}
	
	//Type case: 0=Neutre, 1= Mine, 2= Robot, 3 = Obstacle

}
