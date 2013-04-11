package com.curso.clases;

public class Tarea {
	
	private int codigo; 
	private String nombre;
	private int nivelResponsabilidad;
	private int duracion; // en minutos
	private String dificultad; // Alta, Baja, Media
	private int estado; // 0 asignada, 1 revisión, 2 realizada
	
	// Constructores
	public Tarea(){
		this.codigo = -1;
		this.nombre = "";
		this.nivelResponsabilidad = 0;
		this.duracion = 0;
		this.dificultad = "";
		this.estado = 0;
	}
	public Tarea(String nombre, int codigo, int nivelResponsabilidad, int duracion, String dificultad, int estado){
		this.codigo = codigo;
		this.nombre = nombre;
		this.nivelResponsabilidad = nivelResponsabilidad;
		this.duracion = duracion;
		this.dificultad = dificultad;
		this.estado = estado;
	}
	public void imprimir(){
		System.out.println("Nombre "+getNombre()+" Estado: "+ getEstado() );
	}
	// Getters and setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivelResponsabilidad() {
		return nivelResponsabilidad;
	}
	public void setNivelResponsabilidad(int nivelResponsabilidad) {
		this.nivelResponsabilidad = nivelResponsabilidad;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getDificultad() {
		return dificultad;
	}
	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
