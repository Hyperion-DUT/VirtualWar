package main;

public class Vue {
	private boolean estVisible;
	private Plateau plateau;
	
	public Vue(){
		
	}
	
	public Vue(Plateau plateau){
		this.plateau = plateau;
	}

	public boolean estVisible() {
		return estVisible;
	}

	public void setVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}
}
