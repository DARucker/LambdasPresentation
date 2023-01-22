package slidesStream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
	
		
		// Suma de los valores de un campo 
		double population = cities.stream()
				.mapToDouble(x -> x.getPopulation())
				.sum();
		System.out.println("Total population: " + population);
		
		//Filtro y luego sumo los valores de un campo
		double populationArg = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("Argentina"))					
				.mapToDouble(x -> x.getPopulation())
				.sum();
		System.out.println("Total population of Arg main cities: " + populationArg);
		//
		double populationSpainBeginsWithB = cities.stream()
				.filter(x -> x.getCountry().equalsIgnoreCase("Argentina") && x.getName().startsWith("B"))					
				.mapToDouble(x -> x.getPopulation())
				.sum();
		System.out.println("Total population of Spanish cities begining with B: " + populationSpainBeginsWithB);			
		
		// Filtramos por nombre, ordenamos y limitamos la cantidad de respuestas
		cities.stream()
			.filter(x -> x.getName().startsWith("B"))
			.sorted(Comparator.comparing(City::getName)) 
			.limit(2)
			.forEach(x -> System.out.println(x.getName()));
	
		long cantidad = cities.stream()
				.count();
		System.out.println("cantidad: " + cantidad);
		
	
	}

}
