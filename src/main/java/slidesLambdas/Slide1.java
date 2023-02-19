package slidesLambdas;

import java.util.function.Function;

public class Slide1 {

	public static void main(String args[]) {

		/* Ejemplo 1
		 * Implementa la interfaz longitud
		 */
		Longitud l = (String s) -> s.length();
		System.out.println("la longitud de f c barcelona es " + l.longitud("f c barcelona"+ "\n"));
		/* Ejemplo 2
		 * Implementa la interfaz Mayuscula
		 */
		Mayuscula m = s1 -> s1.toUpperCase();
		System.out.println("Mayuscula " + m.mayuscula("futbol club barcelona") + "\n");
		/* Ejemplo 3
		 * Dos implementaciones de la interfaz Operation
		 */
		Operation<String, Integer> longitud2 = (String s) -> s.length();
		System.out.println("calculo la longitud de f c barcelona utilizando genericos "
				+ longitud2.operation("f c barcelona") + "\n");

		Operation<String, String> mayuscula2 = (String s) -> s.toUpperCase();
		System.out.println("Utilizando genericos devolvemos un string en mayusculas "
				+ mayuscula2.operation("club atletico huracan") + "\n");

		// 5. Idem 1 pero utilizando la interfaz Function del paquete
		// "java.util.function"
		Function<String, Integer> longitud3 = s -> s.length();
		System.out.println("Utilizamos la interfaz Function para calcular la longitud de club atletico huracan "
				+ longitud3.apply("club atletico huracan") + "\n");

		// 6. Pasamos la interfaz por parametros a un metodo
		printLength(l);

	}

	// 6. El metodo recibe por parametro la interfaz ya implementada como si fuera una funci�n.
	public static void printLength(Longitud l) {
		System.out.println("La longitud de Hola Mundo es " + l.longitud("Hola mundo") + "\n");
	}


	@FunctionalInterface
	interface Longitud { int longitud(String s);}
	@FunctionalInterface
	interface Mayuscula { String mayuscula(String s1);}
	@FunctionalInterface
	interface Operation<T, R> {	R operation(T t);}
}