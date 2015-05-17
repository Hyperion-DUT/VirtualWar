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
		setEnergieInitiale(50);
		setEnergie(50);
		setPortee(1);
		setDepMax(1);
		setRegenBase(2);
		setCoutDep(2);
		typeRobot = "Piegeur";
	}

	public Piegeur() {
		super();
	}

	@Override
	public boolean peutTirer() { return false; }

	@Override
	public int getCoutAction() { return 2; }

	@Override
	public int getCoutDep() { return 2; }

	@Override
	public int getDegatTir() { return 0; }

	public int getDegatMine() { return 2; }

}
