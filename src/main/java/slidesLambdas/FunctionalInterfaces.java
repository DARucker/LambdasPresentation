package slidesLambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		List<String> clubs = new ArrayList<>();
		clubs.addAll(Arrays.asList("F C Barcelona", "Real Madrid", "Club Atletico Huracan", "Manchester City"));

		/*
		 * Implementamos la interfaz funcional Consumer del metodo forEach(Consumer<?
		 * super T> action) para imprimir en los elementos de la lista
		 */

		System.out.println("\n" + "1. forEach(Consumer<? super T> action)");
		clubs.forEach(x -> System.out.println(x));
		System.out.println("\n");

		/*
		 * Implementamos la interfaz funcional Predicate removeIf(Predicate<? super E>
		 * filter) para eliminar Real Madrid
		 */

		System.out.println("\n" + "2. removeIf(Predicate<? super E> filter)");
		clubs.removeIf(x -> x.equals("Real Madrid"));
		clubs.forEach(x -> System.out.println(x));

		/*
		 * Implementamos la interfaz funcional Compare del metodo sort(Comparator<? super E> c)
		 */

		System.out.println("\n" + "3. sort(Comparator<? super E> c)");

		clubs.sort((String x, String y) -> x.compareTo(y));
		clubs.forEach(x -> System.out.println(x));

	}

}
