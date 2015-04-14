
/**
 * La classe Char représente un Robot particulier, le Char, avec les caractéristiques communes à tous les Robots,
 * mais des valeurs différentes pour ces caractéristiques.
 * @author ?, Cyrille
 */
public class Char extends Robot {

	/**
	 * Construit un nouveau Char, avec une vue associée, des coordonnées, et une équipe
	 * @param vue - la vue assiciée au Char
	 * @param x - l'abscisse des coordonnées du Char
	 * @param y - l'ordonnée des coordonnées du Char
	 * @param equipe - l'équipe du Char
	 */
	public Char(Vue vue,int x, int y, int equipe){
		super(vue, x, y, equipe);
		super.setEnergieInitiale(60);
		super.setEnergie(60);
		super.setDepMax(2);
		super.setPortee(10);
		super.setCoutDep(5);
		super.setEquipe(equipe);
		super.typeRobot = "c";
	}

	@Override
	public boolean peutTirer() {
		if (super.getEnergie() > 0) return true;
		return false;
	}

	@Override
	public int getCoutAction() { return 1; }

	@Override
	public int getCoutDep() { return 5; }

	@Override
	public int getDegatTir() { return 6; }

	@Override
	public int getDegatMine() { return 0; }
	
}

