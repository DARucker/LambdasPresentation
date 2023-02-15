package slidesStream;

import java.util.*;
import java.util.function.DoubleConsumer;

public class OperacionesTerminales2 {

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
        System.out.println("Utilización del método reduce acumulando mediante una multiplicación");

        OptionalDouble calculo = cities.stream()
                .filter(x -> x.getName().startsWith("B")
                        || x.getName().startsWith("M"))  // (Predicate<? super T> predicate) return Stream<T>
                .mapToDouble(x -> x.getPopulation())// mapToDouble(ToDoubleFunction<? super T> mapper) return DoubleStream
                .reduce((x, y) -> x * y);           //  reduce(BinaryOperator<T> accumulator)
                                                    // Applies the function to the given arguments.

                                                    //        int multiplicacion = 0;
                                                    //        for (int x : numbers) {
                                                    //            multiplicacion = multiplicacion * x;
                                                    //        }
        calculo.ifPresent(System.out::println);

        // 2
        System.out.println("Utilización del método reduce con identity");
        double calculo1 = cities.stream()
                .filter(x -> x.getName().startsWith("B")
                        || x.getName().startsWith("M"))  // (Predicate<? super T> predicate) return Stream<T>
                .mapToDouble(x -> x.getPopulation())     // mapToDouble(ToDoubleFunction<? super T> mapper) return DoubleStream
                .reduce(1000, (x, y) -> x * y);   //  (T identity, BinaryOperator<T> accumulator) return T
                                                         // Applies the function to the given arguments.

                                                        //        int multiplicacion = 1000;
                                                        //        for (int x : numbers) {
                                                        //            multiplicacion = multiplicacion * x;
                                                        //        }
        System.out.println(calculo1);
/*
        // 3
        System.out.println("utilizando identity, accumulator y combiner");
        double calculo2 = cities.stream()
                .filter(x -> x.getName().startsWith("B")
                        || x.getName().startsWith("M"))  // (Predicate<? super T> predicate) return Stream<T>
                .reduce(1000, (x, y) -> (int) (x + y.getPopulation()),(x1, x2) -> x1+x2);   // (U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner) return U

        //        }
        System.out.println(calculo2);
*/
    }
}
