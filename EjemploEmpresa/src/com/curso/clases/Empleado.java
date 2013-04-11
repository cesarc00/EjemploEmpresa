package com.curso.clases;

import java.util.ArrayList;

public class Empleado {
	
	private int idEmpleado;
	private static int idEmpleados = 0; 
	private int dni;
	private String nombre;
	private String puesto;
	private int sueldo;
	private int categoria;
	private ArrayList<Tarea> funciones;
	private int horasTrabajadas;

	public final int horasJornada = 480; // 8 horas
	public final int maxTareas = 5; // máximo tareas por jornada
	
	// Constructores
	public Empleado(){
		idEmpleados++;
		this.idEmpleado = idEmpleados;
		this.dni = 0;
		this.nombre = "";
		this.puesto = "";
		this.sueldo = 0;
		this.categoria = 0;
		this.funciones = new ArrayList<Tarea>();
		this.horasTrabajadas = 0;
	}
	public Empleado(int dni, String nombre, String puesto, int sueldo, int categoria, int horasTrabajadas){
		idEmpleados++;
		this.idEmpleado = idEmpleados;
		this.dni = dni;
		this.nombre = nombre;
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.categoria = categoria;
		this.funciones = new ArrayList<Tarea>();
		this.horasTrabajadas = horasTrabajadas;
	}
	public Empleado(int dni, String nombre, String puesto, int sueldo, int categoria, int horasTrabajadas, ArrayList<Tarea> funciones){
		idEmpleados++;
		this.idEmpleado = idEmpleados;
		this.dni = dni;
		this.nombre = nombre;
		this.puesto = puesto;
		this.sueldo = sueldo;
		this.categoria = categoria;
		this.funciones = funciones;
		this.horasTrabajadas = horasTrabajadas;
	}
	// Métodos
	// Recibe Tarea y, si puede realizarla, la ejecuta y la añade a su lista de Tareas
	public boolean ejecutarTarea(Tarea tarea) {
		boolean exito = false;	
		if ( ( this.funciones != null ) && ( tarea != null ) ) {	
			if ( (tarea.getNivelResponsabilidad() <= this.categoria)
				&& (this.funciones.size() < this.maxTareas)
				&& (this.horasTrabajadas <= this.horasJornada) ){			
				tarea.setEstado(1);
				this.funciones.add(tarea);
				this.horasTrabajadas -= tarea.getDuracion();
				exito = true;				
			}	
		}		
		// devuelve informe		
		return exito;
	}
	// Revisa si alguna de sus tareas ha sido validada para quitarla de la lista
	public void actualizarTareas() {
		if ( this.funciones != null ) {	
			ArrayList<Tarea> funcionesUpdated = new ArrayList<Tarea>();
			for (int i=0; i<this.funciones.size();i++){
				// ¿Tarea validada?
				if ( this.funciones.get(i).getEstado() != 2 ){
					//this.funciones.remove(i);
					funcionesUpdated.add( this.funciones.get(i) );
				}
			}
			// Actualizar lista tareas
			this.funciones = funcionesUpdated;
		}		
	}
	// Revisa si hay nuevas tareas asignadas y las ejecuta
	public void revisarTareas(){
		if ( funciones != null){
			if (funciones.size() > 0){
				for (int i=0; i<funciones.size();i++){
					System.out.print("Revisando tarea "+i+" ");
					(funciones.get(i)).imprimir();
					if ( this.funciones.get(i).getEstado() == 0 ){
						System.out.println("Ejecutando tarea "+this.funciones.get(i).getNombre());
						this.funciones.get(i).setEstado(1);
					}
				}
			}else{
				System.out.println("No hay tareas nuevas");
			}
		}
	}
	public void estadoTareas(){
		if ( funciones != null){
			if (funciones.size() > 0){
				for (int i=0; i<funciones.size();i++){
					System.out.print("Tarea "+i+" ");
					(funciones.get(i)).imprimir();
				}
			}else{
				System.out.println("No hay tareas");
			}
		}
	}
	// Getters and setters
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public int getSueldo() {
		return sueldo;
	}
	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}; 
	public ArrayList<Tarea> getFunciones() {
		return funciones;
	}
	public void setFunciones(ArrayList<Tarea> funciones) {
		this.funciones = funciones;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	public void setHorasTrabajadas(int horasTrabajdadas) {
		this.horasTrabajadas = horasTrabajdadas;
	}
}
