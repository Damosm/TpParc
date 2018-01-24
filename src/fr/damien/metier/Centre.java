package fr.damien.metier;

import java.io.Serializable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/***********************************************************************
 * Module: Centre.java Author: user Purpose: Defines the Class Centre
 ***********************************************************************/

public class Centre implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IntegerProperty idCentre;
	private StringProperty nomCentre;
	private StringProperty lieuCentre;

	public java.util.Collection<Batiment> batiments;
	public java.util.Collection<Formation> formations;

	//////////////////////////////////////////////////////////////////////////////////////////////

	public Centre() {
		this.idCentre = new SimpleIntegerProperty();		
		this.nomCentre = new SimpleStringProperty();
		this.lieuCentre = new SimpleStringProperty();
	}

	public Centre(String nomCentre, String lieuCentre) {
		this.idCentre = new SimpleIntegerProperty();
		this.nomCentre = new SimpleStringProperty(nomCentre);
		this.lieuCentre = new SimpleStringProperty(lieuCentre);
	}

	public Centre(int idCentre, String nomCentre, String lieuCentre) {

		this.idCentre = new SimpleIntegerProperty(idCentre);	
		this.nomCentre = new SimpleStringProperty(nomCentre);
		this.lieuCentre = new SimpleStringProperty(lieuCentre);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getIdCentre() {
		return idCentre.get();
	}

	public String getNomCentre() {
		return nomCentre.get();
	}

	public String getLieuCentre() {
		return lieuCentre.get();
	}

	public void setIdCentre(int newidCentre) {
		this.idCentre.set(newidCentre);
		
	}

	public void setNomCentre(String newNomCentre) {
		this.nomCentre.set(newNomCentre);
	}

	public void setLieuCentre(String newLieuCentre) {
		this.lieuCentre.set(newLieuCentre);
	}

	public IntegerProperty idProperty() {
		return idCentre;
	}

	public StringProperty nomProperty() {
		return nomCentre;
	}

	public StringProperty lieuProperty() {
		return lieuCentre;
	}

	public java.util.Collection<Batiment> getBatiment() {
		if (batiments == null)
			batiments = new java.util.HashSet<Batiment>();
		return batiments;
	}

	public java.util.Iterator getIteratorBatiment() {
		if (batiments == null)
			batiments = new java.util.HashSet<Batiment>();
		return batiments.iterator();
	}

	public void setBatiment(java.util.Collection<Batiment> newBatiment) {
		removeAllBatiment();
		for (java.util.Iterator iter = newBatiment.iterator(); iter.hasNext();)
			addBatiment((Batiment) iter.next());
	}

	public void addBatiment(Batiment newBatiment) {
		if (newBatiment == null)
			return;
		if (this.batiments == null)
			this.batiments = new java.util.HashSet<Batiment>();
		if (!this.batiments.contains(newBatiment)) {
			this.batiments.add(newBatiment);
			
		}

	}

	public void removeBatiment(Batiment oldBatiment) {
		if (oldBatiment == null)
			return;
		if (this.batiments != null)
			if (this.batiments.contains(oldBatiment)) {
				this.batiments.remove(oldBatiment);
				oldBatiment.setCentre((Centre) null);
			}
	}

	public void removeAllBatiment() {
		if (batiments != null) {
			Batiment oldBatiment;
			for (java.util.Iterator iter = getIteratorBatiment(); iter.hasNext();) {
				oldBatiment = (Batiment) iter.next();
				iter.remove();
				oldBatiment.setCentre((Centre) null);
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
			newFormation.addCentre(this);
		}
	}

	public void removeFormation(Formation oldFormation) {
		if (oldFormation == null)
			return;
		if (this.formations != null)
			if (this.formations.contains(oldFormation)) {
				this.formations.remove(oldFormation);
				oldFormation.removeCentre(this);
			}
	}

	public void removeAllFormation() {
		if (formations != null) {
			Formation oldFormation;
			for (java.util.Iterator iter = getIteratorFormation(); iter.hasNext();) {
				oldFormation = (Formation) iter.next();
				iter.remove();
				oldFormation.removeCentre(this);
			}
		}
	}

	///////////////////////////////////////////////////////////////////

	public String estCompose() {

		return "Nom centre : " + nomCentre + " //////// Lieu : " + lieuCentre;

	}

	public String afficherId() {

		return "" + idCentre;
	}

	public void afficherBatiments() {

		System.out.println("Centre " + this.nomCentre + ", liste batiments : ");

		for (Batiment b : batiments) {
			System.out.println(b.estCompose());
		}
	}

	public void afficherFormations() {

		System.out.println("Centre " + this.nomCentre + ", liste des formations : ");

		for (Formation f : formations) {
			System.out.println(f.estCompose());
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Centre [ Nom = " + nomCentre + ", Id = " + idCentre + ", Lieu = " + lieuCentre + " ]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Centre other = (Centre) obj;
		if (batiments == null) {
			if (other.batiments != null)
				return false;
		} else if (!batiments.equals(other.batiments))
			return false;
		if (formations == null) {
			if (other.formations != null)
				return false;
		} else if (!formations.equals(other.formations))
			return false;
		if (lieuCentre == null) {
			if (other.lieuCentre != null)
				return false;
		} else if (!lieuCentre.equals(other.lieuCentre))
			return false;
		if (nomCentre == null) {
			if (other.nomCentre != null)
				return false;
		} else if (!nomCentre.equals(other.nomCentre))
			return false;
		return true;
	}

}