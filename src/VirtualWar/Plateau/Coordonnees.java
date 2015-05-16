package VirtualWar.Plateau;
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

	// Constructeur -> Acceptant un abscisse et une ordonn�e
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + X;
		result = prime * result + Y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		if (X != other.X)
			return false;
		if (Y != other.Y)
			return false;
		return true;
	}

	// M�thode -> toString() , par d�faut , pour afficher les coordonn�es sous
	// forme de chaine
	public String toString() {
		return "[Coordonnees] X -> " + X + " , Y -> " + Y;
	}

}
