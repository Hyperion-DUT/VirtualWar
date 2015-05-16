package VirtualWar.Unites;
import VirtualWar.Plateau.Vue;


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
		setEnergieInitiale(60);
		setEnergie(60);
		setDepMax(2);
		setPortee(10);
		setCoutDep(5);
		setEquipe(equipe);
		typeRobot = "c";
	}

	@Override
	public boolean peutTirer() {
		if (getEnergie() > 0) return true;
		return false;
	}

	@Override
	/**
	 * Retourne le cout de l'action.
	 */
	public int getCoutAction() { return 1; }

	@Override
	/**
	 * Retourne le cout du deplacement.
	 */
	public int getCoutDep() { return 5; }

	@Override
	/**
	 * Retourne les d�gats des tirs. 
	 */
	public int getDegatTir() { return 6; }

	public int getDegatMine() { return 0; }
	
}

