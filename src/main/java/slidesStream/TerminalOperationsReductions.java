package slidesStream;

import java.util.*;

public class TerminalOperationsReductions {

    public static void main(String[] args) {
        streamPractice();
    }

    public static void streamPractice() {

        List<City> cities = new ArrayList<>();
        cities.add(new City("Madrid", "Spain", 3.3));
        cities.add(new City("Barcelona", "Spain", 1.6));
        cities.add(new City("Zaragoza", "Spain", 1));
        cities.add(new City("Girona", "Spain", 0.1));
        // Reduce
        System.out.println("\n" + "Total population of Spain minus the cities that begin with b or m");
        double reduction1 = cities.stream()
                .filter(x -> x.getName().startsWith("B")
                        || x.getName().startsWith("M"))  // (Predicate<? super T> predicate) return Stream<T>
                .mapToDouble(x -> x.getPopulation())     // (ToDoubleFunction<? super T> mapper) return DoubleStream
                .reduce(46, (x, y) -> x - y);     // (T identity, BinaryOperator<T> accumulator) return T
        System.out.println(reduction1);

        // Count
        System.out.println("\n" + "Counts the elements");
        long quantity = cities.stream()
                        .count();                		//  return long
        System.out.println("cantidad: " + quantity);

        // Sum
        System.out.println("\n" + "Sum the population");
        Double population = cities.stream()
                .mapToDouble(City::getPopulation)       // (ToDoubleFunction<? super T> mapper) return DoubleStream
                .sum();                		            //  this method is present only in IntStream, DoubleStream or LongStream
        System.out.println("cantidad: " + quantity);

        //
        System.out.println("\n" + "Method reduce without Identity");
        OptionalDouble calculo = cities.stream()
                .filter(x -> x.getName().startsWith("B")
                        || x.getName().startsWith("M"))  // (Predicate<? super T> predicate) return Stream<T>
                .mapToDouble(x -> x.getPopulation())// mapToDouble(ToDoubleFunction<? super T> mapper) return DoubleStream
                .reduce((x, y) -> x + y);           //  reduce(BinaryOperator<T> accumulator)
                                                    // Applies the function to the given arguments.

                                                    //        int x = 0;
                                                    //        for (int x : numbers) {
                                                    //            x = x + y;
                                                    //        }
        calculo.ifPresent(System.out::println);


    }
}
