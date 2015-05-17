package VirtualWar.Affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import VirtualWar.Main.Jeu;

public class Fenetre extends JFrame{
	
	private JPanel principal;
	private JPanel interf;

	private JPanel recap;
	private JPanel recap_j1;
	private JPanel recap_j2;
	private JPanel recap_j1_titre;
	private JPanel recap_j2_titre;
	private Energie recap_j1_contenu;
	private Energie recap_j2_contenu;

	private JPanel actions;
	
	private JButton bouger;
	private JButton tirer;

	private JLabel j1;
	private JLabel j2;
	
	private Jeu jeu;
	
	public Fenetre(Plateau p, Jeu j){
		super();
		jeu = j;
		this.setTitle("VirtualWar");
		this.setLocation(100, 100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		//Création des panels
		principal = new JPanel(new GridLayout(1, 2, 10, 0));
		interf = new JPanel(new GridLayout(2, 1, 0, 5));
	
		recap = new JPanel(new GridLayout(1, 2));
		recap_j1 = new JPanel(new GridLayout(2, 1));
		recap_j2 = new JPanel(new GridLayout(2, 1));
		recap_j1_titre = new JPanel();
		recap_j2_titre = new JPanel();
		recap_j1_contenu = new Energie(j.getRobots_Equipe1());
		recap_j2_contenu = new Energie(j.getRobots_Equipe2());
	
		actions = new JPanel();
	
		j1 = new JLabel("Equipe bleue (j1)");
		j2 = new JLabel("Equipe rouge (j2)");
	
		//Colore les Panels pour les distinguer
		principal.setBackground(Color.BLACK);
		//recap_j1.setBackground(Color.YELLOW);
		//recap_j2.setBackground(Color.MAGENTA);
		recap_j1_titre.setBackground(Color.BLUE);
		recap_j2_titre.setBackground(Color.RED);
		recap_j1_contenu.setBackground(new Color(139,217,250));
		recap_j2_contenu.setBackground(new Color(250, 139, 139));
		actions.setBackground(Color.darkGray);
		interf.setBackground(Color.GRAY);
	
		//Nommage des équipes
		recap_j1_titre.add(j1);
		recap_j2_titre.add(j2);
	
		//Ajout des robots de l'équipe bleue dans l'interface
		recap_j1.add(recap_j1_titre);
		recap_j1.add(recap_j1_contenu);
	
		//Ajout des robots de l'équipe rouge dans l'interface
		recap_j2.add(recap_j2_titre );
		recap_j2.add(recap_j2_contenu);
	
		recap.add(recap_j1);
		recap.add(recap_j2);
	
	
		//Configuration de l'interface

		interf.setPreferredSize(new Dimension(100, p.getHeight()));
		interf.add(recap);
		interf.add(actions);
	
		//Configuration de la fenetre principale
		principal.add(p);
		principal.add(interf);
	
		//Ajout du panel principal dans la fenetre puis affichage
		this.getContentPane().add(principal);
		this.pack();
		this.setVisible(true);
	}
}
