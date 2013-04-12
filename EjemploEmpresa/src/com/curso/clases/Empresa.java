package com.curso.clases;

import java.util.ArrayList;

import com.curso.excepciones.LimitePlantillaExcedido;

public class Empresa {
	
	// Atributos
	private int idEmpresa;
	static int idEmpresas = 0;
	private String cif;
	private String nombre;
	private String descripcion;
//    private ArrayList<Empleado> plantilla;
    private int presupuestoAnual;
	public final int maxTrabajadores = 20; // máximo trabajadores en plantilla
	private static int NUMERO_EMPRESAS = 0;  // constante de clase, nos lleva el número de empresas creadas
    private ArrayList<Gerente> gerentes;
    private ArrayList<Departamento> departamento;
	
    // Constructores
    public Empresa(){
    	this.idEmpresa = ++idEmpresas;
    	this.cif = "";
    	this.nombre = "";
    	this.descripcion = "";
  //  	this.plantilla = new ArrayList<Empleado>();
    	this.presupuestoAnual = 0;
    	NUMERO_EMPRESAS++;
    	this.gerentes = new ArrayList<Gerente>();
    	this.departamento = new ArrayList<Departamento>();
    }

    public Empresa(String cif, String nombre, String descripcion, int presupuesto){
		this.idEmpresa = ++idEmpresas;
		this.cif = cif;
    	this.nombre = nombre;
    	this.descripcion = descripcion;
 //   	this.plantilla = new ArrayList<Empleado>();
    	this.presupuestoAnual = presupuesto;
    	NUMERO_EMPRESAS++;
    	this.gerentes = new ArrayList<Gerente>();
    	this.departamento = new ArrayList<Departamento>();
    }

	// Métodos
	// Recibe Empleado y lo añade al primer departamento disponible. Si no se puede incluir
	// al empleado en ningún departamento, no se agrega y lanzamos excepción de límite plantilla superado
	public boolean nuevoEmpleado(Empleado worker) throws LimitePlantillaExcedido{
		boolean resultado = false;
		
		if ( (this.departamento != null) && (worker != null) && !(departamento.isEmpty())) {		
			// Preguntamos si hay dinero..
			if ( worker.getSueldo() <= this.presupuestoAnual ){
				// Preguntamos si hay vacantes en cada departamento....
				for (int i=0; i< departamento.size(); i++){
					if ( departamento.get(i).nuevoMiembroEquipo(worker) ){
						System.out.println("Añadido");
						this.presupuestoAnual-=worker.getSueldo();
						resultado = true;
						break;
					}else{
						throw new LimitePlantillaExcedido(worker.getNombre(),3);
					}
				}
			}else {
				throw new LimitePlantillaExcedido(worker.getNombre(),2);
			}
		}
		return resultado;
	}
	// Recibe Empleado y departamento dónde insertarlo, lo añade si es posible
	public boolean nuevoEmplado(Empleado worker, Departamento departamento ){
		return departamento.nuevoMiembroEquipo(worker);
		//return false;
	}
	// Recibe Empleado y departamento dónde insertarlo, lo añade si es posible
	public Departamento nuevoEmpleado(Empleado worker, Departamento departamento ){
		departamento.nuevoMiembroEquipo(worker);
		return departamento;
	}
	// Recibe Departamento y lo añade a la empresa
	public void nuevoDepartamento(Departamento departamento){
		if ( (this.departamento != null) && (departamento!=null)){
			this.departamento.add(departamento);
		}
	}
	public void validarDepartamento(){
	// TODO
	}
	// Imprime los nombres e ids de los departamentos. 
	public void imprimirDepartamentos() {
		if ( (this.departamento != null) && !(this.departamento.isEmpty()) ) {	
			// Imprimir listado de departamentos
			System.out.println("Departamentos actuales: "+ departamento.size());
			System.out.println("-------------------0");
			for(int i=0; i<this.departamento.size();i++){
				System.out.println( "id: "+ this.departamento.get(i).getIdDepartamento()+" "+ this.departamento.get(i).getNombreDepartamento() );	
			}
		}
		else { System.out.println("** No hay departamentos **"); }
		System.out.println();		
	}	
	// Imprime todos los empleados de todos los departamentos.
	public void imprimirEmpleados(){
		if ( (this.departamento != null) && !(this.departamento.isEmpty()) ) {	
			// Imprimir listado de empleados
			//System.out.println("Departamentos actuales: "+ departamento.size());
			//System.out.println("-------------------1");
			for(int i=0; i<this.departamento.size();i++){
				System.out.println(this.departamento.get(i).getNombreDepartamento());
				imprimirEmpleados(this.departamento.get(i));
				
			/*	
				ArrayList<Empleado> equipo = (departamento.get(i)).getEquipo();
				System.out.println( "id: "+ this.departamento.get(i).getIdDepartamento()+" "+ this.departamento.get(i).getNombreDepartamento() );
					for (int j=0; j<equipo.size();j++){
						System.out.println("\t"+(j+1)+" Empleado "+ ((equipo.get(j)).getNombre())+" id: "+((equipo.get(j)).getIdEmpleado()) );
					}
			*/}
		}
		else { System.out.println("** No hay más departamentos" +
				" **"); }
		System.out.println();	
	}
	public void imprimirEmpleados(Departamento d){
		if ( (d != null) && !(d.getEquipo().isEmpty()) ) {	
			// Imprimir listado de departamentos
			System.out.println("Departamento "+ d.getNombreDepartamento());
			System.out.println("-------------------");
			for(int i=0; i<d.getEquipo().size();i++){
				System.out.println( "id: "+ d.getEquipo().get(i).getNombre()+" "+ d.getEquipo().get(i).getIdEmpleado() );	
			}
		}
		else { System.out.println("** El departamento "+d.getNombreDepartamento()+" no tiene empleados **"); }
		System.out.println();		
	}
	// Getters and setters
	public int getIdEmpresa(){
		return idEmpresa;
	}
	static int getNUMERO_EMPRESAS() {
		return NUMERO_EMPRESAS;
	}
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    public int getPresupuestoAnual() {
		return presupuestoAnual;
	}
	public void setPresupuestoAnual(int presupuestoAnual) {
		this.presupuestoAnual = presupuestoAnual;
	}

/*
 * 	public void nuevoEmpleado(Empleado nuevoEmpleado) throws LimitePlantillaExcedido {	
		if ( (this.departamento != null) && (nuevoEmpleado != null) ) {		
			// Preguntamos si hay dinero...
			if ( nuevoEmpleado.getSueldo() <= this.presupuestoAnual ){			
				// Preguntamos si hay vacantes...
				if ( this.departamento.size() < this.maxTrabajadores ) {				
					// Contratamos
					departamento.add(nuevoEmpleado);
					this.presupuestoAnual-=nuevoEmpleado.getSueldo();
				}
				else {
					throw new LimitePlantillaExcedido(nuevoEmpleado.getNombre(),1);
				}
			} 
			else {
				throw new LimitePlantillaExcedido(nuevoEmpleado.getNombre(),0); 
				}		
		}
	}
	
	public void imprimirEmpleados() {
		if ( (this.plantilla != null) && !(this.plantilla.isEmpty()) ) {	
			// Imprimir listado de empleados
			System.out.println("Plantilla actual: "+plantilla.size());
			System.out.println("-------------------");
			for(int i=0; i<this.plantilla.size();i++){
				System.out.println( this.plantilla.get(i).getNombre() );	
			}
		}
		else { System.out.println("** Plantilla actual vacía **"); }
		System.out.println();		
	}
	
	public void revisarTareasPlantilla() {
		if ( (this.plantilla != null) && !(this.plantilla.isEmpty()) ) {
			Empleado e = null;
			Tarea t = null;
			int tareasRevisadas;
			for(int i=0; i<this.plantilla.size();i++){
				System.out.println();
				e = this.plantilla.get(i);
				System.out.println("Revisión tareas empleado "+e.getNombre());
				System.out.println("------------------------------");
				tareasRevisadas = 0;
				for (int j=0; j<e.getFunciones().size();j++){
					t = e.getFunciones().get(j);
					// ¿Tarea pendiente de revisión?
					if ( t.getEstado() == 1 ){
						System.out.println("Revisando tarea "+t.getNombre()+"...");
						t.setEstado(2);
						System.out.println("Tarea revisada");
						tareasRevisadas++;
					}
				}
				System.out.println("Total tareas empleado revisadas: "+tareasRevisadas);
			}
		}
		else { System.out.println("** No hay tareas a revisar **"); }
		System.out.println();		
	}
	
	public void nuevoDepartamento(Departamento departamento){
		if ( departamento != null ){
			this.departamento.add(departamento);
		}
	}
*/
 
}
		
