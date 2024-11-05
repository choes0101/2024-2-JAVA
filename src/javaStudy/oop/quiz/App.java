package javaStudy.oop.quiz;

public class App {

  public static void main(String[] args) {
    Person person2 = new Person("홍길동 ", new CellPhone("010-1234-5678"));
    Person person1 = new Person("김사랑 ", new CellPhone("010-9876-5432"));


    person1.getPhone().callTo(person2);
    person2.getPhone().receiveFrom(person1);
  }
}
