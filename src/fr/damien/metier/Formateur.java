package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Formateur.java Author: user Purpose: Defines the Class Formateur
 ***********************************************************************/

public class Formateur extends Personne implements Comparable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public Formateur(String nomPersonne, String prenomPersonne, String adressePersonne, int agePersonne) {
		super(nomPersonne, prenomPersonne, adressePersonne, agePersonne);
	}

	public Formateur() {
		

	}

	public java.util.Collection<Machine> machines;
	public java.util.Collection<Formation> formations;

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
			newMachine.setFormateur(this);
		}
	}

	public void removeMachine(Machine oldMachine) {
		if (oldMachine == null)
			return;
		if (this.machines != null)
			if (this.machines.contains(oldMachine)) {
				this.machines.remove(oldMachine);
				oldMachine.setFormateur((Formateur) null);
			}
	}

	public void removeAllMachine() {
		if (machines != null) {
			Machine oldMachine;
			for (java.util.Iterator iter = getIteratorMachine(); iter.hasNext();) {
				oldMachine = (Machine) iter.next();
				iter.remove();
				oldMachine.setFormateur((Formateur) null);
			}
		}
	}

	public java.util.Collection<Formation> getFormation() {
		if (formations == null)
			formations = new java.util.HashSet<Formation>();
		return formations;
	}

	public java.util.Iterator getIteratorFormation() {
		if (formations == null)
			formations = new java.util.HashSet<Formation>();
		return formations.iterator();
	}

	public void setFormation(java.util.Collection<Formation> newFormation) {
		removeAllFormation();
		for (java.util.Iterator iter = newFormation.iterator(); iter.hasNext();)
			addFormation((Formation) iter.next());
	}

	public void addFormation(Formation newFormation) {
		if (newFormation == null)
			return;
		if (this.formations == null)
			this.formations = new java.util.HashSet<Formation>();
		if (!this.formations.contains(newFormation)) {
			this.formations.add(newFormation);
			newFormation.addFormateur(this);
		}
	}

	public void removeFormation(Formation oldFormation) {
		if (oldFormation == null)
			return;
		if (this.formations != null)
			if (this.formations.contains(oldFormation)) {
				this.formations.remove(oldFormation);
				oldFormation.removeFormateur(this);
			}
	}

	public void removeAllFormation() {
		if (formations != null) {
			Formation oldFormation;
			for (java.util.Iterator iter = getIteratorFormation(); iter.hasNext();) {
				oldFormation = (Formation) iter.next();
				iter.remove();
				oldFormation.removeFormateur(this);
			}
		}
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void afficherMachines() {

		System.out.println("Formateur " + this.getNomPersonne() + " liste de machines : ");

		for (Machine m : machines) {
			System.out.println(m.estCompose());
		}
	}

	public void afficherFormations() {

		System.out.println("Formateur " + this.getNomPersonne() + " liste de formations : ");

		for (Formation f : formations) {
			System.out.println(f.estCompose());
		}
	}

	public String estCompose() {

		return "Nom formateur : " + this.getNomPersonne() + " // Prenom : " + this.getPrenomPersonne()
				+ " // Adresse : " + this.getAdressePersonne() + " // Age : " + this.getAgePersonne();

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Formateur [machines=" + machines + ", formations=" + formations + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formations == null) ? 0 : formations.hashCode());
		result = prime * result + ((machines == null) ? 0 : machines.hashCode());
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
		Formateur other = (Formateur) obj;
		if (formations == null) {
			if (other.formations != null)
				return false;
		} else if (!formations.equals(other.formations))
			return false;
		if (machines == null) {
			if (other.machines != null)
				return false;
		} else if (!machines.equals(other.machines))
			return false;
		return true;
	}

}