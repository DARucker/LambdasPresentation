package slidesLambdas;

public class EjemploCalculos {

	public static void main(String[] args) {
		
		operacionesMatematicas();
	
	}
	
	public static void operacionesMatematicas() {
	Operacion suma = (a,b) -> a + b;
	utilizacionOperaciones(suma);

	Operacion multiplicacion = (a,b) -> a * b;
	utilizacionOperaciones(multiplicacion);

	Operacion resta = (a,b) -> a - b;
	utilizacionOperaciones(resta);
	
	Operacion division = (a,b) -> a / b;
	utilizacionOperaciones(division);
	
	}

	public static void utilizacionOperaciones(Operacion op) {
		System.out.println("El resultado es: " + op.operacion(10, 20));
	}	
}

@FunctionalInterface
interface Operacion{
	float operacion(float a, float b);
}
