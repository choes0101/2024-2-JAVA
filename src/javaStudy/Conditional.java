package javaStudy;

import java.util.Scanner;

public class Conditional {
    void login(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String uname = scan.next();

        System.out.print("Enter your password: ");
        String pwd = scan.next();

        if(uname.equals("hong") && pwd.equals("1234")) {
            System.out.println("인증확인!! -> 로그인 성공");
        }
        else {
            System.out.println("아이디나 비밀번호가 틀렸습니다.!!");
        }
    }

    void check(){
        int cnt = 10;
        String msg = cnt > 0? "새로운 쪽지가 있습니다.!!" : "새로운 쪽지가 없습니다.!!";
        System.out.println(msg);
    }
    public static void main(String[] args) {
        Conditional con = new Conditional();

        while(true) {
            System.out.printf("# 메뉴를 선택하세요 (1:로그인, 2:쪽지 확인, x:종료) ==> ");
            Scanner scan = new Scanner(System.in);
            String sel = scan.next();

            switch (sel) {
                case "1" -> con.login();
                case "2" -> con.check();
                case "x" -> System.exit(0);
                default -> System.out.println("잘못된 입력입니다.!!");
            }
        }
    }
}
