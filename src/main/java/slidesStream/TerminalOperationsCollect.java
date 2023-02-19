package slidesStream;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperationsCollect {

    public static void main(String[] args) {
        streamPractice();
    }
    public static void streamPractice() {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Buenos Aires", "Argentina", 3.1));
        cities.add(new City("Mendoza", "Argentina", 2.0));
        cities.add(new City("Mendoza", "Argentina", 2.0)); // repeated
        cities.add(new City("Rosario", "Argentina", 1.3));
        cities.add(new City("Rosario", "Argentina", 1.3));// repeated
        cities.add(new City("Cordoba", "Argentina", 1.6));
        cities.add(new City("Madrid", "Spain", 3.3));
        cities.add(new City("Valencia", "Spain", 0.8));
        cities.add(new City("Barcelona", "Spain", 1.6));
        cities.add(new City("Zaragoza", "Spain", 1));
        cities.add(new City("Girona", "Spain", 0.1));
        cities.add(new City("Badalona", "Spain", 0.2));

        // To List
        List<City> result = cities.stream()
                .filter(x -> x.getCountry()
                        .equalsIgnoreCase("Argentina"))
                        .collect(Collectors.toList());                      // method collect: (Collector<? super T,A,R> collector)
                                                                            // method toList(): static method return <T> Collector<T,?,List<T>>
                                                                            // accumulates input elements into a mutable result container,
                                                                            // such as a Collection
        System.out.println("\n" + "Print a List<>()");
        result.forEach(System.out::println);

        // To Collection
        Set<City> result1 = cities.stream().filter(x -> x.getCountry()
                        .equalsIgnoreCase("argentina"))                             // toCollection(Supplier<C> collectionFactory)
                .collect(Collectors.<City, TreeSet<City>>toCollection(() -> new TreeSet<>())); // Returns a Collector that accumulates the input
                                                                                               // elements into a new Collection, in encounter order.
        System.out.println("\n" + "Print a TreeSet<>()");
        result1.forEach(System.out::println);
        // To Map
        Map<String, City> result2 = result1.stream().filter(x -> x.getCountry()
                        .equalsIgnoreCase("argentina"))
                .collect(Collectors.toMap(City::getName, City -> City));            //toMap(Function<? super T,? extends K> keyMapper,
        System.out.println("\n" + "Print a Map<>()");                               // Function<? super T,? extends U> valueMapper)
        System.out.println(result2 + "\n");
        // Joinning
        String result3 = cities.stream()
                .map(x -> {
                    StringBuilder sb = new StringBuilder();
                    String y;
                    sb.append(x.getCountry());
                    sb.append(",");
                    sb.append(x.getName());
                    y = sb.toString();
                    return y;
                })
                .distinct()
                .collect(Collectors.joining(";" +"\n"));                // Returns a Collector that concatenates the input
                System.out.println("\n" + "Print an example of joining()");     // elements into a String, in encounter order.
                System.out.println(result3);
        // Grouping
        Map<String, List<City>> result4 = cities.stream()
                .collect(Collectors.groupingBy(x -> x.getCountry()));               // groupingBy(Function<? super T,? extends K> classifier)
                System.out.println("\n" + "Print an example of groupingBy()");
                System.out.println(result4);
        // Grouping + Mapping + Joining
        Map<String, String> result5 = cities.stream()
                .collect(Collectors.groupingBy(x -> x.getCountry(),                 // mapping(Function<? super T,? extends U> mapper,
                            Collectors.mapping(City -> City.getName(),              // Collector<? super U,A,R> downstream)
                            Collectors.joining(";" +"\n"))));
        System.out.println("\n" + "Print an example of groupingBy() mapping() + joining()");
        System.out.println(result5);
    }
}
