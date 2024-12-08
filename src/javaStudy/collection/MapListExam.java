package javaStudy.collection;

import java.util.*;

public class MapListExam {
  public static void main(String[] args) {
    List<Integer> s1 = Arrays.asList(95, 87, 88, 92, 96);
    List<Integer> s2 = Arrays.asList(88, 67, 96, 91, 92);
    List<Integer> s3 = Arrays.asList(94, 67, 86, 99, 91);

    Map<String, List<Integer>> students = new HashMap<>();
    students.put("홍길동", s1);
    students.put("김철수", s2);
    students.put("이영희", s3);

    Scanner scanner = new Scanner(System.in);
    System.out.print("검색할 이름을 입력하세요: ");
    String name = scanner.next();

    // 합계 구하기
    int total = students.get(name).stream().mapToInt(Integer::intValue).sum();
//            int total = 0;
//        for (int score : students.get(name)) {
//            total += score;
//        }
    System.out.printf("%s의 총점은 %d 평균은 %d 입니다!!\n", name, total, total / students.get(name).size());
  }
}
