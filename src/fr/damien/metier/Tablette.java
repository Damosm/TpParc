package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Tablette.java Author: user Purpose: Defines the Class Tablette
 ***********************************************************************/

public class Tablette implements Itype, Comparable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OsTabletteVersion os;

	public Tablette(OsTabletteVersion os) {
		this.os = os;
	}

	public String version() {

		return os.name();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "Tablette [os=" + os + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((os == null) ? 0 : os.hashCode());
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
		Tablette other = (Tablette) obj;
		if (os != other.os)
			return false;
		return true;
	}

}