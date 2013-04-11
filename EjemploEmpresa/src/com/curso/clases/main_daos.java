package com.curso.clases;

import java.util.ArrayList;

import com.curso.daos.DAOEmpleado;
import com.curso.daos.DAOEmpresa;
import com.curso.daos.DAOTarea;
import com.curso.excepciones.LimitePlantillaExcedido;

public class main_daos {

		public static void main(String[] args) {
	
			// EJEMPLO CONTROLLER EMPRESA
			
			Empresa company = new Empresa("41508045-Z","COCA-COLA","Patrocinador oficial de los JJOO",10);
			
			DAOEmpresa daoEmpresa = new DAOEmpresa();
			
			daoEmpresa.insertarEmpresa(company);
			//daoEmpresa.actualizarEmpresa(company);
			//daoEmpresa.eliminarEmpresa(company);
			
			ArrayList<Empresa> resultadoEmpresa = daoEmpresa.buscarEmpresa(company.getCif());
			
			if (!resultadoEmpresa.isEmpty()) {
				for (int i=0; i<resultadoEmpresa.size();i++){
					System.out.println("Resultados de búsqueda: "+resultadoEmpresa.size());
					System.out.println("CIF empresa - "+resultadoEmpresa.get(i).getCif());
					System.out.println("Nombre empresa - "+resultadoEmpresa.get(i).getNombre());
					System.out.println("Descripcion empresa - "+resultadoEmpresa.get(i).getDescripcion());
					System.out.println("Presupuesto anual empresa - "+resultadoEmpresa.get(i).getPresupuestoAnual());
				}	
			}
			else System.out.println("Sin resultados de búsqueda");
			
			// EJEMPLO CONTROLLER EMPLEADO
			
			Empleado employee = new Empleado(41508045,"Ramón","Formador PHP",1500,3,120);
			
			DAOEmpleado daoEmpleado = new DAOEmpleado();
			
			daoEmpleado.insertarEmpleado(employee);
			//daoEmpleado.actualizarEmpleado(employee);
			//daoEmpleado.eliminarEmpleado(employee);
			
			ArrayList<Empleado> resultadoEmpleado = daoEmpleado.buscarEmpleado(employee.getDni());
			
			if (!resultadoEmpleado.isEmpty()) {
				for (int i=0; i<resultadoEmpleado.size();i++){
					System.out.println("Resultados de búsqueda: "+resultadoEmpleado.size());
					System.out.println("DNI empleado - "+resultadoEmpleado.get(i).getDni());
					System.out.println("Nombre empleado - "+resultadoEmpleado.get(i).getNombre());
					System.out.println("Sueldo empleado - "+resultadoEmpleado.get(i).getSueldo());
					System.out.println("Categoria empleado - "+resultadoEmpleado.get(i).getCategoria());
				}	
			}
			else System.out.println("Sin resultados de búsqueda");
			
			// EJEMPLO CONTROLLER TAREA
			
			Tarea task = new Tarea("Redactar informe", 444, 2, 35, "Media", 2);
			
			DAOTarea daoTarea = new DAOTarea();
			
			daoTarea.insertarTarea(task);
			//daoTarea.actualizarTarea(task);
			//daoTarea.eliminarTarea(task);
			
			ArrayList<Tarea> resultadoTarea = daoTarea.buscarTarea(task.getCodigo());
			
			if (!resultadoTarea.isEmpty()) {
				for (int i=0; i<resultadoTarea.size();i++){
					System.out.println("Resultados de búsqueda: "+resultadoTarea.size());
					System.out.println("Código tarea - "+resultadoTarea.get(i).getCodigo());
					System.out.println("Nombre tarea - "+resultadoTarea.get(i).getNombre());
					System.out.println("Nivel responsabilidad - "+resultadoTarea.get(i).getNivelResponsabilidad());
					System.out.println("Duración - "+resultadoTarea.get(i).getDuracion()+ " minutos");
					System.out.println("Dificultad - "+resultadoTarea.get(i).getDificultad());
					
					switch (resultadoTarea.get(i).getEstado()){
						case 0 : System.out.println("Estado  - Asignada"); break;
						case 1 : System.out.println("Estado  - Pendiente revisión"); break;
						case 2 : System.out.println("Estado  - Validada"); break;
					}
				}	
			}
			else System.out.println("Sin resultados de búsqueda");
			
		}
			
	}