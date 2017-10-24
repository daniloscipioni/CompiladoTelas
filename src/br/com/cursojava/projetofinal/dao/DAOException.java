package br.com.cursojava.projetofinal.dao;

public class DAOException extends Exception {
	
	public DAOException(String msg, Exception e){
		super(msg, e);
	}
	
}
