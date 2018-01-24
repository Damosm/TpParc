package fr.damien.dao;

import java.sql.*;
import java.util.List;



import fr.damien.metier.Batiment;

public abstract class DAO<T> {

	protected Connection connect = DAOConnection.getInstance();


	/**
	 * Méthode de création
	 * 
	 * @param obj
	 * 
	 */
	public abstract void create(T obj) throws SQLException;
	
	
	/**
	 * Méthode de mise à jour
	 * 
	 * @param obj
	 * 
	 */
	public abstract void update(T obj) throws SQLException;

	/**
	 * Méthode pour effacer
	 * 
	 * @param obj
	 * 
	 */
	public abstract void delete(int id) throws SQLException;

	/**
	 * Méthode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);

	/**
	 * Méthode pour lister le contenu de la table
	 * 
	 * @return T
	 */
	public abstract List<T> liste();
	
}
