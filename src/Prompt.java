import java.util.Scanner;

public class Prompt {
    // private final static String PROMPT = "cal> ";

    public void runPrompt() {
        Scanner scanner = new Scanner(System.in);
        int month;
        int year;
        String weekday;

        while (true) {
            System.out.println("년도를 입력하세요");
            System.out.print("YEAR> ");
            year = scanner.nextInt();
            System.out.println("월을 입력하세요.");
            System.out.print("MONTH> ");
            month = scanner.nextInt();
            System.out.println("첫번째 요일을 입력하세요. (SU, MO, WE, TH, FR, SA)");
            System.out.print("WEEKDAY> ");
            weekday = scanner.next();

            if (month == -1) {
                break;
            }
            Calendar.printCalendar(year, month, weekday);
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
