package slidesStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObtaningStream {

    /**
     * From a Collection via the stream() and parallelStream() methods;
     * From an array via Arrays.stream(Object[]);
     * From static factory methods on the stream classes, such as Stream.of(Object[]), IntStream.range(int, int) or Stream.iterate(Object, UnaryOperator);
     * The lines of a file can be obtained from BufferedReader.lines();
     * Streams of file paths can be obtained from methods in Files;
     * Streams of random numbers can be obtained from Random.ints();
     * Numerous other stream-bearing methods in the JDK, including BitSet.stream(), Pattern.splitAsStream(java.lang.CharSequence), and JarFile.stream().
     */

    private static List<City> cities = new ArrayList<>();
    private static String [] nombres = new String[]{"Messi", "Lionel"};


    public static void main(String args[]){

        List<String> names = new ArrayList<>(List.of("Lionel", "Messi"));
        names.stream(); // Interface Collection return Stream<E>

        String [] tenis = new String[]{"Nadal", "Federer"};
        Arrays.stream(tenis);

        Stream<String> teams = Stream.of("Barcelona", "Huracan"); // static of(T t) return <T> Stream<T>

        Stream<Double> res = Stream.generate(() -> Math.random()); // static generate (Supplier<? extends T> s) <T> Stream<T>

        IntStream character = "Barcelona".chars();

        try {
            FileReader fr = new FileReader("C:\\Users\\formacio\\Downloads\\palabras.csv");
            BufferedReader br = new BufferedReader(fr);
            Stream<String> lector = br.readLine().lines();
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
