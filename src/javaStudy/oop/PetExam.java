package javaStudy.oop;

public class PetExam {

  public static void main(String[] args) {
    Pet p = new Cat();
    p.bark();
    RobotDog rd = new RobotDog();
    rd.setName("테슬라멍멍이");
    rd.move();
    rd.charging();
  }
}
