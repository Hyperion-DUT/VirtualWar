package VirtualWar.Affichage;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import VirtualWar.Unites.Robot;

public class Energie extends JPanel{

	private ArrayList<Robot> listeRobots;
	
	/**
	 * Constructeur prenant en paramètre une liste de robots
	 * @param listeRobots
	 */
	 
	public Energie(ArrayList<Robot> listeRobots){
		System.out.println("Création");
		this.listeRobots = listeRobots;
		initUI();

	}
	/**
	 * méthode permettant d'afficher l'énergie des robots 
	 */
	
	public void initUI(){
		System.out.println("InitUI(): ");
		System.out.println("------------------");
		for(Robot r : listeRobots){
			System.out.println((r.toString() 
				+ ":" 
				+ r.getEnergie() 
				+"/"
				+ r.getEnergieInitiale()));
			this.add(new JLabel(r.toString() 
				+ ":" 
				+ r.getEnergie() 
				+"/"
				+ r.getEnergieInitiale()));
		}
		System.out.println("------------------");
	}
}
