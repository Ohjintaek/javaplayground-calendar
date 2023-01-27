import java.util.Scanner;

public class Prompt {
    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        int month;
        int year;

        while (true) {
            System.out.println("년도를 입력하세요. (종료: -1)");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            if (year  == -1) {
                break;
            }

            System.out.println("월을 입력하세요.");
            System.out.print("MONTH> ");
            month = scanner.nextInt();

            Calendar.printCalendar(year, month);
        }

        System.out.println("Have a nice day!");
        scanner.close();
    }

    public static void main(String[] args) {
        // 셀 실행
        Prompt p = new Prompt();
        p.runPrompt();
    }
}
