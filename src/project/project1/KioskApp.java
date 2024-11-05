package project.project1;

import java.util.Scanner;

public class KioskApp {

    // 결제 수단 유효 여부 설정
    boolean VALID = false;
    // 선택한 메뉴와 옵션 항목을 저장
    String selMenu;
    String optionSelect = "";

    // 메뉴와 옵션 배열
    String[][] menu = {{"돈까스"}, {"일반", "왕돈까스", "치즈가루"}, {"카레라이스"}, {"보통", "맵게", "치킨", "새우", "난 추가"}};

    Scanner scan = new Scanner(System.in);

    // 프로그램의 실행 메소드
    public void run() {
        showMenu();
        System.out.print("# 메뉴를 선택하세요: ");
        int sel = scan.nextInt();

        switch (sel) {
            case 0 -> selMenu = menu[0][0];
            case 2 -> selMenu = menu[2][0];
            default -> System.out.println("주문할 수 없는 메뉴입니다.!!");
        }
        System.out.println(selMenu + "를 선택했습니다.");

        optionSelect(menu[sel+1]);

        checkOrder();

        while(!checkOut()) {
            System.out.println("\n\n>> 결제 실패!!!!");
            System.out.println(">> 결제 수단을 변경합니다.");
            VALID = true;
        }


    }

    // 메뉴 보기 메서드
    public void showMenu() {
        System.out.println("#### 메뉴 ####");
        for(int i = 0; i < menu.length; i+=2) {
            System.out.printf("[%d]%s ", i, menu[i][0]);
        }
        System.out.println("\n-------------------\n");
    }

    // 옵션 선택 메서드
    private void optionSelect(String[] options) {
        System.out.printf("%s 선택: 옵션을 선택하세요(콤마구분)!!\n", selMenu);
        for(int i = 0; i < options.length; i++) {
            System.out.printf("[%d]%s ", i, options[i]);
        }
        System.out.print("\n # 옵션 => ");
        String input = scan.next();
        for (String sel : input.split(",")) {
            optionSelect += options[Integer.parseInt(sel)] + ",";
        }
    }

    // 주문내역 확인
    private void checkOrder() {
        System.out.printf("## %s 주문 내역 확인 ##\n", selMenu);
        System.out.println("====================");
        System.out.println("선택 옵션:" + optionSelect);
    }

    // 결제 진행 메서드
    private boolean checkOut() {
        System.out.println("\n\n>>>> 결제를 진행합니다. <<<<");
        if(VALID) {
            System.out.println(">> 주문을 저장합니다.");
            System.out.println(">> 영수증을 출력합니다.");
            return true;
        } else {
            return false;
        }
    }

    // 메인
    public static void main(String[] args) {
        KioskApp app = new KioskApp();
        app.run();
    }
}