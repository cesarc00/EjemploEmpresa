package com.curso.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.curso.clases.Tarea;

public class DAOTarea extends DAO{

	
	// Atributos
	final static String TABLE = "TAREAS";
	
	final static String INSERT_TAREA_QUERY = "INSERT INTO " +TABLE+ " VALUES (?,?,?,?,?,?)";
	final static String DELETE_TAREA_QUERY = "DELETE FROM " +TABLE+ " WHERE CODIGO = ?";
	final static String UPDATE_TAREA_QUERY = "UPDATE " +TABLE+ " SET NOMBRE = ? , NIVEL_RESPONSABILIDAD = ? , DURACION = ? , DIFICULTAD = ? , ESTADO = ?  WHERE CODIGO = ?";
	final static String GET_TAREA_QUERY = "SELECT * FROM " +TABLE+ " WHERE CODIGO = ";
	
	// Constructor
	public DAOTarea(){ super(); }
	
	// Métodos
	public boolean insertarTarea(Tarea instance){
		
		// Open connection
		this.abrirConexion();
		
		// INSERT
		
		try {
			System.out.println("INSERT TAREA: "+instance.getCodigo()+" - "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(INSERT_TAREA_QUERY);		  

			preparedStatement.setInt(1, instance.getCodigo());
			preparedStatement.setString(2, instance.getNombre());
			preparedStatement.setInt(3, instance.getNivelResponsabilidad());
			preparedStatement.setInt(4, instance.getDuracion());
			preparedStatement.setString(5, instance.getDificultad());
			preparedStatement.setInt(6, instance.getEstado());
	
			preparedStatement.executeUpdate();
			
			
			System.out.println("TAREA SUCCESFULLY INSERTED INTO TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR INSERT TAREA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean eliminarTarea(Tarea instance){
		
		// Open connection
		this.abrirConexion();
		
		// DELETE
		
		try {
			System.out.println("DELETE TAREA: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(DELETE_TAREA_QUERY);		  
			  
			preparedStatement.setInt(1, instance.getCodigo());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("TAREA SUCCESFULLY DELETED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR DELETE TAREA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean actualizarTarea(Tarea instance){
		
		// Open connection
		this.abrirConexion();
		
		// UPDATE
		
		try {
			System.out.println("UPDATE TAREA: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(UPDATE_TAREA_QUERY);		  
			
			preparedStatement.setString(1, instance.getNombre());
			preparedStatement.setInt(2, instance.getNivelResponsabilidad());
			preparedStatement.setInt(3, instance.getDuracion());
			preparedStatement.setString(4, instance.getDificultad());
			preparedStatement.setInt(5, instance.getEstado());
			preparedStatement.setInt(6, instance.getCodigo());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("TAREA SUCCESFULLY UPDATED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR UPDATE TAREA: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	
	public ArrayList<Tarea> buscarTarea(int instanceDni){
		
		// Open connection
		this.abrirConexion();
		
		// FIND BY PROPERTY
		
		ArrayList<Tarea> resultadoBusqueda = new ArrayList<Tarea>();
		
		try {
			
			System.out.println("GET TAREA: "+instanceDni);
			
			String REQUEST = GET_TAREA_QUERY + "'" + instanceDni + "'";

			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(REQUEST);
			
			ResultSet rs = preparedStatement.executeQuery(REQUEST);	
			
			Tarea e = null;
			
			while (rs.next()) {
				e = new Tarea( rs.getString("NOMBRE"), rs.getInt("CODIGO"), rs.getInt("NIVEL_RESPONSABILIDAD"), rs.getInt("DURACION"), rs.getString("DIFICULTAD"), rs.getInt("ESTADO") );
				resultadoBusqueda.add(e);
			  }
			
			System.out.println("TAREA SUCCESFULLY GETTED FROM TABLE "+TABLE);			
			return resultadoBusqueda;
		}
		
		catch (Exception e){
			System.out.println("ERROR GET TAREA: "+e.getMessage());
			return resultadoBusqueda;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
}
