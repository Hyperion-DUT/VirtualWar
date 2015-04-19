/**
 * 
 * @author noxilex
 *
 */
public class Plateau {
	Cellule[][] truePlateau;
	String[][] plateau;
	int hauteur;
	int largeur;
	int trueHauteur;
	int trueLargeur;

	/**
	 * Si le plateau n'a pas de taille, la taille par dÃ©faut est 10
	 */
	Plateau() {
		truePlateau = new Cellule[10][10];
		trueHauteur = 10;
		trueLargeur = 10;
		initialiser();
		plateau = new String[10 * 2 + 1][10 * 2 + 1];
		this.hauteur = 10 * 2 + 1;
		this.largeur = 10 * 2 + 1;
	}

	/**
	 * Initialise un tableau dont la largeur et la longueur sont definies par l'utilisateur.
	 * @param hauteur la hauteur definie pour le plateau.
	 * @param largeur la largeur definie pour le plateau.
	 */
	Plateau(int hauteur, int largeur) {
		truePlateau = new Cellule[hauteur][largeur];
		trueHauteur = hauteur;
		trueLargeur = largeur;
		initialiser();
		plateau = new String[hauteur * 2 + 1][largeur * 2 + 1];
		this.hauteur = hauteur * 2 + 1;
		this.largeur = largeur * 2 + 1;
	}

	/**
	 * Utilisée dans un constructeur elle permet l'initialisation du tableau.
	 */
	public void initialiser() {
		for (int i = 0; i < trueHauteur; i++) {
			for (int j = 0; j < trueLargeur; j++) {
				if (i == 0 && j == 0) {
					truePlateau[i][j] = new Base(i, j, 1);
				} else if (i == trueHauteur - 1 && j == trueHauteur - 1) {
					truePlateau[i][j] = new Base(i, j, 2);
				} else {
					truePlateau[i][j] = new Case(i, j);
				}
			}
		}
	}
	/**
	 * Retourne les coordonnées de la base de l'equipe qui est passée en paramatre.
	 * @param equipe valeur caracterisant une equipe.
	 * @return deux nombres qui donnent les coordonnées de la base.
	 */
	public Coordonnees getBase(int equipe) {
		for (int y = 0; y < trueHauteur; y++) {
			for (int x = 0; x < trueLargeur; x++) {
				if (truePlateau[x][y].estBase()
						&& truePlateau[x][y].getBase() == equipe) {
					return truePlateau[x][y].getCoordonnees();
				}
			}
		}
		return null;
	}

	/**
	 * retourne le contenu de la case de coordonnées (x,y).
	 * @param x est l'abscisse de la case.
	 * @param y est l'ordonnée de la case.
	 * @return Le robot sur la case de coordonnées (x,y)
	 */

	public Robot getRobot(int x, int y) {
		return truePlateau[x][y].getContenu();
	}
	/**
	 * Retourne un booleen qui exprime  si il y a une mine posée sur la case de coordonnées(x,y).
	 * @param x est l'abscisse de la case .
	 * @param y est l'ordonnée de la case.
	 * @return vrai si il y a un mine sur la case(x,y), faux sinon.

	 */
	public boolean estMine(int x, int y) {
		return truePlateau[x][y].estMine();
	}
	
	/**
	 * retourne un booleen qui exprime  si il y a une base posée sur la case de coordonnées(x,y).
	 * @param x est l'abscisse de la case.
	 * @param y est l'ordonnée de la case.
	 * @return vrai si la case du plateau contient une base.
	 */

	public boolean estBase(int x, int y) {
		return truePlateau[x][y].estBase();
	}
	/**
	 * retourne un booleen qui exprime  si il y a un obstacle posé sur la case de coordonnées(x,y).
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonnée de la case
	 * @return
	 */
	public boolean estObstacle(int x, int y) {
		return truePlateau[x][y].estObstacle();
	}
	/**
	 * retourne un booleen qui exprime  si il y a un robot posé sur la case de coordonnées(x,y).
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonnée de la case
	 * @return

	 */
	public boolean estRobot(int x, int y) {
		return truePlateau[x][y].estObstacle();
	}

	/**
	 * retourne un booleen qui exprime  si la case de coordonnées(x,y) est vide.
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonnée de la case
	 * @return

	 */
	public boolean estVide(int x, int y) {
		return truePlateau[x][y].estVide();
	}
	/**
	 * cette methode permet la pose d'une mine sur le plateau par un piegeur de l'une des deux equipes 
	 * @param x abscisse de la case ou sera posée la mine.
	 * @param y est l'ordonnée de la case ou sera posée la mine.

	 */
	public void setMine(int x, int y) {
		Case a = new Case(x, y);
		a.setTypeCase(1);
		truePlateau[x][y] = a;
	}
	/**
	 * Cette methode deploie un robot passe en parametre sur le plateau de jeu au coordonnées (x,y)
	 * @param x
	 * @param y
	 * @param robot
	 */
	public void setRobot(int x, int y, Robot robot) {
		Case a = new Case(x, y, robot);
		truePlateau[x][y] = a;
	}
	/**
	 * 	 * Cette methode place un obstacle sur la case de coordonnees(x,y).
	 * @param x est l'abscisse de la case sur laquelle sera place l'obstacle. 
	 * @param y est l'ordonnee de la case sur laquelle sera placé l'obstacle.
	 */
	public void setObstacle(int x, int y) {
		Case a = new Case(x, y);
		a.setTypeCase(3);
		truePlateau[x][y] = a;
	}
	/**
	 * Cette methode place une base sur la case de coordonnees(x,y).
	 * @param x est l'abscisse de la case sur laquelle sera placee la base.
	 * @param y est l'ordonnee de la case sur laquelle sera placee la base.
	 */
	public void setBase(int x, int y, int equipe) {
		truePlateau[x][y] = new Base(x, y, equipe);
	}
	/**
	 * Appelle la fonction videCase() qui permet de vider la case de coordonnees(x,y)
	 * @param x est l'abscisse de la case à vider.
	 * @param y est l'ordonnée de la case à vider.

	 */
	public void Vider(int x, int y) {
		truePlateau[x][y].videCase();
	}
	/**
	 * Retourne une chaine de caractere qui renvoie toutes les informations sur les attributs de la classe.
	 */
	public String toString() {

		// Crï¿½ation du Plateau ASCII
		for (int l = 0; l < hauteur; l++) {
			for (int c = 0; c < largeur; c++) {
				if (l % 2 == 0 && c % 2 == 0)
					plateau[l][c] = "+";
				else if (l % 2 == 0 && c % 2 != 0)
					plateau[l][c] = "---";
				else if (c % 2 == 0 && l % 2 != 0)
					plateau[l][c] = "|";
				else
					plateau[l][c] = "   ";
			}
		}

		// Ajout des donnï¿½es du vrai Plateau
		for (int l = 0; l < trueHauteur; l++) {
			for (int c = 0; c < trueLargeur; c++) {
				plateau[c * 2 + 1][l * 2 + 1] = " " + truePlateau[l][c] + " ";
			}
		}

		// Conversion du plateau final en une chaï¿½ne de caractï¿½re
		String res = "";
		for (String[] l : plateau) {
			for (String c : l) {
				res += c;
			}
			res += "\n";
		}
		return res;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Plateau a = new Plateau(11, 11);
		Vue a_p = new Vue(a);
		Robot tireur = new Tireur(a_p, 2, 3, 1);
		a.setRobot(2, 3, tireur);
		a.setObstacle(3, 3);
		System.out.println(a_p.toString());
	}
}
