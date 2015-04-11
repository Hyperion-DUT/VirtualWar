package main;

public class Base extends Cellule {
	
	public Base(int x, int y, int equipe){
		super(x,y);
		super.base = equipe;
	}

	@Override
	public void videCase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajoute(int equipe) {
		super.base = equipe;
	}

	@Override
	public void deplaceSur(Robot robot) {
		// TODO Auto-generated method stub
		
	}

}
