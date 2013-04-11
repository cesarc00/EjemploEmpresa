package com.curso.daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	
	// Atributos
	static Connection conn = null;
	  
	final static String URL = "jdbc:mysql://localhost:3306/";
	final static String DB_NAME = "itcourses";
	final static String DRIVER = "com.mysql.jdbc.Driver";
	final static String USER_NAME = "root"; 
	final static String PASSWORD = "root";
	
	// Constructor
	DAO(){}
	
	// Métodos	
	public void abrirConexion() {		
		try {
			Class.forName(DRIVER).newInstance();
			this.conn = DriverManager.getConnection(URL+DB_NAME,USER_NAME,PASSWORD);
			System.out.println("Connected to the database");
		}
		catch (Exception e){
			System.out.println("ERROR INICIO CONEXIÓN: "+e.getMessage());
		}
	} 
	
	public void cerrarConexion(){	
		try {
			this.conn.close();
			System.out.println("Disconnected from database");
		}
		catch (Exception e){
			System.out.println("ERROR CIERRE CONEXIÓN: "+e.getMessage());
		}

	} 

}
