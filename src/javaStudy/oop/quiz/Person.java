package javaStudy.oop.quiz;

public class Person {
  private String name;
  private CellPhone phone;


  public Person(String name, CellPhone phone) {
    this.name = name;
    this.phone = phone;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CellPhone getPhone() {
    return phone;
  }

  public void setPhone(CellPhone phone) {
    this.phone = phone;
  }

}
