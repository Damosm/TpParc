package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Personne.java Author: user Purpose: Defines the Class Personne
 ***********************************************************************/

public class Personne implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomPersonne;
	private String prenomPersonne;
	private String adressePersonne;
	private int agePersonne;

	public java.util.Collection<Machine> machines;
	// public java.util.Collection<Formation> formation;

	//////////////////////////////////////////////////////////////////////////////////

	public Personne(String nomPersonne, String prenomPersonne, String adressePersonne, int agePersonne) {

		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.adressePersonne = adressePersonne;
		this.agePersonne = agePersonne;
	}

	public Personne() {

	}

	//////////////////////////////////////////////////////////////////////////////

	public int getAgePersonne() {
		return agePersonne;
	}

	public void setAgePersonne(int newAgePersonne) {
		agePersonne = newAgePersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String newNomPersonne) {
		nomPersonne = newNomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String newPrenomPersonne) {
		prenomPersonne = newPrenomPersonne;
	}

	public String getAdressePersonne() {
		return adressePersonne;
	}

	public void setAdressePersonne(String newAdressePersonne) {
		adressePersonne = newAdressePersonne;
	}

	public java.util.Collection<Machine> getMachine() {
		if (machines == null)
			machines = new java.util.HashSet<Machine>();
		return machines;
	}

	public java.util.Iterator getIteratorMachine() {
		if (machines == null)
			machines = new java.util.HashSet<Machine>();
		return machines.iterator();
	}

	public void setMachine(java.util.Collection<Machine> newMachine) {
		removeAllMachine();
		for (java.util.Iterator iter = newMachine.iterator(); iter.hasNext();)
			addMachine((Machine) iter.next());
	}

	public void addMachine(Machine newMachine) {
		if (newMachine == null)
			return;
		if (this.machines == null)
			this.machines = new java.util.HashSet<Machine>();
		if (!this.machines.contains(newMachine)) {
			this.machines.add(newMachine);
			newMachine.addPersonne(this);
		}
	}

	public void removeMachine(Machine oldMachine) {
		if (oldMachine == null)
			return;
		if (this.machines != null)
			if (this.machines.contains(oldMachine)) {
				this.machines.remove(oldMachine);
				oldMachine.removePersonne(this);
			}
	}

	public void removeAllMachine() {
		if (machines != null) {
			Machine oldMachine;
			for (java.util.Iterator iter = getIteratorMachine(); iter.hasNext();) {
				oldMachine = (Machine) iter.next();
				iter.remove();
				oldMachine.removePersonne(this);
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	public void afficher() {

		System.out.println("Personne " + this.nomPersonne);

		for (Machine m : machines) {
			System.out.println(m.estCompose());
		}
	}

	public String estCompose() {

		return "Nom : " + nomPersonne + " // Prenom : " + prenomPersonne + " // Adresse : " + adressePersonne
				+ " // Age : " + agePersonne;

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Personne [nomPersonne=" + nomPersonne + ", prenomPersonne=" + prenomPersonne + ", adressePersonne="
				+ adressePersonne + ", agePersonne=" + agePersonne + ", machines=" + machines + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressePersonne == null) ? 0 : adressePersonne.hashCode());
		result = prime * result + agePersonne;
		result = prime * result + ((machines == null) ? 0 : machines.hashCode());
		result = prime * result + ((nomPersonne == null) ? 0 : nomPersonne.hashCode());
		result = prime * result + ((prenomPersonne == null) ? 0 : prenomPersonne.hashCode());
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
		Personne other = (Personne) obj;
		if (adressePersonne == null) {
			if (other.adressePersonne != null)
				return false;
		} else if (!adressePersonne.equals(other.adressePersonne))
			return false;
		if (agePersonne != other.agePersonne)
			return false;
		if (machines == null) {
			if (other.machines != null)
				return false;
		} else if (!machines.equals(other.machines))
			return false;
		if (nomPersonne == null) {
			if (other.nomPersonne != null)
				return false;
		} else if (!nomPersonne.equals(other.nomPersonne))
			return false;
		if (prenomPersonne == null) {
			if (other.prenomPersonne != null)
				return false;
		} else if (!prenomPersonne.equals(other.prenomPersonne))
			return false;
		return true;
	}

}