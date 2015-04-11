public class Coordonnees {

	// Coordonnée X
	private int X;

	// Coordonnée Y
	private int Y;

	// Constructeur -> Par défaut
	public Coordonnees() {

	}

	// Constructeur -> Acceptant un abcisse
	public Coordonnees(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	// Méthode -> Pour ajouter une coordonnée
	public Coordonnees addCords(Coordonnees coords) {
		return new Coordonnees(X + coords.getX(), Y + coords.getY());
	}

	// Méthode -> Pour avoir X
	public int getX() {
		return X;
	}

	// Méthode -> Pour avoir Y
	public int getY() {
		return Y;
	}

	// Méthode -> toString() , par défaut , pour afficher les coordonnées sous
	// forme de chaine
	public String toString() {
		return "[Coordonnees] X -> " + X + " , Y -> " + Y;
	}

}
