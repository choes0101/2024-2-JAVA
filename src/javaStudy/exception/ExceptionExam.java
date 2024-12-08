package javaStudy.exception;

public class ExceptionExam{
  public int get50thItem(int []array) throws IllegalArgumentException {
    if(array.length < 50){
      throw new IllegalArgumentException("예외");
    }
    return  array[49];
  }
}