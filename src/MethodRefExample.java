import java.util.Arrays;
import java.util.List;

public class MethodRefExample {
  //method refernce example
  public static void main(String args[]) {
    List<String> str = Arrays.asList("a", "b", "A", "B");
    //s1 is of type ClassName(String
    //Classname::instanceMethod
    str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
    System.out.println(str);

    //Classname::staticMethod
    List<String> str2 = Arrays.asList("a", "b", "A", "B");
    str2.sort(String::compareToIgnoreCase);
    System.out.println(str2);

  }
}
