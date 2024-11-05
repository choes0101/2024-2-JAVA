// 컴퓨터공학과 202334757 조은성
import java.util.Scanner;

public class MidExam {
  String[][] courses = {
      {"컴퓨터공학개론", "C언어", "JAVA", "자료구조", "컴퓨터구조"}, // 전공 강의
      {"가천리더십", "글로벌 시민 교육", "창의적 사고", "논리적 사고", "창의 엔트리"}  // 교양 강의
  };

  String[] enrolledCourses = new String[10]; //수강 신청 배열
  String[] temporaryEnrollment = new String[10]; // 예비 신청 배열
  int tempCount = 0; // 현재 예비 신청 수
  int enrolledCount = 0; // 현재 수강 신청 수

  Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    MidExam system = new MidExam();
    system.run();
  }
  // 실행 메서드
  public void run() {
    int option;
    do {
      System.out.println("1. 개설 강의 조회");
      System.out.println("2. 예비 수강 신청");
      System.out.println("3. 예비 수강 내역 조회");
      System.out.println("4. 예비 수강 취소");
      System.out.println("5. 수강 신청");
      System.out.println("6. 수강 내역 조회");
      System.out.println("7. 수강 취소");
      System.out.println("8. 종료");
      System.out.print("옵션을 선택하세요: ");
      option = scan.nextInt();
      scan.nextLine();

      switch (option) {
        case 1:
          searchAvailableCourses();
          break;
        case 2:
          tempEnrollment();
          break;
        case 3:
          viewTemporaryEnrollments();
          System.out.println("======================");
          break;
        case 4:
          cancelTemporaryEnrollment();
          break;
        case 5:
          registerCourse();
          break;
        case 6:
          viewEnrolledCourses();
          System.out.println("======================");
          break;
        case 7:
          cancelEnrolledCourse();
          break;
        case 8:
          System.out.println("프로그램을 종료합니다.");
          break;
        default:
          System.out.println("잘못된 옵션입니다. 다시 시도하세요.");
      }
    } while (option != 8);
    scan.close();
  }

  // 개설 강의 조회
  private void searchAvailableCourses() {
    System.out.println("=== 개설 강의 목록 ===");
    System.out.println("1. 전공 강의");
    for (String course : courses[0]) { // 전공 강의 조회
      System.out.println(course);
    }
    System.out.println("2. 교양 강의");
    for (String course : courses[1]) { // 교양 강의 조회
      System.out.println(course);
    }
    System.out.println("======================");
  }

  // 예비 수강 신청
  private void tempEnrollment() {
    System.out.println("수강 신청할 강의 종류를 선택하세요:");
    System.out.println("1. 전공 강의");
    System.out.println("2. 교양 강의");
    System.out.print("선택: ");
    int choice = scan.nextInt();
    scan.nextLine();

    String[] selectedCourses = (choice == 1) ? courses[0] : courses[1];

    if (choice < 1 || choice > 2) {
      System.out.println("잘못된 입력입니다.");
      return;
    }

    System.out.println("개설된 강의:");
    for (int i = 0; i < selectedCourses.length; i++) {
      System.out.println((i + 1) + ". " + selectedCourses[i]);
    }

    System.out.print("신청할 강의 번호를 입력하세요 (쉼표로 구분): ");
    String input = scan.nextLine();
    String[] courseNumbers = input.split(",");

    for (String number : courseNumbers) {
      int courseNumber = Integer.parseInt(number);

      // 중복 신청 체크
      boolean alreadyEnrolled = false;
      for (int i = 0; i < tempCount; i++) {
        if (temporaryEnrollment[i] != null && temporaryEnrollment[i].equals(selectedCourses[courseNumber - 1])) {
          alreadyEnrolled = true;
          System.out.println("이미 신청한 강의입니다: " + selectedCourses[courseNumber - 1]);
          break;
        }
      }

      // 유효한 강의 번호 체크
      if (!alreadyEnrolled && tempCount < temporaryEnrollment.length && courseNumber > 0 && courseNumber <= selectedCourses.length) {
        temporaryEnrollment[tempCount] = selectedCourses[courseNumber - 1];
        tempCount++;
        System.out.println(selectedCourses[courseNumber - 1] + " 강의가 예비 수강 신청되었습니다.");
      } else {
        System.out.println("예비 수강 신청 오류 또는 최대 수 신청 수 초과.");
      }
    }
  }

  // 예비 수강 내역 조회
  private void viewTemporaryEnrollments() {
    System.out.println("예비 수강 내역:");
    if (tempCount == 0) {
      System.out.println("신청한 강의가 없습니다.");
    } else {
      for (int i = 0; i < tempCount; i++) {
        System.out.println((i + 1) + ". " + temporaryEnrollment[i]);
      }
    }
  }

  // 예비 수강 취소
  private void cancelTemporaryEnrollment() {
    viewTemporaryEnrollments();
    System.out.print("취소할 강의 번호를 입력하세요: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index > 0 && index <= tempCount) {
      System.out.println(temporaryEnrollment[index - 1] + " 의 예비 수강이 취소되었습니다.");
      for (int i = index - 1; i < tempCount - 1; i++) {
        temporaryEnrollment[i] = temporaryEnrollment[i + 1];
      }
      temporaryEnrollment[tempCount - 1] = null;
      tempCount--;
    } else {
      System.out.println("잘못된 강의 번호입니다.");
    }
  }

  // 수강 신청
  private void registerCourse() {
    viewTemporaryEnrollments();
    System.out.print("신청할 강의 번호를 입력하세요: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index > 0 && index <= tempCount && enrolledCount < enrolledCourses.length) {
      for (int i = 0; i < enrolledCount; i++) {
        if (enrolledCourses[i] != null && enrolledCourses[i].equals(temporaryEnrollment[index - 1])) {
          System.out.println("이미 수강 신청한 강의입니다.");
          return;
        }
      }
      enrolledCourses[enrolledCount] = temporaryEnrollment[index - 1];
      System.out.println(temporaryEnrollment[index - 1] + " 강의가 수강 신청되었습니다.");
      enrolledCount++;
      System.out.println(temporaryEnrollment[index - 1] + " 강의가 예비 수강 목록에서 취소되었습니다.");
      for (int i = index - 1; i < tempCount - 1; i++) {
        temporaryEnrollment[i] = temporaryEnrollment[i + 1];
      }
      temporaryEnrollment[tempCount - 1] = null;
      tempCount--;
    } else {
      System.out.println("잘못된 강의 번호이거나 수강 신청 수 초과입니다.");
    }
  }

  // 수강 내역 조회
  private void viewEnrolledCourses() {
    System.out.println("수강 내역:");
    if (enrolledCount == 0) {
      System.out.println("수강 중인 강의가 없습니다.");
    } else {
      for (int i = 0; i < enrolledCount; i++) {
        System.out.println((i + 1) + ". " + enrolledCourses[i]);
      }
    }
  }

  // 수강 취소
  private void cancelEnrolledCourse() {
    viewEnrolledCourses();
    System.out.print("취소할 수강 과목의 번호를 입력하세요: ");
    int index = scan.nextInt();
    scan.nextLine();

    if (index > 0 && index <= enrolledCount) {
      System.out.println(enrolledCourses[index - 1] + " 의 수강 신청이 취소되었습니다.");
      for (int i = index - 1; i < enrolledCount - 1; i++) {
        enrolledCourses[i] = enrolledCourses[i + 1];
      }
      enrolledCourses[enrolledCount - 1] = null;
      enrolledCount--;
    } else {
      System.out.println("잘못된 과목 번호입니다.");
    }
  }
}
