package VirtualWar.Unites;



/**
 * La classe Robot représente un robot non-typé, avec les caractéristiques communes à tous les robots : son type, son équipe,
 * sa portée d'action, sa portée de déplacement, son énergie actuelle, son énergie maximale, le coût d'une action, les dégâts
 * qu'il peut potentiellement infliger à ses cibles.
 * @author Jules, Cyrille
 */
import java.util.ArrayList;

import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Plateau.Vue;

public abstract class Robot {
	
	/**	Le type du robot, qui sera défini par la suite dans les classes-filles */
	protected String typeRobot;
	/** L'équipe d'appartenance du Robot */
	private int equipe;
	/** La portée d'attaque du Robot */
	private int portee;
	/** La portée de déplacement du Robot */
	private int depMax;
	/** L'énergie courante du Robot */
	private int energie;
	/** L'énergie maximale du Robot, celle qu'il possède initialement */
	private int energieInitiale;
	/** La quantité d'énergie récupérée par le Robot en base */
	private int regenBase;
	/** Le coût d'un tir en énergie */
	private int coutTir;
	/** Le coût d'un déplacement en énergie */
	private int coutDep;
	/** La perte d'énergie causée par le Robot */
	private int degats;
	/**	La vue associée au Robot */
	private Vue vue = new Vue();
	/** La position actuelle du Robot, sous forme de Coordonnees */
	private Coordonnees coord;
	/** L'historique des déplacements du Robots, sous forme de liste de Coordonnees */
	private ArrayList<Coordonnees> histoDeplacements = new ArrayList<Coordonnees>();

	/**
	 * Construit un Robot non-typé, associé à une vue, une équipe, et des coordonnées
	 * @param vue - la vue associée au Robot
	 * @param x - l'abscisse des coordonnées du Robot
	 * @param y - l'ordonnée des coordonnées du Robot
	 * @param equipe - l'équipe d'appartenance du Robot
	 */
	public Robot(Vue vue, int x, int y, int equipe) {
		this.coord = new Coordonnees(x,y);
		this.vue = vue;
		this.equipe = equipe;
	}
	
	/**
	 * Attribue un coût d'action de tir au Robot
	 * @param coutTir - le coût en énergie d'un tir
	 */
	public void setCoutTir(int coutTir) { this.coutTir = coutTir; }

	/**
	 * Attribue une quantité de dégâts que peut causer le Robot
	 * @param degats - les dégâts potentiellement causés par le Robot
	 */
	public void setDegats(int degats) { this.degats = degats; }

	/**
	 * Retourne la portée d'action du Robot
	 * @return la portée d'action du Robot
	 */
	public int getPortee() { return this.portee; }

	/**
	 * Attribue une portée d'action au Robot
	 * @param portee - la portée à attribuer au Robot
	 */
	public void setPortee(int portee) { this.portee = portee; }

	/**
	 * Attribue un coût de déplacement (en énergie) au Robot
	 * @param coutDep - le coût d'un déplacement du Robot
	 */
	public void setCoutDep(int coutDep) { this.coutDep = coutDep; }

	/**
	 * Attribue une équipe au Robot
	 * @param equipe - l'équipe du Robot
	 */
	public void setEquipe(int equipe) { this.equipe = equipe; }

	/**
	 * Retourne vrai si le Robot peut effectuer un tir (i.e. s'il a une ligne de vue), faux sinon
	 * @return vrai si le Robot peut tirer, faux sinon
	 */
	public abstract boolean peutTirer();

	/**
	 * Retourne le coût (en énergie) d'une action d'attaque du Robot
	 * @return le coût d'une attaque du Robot
	 */
	public abstract int getCoutAction();

	/**
	 * Retourne le coût (en énergie) d'une action de déplacement du Robot
	 * @return le coût d'un déplacement du Robot
	 */
	public abstract int getCoutDep();

	/**
	 * Retourne la quantité de dégâts infligée par un tir du Robot
	 * @return la quantité d'énergie causée en perte à l'entité ciblée
	 */
	public abstract int getDegatTir();

	/**
	 * Retourne la quantité de dégâts infligée par une mine
	 * @return la quantité d'énergie causée en perte à l'entité passant sur une mine posée par ce Robot
	 */
	public abstract int getDegatMine();

	/**
	 * Retourne l'historique des déplacements effectués par le Robot, sous forme de liste de Deplacements
	 * @return l'ensemble des déplacements passés du Robot
	 */
	public ArrayList<Coordonnees> getDeplacements() { return this.histoDeplacements; }

	/**
	 * Retourne vrai si le Robot se situe sur une base (associée à son camp), faux sinon
	 * @return vrai si le Robot est en base, faux sinon
	 */
	public boolean estSurBase() {
		return coord.equals(vue.getBase(equipe));
	}

	/**
	 * Attribue une nouvelle position au Robot, via de nouvelles Coordonnees
	 * @param coords - les nouvelles Coordonnees du Robot
	 */
	public void setCoordonnees(Coordonnees coord) { this.coord = coord; }

	/**
	 * Retourne la position actuelle du Robot, sous forme de Coordonnees
	 * @return les Coordonnees du Robot
	 */
	public Coordonnees getCoordonnees() { return coord; }

	/**
	 * Retourne la vue associée au Robot
	 * @return la vue associée au Robot
	 */
	public Vue getVue() { return vue; }

	/**
	 * Retourne l'équipe d'appartenance du Robot
	 * @return l'équipe du Robot
	 */
	public int getEquipe() { return this.equipe; }

	/**
	 * Attribue au Robot une nouvelle quantité d'énergie
	 * @param energie - l'énergie à attribuer au robot
	 */
	public void setEnergie(int energie) { this.energie = energie; }

	/**
	 * Retourne la quantité d'énergie maximale que peut emmagasiner le Robot, celle qu'il possède initialement
	 * @return l'énergie initiale du Robot
	 */
	public int getEnergieInitiale() { return energieInitiale; }

	/**
	 * Attribue au Robot une énergie initiale
	 * @param energieInitiale - l'énergie initiale du Robot
	 */
	public void setEnergieInitiale(int energieInitiale) { this.energieInitiale = energieInitiale; }
	
	/**
	 * Retourne la portée de déplacement maximale que peut effectuer le Robot
	 * @return la portée de déplacement maximale du Robot
	 */
	public int getDepMax() { return depMax; }
	
	/**
	 * Attribue une portée de déplacement maximale au Robot
	 * @param depMax - la portée de déplacement maximale du Robot
	 */
	public void setDepMax(int depMax) { this.depMax = depMax; }

	/**
	 * Retourne l'énergie actuelle du Robot
	 * @return l'énergie du Robot
	 */
	public int getEnergie() { return energie; }

	/**
	 * Affecte une Vue au Robot
	 * @param vue - la vue affectée au Robot
	 */
	public void setVue(Vue vue) { this.vue = vue; }

	/**
	 * Actualise l'énergie du Robot en fonction des dégâts du tir subi
	 */
	public void subitTir(Robot rob) { energie -= rob.getDegatTir(); }

	/**
	 * Actualise l'énergie du Robot en fonction des dégâts de la mine activée
	 */
	public  void subitMine(Robot rob) { energie -= rob.getDegatMine(); }

	/**
	 * Attribue une quantité d'énergie à récupérer lorsque le Robot est en base
	 * @param regenBase - l'énergie récupérée en base
	 */
	public void setRegenBase(int regenBase) {
		this.regenBase = regenBase;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() { return this.typeRobot; }

}
