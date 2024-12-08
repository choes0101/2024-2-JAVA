package javaStudy.oop;

public abstract class Robot {
  private String name;

  void move() {
    System.out.println(">> 로봇 움직임 !!");
  }

  abstract void charging();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
