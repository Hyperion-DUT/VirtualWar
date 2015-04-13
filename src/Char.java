
public class Char extends Robot {

	
	int energie = 60;

	public Char(Vue vue,int x, int y, int equipe){
		super(vue, x, y, equipe);
		setDepMax(2);
		setPortee(10);
		setCoutDep(5);
		setEquipe(equipe);
		setEnergieInitiale(60);
		super.typeRobot = "Char";
	}


	@Override
	public boolean peutTirer() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCoutAction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

