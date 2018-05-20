import java.lang.reflect.Array;
import java.text.CollationElementIterator;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Example of Predicate usage for filtering
// Note that the varargs parameter should be the last one in the list


public class UtilityClass {

    public String filterStringsOfSpecificLength (int length, String... strings)
    {
        return Arrays.stream(strings).filter(string -> string.length() == length).collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        UtilityClass u = new UtilityClass();
        String s = u.filterStringsOfSpecificLength(5, "hhshhs", "egjejgej", "yyyuu", "hhhuu", "lskksjjsh", "hsghs");
        System.out.println(s);

        //stream of operator - generates a stream from the given values
        String names = Stream.of("hhshhs", "egjejgej", "yyyuu", "hhhuu", "lskksjjsh", "hsghs").collect(Collectors.joining(", "));
        System.out.println( names);

        //Stream generaton
        Stream.generate(Math::random).limit(15).forEach(System.out::println);

        //Autoboxing on streams
        List< Integer > ints = IntStream.of( 3, 1, 4, 1, 5, 9).boxed().collect(Collectors.toList());
        ints.stream().forEach(System.out::println);

        //Reduction on streams - map-filter-reduce
        int value = IntStream.rangeClosed(10,25).map(i -> i+20).reduce((x,y) -> x+y).orElse(0);
        System.out.println(value);


        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random).limit(100).summaryStatistics();
        System.out.println(stats);

        // find the first Even
        Optional<Integer> firstEven = Stream.of(1,3,5,7,9,3,5,6,7,9,10).filter(n->n%2==0).findFirst();
        System.out.println(firstEven);

        Optional<Integer> firstEvenGt10 = Stream.of(1,3,5,7,9,3,5,6,7,9,10,11,13,15,57,34,22,33,22,2).filter(n->n > 10).filter(n->n%2==0).findFirst();
        System.out.println(firstEvenGt10);


    }


}
