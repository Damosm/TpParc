package fr.damien.metier;

/***********************************************************************
 * Module:  Machine.java
 * Author:  user
 * Purpose: Defines the Class Machine
 ***********************************************************************/

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.InetAddressValidator;

public class Machine implements Comparable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idMachine;
	private String nomMachine;
	private String numAfpaMachine;
	private String ipMachine;
	private LocalDate dateAchatMachine;
	private LocalDate dateGarantieMachine;
	private String etatMachine;
	private Itype type;
	private Formateur formateur;

	public java.util.Collection<Personne> personnes;

	public Salle salle;

	private List<IComposant> composants;

	////////////////// Constructeurs////////////////////////////////////////////////////////////////////////////////////

	public Machine() {

	}

	public Machine(String nomMachine, Itype type) {
		this.nomMachine = nomMachine;
		this.type = type;
		composants = new ArrayList<>();
	}

	public Machine(String nomMachine, String numAfpaMachine, String ipMachine, LocalDate dateAchatMachine,
			LocalDate dateGarantieMachine, String etatMachine, Itype type) {

		this.nomMachine = nomMachine;
		this.setNumAfpaMachine(numAfpaMachine); 
		this.setIpMachine(ipMachine);
		this.dateAchatMachine = dateAchatMachine;
		this.dateGarantieMachine = dateGarantieMachine;
		this.etatMachine = etatMachine;
		this.type = type;
		composants = new ArrayList<>();
	}

	/////////////////////////////////////////// Méthodes///////////////////////////////////////////////////////////////////////////

	public String estCompose() {

		return "Nom Machine : " + nomMachine + " // Num Afpa : " + numAfpaMachine + " // Ip : " + ipMachine
				+ " // Date d'achat : " + dateAchatMachine + " // Date de garantie : " + dateGarantieMachine
				+ " // Etat : " + etatMachine + " // Type : " + getType() + " // Version : " + type.version();

	}

	public void afficherPersonnes() {

		System.out.println("Machine " + this.nomMachine + " , liste personnes : ");

		for (Personne p : personnes) {
			System.out.println(p.estCompose());
		}
	}


	public void addComposant(IComposant comp) {
		composants.add(comp);

	}

	public void listerComposants() {
		System.out.println("Machine " + this.nomMachine);

		for (IComposant m : this.getComposants()) {
			System.out.println(m.estCompose());
		}
	}

	public void listerDD() {
		System.out.println("Machine " + this.nomMachine);
		for (IComposant m : this.getComposants()) {
			if (m instanceof DDur) {
				System.out.println(m.estCompose());
			}
		}
	}

	public void listerRam() {
		System.out.println("Machine " + this.nomMachine);
		for (IComposant m : this.getComposants()) {
			if (m instanceof Ram) {
				System.out.println(m.estCompose());
			}
		}
	}

	public void listerCM() {
		System.out.println("Machine " + this.nomMachine);
		for (IComposant m : this.getComposants()) {
			if (m instanceof CarteMere) {
				System.out.println(m.estCompose());
			}
		}
	}

	public void listerCG() {
		System.out.println("Machine " + this.nomMachine);
		for (IComposant m : this.getComposants()) {
			if (m instanceof CarteGraphique) {
				System.out.println(m.estCompose());
			}
		}
	}

	public String version() {
		return type.version();
	}

	public void listerVersion() {

		System.out.println("Machine " + this.nomMachine + " " + type.version());

	}

	public void addPersonne(Personne newPersonne) {
		if (newPersonne == null)
			return;
		if (this.personnes == null)
			this.personnes = new java.util.HashSet<Personne>();
		if (!this.personnes.contains(newPersonne)) {
			this.personnes.add(newPersonne);
			newPersonne.addMachine(this);
		}
	}

	public void removePersonne(Personne oldPersonne) {
		if (oldPersonne == null)
			return;
		if (this.personnes != null)
			if (this.personnes.contains(oldPersonne)) {
				this.personnes.remove(oldPersonne);
				oldPersonne.removeMachine(this);
			}
	}

	public void removeAllPersonne() {
		if (personnes != null) {
			Personne oldPersonne;
			for (java.util.Iterator iter = getIteratorPersonne(); iter.hasNext();) {
				oldPersonne = (Personne) iter.next();
				iter.remove();
				oldPersonne.removeMachine(this);
			}
		}
	}

	////////////////////////////////// getteurs
	////////////////////////////////// setteurs/////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "" + nomMachine + ", numéro Afpa : " + numAfpaMachine + ", Ip : " + ipMachine + "";
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur newFormateur) {
		if (this.formateur == null || !this.formateur.equals(newFormateur)) {
			if (this.formateur != null) {
				Formateur oldFormateur = this.formateur;
				this.formateur = null;
				oldFormateur.removeMachine(this);
			}
			if (newFormateur != null) {
				this.formateur = newFormateur;
				this.formateur.addMachine(this);
			}
		}
	}

	public List<IComposant> getComposants() {
		return composants;
	}

	public void setComposants(List<IComposant> composants) {
		this.composants = composants;
	}

	public String getType() {

		return type.getClass().getSimpleName();
	}

	public void setType(Itype newType) {
		type = newType;
	}

	public String getEtatMachine() {
		return etatMachine;
	}

	public void setEtatMachine(String newEtatMachine) {
		etatMachine = newEtatMachine;
	}

	public String getNomMachine() {
		return nomMachine;
	}

	public void setNomMachine(String newNomMachine) {
		nomMachine = newNomMachine;
	}

	public String getNumAfpaMachine() {
		return numAfpaMachine;
	}

	public void setNumAfpaMachine(String newNumAfpaMachine) {

		boolean b = Pattern.matches("[0-9]{3} [0-9]{4}", newNumAfpaMachine);

		if (!b) {
			throw new IllegalArgumentException("Entrez : 3 chiffres, espace, 4 chiffres.");

		}

		else {
			numAfpaMachine = newNumAfpaMachine;
		}
	}

	public String getIpMachine() {
		return ipMachine;
	}

	public void setIpMachine(String newIpMachine) {

		boolean ipValid = InetAddressValidator.getInstance().isValid(newIpMachine);

		if (!ipValid) {
			throw new IllegalArgumentException("Ip non valide");
		} else {
			ipMachine = newIpMachine;
		}
	}

	public LocalDate getDateAchatMachine() {
		return dateAchatMachine;
	}

	public void setDateAchatMachine(LocalDate newDateAchatMachine) {

		dateAchatMachine = newDateAchatMachine;
	}

	public LocalDate getDateGarantieMachine() {
		return dateGarantieMachine;
	}

	public void setDateGarantieMachine(LocalDate newDateGarantieMachine) {
		dateGarantieMachine = newDateGarantieMachine;
	}

	public java.util.Collection<Personne> getPersonne() {
		if (personnes == null)
			personnes = new java.util.HashSet<Personne>();
		return personnes;
	}

	public java.util.Iterator getIteratorPersonne() {
		if (personnes == null)
			personnes = new java.util.HashSet<Personne>();
		return personnes.iterator();
	}

	public void setPersonne(java.util.Collection<Personne> newPersonne) {
		removeAllPersonne();
		for (java.util.Iterator iter = newPersonne.iterator(); iter.hasNext();)
			addPersonne((Personne) iter.next());
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle newSalle) {
		if (this.salle == null || !this.salle.equals(newSalle)) {
			if (this.salle != null) {
				Salle oldSalle = this.salle;
				this.salle = null;
				oldSalle.removeMachine(this);
			}
			if (newSalle != null) {
				this.salle = newSalle;
				this.salle.addMachine(this);
			}
		}
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
		Machine other = (Machine) obj;
		if (composants == null) {
			if (other.composants != null)
				return false;
		} else if (!composants.equals(other.composants))
			return false;
		if (dateAchatMachine == null) {
			if (other.dateAchatMachine != null)
				return false;
		} else if (!dateAchatMachine.equals(other.dateAchatMachine))
			return false;
		if (dateGarantieMachine == null) {
			if (other.dateGarantieMachine != null)
				return false;
		} else if (!dateGarantieMachine.equals(other.dateGarantieMachine))
			return false;
		if (etatMachine == null) {
			if (other.etatMachine != null)
				return false;
		} else if (!etatMachine.equals(other.etatMachine))
			return false;
		if (formateur == null) {
			if (other.formateur != null)
				return false;
		} else if (!formateur.equals(other.formateur))
			return false;
		if (ipMachine != other.ipMachine)
			return false;
		if (nomMachine == null) {
			if (other.nomMachine != null)
				return false;
		} else if (!nomMachine.equals(other.nomMachine))
			return false;
		if (numAfpaMachine != other.numAfpaMachine)
			return false;
		if (personnes == null) {
			if (other.personnes != null)
				return false;
		} else if (!personnes.equals(other.personnes))
			return false;
		if (salle == null) {
			if (other.salle != null)
				return false;
		} else if (!salle.equals(other.salle))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}