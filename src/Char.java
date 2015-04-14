import java.awt.List;
import java.util.ArrayList;


public class Char extends Robot {

	
	int equipe;
	int x;
	int y;
/**
 * 
 * @param vue
 * @param x
 * @param y
 * @param equipe
 */
	

	
	public Char(Vue vue,int x, int y, int equipe){
	
		super(vue,x,y,equipe);
		
		setDepmax(2);
		setPortee(10);
		setCoutDep(5);
		setEnergieInitiale(60);
		setEnergie(60);
		setRegenBase(2);
		setCoutTir(1);
		setCoutDep(5);
		setDegats(6);
		
	}
	

	@Override
	public boolean peutTirer() {
		getEnergie();
		if(getEnergie()>getCoutAction()){
			return true;
		}
		return false;
	}

	@Override
	public int getCoutAction() {
		
		return 1;
	}

	@Override
	public int getCoutDep() {
		
		return 5;
	}

	@Override
	public int getDegatTir() {
		
		return 6;
	}

	@Override
	public int getDegatMine() {
		
		return 0;
	}

	@Override
	public String getType() {
		
		return ("C");
	}


	@Override
	public ArrayList<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

