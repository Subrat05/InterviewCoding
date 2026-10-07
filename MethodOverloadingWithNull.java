package InterviewCoding;

public class MethodOverloadingWithNull {

    public static void main(String[] args) {
        m1("Subrat");
        m1(null);
    }

    static void m1(CharSequence s) {
        System.out.println("CharSequence");
        System.out.println(s);
    }

    static void m1(String s){
        System.out.println("String");
        System.out.println(s);
    }
    static void m1(Object s) {
        System.out.println("Object");
        System.out.println(s);
    }

//    static void m1(Integer s) {
//        System.out.println("Integer");
//        System.out.println(s);
//    }

//    static void m1(StringBuilder s) {
//        System.out.println("StringBuilder");
//        System.out.println(s);
//    }
}

// In method overloading, Java compiler  will check, the most specific match by checking the Inheritance hierarchy, it doest not choose randomly.
// String is the subClass of the object and String implements the CharSequence.
/*
1. Why String is chosen when passing null:-
    Java uses a rule called Most Specific Match to resolve overloaded methods.
    When you pass null, it matches every object reference type (Object, CharSequence, and String).
    To choose the right one, the compiler looks at the class hierarchy:
    Object is the most generic type (the root of all classes).
    CharSequence is an interface that inherits from Object, making it more specific than Object.
    String is a concrete class that implements CharSequence, making it the most specific type in this hierarchy.
    Because String is a subtype of CharSequence, and CharSequence is a subtype of Object, the compiler picks String as the single most specific method.

2. Why Integer or StringBuilder causes a compiler error:-
    If you uncomment static void m1(Integer s) or static void m1(StringBuilder s), the compiler gets confused because the hierarchy structure breaks.
    Look at how these types relate to each other:String and Integer are completely unrelated siblings (neither inherits from the other).
    String and StringBuilder are both distinct classes that implement CharSequence, but they do not inherit from one another.
    When you call m1(null), Java tries to find the most specific method:
    It knows it should narrow things down from Object and CharSequence.
    However, it ends up with multiple specific choices at the same level (e.g., String vs. Integer OR String vs. StringBuilder).
    Since Java cannot determine whether String is more specific than Integer, the call becomes ambiguous,
    and the code will not compile.How to fix the compiler error.
    If you must keep all these overloaded methods but want to pass a null safely,
    you must explicitly cast the null to tell the compiler exactly which method you intend to call:
        m1((String) null);        // Explicitly calls the String version
        m1((Integer) null);       // Explicitly calls the Integer version
        m1((CharSequence) null);  // Explicitly calls the CharSequence version

 */
