package com.curso.clases;

import com.curso.excepciones.LimitePlantillaExcedido;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	 Empresa company = new Empresa("G-58963523", "Coca-Cola","Coca-Cola Company", 100000);
	 Empresa company2 = new Empresa("otro", "Pepsi-Cola","Pepsi-Cola Company", 100001);
	 Empresa company3 = new Empresa("mas", "Casera","La Casera Company", 100001);
	 Empleado e = new Empleado(501, "Luís", "Programador", 1500, 4, 5);
	 Empleado e2 = new Empleado(502, "Pedro", "Financiero", 1500, 4, 5);
	 Empleado e3 = new Empleado(503, "Juan", "Boss", 1500, 4, 5);
	 
	 Departamento d = new Departamento("Financiero");
	 Departamento d2 = new Departamento("Desarrollo");
	 company.nuevoDepartamento(d);
	 company.nuevoDepartamento(d2);
	 
	 System.out.println(company.getIdEmpresa());
	 System.out.println(company2.getIdEmpresa());
	 // Asignamos nuevas funciones al empleado 1
	 Tarea t = new Tarea("Debug aplicación",10, 2, 35, "Media",1);
	 e.getFunciones().add(t);
	 t = new Tarea("Revisar funcionalidad", 11, 2, 35, "Alta",0);
	 e.getFunciones().add(t);
	 t = new Tarea("Redactar informe", 12, 2, 35, "Baja",1);
	 e.getFunciones().add(t);
	 
	// Asignamos nuevas funciones al empleado 2
	 t = new Tarea("Revisión presupuesto mensual", 13,2 , 35, "Media",1);
	 e2.getFunciones().add(t);
	 t = new Tarea("IVA trimestral", 14, 2, 35, "Baja",0);
	 e2.getFunciones().add(t);
	 
	 // Realizamos contratación
	 try {
		 company.nuevoEmpleado(e, d2);
		 company.nuevoEmpleado(e2);
		 company.nuevoEmpleado(e3);
		 //company.imprimirEmpleados();
		// company.nuevoEmpleado(e3);
		// company2.nuevoEmpleado(e3);
		 company3.nuevoEmpleado(e3);
		 //company.imprimirDepartamentos();
		 //company.imprimirEmpleados();
		 company.imprimirEmpleados(d);
		 company.imprimirEmpleados(d2);
	 }
	 catch (LimitePlantillaExcedido ex) {
		 System.out.println(ex.getMessage());
		 System.out.println(ex.causaError());
	 }
	 
	 // Revisamos tareas empleados
//	 company.revisarTareasPlantilla();
	e.revisarTareas();
	}
		
}
