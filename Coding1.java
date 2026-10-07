package InterviewCoding;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Coding1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java","","Stream","","Lambda", "Filter");

        Predicate<String> nonEmpty = String::isEmpty; //A Predicate is a functional interface in Java that takes an input and returns a boolean (true or false).
        long count = words.stream().filter(nonEmpty.negate()).count();
        System.out.println(count);
        //words.stream(): Converts the list into a sequence of elements so you can process them one by one.
        //.filter(nonEmpty.negate()): This goes through the stream and keeps only the elements that match the condition.
        // Because we used .negate(), it flips the original condition, meaning it will now filter for strings that are not empty.
        // count(): A terminal operation that counts how many items made it through the filter. Since the two empty strings were filtered out, 4 items remain.

        //The negate() Method
        //The negate() method is a default method built into Java's java.util.function.Predicate interface.

        //Its job is simple: it returns a new Predicate that is the logical opposite of the original Predicate.
        //If your original predicate evaluates to true for a specific input, the negated predicate will evaluate to false for that same input, and vice versa.
        // It is the functional programming equivalent of putting a NOT operator (!) in front of a boolean expression.
        //Why use it?
        //You might wonder why you wouldn't just write s -> !s.isEmpty() directly inside the filter.
        //While you absolutely can do that, negate() is designed to make your code more readable and modular.
        // If you have a complex condition saved as a Predicate somewhere else in your application,
        // negate() allows you to reuse that exact logic in reverse without having to rewrite or copy the underlying code.
        // If you already have this defined elsewhere:
        //Predicate<User> isBanned = user -> user.getStatus().equals("BANNED");

        // You can easily reuse it in reverse:
        /* List<User> activeUsers = allUsers.stream()
                .filter(isBanned.negate())
                .collect(Collectors.toList());
                /*

         */



        Predicate<String> nullCheck = arg -> arg !=null;
        Predicate<String> emptyCheck = arg -> arg.length() > 0;
        Predicate<String>  nullAndEmptyCheck = nullCheck.and(emptyCheck);
        System.out.println(nullAndEmptyCheck.test(null));  // false
        System.out.println(nullAndEmptyCheck.test("learnJava")); // true

        // The and() Method: chains two predicates together. it only returns true if both the original predicate and the chained predicate evaluate to true.

        // Let's say you want to find words that start with "J" and are exactly 4 letters long:

        List<String> examples = Arrays.asList("Java", "JavaScript", "Jump", "Jet", "Joy");

        Predicate<String> startsWithJ = s -> s.startsWith("J");
        Predicate<String> isFourLetters = s -> s.length() == 4;

        // Combine them using .and()
        List<String> result = examples.stream()
                .filter(startsWithJ.and(isFourLetters))
                .toList(); // Note: .toList() is available in Java 16+

        System.out.println(result); // Prints: [Java, Jump]

        // The or() Method: The or() method returns true if at least one of the predicates evaluates to true.
        // If we want to find words that are either very short (under 4 letters) or start with "Java":

        Predicate<String> underFourLetters = s -> s.length() < 4;
        Predicate<String> startWithJava = s -> s.startsWith("Java");

        List<String> rs = examples.stream().filter(underFourLetters.or(startWithJava)).toList();
        System.out.println(rs);


        // Chaining Multiple Conditions
        //You can chain as many of these as you need, and you can mix them with negate(). They evaluate from left to right.
        //Imagine an e-commerce scenario where you want to filter products:
        /*
        Predicate<Product> inStock = Product::isInStock;
        Predicate<Product> highlyRated = p -> p.getRating() > 4.0;
        Predicate<Product> onSale = Product::isDiscounted;
        // "Show me products that are in stock AND (highly rated OR on sale)"
        Predicate<Product> recommended = inStock.and(highlyRated.or(onSale));
        List<Product> recommendedProducts = allProducts.stream()
                .filter(recommended)
                .toList();
         */

        // Why not just write one big Lambda?
        // You could easily write .filter(p -> p.isInStock() && (p.getRating() > 4.0 || p.isDiscounted())).
        // However, breaking them into separate Predicate variables makes your code modular.
        // You can define these conditions once in a utility class and reuse them across your entire application, making your code easier to test and maintain.


    }
}
