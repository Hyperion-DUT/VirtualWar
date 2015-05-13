package VirtualWar.Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import VirtualWar.Plateau.Base;
import VirtualWar.Plateau.Case;
import VirtualWar.Plateau.Cellule;

public class testPlateau extends JPanel{
	
	private Cellule[][] plateau;
	private int hauteur;
	private int largeur;
	
	public testPlateau(int hauteur, int largeur) {
		super();
		this.hauteur = hauteur;
		this.largeur = largeur;
		plateau = new Cellule[hauteur][largeur];
		initialiser();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		int hauteur = 11;
		int largeur = 11;
		int taille = 40;
		//TODO Parcourir le tableau de case et afficher le contenu
		for (int l = 0; l < hauteur; l++) {
			int cL = l*taille;
			for (int c = 0; c < largeur; c++) {
				int cC = c*taille;
				g.setColor(Color.WHITE);
				g.fillRect(cC,cL,taille,taille);
				g.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 20));
				if(plateau[l][c].estMine()){
					g.setColor(Color.WHITE);
					g.fillRect(cC,cL,taille,taille);
					g.setColor(Color.BLACK);
					g.drawString("M", cC+(taille/2), cL+(taille/2));
				} else if(plateau[l][c].estBase()){
					g.setColor(Color.WHITE);
					g.fillRect(cC,cL,taille,taille);
					g.setColor(Color.BLACK);
					g.drawString("B", cC+(taille/2), cL+(taille/2));
				} else if(plateau[l][c].estObstacle()){
					g.setColor(Color.WHITE);
					g.fillRect(cC,cL,taille,taille);
					g.setColor(Color.BLACK);
					g.drawString("O", cC+(taille/2), cL+(taille/2));
				} else if(plateau[l][c].estRobot()){
					g.setColor(Color.WHITE);
					g.fillRect(cC,cL,taille,taille);
					g.setColor(Color.BLACK);
					g.drawString("R", cC+(taille/2), cL+(taille/2));
				}
				g.setColor(Color.BLACK);
				g.drawRect(cC,cL,taille,taille);
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
