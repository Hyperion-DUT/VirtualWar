import java.util.ArrayList;
public class Tireur extends Robot {

	int X;
	int Y;
	int equipe;
	
	// Variable -> Vue du robot
	Vue vue_robot = new Vue();
	
	ArrayList <Coordonnees> historiqueDep = new ArrayList <Coordonnees>();
	
	/**
	 * 
	 * @param vue_robot
	 * @param X
	 * @param Y
	 * @param Equipe
	 */
	public Tireur(Vue vue_robot,int X, int Y, int Equipe){
		super(vue_robot,X,Y, Equipe);
		setEnergieInitiale(40);
		setEnergie(40);
		setPortee(3);
		setDepMax(1);
		setRegenBase(2);
		setCoutTir(2);
		setCoutDep(1);
		setDegats(3);
		typeRobot = "t";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean peutTirer() {
	 return getEnergie() >= 2;
	}

	/**
	 * 
	 */
	@Override
	public int getCoutAction() {
		return 2;
	}

	/**
	 * 
	 */
	@Override
	public int getCoutDep() {
		// TODO Auto-generated method stub
		return 1;
	}
	/**
	 * 
	 */
	@Override
	public int getDegatTir() {
		// TODO Auto-generated method stub
		return 2;
	}

	/**
	 * 
	 */
	@Override
	public int getDegatMine() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Tireur";
	}

	/**
	 * 
	 */
	
	@Override
	public ArrayList<Coordonnees> getDeplacements() {
		return historiqueDep;
	}
}
