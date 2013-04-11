package com.curso.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.curso.clases.Empresa;

public class DAOEmpresa extends DAO {
	
	// Atributos
	final static String TABLE = "EMPRESAS";
	
	final static String INSERT_EMPRESA_QUERY = "INSERT INTO " +TABLE+ " VALUES (?,?,?,?,?,?)";
	final static String DELETE_EMPRESA_QUERY = "DELETE FROM " +TABLE+ " WHERE CIF = ?";
	final static String UPDATE_EMPRESA_QUERY = "UPDATE " +TABLE+ " SET NOMBRE = ? , DESCRIPCION = ? , PRESUPUESTO_ANUAL = ? WHERE CIF = ?";
	final static String GET_EMPRESA_QUERY = "SELECT * FROM " +TABLE+ " WHERE CIF = ";
	
	// Constructor
	public DAOEmpresa(){ super(); }
	
	// Métodos
	public boolean insertarEmpresa(Empresa instance){
		
		// Open connection
		this.abrirConexion();
		
		// INSERT
		
		try {
			System.out.println("INSERT EMPRESA: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(INSERT_EMPRESA_QUERY);		  

			preparedStatement.setInt(1, instance.getIdEmpresa());
			preparedStatement.setString(2, instance.getCif());
			preparedStatement.setString(3, instance.getNombre());
			preparedStatement.setString(4, instance.getDescripcion());
			preparedStatement.setInt(5, instance.maxTrabajadores);
			preparedStatement.setInt(6, instance.getPresupuestoAnual());
	
			preparedStatement.executeUpdate();
			
			
			System.out.println("EMPRESA SUCCESFULLY INSERTED INTO TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR INSERT EMPRESA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean eliminarEmpresa(Empresa instance){
		
		// Open connection
		this.abrirConexion();
		
		// DELETE
		
		try {
			System.out.println("DELETE EMPRESA: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(DELETE_EMPRESA_QUERY);		  
			  
			preparedStatement.setString(1, instance.getCif());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("EMPRESA SUCCESFULLY DELETED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR DELETE EMPRESA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean actualizarEmpresa(Empresa instance){
		
		// Open connection
		this.abrirConexion();
		
		// UPDATE
		
		try {
			System.out.println("UPDATE EMPRESA: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(UPDATE_EMPRESA_QUERY);		  
			
			preparedStatement.setString(1, instance.getNombre());
			preparedStatement.setString(2, instance.getDescripcion());
			preparedStatement.setInt(3, instance.getPresupuestoAnual());
			preparedStatement.setString(4, instance.getCif());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("EMPRESA SUCCESFULLY UPDATED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR UPDATE EMPRESA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	
	public ArrayList<Empresa> buscarEmpresa(String instanceCif){
		
		// Open connection
		this.abrirConexion();
		
		// FIND BY PROPERTY
		
		ArrayList<Empresa> resultadoBusqueda = new ArrayList<Empresa>();
		
		try {
			
			System.out.println("GET EMPRESA: "+instanceCif);
			
			String REQUEST = GET_EMPRESA_QUERY + "'" + instanceCif + "'";

			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(REQUEST);
			
			ResultSet rs = preparedStatement.executeQuery(REQUEST);	
			
			Empresa e = null;
			
			while (rs.next()) {
				e = new Empresa( rs.getString("CIF"), rs.getString("NOMBRE"), rs.getString("DESCRIPCION"), rs.getInt("PRESUPUESTO_ANUAL") );
				resultadoBusqueda.add(e);
			  }
			
			System.out.println("EMPRESA SUCCESFULLY GETTED FROM TABLE "+TABLE);			
			return resultadoBusqueda;
		}
		
		catch (Exception e){
			System.out.println("ERROR GET EMPRESA: "+e.getMessage());
			return resultadoBusqueda;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
}
