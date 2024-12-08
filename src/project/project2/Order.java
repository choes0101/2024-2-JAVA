package project.project2;

import java.util.*;

public class Order {
  private MenuItem menuItem; // 메뉴 항목
  private List<Option> selOptions = new ArrayList<>(); // 선택된 옵션 목록

  public MenuItem getMenuItem() {
    return menuItem; // 메뉴 항목 반환
  }

  public void setMenuItem(MenuItem menuItem) {
    this.menuItem = menuItem; // 메뉴 항목 설정
  }

  public List<Option> getSelOptions() {
    return selOptions; // 선택된 옵션 목록 반환
  }

  public void setSelOptions(List<Option> selOptions) {
    this.selOptions = selOptions; // 선택된 옵션 목록 설정
  }
}


