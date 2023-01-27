import java.util.Scanner;

public class Calendar {
    private static final int[] MAX_DAYS = {31,28,31,30,31,30,31,31,30,31,30,31};

    public int getMaxDaysOfMonth(int month) {
        return MAX_DAYS[month - 1];
    }

    public void printTempCalendar() {
        String tmp = "일 월 화 수 목 금 토\n" +
                "--------------------\n" +
                " 1  2  3  4  5  6  7\n" +
                " 8  9 10 11 12 13 14\n" +
                "15 16 17 18 19 20 21\n" +
                "22 23 24 25 26 27 28";

        System.out.println(tmp);
        System.out.println();
    }

    private static void printMonth(int month) {
        Calendar cal = new Calendar();

        if (month < 1) {
            System.out.println("올바른 숫자가 아닙니다.");
        } else if (month > 12) {
            System.out.println("올바른 숫자가 아닙니다.");
        } else {
            System.out.printf("%d월은 %d일까지 있습니다.", month, cal.getMaxDaysOfMonth(month));
        }
    }

    public static void main(String[] args) {
        // 월을 입력하면 그 달이 몇일로 구성되어 있는지 출력하는 프로그램 작성하기
        Scanner scanner = new Scanner(System.in);
        System.out.println("반복횟수를 입력하세요.");
        int trial = scanner.nextInt();
        System.out.println();
        int[] requiredMonth = new int[trial];

        System.out.println("월을 입력하세요.");
        for (int i = 0; i < trial; i++) {
            requiredMonth[i] = scanner.nextInt();
        }
        System.out.println();

        int i = 0;
        while(i < trial) {
            System.out.printf("%d월은 %d일까지 있습니다.\n", requiredMonth[i], MAX_DAYS[requiredMonth[i]-1]);
            i++;
        }

        scanner.close();
    }
}