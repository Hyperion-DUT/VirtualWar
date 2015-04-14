/**
 * 
 * @author Jules
 *
 */
public class Coordonnees {

	// Coordonn�e X
	private int X;

	// Coordonn�e Y
	private int Y;

	// Constructeur -> Par d�faut
	public Coordonnees() {

	}

	// Constructeur -> Acceptant un abcisse et une ordonn�e
	public Coordonnees(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	// M�thode -> Pour ajouter une coordonn�e
	public Coordonnees addCords(Coordonnees coords) {
		return new Coordonnees(X + coords.getX(), Y + coords.getY());
	}

	// M�thode -> Pour avoir X
	public int getX() {
		return X;
	}

	// M�thode -> Pour avoir Y
	public int getY() {
		return Y;
	}

	// M�thode -> toString() , par d�faut , pour afficher les coordonn�es sous
	// forme de chaine
	public String toString() {
		return "[Coordonnees] X -> " + X + " , Y -> " + Y;
	}

}
