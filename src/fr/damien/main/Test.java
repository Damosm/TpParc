package fr.damien.main;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;

import fr.damien.dao.BatimentDAO;
import fr.damien.dao.CentreDAO;
import fr.damien.dao.DAO;
import fr.damien.dao.DAOConnection;
import fr.damien.metier.Batiment;
import fr.damien.metier.Centre;
import fr.damien.metier.Etage;
import fr.damien.metier.FabriqueComposants;
import fr.damien.metier.Formateur;
import fr.damien.metier.Formation;
import fr.damien.metier.Itype;
import fr.damien.metier.Mac;
import fr.damien.metier.MacOsVersion;
import fr.damien.metier.Machine;
import fr.damien.metier.OsTabletteVersion;
import fr.damien.metier.Pc;
import fr.damien.metier.Salle;
import fr.damien.metier.Stagiaire;
import fr.damien.metier.Tablette;
import fr.damien.metier.WindowsVersion;



public class Test {
	
	//private static final Logger logger = Logger.getLogger(Test.class);

	private static final String DATE_PATTERN = "dd.MM.yyyy";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static void main(String[] args) throws SQLException {
		
		PropertyConfigurator.configure("log4j.properties");
//		logger.debug("Sample debug message");
//		logger.info("Sample info message");
//		logger.warn("Sample warn message");
//		logger.error("Sample error message");
//		logger.fatal("Sample fatal message");
		

		////////////////////////////// DAO////////////////////////////////////////////
		//////////

		///////////////// Creation centres////////////////////////////////////

		Centre c1 = new Centre("Afpa_1", "Frouard");
		//Centre c2 = new Centre("Afpa_2", "Laxou");
		
		//DAO<Centre> cd1 = new CentreDAO();
Batiment b2 = new Batiment("toto", c1);
		//CentreDAO cd1 = new CentreDAO(DAOConnection.getInstance());
		//System.out.println(c1);
		//cd1.create(c1);
		//c1.setIdCentre(11);
		//c1.setNomCentre("test");
		DAO<Batiment> b1 = new BatimentDAO();
		b1.create(b2);
		System.out.println(b1.liste());
		
		//cd1.create(c1);
		//cd1.delete(1);
		

		/////////////// Creation batiments//////////////////////////////////

		//Batiment b1 = new Batiment("Batiment_1", c1);
		//Batiment b2 = new Batiment("Batiment_2", c1);

		//c1.addBatiment(b1);
		//c1.addBatiment(b2);

		//BatimentDAO bdao1 = new BatimentDAO(DAOConnection.getInstance());

//		bdao1.create(b1);
//		//bdao1.delete(4);
//		bdao1.create(b2);
//		//bdao1.find(12);
		
//		List<Centre> centres = cd1.liste();
//		for(Centre c : centres) {
//			System.out.println(c.getNomCentre());
//		}
//		
		//System.out.println(cd1.liste());
		
	//	cd1.find(14);

		///////////// affichage////////////////////////////////////////////

//		c1.afficherBatiments();
//		System.out.println(cd1.liste());
//		System.out.println(b1);
//		System.out.println(b2);
//		System.out.println(c1);
//		System.out.println(bdao1.find(2));

		/////////////////////////////////////////////////////////////////////////////
		//////////
		/////////////////////////////////////////////////////////////////////////////
		/////////

		///////////////////////// creation type
		//////////////////// machine////////////////////////////////////////////

		Itype windows10 = new Pc(WindowsVersion.windows10);
		Itype windows7 = new Pc(WindowsVersion.windows7);
		Itype mac10_13 = new Mac(MacOsVersion.macOS10_13);
		Itype mac10_12 = new Mac(MacOsVersion.macOS10_12);
		Itype mac10_11 = new Mac(MacOsVersion.osX10_11);
		Itype mac10_10 = new Mac(MacOsVersion.osX10_10);
		Itype android8_0_x = new Tablette(OsTabletteVersion.android8_0_x);
		Itype android7_x = new Tablette(OsTabletteVersion.android7_x);
		Itype android6_0 = new Tablette(OsTabletteVersion.android6_0);
		Itype android5_1_x = new Tablette(OsTabletteVersion.android5_1_x);

		////////////// creation
		// machines/////////////////////////////////////////////////////////

		FabriqueComposants fab1 = new FabriqueComposants();

		Machine m1 = new Machine("Machine_1", windows10);

		Machine m2 = new Machine("Machine_2", "112 4453", "192.168.2.2", LocalDate.of(2001, 02, 06),
				LocalDate.of(2003, 02, 06), "bon", windows10);
		Machine m3 = new Machine("Machine_3", "112 4453", "192.168.3.3", LocalDate.of(2010, 03, 12),
				LocalDate.of(2012, 03, 12), "BON", windows10);

		m1.addComposant(fab1.creerRAM(5000, 1333, "DDR", "Crucial", "545dd"));
		m1.addComposant(fab1.creerDDur(500, 7200, "3.5", "Maxtor", "454"));
		m1.addComposant(fab1.creerCM("1151", 1, 2, "5454", "MSI", "001"));
		m1.addComposant(fab1.creerCG(true, false, true, 2000, "45", "Nvidia", "Geforce"));

		//////////////////////// creation etages et
		// salle//////////////////////////////////////////////////

		Etage e0 = new Etage(0);
		Etage e1 = new Etage(1);
		//b1.addEtage(e0);
		//b1.addEtage(e1);

		Salle s1 = new Salle("Salle_DL", 1);
		Salle s2 = new Salle("CDI", 2);
		e0.addSalle(s1);
		e1.addSalle(s2);
		s2.addMachine(m1);
		s1.addMachine(m2);

		////////////////////////// creation formateurs et
		// stagiaires///////////////////////////////////////////

		Formation cdi11 = new Formation("CDI", "11", 2017);
		Stagiaire st1 = new Stagiaire("Durand", "Paul", "45, rue bleue nancy", 32, cdi11, m2);

		Formateur form1 = new Formateur("Sieber", "Marc", "45, rue verte Paris", 60);

		cdi11.addFormateur(form1);
		//cdi11.addCentre(c1);
		cdi11.addPersonne(form1);
		cdi11.addPersonne(st1);

		form1.addMachine(m1);
		form1.addFormation(cdi11);

		m2.addPersonne(st1);

		m1.addPersonne(form1);

		/////////////////////////////////////////////////// affichage/////////////////
		/////////////////////////////////////////////

		///////////////// machines////////////////////////////

//		m1.listerComposants();
//		m1.listerVersion();
//		m1.listerCM();
//		m1.listerCG();
//		System.out.println(m2.estCompose());
//		System.out.println(m3.estCompose());
//		m2.afficherPersonnes();

		///////////////// batiments///////////////////////////////////////

//		b1.afficher();

		///////////////// centres/////////////////////////////////

//		c1.afficherBatiments();
//		System.out.println(c1.estCompose());
//		c1.afficherFormations();

		///////////////// etages////////////////////////////////

//		e1.afficher();

		/////////////// salles///////////////////////////

//		s2.afficher();

		/////////////////// formations/////////////////////

//		cdi11.afficherCentre();
//		cdi11.afficherFormateur();
//		cdi11.afficherPers();

		///////////////// personnes//////////////////

//		st1.estCompose();

	}
}
