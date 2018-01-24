package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: DDur.java Author: user Purpose: Defines the Class DDur
 ***********************************************************************/

public class DDur implements IComposant, Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int capacite;
	private int rpm;
	private Constructeur constructeur;

	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int newCapacite) {
		capacite = newCapacite;
	}

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int newRpm) {
		rpm = newRpm;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public DDur(int capacite, int rpm, Constructeur constructeur) {
		
		this.capacite = capacite;
		this.rpm = rpm;
		this.constructeur = constructeur;
	}

	public DDur(int capacite, int rpm, String type, String constructeur, String ref) {
		
		this.capacite = capacite;
		this.rpm = rpm;
		this.constructeur = new Constructeur(type, constructeur, ref);
	}

	public DDur() {

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String estCompose() {

		return "Disque dur [Capacité  : " + capacite + " Go, Vitesse de rotation : " + rpm + " rpm, Constructeur : "
				+ constructeur.getConstructeur() + "]";

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "DDur [capacite=" + capacite + ", rpm=" + rpm + ", constructeur=" + constructeur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacite;
		result = prime * result + ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + rpm;
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
		DDur other = (DDur) obj;
		if (capacite != other.capacite)
			return false;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (rpm != other.rpm)
			return false;
		return true;
	}

	
	
}