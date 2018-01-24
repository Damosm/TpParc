package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: CarteGraphique.java Author: user Purpose: Defines the Class
 * CarteGraphique
 ***********************************************************************/

public class CarteGraphique implements IComposant, Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean hdmi;
	private boolean vga;
	private boolean dvi;
	private int memoire;
	private Constructeur constructeur;

	///////////////////////////////////////////////////////////////////////////

	public CarteGraphique(boolean hdmi, boolean vga, boolean dvi, int memoire, Constructeur constructeur) {
		this.hdmi = hdmi;
		this.vga = vga;
		this.dvi = dvi;
		this.memoire = memoire;
		this.constructeur = constructeur;
	}

	public CarteGraphique(boolean hdmi, boolean vga, boolean dvi, int memoire, String type, String constructeur, String ref) {
		this.hdmi = hdmi;
		this.vga = vga;
		this.dvi = dvi;
		this.memoire = memoire;
		this.constructeur = new Constructeur(type, constructeur, ref);
	}

	public CarteGraphique() {

	}

	////////////////////////////////////////////////////////////////////////////////////

	public int getMemoire() {
		return memoire;
	}

	public void setMemoire(int newMemoire) {
		memoire = newMemoire;
	}

	public boolean getHdmi() {
		return hdmi;
	}

	public void setHdmi(boolean newHdmi) {
		hdmi = newHdmi;
	}

	public boolean getVga() {
		return vga;
	}

	public void setVga(boolean newVga) {
		vga = newVga;
	}

	public boolean getDvi() {
		return dvi;
	}

	public void setDvi(boolean newDvi) {
		dvi = newDvi;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String estCompose() {
		
		return "Carte Graphique [Hdmi  : " + hdmi + ", Vga : " + vga + ", Dvi : " + dvi + ", Constructeur : "
				+ constructeur.getConstructeur() + "]";
	}

	@Override
	public String toString() {
		return "CarteGraphique [hdmi=" + hdmi + ", vga=" + vga + ", dvi=" + dvi + ", memoire=" + memoire
				+ ", constructeur=" + constructeur + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + (dvi ? 1231 : 1237);
		result = prime * result + (hdmi ? 1231 : 1237);
		result = prime * result + memoire;
		result = prime * result + (vga ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarteGraphique other = (CarteGraphique) obj;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (dvi != other.dvi)
			return false;
		if (hdmi != other.hdmi)
			return false;
		if (memoire != other.memoire)
			return false;
		if (vga != other.vga)
			return false;
		return true;
	}
	

}