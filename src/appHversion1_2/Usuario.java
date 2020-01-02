package appHversion1_2;
// Esta clase esta destinada a procesar, ordenar, recavar, editar, formatear etc. Toda la infromacion que pueda tener relacion con los usuarios
// Para mayor simplicidad, NO habrá una clase exclusiva para empleados y jefes. Ésta caracteristicas se decidira por un atributo del objeto de tipo boolean, el cual se tomará en cuanta a la hora de mostrar cierta informacion en la pantalla 


public class Usuario {

	private String nombredUs;
	private String numDeEmpleado;
	private String correodUs;
	private String rfcdUs;
	//private Fecha fechadIngreso;
	private float sueldodEmpleado;
	private boolean esJefe;
	
	
	
	
	
	
	
	
	public Usuario() {
 		esJefe = false;
		
	}//fin de constructor DEFAULT

	
	
	
	
	
	
	
	
	
	
	public Usuario( boolean esGfe ) { //fin de metodo constructor sobrecargado con un argumento BOOL  
		this.esJefe = esGfe;
		
	}
	
	
	
	
	
	
	
	
}//fin de clase
