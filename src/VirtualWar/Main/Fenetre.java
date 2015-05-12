package VirtualWar.Main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import VirtualWar.Plateau.Vue;
/**
 * Fenetre permettra de mettre en place un mode graphique au projet
 * Probleme: Pas de possibilité de JLabel avec le mode texte du plateau
 * pour un affichage temporaire 
 * @author Noxilex
 *
 */
public class Fenetre extends JFrame{

	public Fenetre(){
		JOptionPane.showMessageDialog(null, "Bienvenue dans VirtualWar - Version Semi-Graphique \n Lancement de la partie...");
		JFrame fenetre = new JFrame();
		JPanel container = new JPanel();
		JLabel plateau = new JLabel();
		
		fenetre.setTitle("VirtualWar");
		fenetre.setSize(500,500);
		fenetre.setLocation(100, 200);
		fenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		plateau.setText("OK");
		container.add(plateau);
		fenetre.getContentPane().add(container);
		
		fenetre.setVisible(true);
	}
	
	public Fenetre(Vue vue){
		JOptionPane.showMessageDialog(null, "Bienvenue dans VirtualWar - Version Semi-Graphique \n Lancement de la partie...");
		JFrame fenetre = new JFrame();
		JPanel container = new JPanel();
		JLabel plateau = new JLabel();
		
		fenetre.setTitle("VirtualWar");
		fenetre.setSize(500,500);
		fenetre.setLocation(100, 200);
		fenetre.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		plateau.setText(vue.toString());
		container.add(plateau);
		fenetre.getContentPane().add(container);
		
		fenetre.setVisible(true);
	}
	
	public static void main(String[] args){
		new Fenetre();
	}
}
