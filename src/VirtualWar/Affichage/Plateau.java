package VirtualWar.Affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import VirtualWar.Plateau.Base;
import VirtualWar.Plateau.Case;
import VirtualWar.Plateau.Cellule;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.*;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Plateau extends JPanel{
	
	private Cellule[][] plateau;
	static Set<Coordonnees> obstacles = new HashSet<Coordonnees>();
	private int hauteur;
	private int largeur;
	private File f;
	private int taille = 40;
	
	//Images
	private BufferedImage home_blue;
	private BufferedImage home_red;
	private BufferedImage mine;
	private BufferedImage miner_blue;
	private BufferedImage miner_red;
	private BufferedImage shooter_blue;
	private BufferedImage shooter_red;
	private BufferedImage tank_blue;
	private BufferedImage tank_red;
	private BufferedImage wall;

	/**
	 * constructeur acceptant une hauteur et une largeur
	 * @param hauteur
	 * @param largeur
	 */

	public Plateau(int hauteur, int largeur) {
		super();
		try{
			this.f = new File("res/img/home_blue.png");
			this.home_blue = ImageIO.read(f);
			this.f = new File("res/img/home_red.png");
			this.home_red = ImageIO.read(f);
			this.f = new File("res/img/mine.png");
			this.mine = ImageIO.read(f);
			this.f = new File("res/img/miner_blue.png");
			this.miner_blue = ImageIO.read(f);
			this.f = new File("res/img/miner_red.png");
			this.miner_red = ImageIO.read(f);
			this.f = new File("res/img/shooter_blue.png");
			this.shooter_blue = ImageIO.read(f);
			this.f = new File("res/img/shooter_red.png");
			this.shooter_red = ImageIO.read(f);
			this.f = new File("res/img/tank_blue.png");
			this.tank_blue = ImageIO.read(f);
			this.f = new File("res/img/tank_red.png");
			this.tank_red = ImageIO.read(f);
			this.f = new File("res/img/wall.png");
			this.wall = ImageIO.read(f);
		} catch(IOException e){
				e.printStackTrace();
		}
		this.hauteur = hauteur;
		this.largeur = largeur;
		plateau = new Cellule[hauteur][largeur];
		this.setPreferredSize(new Dimension(largeur*taille, hauteur*taille));
		initialiser();
	}
	/**
	 * Permet de dessiner les changements apportés à la classe quand on repaint()
	 */

	public void paintComponent(Graphics g){
		super.paintComponents(g);
		//TODO Parcourir le tableau de case et afficher le contenu
		for (int h = 0; h < hauteur; h++) {
			int cH = h*taille;
			for (int l = 0; l < largeur; l++) {
				int cL = l*taille;
				g.setColor(Color.WHITE);
				g.fillRect(cH,cL,taille,taille);
				if(plateau[h][l].estMine()){
					g.drawImage(mine, cH, cL, taille, taille, null);
				} 
				else if(plateau[h][l].estBase()){
					if(plateau[h][l].getBase() == 1){
						g.drawImage(home_blue, cH, cL, taille, taille, null);
					}else{
						g.drawImage(home_red, cH, cL, taille, taille, null);
					}
				} 
				else if(plateau[h][l].estObstacle()){
						g.drawImage(wall, cH, cL, taille, taille, null);
				} 
				else if(plateau[h][l].estRobot()){
					if(plateau[h][l].getContenu().getEquipe() == 1){
						if(plateau[h][l].getContenu() instanceof Piegeur)
							g.drawImage(miner_blue, cH, cL, taille, taille, null);
						if(plateau[h][l].getContenu() instanceof Char)
							g.drawImage(tank_blue, cH, cL, taille, taille, null);
						if(plateau[h][l].getContenu() instanceof Tireur)
							g.drawImage(shooter_blue, cH, cL, taille, taille, null);
					}else{
						if(plateau[h][l].getContenu() instanceof Piegeur)
							g.drawImage(miner_red, cH, cL, taille, taille, null);
						if(plateau[h][l].getContenu() instanceof Char)
							g.drawImage(tank_red, cH, cL, taille, taille, null);
						if(plateau[h][l].getContenu() instanceof Tireur)
							g.drawImage(shooter_red, cH, cL, taille, taille, null);
					}
				}
				g.setColor(Color.BLACK);
				g.drawRect(cH, cL, taille, taille);
			}
		}
			
	}
	/**
	 * Permet de générer des cases, des bases ainsi que des obstacles sur le plateau
	 */
	
	public void initialiser() {
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				if (i == 0 && j == 0) {
					plateau[i][j] = new Base(i, j, 1);
				} else if (i == hauteur - 1 && j == hauteur - 1) {
					plateau[i][j] = new Base(i, j, 2);
				} else {
					plateau[i][j] = new Case(i, j);
				}
			}
		}
		generationObstacles((int)(largeur*hauteur*0.25));
	}
	/**
	 * Retourne la taille du plateau
	 * @return
	 */
	public int getTaille(){
		return taille;
	}
	
	/**
	 * Retourne les coordonnées de la base de l'équipe en paramètre
	 * @param equipe
	 * @return
	 */
	public Coordonnees getBase(int equipe) {
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				if (plateau[x][y].estBase()
						&& plateau[x][y].getBase() == equipe) {
					return plateau[x][y].getCoordonnees();
				}
			}
		}
		return null;
	}

	/**
	 * retourne le contenu de la case de coordonn�es (x,y).
	 * @param x est l'abscisse de la case.
	 * @param y est l'ordonn�e de la case.
	 * @return Le robot sur la case de coordonn�es (x,y)
	 */

	public Robot getRobot(int x, int y){
		if(plateau[x][y].estRobot()){
			return plateau[x][y].getContenu();
		}
		else{
			return null;
		}
	}
	/**
	 * Retourne un booleen qui exprime  si il y a une mine pos�e sur la case de coordonn�es(x,y).
	 * @param x est l'abscisse de la case .
	 * @param y est l'ordonn�e de la case.
	 * @return vrai si il y a un mine sur la case(x,y), faux sinon.

	 */
	public boolean estMine(int x, int y) {
		return (plateau[x][y] instanceof Case && plateau[x][y].estMine());
	}
	
	/**
	 * retourne un booleen qui exprime  si il y a une base pos�e sur la case de coordonn�es(x,y).
	 * @param x est l'abscisse de la case.
	 * @param y est l'ordonn�e de la case.
	 * @return vrai si la case du plateau contient une base.
	 */

	public boolean estBase(int x, int y) {
		return plateau[x][y] instanceof Base;
	}
	/**
	 * retourne un booleen qui exprime  si il y a un obstacle pos� sur la case de coordonn�es(x,y).
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonn�e de la case
	 * @return
	 */
	public boolean estObstacle(int x, int y) {
		return (plateau[x][y].estObstacle() && plateau[x][y] instanceof Case);
	}
	/**
	 * retourne un booleen qui exprime  si il y a un robot pos� sur la case de coordonn�es(x,y).
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonn�e de la case
	 * @return

	 */
	public boolean estRobot(int x, int y) {
		return (plateau[x][y].estRobot() && plateau[x][y] instanceof Case);
	}

	/**
	 * retourne un booleen qui exprime  si la case de coordonn�es(x,y) est vide.
	 * @param x est l'abscisse de la case 
	 * @param y est l'ordonn�e de la case
	 * @return

	 */
	public boolean estVide(int x, int y) {
		return plateau[x][y].estVide();
	}
	/**
	 * cette methode permet la pose d'une mine sur le plateau par un piegeur de l'une des deux equipes 
	 * @param x abscisse de la case ou sera pos�e la mine.
	 * @param y est l'ordonn�e de la case ou sera pos�e la mine.

	 */
	public void setMine(int x, int y) {
		if(plateau[x][y].estVide()){
			Case a = new Case(x, y);
			a.setTypeCase(1);
			plateau[x][y] = a;
		}
	}
	/**
	 * Cette methode deploie un robot passe en parametre sur le plateau de jeu au coordonn�es (x,y)
	 * @param x
	 * @param y
	 * @param robot
	 */
	public void setRobot(int x, int y, Robot robot) {
		robot.setCoordonnees(new Coordonnees(x,y));
		if(plateau[x][y].estVide()){
			Case a = new Case(x, y, robot);
			plateau[x][y] = a;
		}else if(plateau[x][y].estMine()){
			//TODO Infliger des degats
		}
	}
	/**
	 * 	 * Cette methode place un obstacle sur la case de coordonnees(x,y).
	 * @param x est l'abscisse de la case sur laquelle sera place l'obstacle. 
	 * @param y est l'ordonnee de la case sur laquelle sera plac� l'obstacle.
	 */
	public void setObstacle(int x, int y) {
		if(plateau[x][y].estVide()){
			Case a = new Case(x, y);
			a.setTypeCase(3);
			plateau[x][y] = a;
			obstacles.add(new Coordonnees(x,y));
		}
	}
	/**
	 * Cette methode place une base sur la case de coordonnees(x,y).
	 * @param x est l'abscisse de la case sur laquelle sera placee la base.
	 * @param y est l'ordonnee de la case sur laquelle sera placee la base.
	 */
	public void setBase(int x, int y, int equipe) {
		plateau[x][y] = new Base(x, y, equipe);
	}
	/**
	 * Appelle la fonction videCase() qui permet de vider la case de coordonnees(x,y)
	 * @param x est l'abscisse de la case � vider.
	 * @param y est l'ordonn�e de la case � vider.

	 */
	public void vider(Coordonnees c) {
		if(!plateau[c.getX()][c.getY()].estBase()){
			plateau[c.getX()][c.getY()].videCase();
		}
	}
	
    /**
     * Genere aleatoirement les obstacles sur le plateau.
     * @param nbObstacle Le nombre d'obstacles souhait�s sur le plateau lors de la partie
     * @param plateau 
     */
    public void generationObstacles(int nbObstacles){
    	Set<Coordonnees> path = buildPath();
    	Random alea = new Random();
    	int x, y;
    	while (nbObstacles > 0) {
    		x = alea.nextInt(largeur);
    		y = alea.nextInt(hauteur);
    		if (!path.contains(new Coordonnees(x,y))) {
    			setObstacle(x,y);
    			nbObstacles--;
    		}
    	}
    }
    /**
     * Creer un chemin libre obligatoire reliant les deux bases.
     * @return un tableau de coordonnees
     */
    private Set<Coordonnees> buildPath() {
    	Set<Coordonnees> path = new HashSet<Coordonnees>();
    	path.add(new Coordonnees(0,1));
    	path.add(new Coordonnees(1,0));
    	path.add(new Coordonnees(1,1));
    	path.add(new Coordonnees(largeur-1, hauteur-2));
    	path.add(new Coordonnees(largeur-2, hauteur-1));
    	path.add(new Coordonnees(largeur-2, hauteur-2));
    	Random alea = new Random();
    	Coordonnees c = new Coordonnees(0,0);
		path.add(c);
    	boolean endOfPath = false;
    	boolean directionX;
    	while (!endOfPath) {
    		if (c.getX()==largeur-1) {
    			directionX = false;
    		} else if (c.getY()==hauteur-1) {
    			directionX = true;
    		} else {
    			directionX = alea.nextBoolean();
    		}
    		
    		if (directionX) {
        		c = c.addCords(new Coordonnees(1,0));
    			path.add(c);
    		} else {
    			c = c.addCords(new Coordonnees(0,1));
    			path.add(c);
    		}
    		
    		if (c.getX()==largeur-1 && c.getY()==hauteur-1) {
    			endOfPath=true;
    		}
    	}
    	return path;
    }
    
}
