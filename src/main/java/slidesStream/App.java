package slidesStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		streamPractice();
	}

	public static void streamPractice() {

		List<City> cities = new ArrayList<>();
		cities.add(new City("Buenos Aires", "Argentina", 2.5));
		cities.add(new City("Mendoza", "Argentina", 1.0));
		cities.add(new City("Rosario", "Argentina", 1.4));
		cities.add(new City("Cordoba", "Argentina", 1.2));
		cities.add(new City("Madrid", "Spain", 1.8));
		cities.add(new City("Valencia", "Spain", 0.9));
		cities.add(new City("Barcelona", "Spain", 1.5));
		cities.add(new City("Zaragoza", "Spain", 1));
		cities.add(new City("Girona", "Spain", 1));
		cities.add(new City("Badalona", "Spain", 1));

		// demostracion del pipeline
		System.out.println("Filtramos por nombre, ordenamos y limitamos la cantidad de respuestas");
		cities.stream()
				.filter(x -> x.getName().startsWith("B"))  // (Predicate<? super T> predicate) return Stream<T>
				.sorted(Comparator.comparing(City::getName)) // (Comparator<? super T> comparator) return Stream<T>
				.limit(2)                             // limit(long maxSize) return Stream<T>
				.forEach(x -> System.out.println(x.getName())); // forEach(Consumer<? super T> action) void (Terminal operation)

		// agregamos un peek al pipeline
		System.out.println("\n" + "Filtramos por nombre, ordenamos y limitamos la cantidad de respuestas");
		cities.stream()
				.filter(x -> x.getCountry().startsWith("A")) // (Predicate<? super T> predicate) return Stream<T>
				.peek(System.out::println) // peek(Consumer<? super T> action) return Stream<T>
				.sorted(Comparator.comparing(City::getName)) // sorted(Comparator<? super T> comparator)
				.limit(2)                             // limit(long maxSize) return Stream<T>
				.forEach(x -> System.out.println(x.getName())); // forEach(Consumer<? super T> action) void

		System.out.println("\n" + "Obtenemos un nuevo List al final del stream e imprimimos su contenido");
		List<City> spain = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("spain")) // (Predicate<? super T> predicate) return Stream<T>
				.toList();
		spain.forEach(System.out::println);

		// transformacion o mapeo de Stream a DoubleStream
		System.out.println("\n" + "Suma de los valores de un campo");
		double population = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("Argentina") && x.getName().startsWith("B"))// (Predicate<? super T> predicate) return Stream<T>
				.mapToDouble(x -> x.getPopulation())// mapToDouble(ToDoubleFunction<? super T> mapper) return DoubleStream
				.sum();                             // sum es un metodo de la interface DoubleStream return double
		System.out.println("Total population: " + population);

		// transformacion o mapeo de Stream a IntStream
		System.out.println("\n" + "Cuenta los elementos");
		long cantidad = cities.stream()
				.count();                // metodo de la interface Stream. Tambien esta presente en IntStream LongStream DoubleStream return long
		System.out.println("cantidad: " + cantidad);


		System.out.println("\n" + "Convertimos la lista de City en una de String");
		List<String> countries = cities.stream()
				.map(City::getName) 			// map(Function<? super T,? extends R> mapper) return <R> Stream<R>
				.collect(Collectors.toList());	// collect(Collector<? super T,A,R> collector) return default List<T>
		countries.forEach(System.out::println);


		// retornamos un Optional
		System.out.println("\n" + "Filtramos y devolvemos un Optional e imprimimos su valor o un mensaje si resulta vacio");
		Optional<City> city = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("argentina")) // (Predicate<? super T> predicate) return Stream<T>
				.max(Comparator.comparingDouble(City::getPopulation)); // max(Comparator<? super T> comparator) return Optional<T>
		city.ifPresentOrElse(                                          // return boolean
				x -> System.out.println(x),
				() -> System.out.println("La consulta no retorna ningun valor"));


	}

}