import Logic.Apple;
import Logic.AppleFormatter;
import Logic.ApplyFancyFormatter;
import Logic.ApplySimpleFormatter;
import Logic.Color;

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

    //use lambda expression
    prettyPrintApple(inventory, (Apple apple) -> "lambda Apple " + apple.getColor());
  }

  public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter){
    for(Apple apple: inventory){
      String output = formatter.accept(apple);
      System.out.println(output);
    }
  }
}

