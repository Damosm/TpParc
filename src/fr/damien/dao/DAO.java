package fr.damien.dao;

import java.sql.*;
import java.util.List;



import fr.damien.metier.Batiment;

public abstract class DAO<T> {

	protected Connection connect = DAOConnection.getInstance();


	/**
	 * M�thode de cr�ation
	 * 
	 * @param obj
	 * 
	 */
	public abstract void create(T obj) throws SQLException;
	
	
	/**
	 * M�thode de mise � jour
	 * 
	 * @param obj
	 * 
	 */
	public abstract void update(T obj) throws SQLException;

	/**
	 * M�thode pour effacer
	 * 
	 * @param obj
	 * 
	 */
	public abstract void delete(int id) throws SQLException;

	/**
	 * M�thode de recherche des informations
	 * 
	 * @param id
	 * @return T
	 */
	public abstract T find(int id);

	/**
	 * M�thode pour lister le contenu de la table
	 * 
	 * @return T
	 */
	public abstract List<T> liste();
	
}
