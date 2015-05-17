package VirtualWar.Plateau;
/**
 * 
 * @author Jules
 *
 */
public class Coordonnees {

	/**
	 * Coordonnée X
	 */
	private int X;

	/**
	 * Coordonnée Y
	 */
	private int Y;

	/**
	 * Constructeur par défaut
	 */
	public Coordonnees() {

	}

	/**
	 * Constructeur acceptant des coordonnées
	 * @param X abscisse de la cellule
	 * @param Y coordonnée de la cellule
	 */
	public Coordonnees(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	/**
	 * méthode ajout des coordonnées
	 * @param coords nouvelles coordonnées
	 * @return
	 */
	public Coordonnees addCords(Coordonnees coords) {
		return new Coordonnees(X + coords.getX(), Y + coords.getY());
	}

	/**
	 * permet de récupérer X
	 * @return
	 */
	public int getX() {
		return X;
	}

	/**
	 * permet de récupérer Y
	 * @return
	 */
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

	
	/**
	 * méthode permettant d'afficher les coordonnées sous forme de chaine
	 * 
	 */

	public String toString() {
		return "[Coordonnees] X -> " + X + " , Y -> " + Y;
	}

}
