package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Etage.java Author: user Purpose: Defines the Class Etage
 ***********************************************************************/

public class Etage implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idEtage;
	private int numeroEtage;

	public java.util.Collection<Salle> salles;
	public Batiment batiment;

	////////////////////////////////////////////////////////////////////////////////////////////

	public Etage(int numeroEtage) {

		this.numeroEtage = numeroEtage;
	}

	public Etage() {

	}

	////////////////////////////////////////////////////////////////////////////////////////////////

	public int getNumeroEtage() {
		return numeroEtage;
	}

	public void setNumeroEtage(int newNumeroEtage) {
		numeroEtage = newNumeroEtage;
	}

	public java.util.Collection<Salle> getSalle() {
		if (salles == null)
			salles = new java.util.HashSet<Salle>();
		return salles;
	}

	public java.util.Iterator getIteratorSalle() {
		if (salles == null)
			salles = new java.util.HashSet<Salle>();
		return salles.iterator();
	}

	public void setSalle(java.util.Collection<Salle> newSalle) {
		removeAllSalle();
		for (java.util.Iterator iter = newSalle.iterator(); iter.hasNext();)
			addSalle((Salle) iter.next());
	}

	public void addSalle(Salle newSalle) {
		if (newSalle == null)
			return;
		if (this.salles == null)
			this.salles = new java.util.HashSet<Salle>();
		if (!this.salles.contains(newSalle)) {
			this.salles.add(newSalle);
			newSalle.setEtage(this);
		}
	}

	public void removeSalle(Salle oldSalle) {
		if (oldSalle == null)
			return;
		if (this.salles != null)
			if (this.salles.contains(oldSalle)) {
				this.salles.remove(oldSalle);
				oldSalle.setEtage((Etage) null);
			}
	}

	public void removeAllSalle() {
		if (salles != null) {
			Salle oldSalle;
			for (java.util.Iterator iter = getIteratorSalle(); iter.hasNext();) {
				oldSalle = (Salle) iter.next();
				iter.remove();
				oldSalle.setEtage((Etage) null);
			}
		}
	}

	public Batiment getBatiment() {
		return batiment;
	}

	public void setBatiment(Batiment newBatiment) {
		if (this.batiment == null || !this.batiment.equals(newBatiment)) {
			if (this.batiment != null) {
				Batiment oldBatiment = this.batiment;
				this.batiment = null;
				oldBatiment.removeEtage(this);
			}
			if (newBatiment != null) {
				this.batiment = newBatiment;
				this.batiment.addEtage(this);
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////

	public String estCompose() {

		return "Etage numero : " + numeroEtage;

	}

	public void afficher() {

		System.out.println("Etage " + this.numeroEtage + " , liste salles : ");

		for (Salle s : salles) {
			System.out.println(s.estCompose());
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Etage [numeroEtage=" + numeroEtage + ", salles=" + salles + ", batiment=" + batiment + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etage other = (Etage) obj;
		if (batiment == null) {
			if (other.batiment != null)
				return false;
		} else if (!batiment.equals(other.batiment))
			return false;
		if (numeroEtage != other.numeroEtage)
			return false;
		if (salles == null) {
			if (other.salles != null)
				return false;
		} else if (!salles.equals(other.salles))
			return false;
		return true;
	}

}