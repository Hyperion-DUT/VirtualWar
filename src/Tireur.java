/**
 * 
 * Alexandre
 **/


public class Tireur extends Robot {

	int x;
	int y;
	int equipe;
	
	/**
	 * 
	 * @param vue_robot
	 * @param X
	 * @param Y
	 * @param Equipe
	 */
	public Tireur(Vue vue_robot,int x, int y, int equipe){
		super(vue_robot, x, y, equipe);
		setEnergieInitiale(40);
		setEnergie(40);
		setPortee(3);
		setDepMax(1);
		setRegenBase(2);
		setCoutTir(2);
		setCoutDep(1);
		setDegats(3);
		super.typeRobot = "t";
	}

	@Override
	public boolean peutTirer() {
	 return getEnergie() >= 2;
	}

	@Override
	public int getCoutAction() {
		return 2;
	}

	@Override
	public int getCoutDep() {
		return 1;
	}
	
	@Override
	public int getDegatTir() {
		return 2;
	}
	
	@Override
	public int getDegatMine() {
		return 0;
	}
	
}
