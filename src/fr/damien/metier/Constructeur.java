package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module:  Constructeur.java
 * Author:  user
 * Purpose: Defines the Class Constructeur
 ***********************************************************************/

public class Constructeur implements Comparable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String constructeur;
	private String reference;

	///////////////////////////////////////////////////////////////////////////////////

	public String getType() {
		return type;
	}

	public void setType(String newType) {
		type = newType;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String newConstructeur) {
		constructeur = newConstructeur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String newReference) {
		reference = newReference;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Constructeur(String type, String constructeur, String reference) {
		super();
		this.type = type;
		this.constructeur = constructeur;
		this.reference = reference;
	}

	public Constructeur() {

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Constructeur [type=" + type + ", constructeur=" + constructeur + ", reference=" + reference + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Constructeur other = (Constructeur) obj;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	

}