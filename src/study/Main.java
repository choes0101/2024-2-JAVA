package study;

class MathUtils {
  public static int add(int a, int b) {
    return a + b;
  }
}

// 사용 예시
public class Main {
  public int add(int a, int b, int c) {
    return a + b + c;
  }
  public static void main(String[] args) {
    int result = MathUtils.add(5, 10); // 인스턴스 없이 호출
    System.out.println(result); // 15
  }
}