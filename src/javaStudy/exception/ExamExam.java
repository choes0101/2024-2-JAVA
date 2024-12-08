package javaStudy.exception;

public class ExamExam{
  public static void main(String[]args){
    ExceptionExam ex = new ExceptionExam();
    int[] array = new int[40];
    try {
      System.out.println(ex.get50thItem(array));
    } catch(IllegalArgumentException e) {
      e.printStackTrace();
    }
  }
}
