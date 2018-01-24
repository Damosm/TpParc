package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Stagiaire.java Author: user Purpose: Defines the Class Stagiaire
 ***********************************************************************/

public class Stagiaire extends Personne implements Comparable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Formation maFormation;
	private Machine maMachine;

	public Stagiaire(String nomPersonne, String prenomPersonne, String adressePersonne, int agePersonne,
			Formation maFormation, Machine maMachine) {
		super(nomPersonne, prenomPersonne, adressePersonne, agePersonne);
		this.maFormation = maFormation;
		this.maMachine = maMachine;
	}

	public Formation getMaFormation() {
		return maFormation;
	}

	public void setMaFormation(Formation maFormation) {
		this.maFormation = maFormation;
	}

	public Machine getMaMachine() {
		return maMachine;
	}

	public void setMaMachine(Machine maMachine) {
		this.maMachine = maMachine;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////

	public String estCompose() {

		return "Nom stagiaires: " + this.getNomPersonne() + " // Prenom : " + this.getPrenomPersonne()
				+ " // Adresse : " + this.getAdressePersonne() + " // Age : " + this.getAgePersonne()
				+ " // Formation : " + this.getMaFormation() + " // Machine : " + maMachine;

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Stagiaire [maFormation=" + maFormation + ", maMachine=" + maMachine + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((maFormation == null) ? 0 : maFormation.hashCode());
		result = prime * result + ((maMachine == null) ? 0 : maMachine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stagiaire other = (Stagiaire) obj;
		if (maFormation == null) {
			if (other.maFormation != null)
				return false;
		} else if (!maFormation.equals(other.maFormation))
			return false;
		if (maMachine == null) {
			if (other.maMachine != null)
				return false;
		} else if (!maMachine.equals(other.maMachine))
			return false;
		return true;
	}

}