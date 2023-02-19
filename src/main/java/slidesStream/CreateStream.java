package slidesStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {

    private static List<City> cities = new ArrayList<>();
    private static String [] nombres = new String[]{"Messi", "Lionel"};


    public static void main(String args[]){

        List<String> names = new ArrayList<>(List.of("Lionel", "Messi"));
        names.stream();                                                     // from Interface Collection return Stream<E>

        String [] tenis = new String[]{"Nadal", "Federer"};
        Arrays.stream(tenis);                                               // static stream(T[] array) return <T> Stream<T>

        Stream<String> teams = Stream.of("Barcelona", "Huracan");   // static of(T t) return <T> Stream<T>

        Stream<Double> res = Stream.generate(() -> Math.random());          // static generate (Supplier<? extends T> s) <T> Stream<T>

        IntStream character = "Barcelona".chars();                          // from Class String return IntStream

        try {
            FileReader fr = new FileReader("C:\\Users\\Downloads\\example.csv");
            BufferedReader br = new BufferedReader(fr);
            Stream<String> lector = br.readLine().lines();                  // from Class BufferedReader return Stream<String>
        }catch (Exception e){e.printStackTrace();}
    }


}
