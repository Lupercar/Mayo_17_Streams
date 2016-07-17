package consola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entidades.Persona;

public class App {

	public static void main(String[] args) {
		String[] nombre = 
			{"Fabio", "Irene", "Jose Luis", "Jonathan", 
					"Manuel", "Pablo", "María", "María", "Mar"}; 
		
		List<String>  listadoNombres = Arrays.asList(nombre); 
		
//		Mostrar por pantalla los elementos no repetidos
//		que tengan más de 3 letras, ordenados alfabéticamente.
		String[] array =  listadoNombres.stream()
			.distinct()
			.filter( n -> n.length()>3) // boolean test(param)
			.sorted()
			.toArray( t -> new String[t]); 
		
		System.out.println(Arrays.toString(array));
		
//		Números de elementos
		System.out.println("Número de elementos con count: " + 
							listadoNombres.stream().count());
		
//		Números de elementos con size
		System.out.println("Número de elementos con size: " + 
							listadoNombres.size());
		
//		Convertimos las cadenas a su tamaño en entero
		int[] tamaño = listadoNombres.stream()
				.mapToInt( n -> n.length())
				.toArray();
		
		System.out.println(Arrays.toString(nombre));
		System.out.println(Arrays.toString(tamaño));
		
//		Convertimos las cadenas a su tamaño en entero
		int[] tamaño2 = listadoNombres.stream()
				.mapToInt( String :: length)
				.toArray();
		
		System.out.println(Arrays.toString(nombre));
		System.out.println(Arrays.toString(tamaño2));
		
//		max -> busca el máximo
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona("Pepito",20));
		personas.add(new Persona("Juanito",30));
		personas.add(new Persona("Manganito",18));
		
//		Obtener el nombre de la persona con más edad
		String nombre1 = personas.stream()
				.max((p1,p2) -> 
				Integer.compare(p1.getEdad(), p2.getEdad()))
				.orElse(new Persona("",0))
				.getNombre(); 
		
		System.out.println("Nombre más viejo: " + nombre1);
		
//		Mostrar los nombres de todas las personas
		String[] arrayNombres = personas.stream()
				.map(Persona :: getNombre)	//R apply(T t)
				.toArray( len -> new String[len]  ); 
		
		System.out.println("Nombres array persona: " + 
							Arrays.toString(arrayNombres));
		
//		sumatorio de las edades de las personas
		int suma = personas.stream()
				.mapToInt(Persona :: getEdad)
				.sum();
		
		System.out.println("Suma de edades " +
							suma);
		
//		Media de las edades de las personas
		double media = personas.stream()
				.mapToInt(Persona :: getEdad)
				.average()
				.getAsDouble(); 
				
		
		System.out.println("La media es " +
							media);
	}
}// fin class consola.App
