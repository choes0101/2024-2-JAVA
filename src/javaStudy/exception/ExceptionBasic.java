package javaStudy.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionBasic {
  public void methodA(String filename) throws FileNotFoundException {
    if (filename == null) {
      throw new FileNotFoundException("테스트 파일 없음!!");
    }
    System.out.println("파일명: " + filename);
  }

  public void methodB() throws IOException {
    throw new IOException("입출력 예외 발생!!");
  }

  public static void main(String[] args) {
    ExceptionBasic eb = new ExceptionBasic();
    try {
      eb.methodA("test.txt");
      eb.methodB();
      System.out.println("예외로 실행되지 않음!!");
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      System.out.println("finally 블록 실행");
    }
    System.out.println("프로그램 종료!!");
  }
}
