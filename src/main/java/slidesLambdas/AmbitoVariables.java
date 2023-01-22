package slidesLambdas;

public class AmbitoVariables {

	static float e; 
	static float f = 1;
	
	public static void main(String[] args) {

		ambitoDeLasVariables();

	}
	
	public static void ambitoDeLasVariables() {
		float c; // solo admite variables locales cuando son finales
		final int d = 3;
		
		Ambito ambito = (a,b) -> (e = a + b + d + f);
		System.out.println(ambito.operacion(10, 20));
		System.out.println("imprimo solo la variable de clase " + e); 
		
		/*
		 * Local variable c defined in an enclosing scope must be final or effectively final
		 */
		
		//Ambito ambito1 = (a,b) -> (c = a + b + d);
		//System.out.println(ambito.operacion(10, 20));
	}
}

@FunctionalInterface
interface Ambito{
	float operacion(float a, float b);
}
