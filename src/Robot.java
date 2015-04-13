import java.util.ArrayList;

public abstract class Robot {

	// **Variables du robot en fonction de son type**//
	
	//renvoie une lettre permettant un affichage du robot
	protected String typeRobot;
	private int Equipe;
	private int Portee;
	private int Depmax;
	private int energie;
	private int EnergieInitiale;
	private int RegenBase;
	private int CoutTir;
	private int CoutDep;
	private int Degats;

	public void setCoutTir(int coutTir) {
		CoutTir = coutTir;
	}

	public void setDegats(int degats) {
		Degats = degats;
	}

	// Variable -> Vue du robot
	Vue vue = new Vue();

	public int getPortee() {
		return Portee;
	}

	public void setPortee(int portee) {
		Portee = portee;
	}

	public void setCoutDep(int coutDep) {
		CoutDep = coutDep;
	}

	public void setEquipe(int equipe) {
		Equipe = equipe;
	}

	// Variable -> Coordonn�es du robot
	private Coordonnees coord;

	// Constructeur -> Acceptant une vue , des coordonn�es , ainsi qu'une �quipe
	// � laquelle le robot appartient

	public Robot(Vue vue, int X, int Y, int Equipe) {
		coord = new Coordonnees(X, Y);
		this.vue = vue;
		this.Equipe = Equipe;
	}

	// M�thode abstraite -> Pour savoir si le robot est en mesure de tirer
	public abstract boolean peutTirer();

	// M�thode abstraite -> Pour avoir le cout d'une action
	public abstract int getCoutAction();

	// M�thode abstraite -> Pour avoir le cout d'un deplacement
	public abstract int getCoutDep();

	// M�thode abstraite -> Pour avoir les degats d'un tir
	public abstract int getDegatTir();

	// M�thode abstraite -> Pour avoir les degats d'une mine
	public abstract int getDegatMine();

	// M�thode abstraite -> Pour avoir le type de robot
	public abstract String getType();

	// M�thode abstraite -> Pour avoir l'historique de deplacement du robot
	public abstract ArrayList<Coordonnees> getDeplacements();

	// M�thode -> Pour savoir si le robot est sur la base
	public boolean estSurBase() {
		return coord.equals(vue.getBase(Equipe));
	}

	// M�thode -> Pour attribuer la position du robot
	public void setCoordonnees(Coordonnees coords) {
	}

	// M�thode -> Pour savoir la position du robot
	public Coordonnees getCoordonnees() {
		return coord;
	}

	// M�thode -> Pour r�cuperer la vue du robot
	public Vue getVue() {
		return vue;
	}

	// M�thode -> Pour r�cuperer l'�quipe du robot
	public int getEquipe() {
		return this.Equipe;
	}

	// M�thode -> Pour attribuer l'energie actuelle du robot
	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public int getPorte() {
		return Portee;
	}

	public void setPorte(int porte) {
		Portee = porte;
	}

	public int getEnergieInitiale() {
		return EnergieInitiale;
	}

	public void setEnergieInitiale(int energieInitiale) {
		EnergieInitiale = energieInitiale;
	}
	public int getDepMax() {
		return Depmax;
	}

	public void setDepMax(int depmax) {
		Depmax = depmax;
	}

	// M�thode -> Pour r�cuperer l'energie actuelle du robot
	public int getEnergie() {
		return this.energie;
	}

	// M�thode -> Pour attribuer la vue du robot
	public void setVue(Vue vue) {
		this.vue = vue;
	}

	// M�thode -> Pour que le robot subisse un tir
	public void subitTir() {
		energie -= getCoutAction();
	}

	// M�thode -> Pour que le robot subisse les d�g�ts d'une mine
	
	public  void subitMine() {
		energie -= getCoutAction();
	}

	// M�thode -> toString() , par d�faut, pour montrer les caract�ristiques du
	// robot
	public String toString() {
		return typeRobot;
	}

	public void setRegenBase(int regenBase) {
		RegenBase = regenBase;
	}

}
