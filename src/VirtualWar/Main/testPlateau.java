package VirtualWar.Main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class testPlateau extends JPanel{
	
	private int hauteur;
	private int largeur;
	
	public testPlateau(int hauteur, int largeur){
		this.hauteur = hauteur;
		this.largeur = largeur;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		int hauteur = 11;
		int largeur = 11;
		int taille = 40;
		for (int l = 0; l < hauteur; l++) {
			for (int c = 0; c < largeur; c++) {
				g.setColor(Color.WHITE);
				g.fillRect(c*taille,l*taille,taille,taille);
				g.setColor(Color.BLACK);
				g.drawRect(c*taille,l*taille,taille,taille);
			}
		}
			
	}
}
