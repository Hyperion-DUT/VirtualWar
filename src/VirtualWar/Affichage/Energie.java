package VirtualWar.Affichage;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import VirtualWar.Unites.Robot;

public class Energie extends JPanel{

	private ArrayList<Robot> listeRobots;
	
	public Energie(ArrayList<Robot> listeRobots){
		System.out.println("Cr�ation");
		this.listeRobots = listeRobots;
		initUI();

	}
	
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
