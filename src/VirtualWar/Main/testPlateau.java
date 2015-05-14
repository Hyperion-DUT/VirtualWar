package VirtualWar.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;


import VirtualWar.Unites.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import VirtualWar.Plateau.Base;
import VirtualWar.Plateau.Case;
import VirtualWar.Plateau.Cellule;

public class testPlateau extends JPanel{
	
	private Cellule[][] plateau;
	private int hauteur;
	private int largeur;
	private File f;
	
	//Images
	private BufferedImage home_blue;
	private BufferedImage home_red;
	private BufferedImage mine_blue;
	private BufferedImage mine_red;
	private BufferedImage miner_blue;
	private BufferedImage miner_red;
	private BufferedImage shooter_blue;
	private BufferedImage shooter_red;
	private BufferedImage tank_blue;
	private BufferedImage tank_red;
	private BufferedImage wall;

	public testPlateau(int hauteur, int largeur) {
		super();
		try{
			this.f = new File("/res/img/home_blue.png");
			this.home_blue = ImageIO.read(f);
			this.f = new File("/res/img/home_red.png");
			this.home_red = ImageIO.read(f);
			this.f = new File("/res/img/mine_blue.png");
			this.mine_blue = ImageIO.read(f);
			this.f = new File("/res/img/mine_red.png");
			this.mine_red = ImageIO.read(f);
			this.f = new File("/res/img/miner_blue.png");
			this.miner_blue = ImageIO.read(f);
			this.f = new File("/res/img/miner_red.png");
			this.miner_red = ImageIO.read(f);
			this.f = new File("/res/img/shooter_blue.png");
			this.shooter_blue = ImageIO.read(f);
			this.f = new File("/res/img/shooter_red.png");
			this.shooter_red = ImageIO.read(f);
			this.f = new File("/res/img/tank_blue.png");
			this.tank_blue = ImageIO.read(f);
			this.f = new File("/res/img/tank_red.png");
			this.tank_red = ImageIO.read(f);
			this.f = new File("/res/img/wall.png");
			this.wall = ImageIO.read(f);
		} catch(IOException e){
				e.printStackTrace();
		}
			
		this.hauteur = hauteur;
		this.largeur = largeur;
		plateau = new Cellule[hauteur][largeur];
		initialiser();
	}
	
	//Equipe 1 = bleu, Equipe 2 = rouge
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		int hauteur = 11;
		int largeur = 11;
		int taille = 40;
		//TODO Parcourir le tableau de case et afficher le contenu
		for (int h = 0; h < hauteur; h++) {
			int cH = h*taille;
			for (int l = 0; l < largeur; l++) {
				int cL = l*taille;
				g.setColor(Color.WHITE);
				g.fillRect(cL,cH,taille,taille);
				if(plateau[h][l].estMine()){
					g.drawImage(mine_blue, cL, cH, null);
				} 
				else if(plateau[h][l].estBase()){
					if(plateau[h][l].getBase() == 1){
						g.drawImage(home_blue, cL, cH, null);
					}else{
						g.drawImage(home_red, cL, cH, null);
					}
				} 
				else if(plateau[h][l].estObstacle()){
						g.drawImage(wall, cL, cH, null);
				} 
				else if(plateau[h][l].estRobot()){
					if(plateau[h][l].getContenu().getEquipe() == 1){
						if(plateau[h][l].getContenu() instanceof Piegeur)
							g.drawImage(miner_blue, cL, cH, null);
						if(plateau[h][l].getContenu() instanceof Char)
							g.drawImage(tank_blue, cL, cH, null);
						if(plateau[h][l].getContenu() instanceof Tireur)
							g.drawImage(shooter_blue, cL, cH, null);
					}else{
						if(plateau[h][l].getContenu() instanceof Piegeur)
							g.drawImage(miner_red, cL, cH, null);
						if(plateau[h][l].getContenu() instanceof Char)
							g.drawImage(tank_red, cL, cH, null);
						if(plateau[h][l].getContenu() instanceof Tireur)
							g.drawImage(shooter_red, cL, cH, null);
					}
				}
				g.setColor(Color.BLACK);
				g.drawRect(cL,cH,taille,taille);
			}
		}
			
	}
	
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
	}
}
