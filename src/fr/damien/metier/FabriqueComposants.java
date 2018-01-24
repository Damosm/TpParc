package fr.damien.metier;
import java.io.Serializable;

public class FabriqueComposants implements Comparable, Serializable{

	

	public FabriqueComposants() {
	}

	public IComposant creerCM(String socket, int nbrProcesseur, int slot, Constructeur constructeur) {
		return new CarteMere(socket, nbrProcesseur, slot, constructeur);
	}

	public IComposant creerCM(String socket, int nbrProcesseur, int slot, String type, String constructeur,
			String ref) {

		return new CarteMere(socket, nbrProcesseur, slot, new Constructeur(type, constructeur, ref));
	}

	public IComposant creerRAM(int memoire, int frequence, Constructeur constructeur) {
		return new Ram(memoire, frequence, constructeur);
	}

	public IComposant creerRAM(int memoire, int frequence, String type, String constructeur, String ref) {

		return new Ram(memoire, frequence, new Constructeur(type, constructeur, ref));
	}

	public IComposant creerDDur(int capacite, int rpm, Constructeur constructeur) {
		return new DDur(capacite, rpm, constructeur);
	}

	public IComposant creerDDur(int capacite, int rpm, String type, String constructeur, String ref) {
		return new DDur(capacite, rpm, new Constructeur(type, constructeur, ref));
	}

	public IComposant creerCG(boolean hdmi, boolean vga, boolean dvi, int memoire, Constructeur constructeur) {
		return new CarteGraphique(hdmi, vga, dvi, memoire, constructeur);
	}

	public IComposant creerCG(boolean hdmi, boolean vga, boolean dvi, int memoire, String type, String constructeur,
			String ref) {
		return new CarteGraphique(hdmi, vga, dvi, memoire, new Constructeur(type, constructeur, ref));
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
