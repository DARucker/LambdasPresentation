package slidesLambdas;

public class DemostracionSintaxis {

	public static void main(String[] args) {

		// + de una linea: requiere llaves y clausula return
		Sintaxis stx = (float a, float b) -> {
			int c = 3;
			return (a + b + c);
		};
		System.out.println("El resultado es: " + stx.operacion(15, 6));

		// sintaxis abreviada
		Sintaxis stx1 = (a, b) -> (a + b);
		System.out.println("El resultado es: " + stx1.operacion(3, 6));

		// cuando recibe solo 1 parametro no requiere brackets
		Sintaxis2 stx2 = a -> (a * 10);
		System.out.println("El resultado es: " + stx2.operacion2(3));
		
	}

}

@FunctionalInterface
interface Sintaxis {float operacion(float a, float b);}

@FunctionalInterface
interface Sintaxis2 {
	float operacion2 (float a);
	default public void saludo() {
		System.out.println("Fin de la demostracion");
	}
}