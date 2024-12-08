//컴퓨터공학과 202334757 조은성

import java.util.*;

public class Quiz {
  public static void main(String[] args) {
    Map<String, Map<String, Integer>> students = new HashMap<>();

    Map<String, Integer> student1 = new HashMap<>();
    student1.put("국어", 87);
    student1.put("영어", 92);
    student1.put("수학", 82);

    Map<String, Integer> student2 = new HashMap<>();
    student2.put("C++", 95);
    student2.put("소프트웨어공학", 91);
    student2.put("데이터베이스", 85);
    student2.put("자바", 80);

    Map<String, Integer> student3 = new HashMap<>();
    student3.put("경영학원론", 84);
    student3.put("통계학", 98);

    students.put("홍길동", student1);
    students.put("김철수", student2);
    students.put("이영희", student3);

    Scanner scanner = new Scanner(System.in);
    System.out.print("검색할 이름을 입력하세요: ");
    String name = scanner.next();

    Map<String, Integer> scores = students.get(name);

    for (Map.Entry<String, Integer> entry : scores.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }

    int total = 0;
    for (int score : scores.values()) {
      total += score;
    }
    System.out.printf("%s의 총점은 %d 평균은 %d 입니다!!\n", name, total, total / students.get(name).size());
  }
}