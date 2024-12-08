package javaStudy.basic;


import java.util.Arrays;

public class Test {
  public static void main(String[] args) {
    String[] scores = {"95","3","6","7"};
    scores[2] = "90";

    System.out.println(Arrays.toString(scores));
  }
}