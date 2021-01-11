package Logic;

import Interfaces.AppleFormatter;

public class ApplyFancyFormatter implements AppleFormatter {
  @Override
  public String accept(Apple apple) {
    return "Fancy apple " + apple.getColor();
  }
}
