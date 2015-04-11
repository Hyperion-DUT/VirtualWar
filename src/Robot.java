import java.util.ArrayList;

public abstract class Robot {

	// **Variables du robot en fonction de son type**//
	private int Equipe;
	private int Portee;
	private int Depmax;
	private int Energie;
	private int EnergieInitiale;
	private int RegenBase;
	private int CoutTir;
	private int CoutDep;
	private int Degats;

	// Variable -> Vue du robot
	Vue vue_robot = new Vue();

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

	// Variable -> Coordonnées du robot
	Coordonnees coords_robot = new Coordonnees();

	// Constructeur -> Par défaut
	public Robot() {

	}

	// Constructeur -> Acceptant une vue , des coordonnées , ainsi qu'une équipe
	// à laquelle le robot appartient
	public Robot(Vue vue, int X, int Y, int Equipe) {
		this.vue_robot = vue;
		this.Equipe = Equipe;
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
		return false;
	}

	// Méthode -> Pour attribuer la position du robot
	public void setCoordonnees(Coordonnees coords) {
	}

	// Méthode -> Pour savoir la position du robot
	public Coordonnees getCoordonnees() {
		return coords_robot;
	}

	// Méthode -> Pour récuperer la vue du robot
	public Vue getVue() {
		return vue_robot;
	}

	// Méthode -> Pour récuperer l'équipe du robot
	public int getEquipe() {
		return this.Equipe;
	}

	// Méthode -> Pour attribuer l'energie actuelle du robot
	public void setEnergie(int energie) {
		this.Energie = energie;
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
	public int getDepmax() {
		return Depmax;
	}

	public void setDepmax(int depmax) {
		Depmax = depmax;
	}

	// Méthode -> Pour récuperer l'energie actuelle du robot
	public int getEnergie() {
		return this.Energie;
	}

	// Méthode -> Pour attribuer la vue du robot
	public void setVue(Vue vue) {
		this.vue_robot = vue;
	}

	// Méthode -> Pour que le robot subisse un tir
	public void SubitTir() {
		this.setEnergie(this.getEnergie() - this.Degats);
	}

	// Méthode -> Pour que le robot subisse les dégâts d'une mine
	public void SubitMine() {
		this.setEnergie(this.getEnergie() - this.Degats);
	}

	// Méthode -> toString() , par défaut, pour montrer les caractéristiques du
	// robot
	public String toString() {
		return "[ROBOT]\r\n" + "Equipe -> " + Equipe + "\r\n" + "Porte -> "
				+ Porte + "\r\n" + "DeplacementMax -> " + DepMax + "\r\n"
				+ "Energie -> " + Energie + "\r\n" + "EnergieInitiale -> "
				+ EnergieInitiale + "\r\n" + "Regeneration sur base -> "
				+ RegenBase + "\r\n" + "Cout tir -> " + CoutTir + "\r\n"
				+ "Cout deplacement -> " + CoutDep + "\r\n" + "Degats -> "
				+ Degats + "\r\n";
	}

}
