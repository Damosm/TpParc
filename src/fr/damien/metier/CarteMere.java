package fr.damien.metier;
import java.io.Serializable;

/***********************************************************************
 * Module: CarteMere.java Author: user Purpose: Defines the Class CarteMere
 ***********************************************************************/

public class CarteMere implements IComposant, Comparable, Serializable {
	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private String socket;
	private int nbrProcesseur;
	private int slot;
	private Constructeur constructeur;

	///////////////////////////////////////////////////////////
	
	/**
	 * Constructeur si fabriquant existant
	 * @param socket
	 * @param nbrProcesseur
	 * @param slot
	 * @param constructeur
	 */

	public CarteMere(String socket, int nbrProcesseur, int slot, Constructeur constructeur) {
		this.socket = socket;
		this.nbrProcesseur = nbrProcesseur;
		this.slot = slot;
		this.constructeur = constructeur;
	}

	/**
	 * Constructeur qui creer carte mere et son fabriquant
	 * @param socket
	 * @param nbrProcesseur
	 * @param slot
	 * @param type
	 * @param constructeur
	 * @param ref
	 */
	public CarteMere(String socket, int nbrProcesseur, int slot, String type, String constructeur, String ref) {

		this.socket = socket;
		this.nbrProcesseur = nbrProcesseur;
		this.slot = slot;
		this.constructeur = new Constructeur(type, constructeur, ref);

	}

	public CarteMere() {

	}

	///////////////////////////////////////////////////////////////////////////////

	public String getSocket() {
		return socket;
	}

	public void setSocket(String newSocket) {
		socket = newSocket;
	}

	public int getNbrProcesseur() {
		return nbrProcesseur;
	}

	public void setNbrProcesseur(int newNbrProcesseur) {
		nbrProcesseur = newNbrProcesseur;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int newSlot) {
		slot = newSlot;
	}

	/////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String estCompose() {

		return "Carte Mère [Socket  : " + socket + ", nombre de processeurs : " + nbrProcesseur + ", slot : " + slot
				+ ", constructeur : " + constructeur.getConstructeur() + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "CarteMere [socket=" + socket + ", nbrProcesseur=" + nbrProcesseur + ", slot=" + slot + ", constructeur="
				+ constructeur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((constructeur == null) ? 0 : constructeur.hashCode());
		result = prime * result + nbrProcesseur;
		result = prime * result + slot;
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
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
		CarteMere other = (CarteMere) obj;
		if (constructeur == null) {
			if (other.constructeur != null)
				return false;
		} else if (!constructeur.equals(other.constructeur))
			return false;
		if (nbrProcesseur != other.nbrProcesseur)
			return false;
		if (slot != other.slot)
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		return true;
	}

	
	
	
}