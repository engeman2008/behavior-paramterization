package Logic;

import Interfaces.AppleFormatter;

public class ApplySimpleFormatter implements AppleFormatter {
  @Override
  public String accept(Apple apple) {
    return "Simple apple " + apple.getColor() + " weight is" + apple.getWeight();
  }
}
