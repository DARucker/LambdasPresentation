package slidesStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OperacionesTerminalesDeConsulta {

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


        // 1
        System.out.println();

        boolean barcelona = cities.stream()
                .anyMatch(x -> x.getName().equalsIgnoreCase("barcelona"));   // (Predicate<? super T> predicate) return boolean.
                System.out.println(barcelona);
        // otros metodos similares  allMatch(), noneMatch()

        // 2
        System.out.println();

        Optional<City> spain = cities.stream()
                .filter(x -> x.getCountry().equalsIgnoreCase("spain"))       // (Predicate<? super T> predicate)
                .findAny();                                                             //  return Optional.

        spain.ifPresentOrElse(
                x -> System.out.println(x),
                () -> System.out.println("La consulta no retorna ningun valor"));



    }
}
