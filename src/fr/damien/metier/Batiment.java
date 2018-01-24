package fr.damien.metier;
import java.io.Serializable;

import fr.damien.dao.BatimentDAO;
import fr.damien.dao.DAOConnection;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.css.SimpleStyleableIntegerProperty;

/***********************************************************************
 * Module: Batiment.java Author: user Purpose: Defines the Class Batiment
 ***********************************************************************/

public class Batiment implements Serializable , Comparable{
	
	
	private IntegerProperty idBatiment;
	private StringProperty nomBat;
	private IntegerProperty idCentre;
	
	

	

	public java.util.Collection<Etage> etages;
	public Centre centre;

	//////////////////////////////////////////////////////////////////////

	
	public Batiment( String nomBat, Centre centre ) {

		this.idBatiment = new SimpleIntegerProperty();		
		this.nomBat = new SimpleStringProperty(nomBat);
		this.idCentre = new SimpleIntegerProperty(centre.getIdCentre());
		this.centre = centre;
		centre.addBatiment(this);

	}

	public Batiment(int idBat, String nomBat) {
		
		this.idBatiment = new SimpleIntegerProperty(idBat);		
		this.nomBat = new SimpleStringProperty(nomBat);
		//centre.addBatiment(this);
	}

	public Batiment() {
		
		this.idBatiment = new SimpleIntegerProperty();		
		this.nomBat = new SimpleStringProperty();
		this.idCentre = new SimpleIntegerProperty();

	}

	/////////////////////////////////////////////////////////////////////////

	
	
	public int getIdBatiment() {
		return idBatiment.get();
	}



	public int getIdCentre() {
		return idCentre.get();
	}

	public void setIdCentre(int idCentre) {
		this.idCentre.set(idCentre);
	}

	public void setIdBatiment(int idBatiment) {
		this.idBatiment.set(idBatiment);;
	}
	
	
	public String getNomBat() {
		return nomBat.get();
	}

	public void setNomBat(String newNomBat) {
		this.nomBat.set(newNomBat);
	}
	
	public IntegerProperty idBatProperty() {
		return idBatiment;
	}

	public StringProperty nomBatProperty() {
		return nomBat;
	}

	public IntegerProperty idCentreBatProperty() {
		return idCentre;
	}

	
	public java.util.Collection<Etage> getEtage() {
		if (etages == null)
			etages = new java.util.HashSet<Etage>();
		return etages;
	}

	
	public java.util.Iterator getIteratorEtage() {
		if (etages == null)
			etages = new java.util.HashSet<Etage>();
		return etages.iterator();
	}

	
	public void setEtage(java.util.Collection<Etage> newEtage) {
		removeAllEtage();
		for (java.util.Iterator iter = newEtage.iterator(); iter.hasNext();)
			addEtage((Etage) iter.next());
	}

	
	public void addEtage(Etage newEtage) {
		if (newEtage == null)
			return;
		if (this.etages == null)
			this.etages = new java.util.HashSet<Etage>();
		if (!this.etages.contains(newEtage)) {
			this.etages.add(newEtage);
			newEtage.setBatiment(this);
		}
	}

	
	public void removeEtage(Etage oldEtage) {
		if (oldEtage == null)
			return;
		if (this.etages != null)
			if (this.etages.contains(oldEtage)) {
				this.etages.remove(oldEtage);
				oldEtage.setBatiment((Batiment) null);
			}
	}

	
	public void removeAllEtage() {
		if (etages != null) {
			Etage oldEtage;
			for (java.util.Iterator iter = getIteratorEtage(); iter.hasNext();) {
				oldEtage = (Etage) iter.next();
				iter.remove();
				oldEtage.setBatiment((Batiment) null);
			}
		}
	}

	
	public Centre getCentre() {
		return centre;
	}

	
	public void setCentre(Centre newCentre) {
		if (this.centre == null || !this.centre.equals(newCentre)) {
			if (this.centre != null) {
				Centre oldCentre = this.centre;
				this.centre = null;
				oldCentre.removeBatiment(this);
			}
			if (newCentre != null) {
				this.centre = newCentre;
				this.centre.addBatiment(this);
			}
		}
	}
	
	////////////////////////////////////////////////////////////////////
	
	public String estCompose() {

		return "Nom batiment : " + nomBat;

	}
	
	
	public void afficher() {
		
		System.out.println("Batiment " + this.nomBat + " , liste etages : ");
		
		for (Etage e : etages) {
			System.out.println(e.estCompose());
		}
	}

	@Override
	public String toString() {
		return "Batiment [ Nom : " + nomBat + ", Id : "+ idBatiment + ", Centre = " + idCentre + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((etages == null) ? 0 : etages.hashCode());
		result = prime * result + ((nomBat == null) ? 0 : nomBat.hashCode());
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
		Batiment other = (Batiment) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (etages == null) {
			if (other.etages != null)
				return false;
		} else if (!etages.equals(other.etages))
			return false;
		if (nomBat == null) {
			if (other.nomBat != null)
				return false;
		} else if (!nomBat.equals(other.nomBat))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
	

}