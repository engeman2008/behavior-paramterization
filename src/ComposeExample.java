import java.util.function.Function;

public class ComposeExample {
  public static void main(String args[]) {
    Function<Integer, Integer> f = x -> x + 1;
    Function<Integer, Integer> g = x -> x * 2;

    //apply f then apply g
    Function<Integer, Integer> h = f.andThen(g);
    int result = h.apply(1);

    //apply g then apply f
    Function<Integer, Integer> z = f.compose(g);
    int result2 = z.apply(1);

    System.out.println(result);
    System.out.println(result2);

    Function<String, String> addHeader = Letter::addHeader;
    Function<String, String> processString = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
    String proceesed = processString.apply("Eman wants to pray");
    System.out.println(proceesed);

  }


}

class Letter {
  public static String addHeader(String text) {
    return "Header " + text;
  }

  public static String addFooter(String text){
    return text + " Footer " ;
  }

  public static String checkSpelling(String text){
    return text.replaceAll("Eman" , "Yahya");
  }
}