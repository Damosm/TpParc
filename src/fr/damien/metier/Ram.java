package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Ram.java Author: user Purpose: Defines the Class Ram
 ***********************************************************************/

public class Ram implements IComposant, Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int memoire;
	private int frequence;
	private Constructeur constructeur;

	//////////////////////////////////////////////////////////////////////////////////////////

	public Ram(int memoire, int frequence, Constructeur constructeur) {
		super();
		this.memoire = memoire;
		this.frequence = frequence;
		this.constructeur = constructeur;
	}

	public Ram(int memoire, int frequence, String type, String constructeur, String ref) {
		this.memoire = memoire;
		this.frequence = frequence;
		this.constructeur = new Constructeur(type, constructeur, ref);
	}

	public Ram(int memoire, int frequence) {

		this.memoire = memoire;
		this.frequence = frequence;
	}

	public Ram() {

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getMemoire() {
		return memoire;
	}

	public void setMemoire(int newMemoire) {
		memoire = newMemoire;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int newFrequence) {
		frequence = newFrequence;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String estCompose() {

		return "RAM [Capacité : " + memoire + " , Fréquence : " + frequence + " Mhz, Constructeur : "
				+ constructeur.getConstructeur() + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Ram [memoire=" + memoire + ", frequence=" + frequence + ", constructeur=" + constructeur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + frequence;
		result = prime * result + memoire;
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
		Ram other = (Ram) obj;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (frequence != other.frequence)
			return false;
		if (memoire != other.memoire)
			return false;
		return true;
	}

}