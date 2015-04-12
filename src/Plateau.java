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
	 * 
	 */
	Plateau(){
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
	
	public Coordonnees getBase(int equipe){
		for(int y = 0; y < trueHauteur; y++){
			for(int x = 0; x < trueLargeur; x++){
				if(truePlateau[x][y].estBase() && truePlateau[x][y].getBase() == equipe){
					return truePlateau[x][y].getCoordonnees();
				}
			}
		}
		return null;
	}
	
	public Robot getRobot(int x, int y){
		return truePlateau[x][y].getContenu();
	}
	
	public boolean estMine(int x, int y){
		return truePlateau[x][y].estMine();
	}
	
	public boolean estBase(int x, int y){
		return truePlateau[x][y].estBase();
	}
	
	public boolean estObstacle(int x, int y){
		return truePlateau[x][y].estObstacle();
	}
	
	public boolean estRobot(int x, int y){
		return truePlateau[x][y].estObstacle();
	}
	
	public boolean estVide(int x, int y){
		return truePlateau[x][y].estVide();
	}

	public void setMine(int x, int y){
		Case a = new Case(x,y);
		a.setTypeCase(1);
		truePlateau[x][y] = a;
	}
	
	public void setRobot(int x, int y, Robot robot){
		Case a = new Case(x,y, robot);
		truePlateau[x][y] = a;
	}
	
	public void setObstacle(int x, int y){
		Case a = new Case(x,y);
		a.setTypeCase(3);
		truePlateau[x][y] = a;
	}
	
	public void setBase(int x, int y, int equipe){
		truePlateau[x][y] = new Base(x,y,equipe);
	}
	
	public void Vider(int x, int y){
		truePlateau[x][y].videCase();
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
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Plateau a = new Plateau(11,11);
		System.out.println(a.toString());
	}
}
