package com.curso.daos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.curso.clases.Empleado;

public class DAOEmpleado extends DAO{
	
	// Atributos
	final static String TABLE = "EMPLEADOS";
	
	final static String INSERT_EMPLEADO_QUERY = "INSERT INTO " +TABLE+ " VALUES (?,?,?,?,?,?)";
	final static String DELETE_EMPLEADO_QUERY = "DELETE FROM " +TABLE+ " WHERE DNI = ?";
	final static String UPDATE_EMPLEADO_QUERY = "UPDATE " +TABLE+ " SET NOMBRE = ? , PUESTO = ? , SUELDO = ? , CATEGORIA = ? , HORAS_TRABAJADAS = ?  WHERE DNI = ?";
	final static String GET_EMPLEADO_QUERY = "SELECT * FROM " +TABLE+ " WHERE DNI = ";
	
	// Constructor
	public DAOEmpleado(){ super(); }
	
	// Métodos
	public boolean insertarEmpleado(Empleado instance){
		
		// Open connection
		this.abrirConexion();
		
		// INSERT
		
		try {
			System.out.println("INSERT EMPLEADO: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(INSERT_EMPLEADO_QUERY);		  

			preparedStatement.setInt(1, instance.getDni());
			preparedStatement.setString(2, instance.getNombre());
			preparedStatement.setString(3, instance.getPuesto());
			preparedStatement.setInt(4, instance.getSueldo());
			preparedStatement.setInt(5, instance.getCategoria());
			preparedStatement.setInt(6, instance.getHorasTrabajadas());
	
			preparedStatement.executeUpdate();
			
			
			System.out.println("EMPLEADO SUCCESFULLY INSERTED INTO TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR INSERT EMPLEADO: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean eliminarEmpleado(Empleado instance){
		
		// Open connection
		this.abrirConexion();
		
		// DELETE
		
		try {
			System.out.println("DELETE EMPLEADO: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(DELETE_EMPLEADO_QUERY);		  
			  
			preparedStatement.setInt(1, instance.getDni());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("EMPLEADO SUCCESFULLY DELETED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR DELETE EMPLEADO: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	public boolean actualizarEmpleado(Empleado instance){
		
		// Open connection
		this.abrirConexion();
		
		// UPDATE
		
		try {
			System.out.println("UPDATE EMPLEADO: "+instance.getNombre());
			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(UPDATE_EMPLEADO_QUERY);		  
			
			preparedStatement.setString(1, instance.getNombre());
			preparedStatement.setString(2, instance.getPuesto());
			preparedStatement.setInt(3, instance.getSueldo());
			preparedStatement.setInt(4, instance.getCategoria());
			preparedStatement.setInt(5, instance.getHorasTrabajadas());
			preparedStatement.setInt(6, instance.getDni());		  	

			preparedStatement.executeUpdate();
			
			System.out.println("EMPLEADO SUCCESFULLY UPDATED FROM TABLE "+TABLE);
			return true;
		}
		
		catch (Exception e){
			System.out.println("ERROR UPDATE EMPLEADO: "+e.getMessage());
			return false;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
	
	public ArrayList<Empleado> buscarEmpleado(int instanceDni){
		
		// Open connection
		this.abrirConexion();
		
		// FIND BY PROPERTY
		
		ArrayList<Empleado> resultadoBusqueda = new ArrayList<Empleado>();
		
		try {
			
			System.out.println("GET EMPLEADO: "+instanceDni);
			
			String REQUEST = GET_EMPLEADO_QUERY + "'" + instanceDni + "'";

			PreparedStatement preparedStatement = null;
			preparedStatement = this.conn.prepareStatement(REQUEST);
			
			ResultSet rs = preparedStatement.executeQuery(REQUEST);	
			
			Empleado e = null;
			
			while (rs.next()) {
				e = new Empleado( rs.getInt("DNI"), rs.getString("NOMBRE"), rs.getString("PUESTO"), rs.getInt("SUELDO"), rs.getInt("CATEGORIA"), rs.getInt("HORAS_TRABAJADAS") );
				resultadoBusqueda.add(e);
			  }
			
			System.out.println("EMPLEADO SUCCESFULLY GETTED FROM TABLE "+TABLE);			
			return resultadoBusqueda;
		}
		
		catch (Exception e){
			System.out.println("ERROR GET EMPLEADO: "+e.getMessage());
			return resultadoBusqueda;
		}
		
		finally{
			// Close connection
			this.cerrarConexion();
		}
		
	}
	
}
