import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface StringProcessor {
    String process(String str);
}

public class LambdaSortingExample {
    public static void main(String[] args) {
        
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("grape");
        words.add("cherry");

        
        words.sort((s1, s2) -> s2.compareTo(s1));

        System.out.println("Sorted list in reverse alphabetical order:");
        System.out.println(words);

        
        StringProcessor processor = String::toUpperCase;

        System.out.println("\nList in uppercase:");
        words.forEach(word -> System.out.println(processor.process(word)));
    }
}
