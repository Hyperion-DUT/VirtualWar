package VirtualWar.Unites;
import VirtualWar.Plateau.Vue;



/**
 * La classe Piegeur représente un robot qui a pour action de poser des mines au sol. Il ne peut pas tirer.
 * @author Cyrille
 */
public class Piegeur extends Robot {

	/**
	 * Construit un robot Piegeur appartenant à une équipe, et aux coordonnées mentionnées
	 * @param vue - le vue à laquelle le Piegeur est rattaché
	 * @param x - l'abscisse des coordonnées du Piegeur
	 * @param y - l'ordonnée des coordonnées du Piegeur
	 * @param equipe - l'équipe d'appartenance du Piegeur
	 */
	public Piegeur(Vue vue, int x, int y, int equipe) {
		super(vue, x, y, equipe);
		super.setEnergieInitiale(50);
		super.setEnergie(50);
		super.setPortee(1);
		super.setDepMax(1);
		super.setRegenBase(2);
		super.setCoutDep(2);
		super.typeRobot = "p";
	}

	public Piegeur() {
		super();
	}

	@Override
	/**
	 * Renvoie si il est possible de tirer 
	 */
	public boolean peutTirer() { return false; }

	@Override
	/**
	 * Renvoie le cout de l'action de l'unite selectionnee.
	 */
	public int getCoutAction() { return 2; }

	@Override
	/**
	 * Renvoie le cout de deplacement de l'unite selectionnee.
	 */
	public int getCoutDep() { return 2; }

	@Override
	/**
	 * Renvoie les degats infliges par l'unite (ici zero car elle est incapable de tirer).
	 */
	public int getDegatTir() { return 0; }

	/**
	 * Renvoie les degats infliges par les mines posees par l'unite.
	 */
	public int getDegatMine() { return 2; }

}
