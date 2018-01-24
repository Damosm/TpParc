package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: Pc.java Author: user Purpose: Defines the Class Pc
 ***********************************************************************/

public class Pc implements Itype, Comparable, Serializable {

	
	private WindowsVersion os;

	public Pc(WindowsVersion os) {
		this.os = os;
	}

	@Override
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
		return "Pc [os=" + os + "]";
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
		Pc other = (Pc) obj;
		if (os != other.os)
			return false;
		return true;
	}

}
