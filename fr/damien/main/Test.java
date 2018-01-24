package fr.damien.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fr.damien.dao.*;
import fr.damien.metier.*;

public class Test {

	private static final String DATE_PATTERN = "dd.MM.yyyy";

	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);


}


  
  //////////////////////////////DAO////////////////////////////////////////////
  //////////
  
  ///////////////// Creation centres////////////////////////////////////
  
  Centre c1 = new Centre("Afpa_1", "Frouard"); Centre c2 = new Centre("Afpa_2",
  "Laxou");
  
  CentreDAO cd1 = new CentreDAO(DAOConnection.getInstance());
  
  cd1.create(c1); cd1.create(c2);
  
  /////////////// Creation batiments//////////////////////////////////
  
  Batiment b1 = new Batiment("Batiment_1", c1); Batiment b2 = new
  Batiment("Batiment_2", c1);
  
  c1.addBatiment(b1); c1.addBatiment(b2);
  
  
  BatimentDAO bdao1 = new BatimentDAO(DAOConnection.getInstance());
  
  bdao1.create(b1); bdao1.create(b2);
  
  
  /////////////affichage////////////////////////////////////////////
  
  c1.afficherBatiments(); bdao1.liste(); System.out.println(b1);
  System.out.println(b2); System.out.println(c1);
  
  /////////////////////////////////////////////////////////////////////////////
  //////////
  /////////////////////////////////////////////////////////////////////////////
  /////////
  
  /////////////////////////creation type
  machine////////////////////////////////////////////
  
  Itype windows10 = new Pc(WindowsVersion.windows10); Itype windows7 = new
  Pc(WindowsVersion.windows7); Itype mac10_13 = new
  Mac(MacOsVersion.macOS10_13); Itype mac10_12 = new
  Mac(MacOsVersion.macOS10_12); Itype mac10_11 = new
  Mac(MacOsVersion.osX10_11); Itype mac10_10 = new Mac(MacOsVersion.osX10_10);
  Itype android8_0_x = new Tablette(OsTabletteVersion.android8_0_x); Itype
  android7_x = new Tablette(OsTabletteVersion.android7_x); Itype android6_0 =
  new Tablette(OsTabletteVersion.android6_0); Itype android5_1_x = new
  Tablette(OsTabletteVersion.android5_1_x);
  
  
  //////////////creation
  machines/////////////////////////////////////////////////////////
  
  
  
  FabriqueComposants fab1 = new FabriqueComposants();
  
  Machine m1 = new Machine("Machine_1", windows10);
  
  Machine m2 = new Machine("Machine_2", "112 4453", "192.168.2.2",
  LocalDate.of(2001, 02, 06), LocalDate.of(2003, 02, 06), "bon", windows10);
  Machine m3 = new Machine("Machine_3", "112 4453", "192.168.3.3",
  LocalDate.of(2010, 03, 12), LocalDate.of(2012, 03, 12), "BON", windows10);
  
  m1.addComposant(fab1.creerRAM(5000, 1333, "DDR", "Crucial", "545dd"));
  m1.addComposant(fab1.creerDDur(500, 7200, "3.5", "Maxtor", "454"));
  m1.addComposant(fab1.creerCM("1151", 1, 2, "5454", "MSI", "001"));
  m1.addComposant(fab1.creerCG(true, false, true, 2000, "45", "Nvidia",
  "Geforce"));
  
  ////////////////////////creation etages et
  salle//////////////////////////////////////////////////
  
  Etage e0 = new Etage(0); Etage e1 = new Etage(1); b1.addEtage(e0);
  b1.addEtage(e1);
  
  Salle s1 = new Salle("Salle_DL", 1); Salle s2 = new Salle("CDI", 2);
  e0.addSalle(s1); e1.addSalle(s2); s2.addMachine(m1); s1.addMachine(m2);
  
  //////////////////////////creation formateurs et
  stagiaires///////////////////////////////////////////
  
  Formation cdi11 = new Formation("CDI", "11", 2017); Stagiaire st1 = new
  Stagiaire("Durand", "Paul", "45, rue bleue nancy", 32, cdi11, m2);
  
  Formateur form1 = new Formateur("Sieber", "Marc", "45, rue verte Paris", 60);
  
  cdi11.addFormateur(form1); cdi11.addCentre(c1); cdi11.addPersonne(form1);
  cdi11.addPersonne(st1);
  
  form1.addMachine(m1); form1.addFormation(cdi11);
  
  m2.addPersonne(st1);
  
  m1.addPersonne(form1);
  
  ///////////////////////////////////////////////////affichage/////////////////
  /////////////////////////////////////////////
  
  /////////////////machines////////////////////////////
  
  m1.listerComposants(); m1.listerVersion(); m1.listerCM(); m1.listerCG();
  System.out.println(m2.estCompose()); System.out.println(m3.estCompose());
  m2.afficherPersonnes();
  
  /////////////////batiments///////////////////////////////////////
  
  b1.afficher();
  
  /////////////////centres/////////////////////////////////
  
  c1.afficherBatiments(); System.out.println(c1.estCompose());
  c1.afficherFormations();
  
  /////////////////etages////////////////////////////////
  
  e1.afficher();
  
  ///////////////salles///////////////////////////
  
  s2.afficher();
  
  ///////////////////formations/////////////////////
  
  cdi11.afficherCentre(); cdi11.afficherFormateur(); cdi11.afficherPers();
  
  /////////////////personnes//////////////////
  
  st1.estCompose();
  
  
  
  
