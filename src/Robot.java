import java.util.ArrayList;

public abstract class Robot {

	// **Variables du robot en fonction de son type**//
	private int energie;
	private final int equipe;


	// Variable -> Vue du robot
	private Vue vue;
	// Variable -> Coordonnées du robot
	private Coordonnees coord;

	// Constructeur -> Acceptant une vue , des coordonnées , ainsi qu'une équipe à laquelle le robot appartient
	public Robot(Vue vue, int X, int Y, int Equipe) {
		coord = new Coordonnees(X, Y);
		this.vue = vue;
		this.equipe = Equipe;
	}

	// Méthode abstraite -> Pour savoir si le robot est en mesure de tirer
	public abstract boolean peutTirer();

	// Méthode abstraite -> Pour avoir le cout d'une action
	public abstract int getCoutAction();

	// Méthode abstraite -> Pour avoir le cout d'un deplacement
	public abstract int getCoutDep();

	// Méthode abstraite -> Pour avoir les degats d'un tir
	public abstract int getDegatTir();

	// Méthode abstraite -> Pour avoir les degats d'une mine
	public abstract int getDegatMine();

	// Méthode abstraite -> Pour avoir le type de robot
	public abstract String getType();

	// Méthode abstraite -> Pour avoir l'historique de deplacement du robot
	public abstract ArrayList<Coordonnees> getDeplacements();

	// Méthode -> Pour savoir si le robot est sur la base
	public boolean estSurBase() {
		return coord.equals(vue.getBase(equipe));
	}

	// Méthode -> Pour attribuer la position du robot
	public void setCoordonnees(Coordonnees coords) {
	}

	// Méthode -> Pour savoir la position du robot
	public Coordonnees getCoordonnees() {
		return coord;
	}
	
	// Méthode -> Pour récuperer la vue du robot
	public Vue getVue() {
		return vue;
	}

	// Méthode -> Pour récuperer l'équipe du robot
	public int getEquipe() {
		return this.equipe;
	}

	// Méthode -> Pour attribuer l'energie actuelle du robot
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	// Méthode -> Pour récuperer l'energie actuelle du robot
	public int getEnergie() {
		return this.energie;
	}

	// Méthode -> Pour attribuer la vue du robot
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	// Méthode -> Pour que le robot subisse un tir
	public void subitTir() {
		energie -= getCoutAction();
	}

	// Méthode -> Pour que le robot subisse les dégâts d'une mine
	
	public  void subitMine() {
		energie -= getCoutAction();
	}

	// Méthode -> toString() , par défaut, pour montrer les caractéristiques du robot
	public String toString() {
		return "ROBOT[energie=" + energie + ", equipe=" + equipe + ", coord="
				+ coord + "]";
	}

}
