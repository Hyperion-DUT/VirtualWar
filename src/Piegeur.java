import java.util.ArrayList;


public class Piegeur extends Robot {

	public Piegeur(Vue vue, int X, int Y, int Equipe) {
		super(vue, X, Y, Equipe);
		// TODO Auto-generated constructor stub
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
		return 0;
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

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Coordonnees> getDeplacements() {
		// TODO Auto-generated method stub
		return null;
	}

}
