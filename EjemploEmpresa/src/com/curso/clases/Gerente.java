package com.curso.clases;

import java.util.ArrayList;

public class Gerente extends Empleado{
	
	private int antiguedad;
//	private ArrayList<Empleado> equipo;

	//Contructores
	public Gerente(){
		super();
		this.antiguedad = 0;
	//	gerente = null;
	//	equipo = null;
	}
	public Gerente(int dni, String nombre, String puesto, int sueldo, int categoria, int horasTrabajadas, int antiguedad){
		super(dni, nombre, puesto, sueldo, categoria, horasTrabajadas);
	//	this.gerente = gerente;
		this.antiguedad = antiguedad;
	//	equipo = new ArrayList<Empleado>();
	}
	
	//Metodos
	// Recibe Tarea para validación
	public Tarea validarTarea(Tarea t){
		if ( t != null ){
			if ( t.getEstado() == 1){
				t.setEstado(2);
			}
		}
		return t;
	} 
	// Recibe listado de Tareas para validación
	public ArrayList<Tarea> validarTarea(ArrayList<Tarea> lista){
		if ( !(lista.isEmpty()) ){
			for (int i=0; i< lista.size();i++){
				validarTarea(lista.get(i));
			}
		}		
		return lista;
	}
	// Recibe empleado para validar sus tareas 
	public Empleado validarTarea(Empleado e){
		if ( (e != null) && !(e.getFunciones().isEmpty())){
			validarTarea(e.getFunciones());
		}
		return e;
	}
	// Recibe listado de empleados para revisar y validar las tareas de todos ellos
	// Recibe listado de Tareas para validación
	public ArrayList<Empleado> validarTareasEquipo(ArrayList<Empleado> equipo){
		if ( (equipo != null) && !(equipo.isEmpty()) ){
			for (int i=0;i<equipo.size();i++){
				validarTarea( ( (equipo).get(i)).getFunciones() );
			}
		}
		return equipo;
	}
	
	//Getters y setters

/*	public ArrayList<Empleado> getEquipo() {
		return equipo;
	}
	public void setEquipo(ArrayList<Empleado> equipo) {
		this.equipo = equipo;
	}*/
	public int getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
/*	public void nuevoEmpleadoEquipo(Empleado e){
	if ( (this.equipo.size() < 10) && (e != null) ){
		this.equipo.add(e);
	}
}*/
/*	public void nuevoEmpleadoEquipo(Empleado e, ArrayList<Empleado> grupo){
	if ( (grupo.size() < 10) && (e != null) ){
		grupo.add(e);
	}
}*/
	/*	public Empleado asignarTarea(Tarea t, Empleado e){
	//	boolean asigna = false;
		if ( (t != null) && (e != null) ){
			//e.añadirTarea(e.getFunciones(), t); --> con metodo nuevo
		/*	ArrayList<Tarea> temporal = e.getFunciones();
			temporal.add(t);
			e.setFunciones( temporal );// --> Con set
	//		asigna = e.ejecutarTarea(t);
			if ( e.ejecutarTarea(t) ){
				System.out.println("Tarea asignada con éxito");
			}
			else{
				System.out.println("No se pudo asignar la tarea");
			}
		}
		return e;
	}*/

/*	// Asigna una tarea al primer miembro del equipo disponible, devuelve true si lo consigue, false si no.
	public boolean asignarTarea(Tarea t){
		boolean resultado = false;
		if ( this.equipo.size() > 0 ){
			for (int i=0;i<this.equipo.size();i++){
				if ( (this.equipo.get(i)).ejecutarTarea(t))  {
					resultado = true;
					break;
				}
			}
		}
		return resultado;
	}
	// Comprueba la tarea y la pone como revisada (2) si está realizada (1)
	public Tarea validarTarea(Tarea t){
		if ( t != null ){
			if ( t.getEstado() == 1){
				t.setEstado(2);
			}
		}
		return t;
	} */
}
