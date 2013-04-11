package com.curso.clases;

import java.util.ArrayList;

public class Departamento {
	
	private int idDepartamento;
	private String nombreDepartamento;
	private ArrayList<Empleado> equipo;
	public final int maxEquipo = 2;
	private Gerente gerente; // Nos ayuda a entrar en los métodos de Gerente desde aquí, por ejemplo
							 // para la funcion validarTarea, cosa que solo puede hacer el gerente, aun siendo gerente null
	private static int idDepartamentos = 0;
	
	public Departamento(){
		idDepartamentos++;
		this.idDepartamento = idDepartamentos;
		this.nombreDepartamento = "";
		this.equipo = null;
	}
	public Departamento(String nombreDepartamento){
		idDepartamentos++;
		this.idDepartamento = idDepartamentos;
		this.nombreDepartamento = nombreDepartamento;
		this.equipo = new ArrayList<Empleado>();
	}
	
	// Métodos
	// Recibe Empleado y lo añade al equipo del dpto., si es posible
	public boolean nuevoMiembroEquipo(Empleado empleado){
		boolean exito = false;
		if ( this.equipo.size() < maxEquipo ){
			this.equipo.add(empleado);
			exito = true;
		}
		return exito;
	}
	//Recibe Equipo y Empleado, lo añade si es posible
	public ArrayList<Empleado> nuevoMiembroEquipo(ArrayList<Empleado> equipo, Empleado worker){
		if ( (worker != null) && (equipo.size() < maxEquipo) ) {
			equipo.add(worker);
		}
		return equipo;
	}
	// Validar todas las tareas del departamento con la ayuda del gerente
	public void validarDepartamento(){
		if ((this.equipo != null) && !(this.equipo.isEmpty()) ){
			this.equipo = gerente.validarTareasEquipo(equipo);
		}
	}
	// Getters y setters
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public ArrayList<Empleado> getEquipo() {
		return equipo;
	}
	public void setEquipo(ArrayList<Empleado> equipo) {
		this.equipo = equipo;
	}
	public int getMaxEquipo() {
		return maxEquipo;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
}
