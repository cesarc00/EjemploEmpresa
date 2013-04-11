package com.curso.excepciones;

public class LimitePlantillaExcedido extends Exception {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int causaError;
	
	// Constructores
	public LimitePlantillaExcedido() {
		 super("No es posible añadir más empleados");
	}
	
	public LimitePlantillaExcedido(String nombre, int error) {
		 super("No es posible añadir el empleado: " + nombre);
		 causaError = error;
	}

	// Métodos
	public String causaError(){
		String error = null;
		switch (this.causaError){
			case 0: {error = "Límite de plantilla superado"; break;}
			case 1: {error = "Presupuesto agotado"; break;	}	
			case 2: {error = "Departamento nula"; break;}
			case 3: {error = "No hay departamentos disponibles"; break;}
		}
		return error; 
	}

}



