package javaStudy.oop;

public class RobotDog extends Robot implements Pet {

  @Override
  public void bark() {
    System.out.println("멍멍");
  }

  @Override
  void charging() {
    System.out.println(getName() + "충전 스테이션으로 이동");
  }
}
