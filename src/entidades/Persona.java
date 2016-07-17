package entidades;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona() {
		this("",0); 
	}
	
	public Persona(String nombre, int edad) {
		super();
		setNombre(nombre);
		setEdad(edad);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Persona [Nombre()=" + getNombre() + 
				", Edad()=" + getEdad() + 
				"]";
	}
}//fin class entidades.Persona
