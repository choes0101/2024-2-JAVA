// 학과 : 컴퓨터 공학과
// 학번 : 202334757
// 이름 : 조은성
package ex;

public class Lab1 {
    public static void main(String[] args) {
        //성적 배열 생성
        int[][] grade = { {90, 85, 91}, {92, 95, 88}, {87, 94, 96}};
        // 이름 배열 생성
        String[] name = {"홍길동", "김사랑", "나대장"};

        // 총합 배열 생성
        int[] total = new int[grade.length];
        // 평균 배열 생성
        int[] average = new int[grade.length];

        // 총합을 계산하여 total[]에 저장
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[i].length; j++) {
                total[i] += grade[i][j];
            }
        }

        // 평균을 계산하여 average[]에 저장
        for (int i = 0; i < grade.length; i++) {
            average[i] = total[i] / grade[i].length;
        }

        // 출력
        for (int i = 0; i < grade.length; i++) {
                // 학생 이름, 성적, 총점, 평균을 탭으로 구분하여 출력
                System.out.println(name[i] + "\t" + grade[i][0] + "\t" + grade[i][1] + "\t" + grade[i][2] + "\t" + total[i] + "\t" + average[i]);
            }

    }
}
