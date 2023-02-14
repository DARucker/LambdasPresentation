package slidesLambdas;

import java.util.function.Function;

public class Slide1 {

	public static void main(String args[]) {

		// 1. contamos las letras de un string
		Longitud l = (String s) -> s.length();
		System.out.println("la longitud de futbol club barcelona es " + l.longitud("futbol club barcelona"+ "\n"));
/*
		// 2. pasamos a mayusculas los caracteres del String
		Mayuscula m = s1 -> s1.toUpperCase();
		System.out.println("Mayuscula " + m.mayuscula("futbol club barcelona") + "\n");
/*
		// 3. Idem 1, pero utilizando genericos en la @FunctionalInterface
		Operation<String, Integer> longitud2 = (String s) -> s.length();
		System.out.println("calculo la longitud de f c barcelona utilizando genericos "
				+ longitud2.operation("f c barcelona") + "\n");
/*
		// 4. Idem 2, pero utilizando genericos en la @FunctionalInterface
		Operation<String, String> mayuscula2 = (String s) -> s.toUpperCase();
		System.out.println("Utilizando genericos devolvemos un string en mayusculas "
				+ mayuscula2.operation("club atletico huracan") + "\n");
/*
		// 5. Idem 1 pero utilizando la interfaz Function del paquete
		// "java.util.function"
		Function<String, Integer> longitud3 = s -> s.length();
		System.out.println("Utilizamos la interfaz Function para calcular la longitud de club atletico huracan "
				+ longitud3.apply("club atletico huracan") + "\n");
/*
		// 6. Pasamos la interfaz por parametros a un metodo
		printLength(l);
*/
	}
/*
	// 6. El metodo recibe por parametro la interfaz ya implementada como si fuera una funci�n.
	public static void printLength(Longitud l) {
		System.out.println("La longitud de Hola Mundo es " + l.longitud("Hola mundo") + "\n");
	}*/


	@FunctionalInterface
	interface Longitud {
		int longitud(String s);
	}

	interface Mayuscula {
		String mayuscula(String s1);
	}

	@FunctionalInterface
	interface Operation<T, R> {
		R operation(T t);
	}
}