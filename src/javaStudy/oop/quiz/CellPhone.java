package javaStudy.oop.quiz;

public class CellPhone {
  private String number;

  public CellPhone(String number) {
    this.number = number;
  }

  public void callTo(Person person) {
    System.out.println("전화걸기 " + person.getName() + getNumber());
  }
  public void receiveFrom(Person person) {
    System.out.println("전화수신 " + person.getName() + getNumber());
  }

  public String getNumber() {
    return number;
  }

}
