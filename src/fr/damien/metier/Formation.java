package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: formation.java Author: user Purpose: Defines the Class formation
 ***********************************************************************/

public class Formation implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomFormation;
	private String versionFormation;
	private int dateFormation;

	public java.util.Collection<Personne> personnes;
	public java.util.Collection<Centre> centres;
	public java.util.Collection<Formateur> formateurs;

	///////////////////////////////////////////////////////////////////////////////////////////

	public Formation() {

	}

	public Formation(String nomFormation, String versionFormation, int dateFormation) {

		this.nomFormation = nomFormation;
		this.versionFormation = versionFormation;
		this.dateFormation = dateFormation;
	}

	///////////////////////////////////////////////////////////////////////////////////////////

	public int getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(int newDateFormation) {
		dateFormation = newDateFormation;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String newNomFormation) {
		nomFormation = newNomFormation;
	}

	public String getVersionFormation() {
		return versionFormation;
	}

	public void setVersionFormation(String newVersionFormation) {
		versionFormation = newVersionFormation;
	}

	public java.util.Collection<Personne> getPersonne() {
		if (personnes == null)
			personnes = new java.util.ArrayList<Personne>();
		return personnes;
	}

	public java.util.Iterator getIteratorPersonne() {
		if (personnes == null)
			personnes = new java.util.ArrayList<Personne>();
		return personnes.iterator();
	}

	public void setPersonne(java.util.Collection<Personne> newPersonne) {
		removeAllPersonne();
		for (java.util.Iterator iter = newPersonne.iterator(); iter.hasNext();)
			addPersonne((Personne) iter.next());
	}

	public void addPersonne(Personne newPersonne) {
		if (newPersonne == null)
			return;
		if (this.personnes == null)
			this.personnes = new java.util.ArrayList<Personne>();
		if (!this.personnes.contains(newPersonne))
			this.personnes.add(newPersonne);
	}

	public void removePersonne(Personne oldPersonne) {
		if (oldPersonne == null)
			return;
		if (this.personnes != null)
			if (this.personnes.contains(oldPersonne))
				this.personnes.remove(oldPersonne);
	}

	public void removeAllPersonne() {
		if (personnes != null)
			personnes.clear();
	}

	public java.util.Collection<Centre> getCentre() {
		if (centres == null)
			centres = new java.util.HashSet<Centre>();
		return centres;
	}

	public java.util.Iterator getIteratorCentre() {
		if (centres == null)
			centres = new java.util.HashSet<Centre>();
		return centres.iterator();
	}

	public void setCentre(java.util.Collection<Centre> newCentre) {
		removeAllCentre();
		for (java.util.Iterator iter = newCentre.iterator(); iter.hasNext();)
			addCentre((Centre) iter.next());
	}

	public void addCentre(Centre newCentre) {
		if (newCentre == null)
			return;
		if (this.centres == null)
			this.centres = new java.util.HashSet<Centre>();
		if (!this.centres.contains(newCentre)) {
			this.centres.add(newCentre);
			newCentre.addFormation(this);
		}
	}

	public void removeCentre(Centre oldCentre) {
		if (oldCentre == null)
			return;
		if (this.centres != null)
			if (this.centres.contains(oldCentre)) {
				this.centres.remove(oldCentre);
				oldCentre.removeFormation(this);
			}
	}

	public void removeAllCentre() {
		if (centres != null) {
			Centre oldCentre;
			for (java.util.Iterator iter = getIteratorCentre(); iter.hasNext();) {
				oldCentre = (Centre) iter.next();
				iter.remove();
				oldCentre.removeFormation(this);
			}
		}
	}

	public java.util.Collection<Formateur> getFormateur() {
		if (formateurs == null)
			formateurs = new java.util.HashSet<Formateur>();
		return formateurs;
	}

	public java.util.Iterator getIteratorFormateur() {
		if (formateurs == null)
			formateurs = new java.util.HashSet<Formateur>();
		return formateurs.iterator();
	}

	public void setFormateur(java.util.Collection<Formateur> newFormateur) {
		removeAllFormateur();
		for (java.util.Iterator iter = newFormateur.iterator(); iter.hasNext();)
			addFormateur((Formateur) iter.next());
	}

	public void addFormateur(Formateur newFormateur) {
		if (newFormateur == null)
			return;
		if (this.formateurs == null)
			this.formateurs = new java.util.HashSet<Formateur>();
		if (!this.formateurs.contains(newFormateur)) {
			this.formateurs.add(newFormateur);
			newFormateur.addFormation(this);
		}
	}

	public void removeFormateur(Formateur oldFormateur) {
		if (oldFormateur == null)
			return;
		if (this.formateurs != null)
			if (this.formateurs.contains(oldFormateur)) {
				this.formateurs.remove(oldFormateur);
				oldFormateur.removeFormation(this);
			}
	}

	public void removeAllFormateur() {
		if (formateurs != null) {
			Formateur oldFormateur;
			for (java.util.Iterator iter = getIteratorFormateur(); iter.hasNext();) {
				oldFormateur = (Formateur) iter.next();
				iter.remove();
				oldFormateur.removeFormation(this);
			}
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////////

	public void afficherPers() {

		System.out.println("Formation " + this.nomFormation + " " + versionFormation);

		for (Personne p : personnes) {
			System.out.println(p.estCompose());
		}
	}

	public void afficherCentre() {

		System.out.println("Formation " + this.nomFormation + " " + versionFormation);

		for (Centre c : centres) {
			System.out.println(c.estCompose());
		}
	}

	public void afficherFormateur() {

		System.out.println("Formation " + this.nomFormation + " " + versionFormation);

		for (Formateur f : formateurs) {
			System.out.println(f.estCompose());
		}
	}

	public String estCompose() {

		return "Nom formation : " + nomFormation + " // Version : " + versionFormation + " // Date : " + dateFormation;

	}

	@Override
	public String toString() {
		return "" + nomFormation + "";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formation other = (Formation) obj;
		if (centres == null) {
			if (other.centres != null)
				return false;
		} else if (!centres.equals(other.centres))
			return false;
		if (dateFormation != other.dateFormation)
			return false;
		if (formateurs == null) {
			if (other.formateurs != null)
				return false;
		} else if (!formateurs.equals(other.formateurs))
			return false;
		if (nomFormation == null) {
			if (other.nomFormation != null)
				return false;
		} else if (!nomFormation.equals(other.nomFormation))
			return false;
		if (personnes == null) {
			if (other.personnes != null)
				return false;
		} else if (!personnes.equals(other.personnes))
			return false;
		if (versionFormation == null) {
			if (other.versionFormation != null)
				return false;
		} else if (!versionFormation.equals(other.versionFormation))
			return false;
		return true;
	}

}