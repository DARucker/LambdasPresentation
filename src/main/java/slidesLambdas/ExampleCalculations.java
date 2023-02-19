package slidesLambdas;

public class ExampleCalculations {

	public static void main(String[] args) {mathOperations();}

	public static void mathOperations() {
		Operation add = (a, b) -> a + b;
		Operation multiplication = (a, b) -> a * b;
		Operation subtraction = (a, b) -> a - b;
		Operation division = (a, b) -> a / b;
		operationUsage(add, 10, 20);
		operationUsage(multiplication, 10,20);
		operationUsage(subtraction, 10, 20);
		operationUsage(division, 10, 20);
	}
	public static void operationUsage(Operation op, float a, float b) {
		System.out.println("The result is: " + op.operacion(a, b));
	}
	@FunctionalInterface
	interface Operation { float operacion(float a, float b);}}
