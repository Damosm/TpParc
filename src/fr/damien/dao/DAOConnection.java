package fr.damien.dao;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class DAOConnection {
	
	
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String JDBC_URL = "jdbc:mysql://";

    // Database credentials
    static String URL = "";
    static String USER = "";
    static String PASSWORD = "";
    static String DB = "osed";

    private static Connection connect;


    public static Connection getInstance()
    {
        if (connect == null)
        {
            try
            {
                try
                {
                    File fXmlFile = new File("MysqlConnect.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(fXmlFile);

                    // optional, but recommended
                    // read this -
                    // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                    doc.getDocumentElement().normalize();

                    NodeList nList = doc.getElementsByTagName("DB");
                    URL = (((Element) (nList.item(0))).getElementsByTagName("url").item(0).getTextContent());
                    PASSWORD = (((Element) (nList.item(0))).getElementsByTagName("password").item(0).getTextContent());
                    USER = (((Element) (nList.item(0))).getElementsByTagName("user").item(0).getTextContent());
                    DB = (((Element) (nList.item(0))).getElementsByTagName("database").item(0).getTextContent());
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
               // System.out.println(JDBC_URL + URL + "/" + DB);
                connect = DriverManager.getConnection(JDBC_URL + URL + "/" + DB, USER, PASSWORD);
            }
            catch (SQLException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        return connect;
		    }

}
