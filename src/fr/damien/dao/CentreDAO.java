package fr.damien.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.damien.metier.Centre;

public class CentreDAO extends DAO<Centre> {

	private static final Logger logger = Logger.getLogger(CentreDAO.class);

	/**
	 * Méthode pour créer un centre dans la base
	 * 
	 * @throws SQLException
	 */
	@Override
	public void create(Centre obj) {

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;

		try {

			preparedStatement = (PreparedStatement) connect.prepareStatement(
					"INSERT INTO`centre` (`idCentre`, `nomCentre`, `lieuCentre`) VALUES (NULL,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, obj.getNomCentre());
			preparedStatement.setString(2, obj.getLieuCentre());

			preparedStatement.executeUpdate();

			logger.info("Le centre a été créé");

			rs = preparedStatement.getGeneratedKeys();

			if (rs.first()) {
				
				obj.setIdCentre(rs.getInt(1));
			}

			rs.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : centre non créé");
		}

	}

	/**
	 * Méthode pour effacer un centre dans la base
	 * 
	 * @throws SQLException
	 */
	@Override
	public void delete(int id) {

		Statement stmt = null;

		try {

			stmt = connect.createStatement();

			String sql = "DELETE FROM `centre` WHERE `centre`.`idCentre` = " + id;

			stmt.executeLargeUpdate(sql);

			logger.info("Le centre a été effacé");

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : le centre n'a pas été effacé");
		}

	}

	/**
	 * Mise à jour centre dans la base
	 * 
	 * @param Centre
	 *            obj
	 * @throws SQLException
	 */
	@Override
	public void update(Centre obj) {

		Statement stmt = null;

		try {

			stmt = connect.createStatement();

			String sql = "UPDATE `centre` SET `nomCentre` = '" + obj.getNomCentre() + "', `lieuCentre` = '"
					+ obj.getLieuCentre() + "' WHERE `centre`.`idCentre` = " + obj.getIdCentre();

			stmt.executeLargeUpdate(sql);

			logger.info("Le centre a été mis à jour");

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : Le centre n'a pas été mis à jour ");
		}

	}

	/**
	 * Méthode pour trouver un centre
	 */
	@Override
	public Centre find(int id) {

		Centre centre = new Centre();
		Statement stmt = null;

		try {
			stmt = connect.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM centre WHERE idCentre = " + id);
			if (rs.first())
				centre.setIdCentre(rs.getInt("idCentre"));
			centre.setNomCentre(rs.getString("nomCentre"));
			centre.setLieuCentre(rs.getString("lieuCentre"));

			rs.close();
			stmt.close();

			logger.info("Le centre a été affiché");

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur lors de l'affichage du centre");
		}
		return centre;
	}

	/**
	 * Méthode pour lister tous les centres
	 */

	public List<Centre> liste() {

		List<Centre> centres = new ArrayList<>();

		Statement stmt = null;

		try {

			stmt = connect.createStatement();
			String sql;
			sql = "SELECT * FROM centre";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				
				Centre c = new Centre();
				c.setIdCentre(rs.getInt("idCentre"));
				c.setNomCentre(rs.getString("nomCentre"));
				c.setLieuCentre(rs.getString("lieuCentre"));

				// Add List
				centres.add(c);
			}

			logger.info("La liste des centres a été affiché");
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
			logger.error("Erreur : SQL");
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
			logger.error("Erreur : affichage liste centres");
		}

		return centres;
	}

}
