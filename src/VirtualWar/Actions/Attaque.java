package VirtualWar.Actions;
import VirtualWar.Plateau.Cellule;
import VirtualWar.Plateau.Coordonnees;
import VirtualWar.Unites.Char;
import VirtualWar.Unites.Piegeur;
import VirtualWar.Unites.Robot;
import VirtualWar.Unites.Tireur;

/**
 * 
 * @author Jules
 *
 */
public class Attaque extends Action {
	/**
	 * encapsulation de la classe Robot avoir une cible
	 */
	Robot robotCible;
	int porteeAttaque;
	/**
	 * Ce constructeur initialise une attaque à partir d'un robot et de coordonnees places en parametre.
	 * @param robot
	 * @param direction
	 */
	public Attaque(Robot robot, Coordonnees direction) {
		super(robot, direction);

	}

	@Override
	/**
	 * Cette methode modifie la portee d'attaque en fonction de l'unite et modifie l'energie de l'unité et de sa cible apres l'attaque
	 */
	public void agit() {
		
		if (this.getRobot() instanceof Tireur){
			porteeAttaque=3;
			if(peutAttaquer(robotCible)==true){
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
				robotCible.setEnergie(robotCible.getEnergie()-this.getRobot().getDegatTir());
			}
			
		if (this.getRobot() instanceof Char){
			porteeAttaque=10;
			if(peutAttaquer(robotCible)==true){
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
				robotCible.setEnergie(robotCible.getEnergie()-this.getRobot().getDegatTir());
			}
		}	
		if (this.getRobot() instanceof Piegeur &&(robotCible instanceof Tireur || robotCible instanceof Piegeur || robotCible instanceof Char)){
			porteeAttaque=1;
			if(peutAttaquer(robotCible)==true){
				this.getRobot().setEnergie(this.getRobot().getEnergie()-this.getRobot().getCoutAction());
				robotCible.setEnergie(robotCible.getEnergie()-this.getRobot().getDegatMine());
				}
			}
		
		}
	}
	/**
	 * Cette methode retourne un booleen qui exprime si le robot est capable d'attaquer sa cible
	 * @param robotCible
	 * @return
	 */
		public boolean peutAttaquer(Robot robotCible){
			if ((robotCible.getCoordonnees().getX()-this.getRobot().getCoordonnees().getX()<=porteeAttaque && robotCible.getCoordonnees().getX()-this.getRobot().getCoordonnees().getX()>-porteeAttaque) || (robotCible.getCoordonnees().getY()==this.getRobot().getCoordonnees().getY())){
				return true;
			}
			if((robotCible.getCoordonnees().getY()-this.getRobot().getCoordonnees().getY()<porteeAttaque && robotCible.getCoordonnees().getY()-this.getRobot().getCoordonnees().getY()>porteeAttaque)&& (this.getRobot().getCoordonnees().getX()==robotCible.getCoordonnees().getX())){
				return true;
			}
			return false;
		}
		/**
		 * Cette methode retourne true si il est possible de poser une mine
		 * @param cellule
		 * @return
		 */
		public boolean PoserMine(Cellule cellule){
			if (cellule.estVide()==true){
				return true;
			}
			return false;
		}
	
}
	
	
