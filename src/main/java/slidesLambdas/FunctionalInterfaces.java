package slidesLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FunctionalInterfaces {

	public static void main(String[] args) {
		List<String> clubs = new ArrayList<>();
		clubs.addAll(Arrays.asList("F C Barcelona", "Real Madrid", "Club Atletico Huracan", "Manchester City"));
		/*
		 * Functional interface CONSUMER: forEach(Consumer<? super T> action)
		 */
		System.out.println("\n" + "1. forEach(Consumer<? super T> action)");
		clubs.forEach(x -> System.out.println(x));
		/*
		 * Functional interface FUNCTION: map(Function<? super T,? extends R> mapper)
		 */
		System.out.println("\n" + "3. map(Function<? super T,? extends R> mapper)");
		clubs.stream().map(x -> x.toUpperCase()).forEach(System.out::println);
		/*
		 * Functional interface PREDICATE: removeIf(Predicate<? super E> filter)
		 */
		System.out.println("\n" + "2. removeIf(Predicate<? super E> filter)");
		clubs.removeIf(x -> x.equals("Real Madrid"));
		clubs.forEach(x -> System.out.println(x));
		/*
		 * Functional interface SUPPLIER: generate(Supplier<? extends T> s)
		 */
		System.out.println("\n" + "4. generate(Supplier<? extends T> s");
		Stream.generate(() -> Math.random()*10).mapToInt(x-> x.intValue()).limit(5).forEach(x -> System.out.print(x + " "));
	}
}
