import java.util.Scanner;

public class Prompt {
    public void runPrompt(Scanner scanner) {
        int month;
        int year;

        System.out.println("년도를 입력하세요.");
        System.out.print("YEAR> ");
        year = scanner.nextInt();
        System.out.println("월을 입력하세요.");
        System.out.print("MONTH> ");
        month = scanner.nextInt();

        Calendar.printCalendar(year, month);
    }
}
