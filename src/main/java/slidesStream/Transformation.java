package slidesStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Transformation {

	public static void main(String[] args) {
		streamPractice();
	}
	public static void streamPractice() {

		List<City> cities = new ArrayList<>();
		cities.add(new City("Buenos Aires", "Argentina", 3.1));
		cities.add(new City("Mendoza", "Argentina", 2.0));
		cities.add(new City("Rosario", "Argentina", 1.3));
		cities.add(new City("Cordoba", "Argentina", 1.6));
		cities.add(new City("Madrid", "Spain", 3.3));
		cities.add(new City("Valencia", "Spain", 0.8));
		cities.add(new City("Barcelona", "Spain", 1.6));
		cities.add(new City("Zaragoza", "Spain", 1));
		cities.add(new City("Girona", "Spain", 0.1));
		cities.add(new City("Badalona", "Spain", 0.2));
		//
		System.out.println("\n" + "Filter by name then apply order and limit");
		cities.stream()
				.filter(x -> x.getCountry().startsWith("A")) 			// (Predicate<? super T> predicate) return Stream<T>
				.peek(System.out::println) 								// peek(Consumer<? super T> action) return Stream<T>
				.sorted(Comparator.comparing(City::getName).reversed()) // sorted(Comparator<? super T> comparator) return Stream<T>
				.limit(2)                             			// limit(long maxSize) return Stream<T>
				.forEach(x -> System.out.println(x.getName())); 		// forEach(Consumer<? super T> action) void


		System.out.println("\n" + "Get a new List named spain");
		List<City> spain = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("spain")) // (Predicate<? super T> predicate) return Stream<T>
				.toList();
		spain.forEach(System.out::println);

		// transformation from Stream to DoubleStream
		System.out.println("\n" + "Add the values of a field");
		double population = cities.stream()
				.filter(x -> x.getCountry()
						.equalsIgnoreCase("Argentina")
						 && x.getName().startsWith("B"))			// (Predicate<? super T> predicate) return Stream<T>
				.mapToDouble(x -> x.getPopulation())				// mapToDouble(ToDoubleFunction<? super T> mapper) return DoubleStream
				.sum();                             				// sum es un metodo de la interface DoubleStream return double
		System.out.println("Total population: " + population);

		//
		System.out.println("\n" + "Transform the list of City into a list of String");
		List<String> countries = cities.stream()
				.map(City::getName) 								// map(Function<? super T,? extends R> mapper) return <R> Stream<R>
				.collect(Collectors.toList());						// collect(Collector<? super T,A,R> collector) return default List<T>
		countries.forEach(System.out::println);
	}

}