// 202334757 컴퓨터공학전 조은성
package javaStudy.exception;

import java.util.Optional;

public class OptionalExam {
  public void test1(Optional<String> name) {
    System.out.print("optionalTest1(): ");
    System.out.println(name.orElse("변환불가-이름이 없습니다.").toUpperCase());
  }

  public void test2(String name) {
    System.out.print("optionalTest2(): ");
    System.out.println(name.toUpperCase());
  }

  public static void main(String[] args) {
    OptionalExam optionalExam = new OptionalExam();

    Optional<String> name = Optional.ofNullable(null);
    optionalExam.test1(name);
    optionalExam.test2(name.orElse("--"));
  }
}