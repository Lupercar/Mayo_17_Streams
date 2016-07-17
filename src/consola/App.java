package consola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import entidades.Persona;

public class App {

	public static void main(String[] args) {
		String[] nombre = 
			{"Fabio", "Irene", "Jose Luis", "Jonathan", 
					"Manuel", "Pablo", "Mar�a", "Mar�a", "Mar"}; 
		
		List<String>  listadoNombres = Arrays.asList(nombre); 
		
//		Mostrar por pantalla los elementos no repetidos
//		que tengan m�s de 3 letras, ordenados alfab�ticamente.
		String[] array =  listadoNombres.stream()
			.distinct()
			.filter( n -> n.length()>3) // boolean test(param)
			.sorted()
			.toArray( t -> new String[t]); 
		
		System.out.println(Arrays.toString(array));
		
//		N�meros de elementos
		System.out.println("N�mero de elementos con count: " + 
							listadoNombres.stream().count());
		
//		N�meros de elementos con size
		System.out.println("N�mero de elementos con size: " + 
							listadoNombres.size());
		
//		Convertimos las cadenas a su tama�o en entero
		int[] tama�o = listadoNombres.stream()
				.mapToInt( n -> n.length())
				.toArray();
		
		System.out.println(Arrays.toString(nombre));
		System.out.println(Arrays.toString(tama�o));
		
//		Convertimos las cadenas a su tama�o en entero
		int[] tama�o2 = listadoNombres.stream()
				.mapToInt( String :: length)
				.toArray();
		
		System.out.println(Arrays.toString(nombre));
		System.out.println(Arrays.toString(tama�o2));
		
//		max -> busca el m�ximo
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona("Pepito",20));
		personas.add(new Persona("Juanito",30));
		personas.add(new Persona("Manganito",18));
		personas.add(new Persona("Julia",18));
		personas.add(new Persona("Pepe",30));
		
//		Obtener el nombre de la persona con m�s edad
		String nombre1 = personas.stream()
				.max((p1,p2) -> 
				Integer.compare(p1.getEdad(), p2.getEdad()))
				.orElse(new Persona("",0))
				.getNombre(); 
		
		System.out.println("Nombre m�s viejo: " + nombre1);
		
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
		
//		Reduce: Generar algo a partir de la lista
//		Acumular edades de las personas
		suma = personas.stream()
				.reduce(new Persona("",0), 
							(acc,p) -> {
								acc.setEdad(acc.getEdad() + p.getEdad());
								return acc; 
							}
						)
				.getEdad();
		
		System.out.println("La suma con reduce es " + suma);
		
//		Agrupaci�n de personas por edad
		Map<Integer, List<Persona>>  mapa = personas.stream()
				.collect(Collectors.groupingBy(Persona::getEdad));
		
		System.out.println("Personas agrupadas por edad: " + mapa.toString());
		
//		Creamos dos grupos uno para mayores de 20 y otro para menores o iguales a 20
		Map<Boolean,List<Persona>> mapa2 = personas.stream()
				.collect(Collectors.partitioningBy(p -> p.getEdad()>20));
		
		System.out.println("Personas particionadas por edad: " +
				mapa2);
		
//		Obtener todos los nombres de las personas en un �nico String
		String nombresPersonas = personas.stream()
				.map(Persona :: getNombre)
				.collect(Collectors.joining("-"));
		
		System.out.println("Nombre de personas: " + 
							nombresPersonas);
	}
}// fin class consola.App
