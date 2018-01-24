package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Salle.java Author: user Purpose: Defines the Class Salle
 ***********************************************************************/

public class Salle implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idSalle;
	private String nomSalle;
	private int numeroSalle;

	public java.util.Collection<Machine> machines;
	public Etage etage;

	/////////////////////////////////////////////////////////////////////////////////////

	public Salle(String nomSalle, int numeroSalle) {

		this.nomSalle = nomSalle;
		this.numeroSalle = numeroSalle;
	}

	public Salle() {

	}

	////////////////////////////////////////////////////////////////////////////////////////////

	public int getNumeroSalle() {
		return numeroSalle;
	}

	public void setNumeroSalle(int newNumeroSalle) {
		numeroSalle = newNumeroSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String newNomSalle) {
		nomSalle = newNomSalle;
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
			newMachine.setSalle(this);
		}
	}

	public void removeMachine(Machine oldMachine) {
		if (oldMachine == null)
			return;
		if (this.machines != null)
			if (this.machines.contains(oldMachine)) {
				this.machines.remove(oldMachine);
				oldMachine.setSalle((Salle) null);
			}
	}

	public void removeAllMachine() {
		if (machines != null) {
			Machine oldMachine;
			for (java.util.Iterator iter = getIteratorMachine(); iter.hasNext();) {
				oldMachine = (Machine) iter.next();
				iter.remove();
				oldMachine.setSalle((Salle) null);
			}
		}
	}

	public Etage getEtage() {
		return etage;
	}

	public void setEtage(Etage newEtage) {
		if (this.etage == null || !this.etage.equals(newEtage)) {
			if (this.etage != null) {
				Etage oldEtage = this.etage;
				this.etage = null;
				oldEtage.removeSalle(this);
			}
			if (newEtage != null) {
				this.etage = newEtage;
				this.etage.addSalle(this);
			}
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	public String estCompose() {

		return "Nom salle : " + nomSalle + " /////////////// Numéro salle : " + numeroSalle;

	}

	public void afficher() {

		System.out.println("Salle " + this.nomSalle + " , liste machines : ");

		for (Machine m : machines) {
			System.out.println(m.estCompose());
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Salle [nomSalle=" + nomSalle + ", numeroSalle=" + numeroSalle + ", machines=" + machines + ", etage="
				+ etage + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((etage == null) ? 0 : etage.hashCode());
		result = prime * result + ((machines == null) ? 0 : machines.hashCode());
		result = prime * result + ((nomSalle == null) ? 0 : nomSalle.hashCode());
		result = prime * result + numeroSalle;
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
		Salle other = (Salle) obj;
		if (etage == null) {
			if (other.etage != null)
				return false;
		} else if (!etage.equals(other.etage))
			return false;
		if (machines == null) {
			if (other.machines != null)
				return false;
		} else if (!machines.equals(other.machines))
			return false;
		if (nomSalle == null) {
			if (other.nomSalle != null)
				return false;
		} else if (!nomSalle.equals(other.nomSalle))
			return false;
		if (numeroSalle != other.numeroSalle)
			return false;
		return true;
	}

}