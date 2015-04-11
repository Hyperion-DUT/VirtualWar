package main;


/**
 * 
 * @author noxilex
 *
 */
public class Plateau{
	Cellule[][] truePlateau;
	String[][] plateau;
	int hauteur;
	int largeur;
	int trueHauteur;
	int trueLargeur;
	
	/**
	 * Si le plateau n'a pas de taille,
	 * la taille par défaut est 10
	 */
	Plateau(){
		truePlateau = new Cellule[10][10];
		trueHauteur = 10;
		trueLargeur = 10;
		initialiser();
		plateau = new String[10*2+1][10*2+1];
		this.hauteur = 10*2+1;
		this.largeur = 10*2+1;
	}
	/**
	 * 
	 * @param hauteur
	 * @param largeur
	 */
	Plateau(int hauteur, int largeur){
		truePlateau = new Cellule[hauteur][largeur];
		trueHauteur = hauteur;
		trueLargeur = largeur;
		initialiser();
		plateau = new String[hauteur*2+1][largeur*2+1];
		this.hauteur = hauteur*2+1;
		this.largeur = largeur*2+1;
	}
	
	/**
	 * 
	 */
	public void initialiser(){
		for(int i = 0; i < trueHauteur; i++){
			for(int j = 0; j < trueLargeur; j++){
				if(i == 0 && j == 0){
					truePlateau[i][j] = new Base(i, j, 1); 
				}
				else if(i == trueHauteur-1 && j == trueHauteur-1){
					truePlateau[i][j] = new Base(i, j, 2);
				}
				else{
					truePlateau[i][j] = new Case(i, j);
				}
			}
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param robot
	 */
	public void ajouterUneMachine(int x, int y, Robot robot){
		plateau[x*2+1][y*2+1] = " " + robot + " ";
	}
	
	public String toString(){
		for(int l = 0; l < hauteur; l++){
			for(int c = 0; c < largeur; c++){
				if(l%2 == 0 && c%2 == 0 )
					plateau[l][c] = "+";
				else if(l%2 == 0 && c%2 != 0)
					plateau[l][c] = "---";
				else if(c%2 == 0 && l%2 != 0)
					plateau[l][c] = "|";
				else
					plateau[l][c] = "   ";
			}
		}
		String res = "";
		for(String[] l: plateau){
			for(String c: l){			
					res += c;
			}
			res += "\n";
		}
		return res;
	}
}
