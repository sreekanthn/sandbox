import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleLambda {

    public static void main (String[] args)
    {
        // simple runnable
        new Thread (() -> System.out.println("Hello")).start();

        // multi line runnable
        Runnable l = () -> { for(int k=1; k<3; k++)
            System.out.println(k);};
        new Thread (l).start();

        // File processing Lambda
        File f = new File("/Users/srnarayanan/MyCode/Java/GenericCode/src");
        String [] names = f.list( (dir, name) ->  name.endsWith(".java")); //Replaces the FilenameFilter
        System.out.println(Arrays.asList(names));

        // print using a method reference
        List<Integer> numbers = new ArrayList  (Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        numbers.stream().forEach(System.out::println);

        // print a stream of random numbers
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        //a more complex method reference
        List<String> words = new ArrayList<>(Arrays.asList("this", "is","an","amazing", "story", "told", "by", "the", "old", "woman"));
        List<String> sorted = words.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList());
        sorted.stream().forEach((str) -> System.out.print(str + " "));

        //even more !!
        List<String> words1 = new ArrayList<>(Arrays.asList("this", "is","an","amazing", "story", "told", "by", "the", "old", "woman"));
        List<String> sorted1 = words1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        sorted1.stream().forEach((str) -> System.out.print(str + " "));

        // creating other objects from collections
        List<String> namesPersons = new ArrayList<>(Arrays.asList("Bunnu, Minnu", "Tinnu"));
        namesPersons.stream().map(str -> new Person(str)).collect(Collectors.toList());

        //constructor references
        List<String> namedPersons = new ArrayList<>(Arrays.asList("Bunnu, Minnu", "Tinnu"));
        namedPersons.stream().map(Person::new).collect(Collectors.toList());

        //Optional - optional avoid null checks
        List<String> namedPersons1 = new ArrayList<>(Arrays.asList("Bunnu, Minnu", "Tinnu"));
        Optional<String> first = namedPersons1.stream().filter(name -> name.startsWith("S")).findFirst();
        System.out.println(first.orElse("There was nothing found"));

        //Predicates - filtering



    }
}

