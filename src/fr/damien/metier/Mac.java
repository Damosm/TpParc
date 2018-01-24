package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Mac.java Author: user Purpose: Defines the Class Mac
 ***********************************************************************/

public class Mac implements Itype, Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MacOsVersion os;

	/**
	 * @param os
	 */
	public Mac(MacOsVersion os) {
		this.os = os;
	}

	public MacOsVersion getOs() {
		return os;
	}

	public void setOs(MacOsVersion os) {
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
		return "Mac [os=" + os + "]";
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
		Mac other = (Mac) obj;
		if (os != other.os)
			return false;
		return true;
	}

}