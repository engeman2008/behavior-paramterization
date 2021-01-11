package Interfaces;

import Logic.Apple;

@FunctionalInterface
public interface AppleFormatter {
  String accept(Apple apple);
}
