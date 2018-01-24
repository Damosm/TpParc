package fr.damien.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import fr.damien.metier.Batiment;
import fr.damien.metier.Centre;

public class BatimentDAO extends DAO<Batiment> {

	private static final Logger logger = Logger.getLogger(CentreDAO.class);

	/**
	 * Méthode pour creer batiment dans la base
	 */
	@Override
	public void create(Batiment obj) {

		PreparedStatement preparedStatement = null;

		ResultSet rs = null;

		try {

			preparedStatement = (PreparedStatement) connect.prepareStatement(
					"INSERT INTO `batiment` (`idBatiment`, `nomBat`, `idCentre`) VALUES (NULL,?,?)",

					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, obj.getNomBat());
			preparedStatement.setInt(2, obj.getIdCentre());

			preparedStatement.executeUpdate();

			logger.info("Le batiment a été créé");

			rs = preparedStatement.getGeneratedKeys();

			if (rs.first()) {
				obj.setIdBatiment(rs.getInt(1));
			}

			rs.close();
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : batiment non créé");
		}

	}

	public List<Batiment> afficherBatCentre(Centre centre) {

		List<Batiment> l1 = new ArrayList<>();

		PreparedStatement p1 = null;
		ResultSet rs = null;

		try {
			p1 = connect.prepareStatement("select * from batiment where idCentre = ?");

			p1.setInt(1, centre.getIdCentre());

			rs = p1.executeQuery();

			while (rs.next()) {

				l1.add(new Batiment(rs.getInt(1), rs.getString(2)));
			}
			rs.close();
			p1.close();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return l1;
	}

	/**
	 * Méthode pour effacer batiment de la base
	 */
	@Override
	public void delete(int id) {

		Statement stmt = null;

		try {

			stmt = connect.createStatement();

			String sql = "DELETE FROM `batiment` WHERE `batiment`.`idBatiment` = " + id;

			stmt.executeLargeUpdate(sql);

			logger.info("Le batiment a été effacé");

			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : Le batiment n'a pas été effacé");
		}

	}

	/**
	 * Mise à jour batiment dans la base
	 * 
	 * @param Batiment
	 *            obj
	 */
	public void update(Batiment obj) {

		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connect
					.prepareStatement("update batiment set nomBat = ? where batiment.idBatiment = ?");

			preparedStatement.setString(1, obj.getNomBat());
			preparedStatement.setInt(2, obj.getIdBatiment());

			preparedStatement.executeUpdate();

			logger.info("Le batiment a été mis à jour");

			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur : Le batiment n'a pas été mis à jour");
		}

	}

	/**
	 * Méthode pour trouver un batiment avec son ID
	 */
	@Override
	public Batiment find(int id) {

		Batiment batiment = new Batiment();
		Statement stmt = null;

		try {
			stmt = connect.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM batiment WHERE idBatiment = " + id);
			if (rs.first())
				batiment.setIdBatiment(rs.getInt("idBatiment"));
			batiment.setNomBat(rs.getString("nomBat"));
			batiment.setIdCentre(rs.getInt("idCentre"));

			System.out.println(batiment);

			logger.info("Le batiment a été affiché");

			rs.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Erreur lors de l'affichage du batiment");
		}
		return batiment;

	}

	/**
	 * Méthode pour lister tous les batiments
	 */
	@Override
	public List<Batiment> liste() {

		List<Batiment> batiments = new ArrayList<>();
		Statement stmt = null;

		try {

			stmt = connect.createStatement();
			String sql;
			sql = "SELECT * FROM batiment";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				Batiment b = new Batiment();
				b.setIdBatiment(rs.getInt("idBatiment"));
				b.setNomBat(rs.getString("nomBat"));
				b.setIdCentre(rs.getInt("idCentre"));

				// Add List
				batiments.add(b);
			}
			logger.info("La liste de batiments a été affiché");

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
			logger.error("Erreur : Probleme d'affichage liste batiments");
		}

		return batiments;
	}

}
