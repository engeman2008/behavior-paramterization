import Logic.Apple;
import Logic.AppleFormatter;
import Logic.ApplyFancyFormatter;
import Logic.ApplySimpleFormatter;
import Logic.Color;
import Logic.Predicate;

import java.util.ArrayList;
import java.util.List;

public class Hello {
  public static void main(String args[]){
    //this is an example of behavior parameterization
    List<Apple> inventory = new ArrayList<>();
    inventory.add(new Apple(150, Color.RED.name()));
    inventory.add(new Apple(200, Color.Green.name()));
    inventory.add(new Apple(90, Color.YELLOW.name()));
    prettyPrintApple(inventory,new ApplySimpleFormatter());
    prettyPrintApple(inventory,new ApplyFancyFormatter());

    //use anonymous class
    prettyPrintApple(inventory, new AppleFormatter() {
      @Override
      public String accept(Apple apple) {
        return "anonymous apple " + apple.getWeight();
      }
    });

    List<Apple> redApples = filter(inventory,(Apple apple) -> Color.RED.name().equals(apple.getColor()));

    //use lambda expression
    prettyPrintApple(redApples, (Apple apple) -> "lambda Apple " + apple.getColor());

    List<Integer> numbers = List.of(1,2,3,4,5,6);
    List<Integer> evenNumbers = filter(numbers, (Integer i) -> i%2 == 0);
    System.out.println(evenNumbers);

  }

  public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
    for(Apple apple: inventory){
      String output = formatter.accept(apple);
      System.out.println(output);
    }
  }

  //abstraction over list type
  public static <T> List<T> filter(List<T> list, Predicate<T> p){
    List<T> result = new ArrayList<>();
    for(T t: list){
      if(p.test(t))
      {
        result.add(t);
      }
    }
    return result;
  }
}

