import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("두 수를 입력하세요.");
        String userInput = scanner.nextLine();
        String[] splitInput = userInput.split(" ");
        int number1 = Integer.parseInt(splitInput[0]);
        int number2 = Integer.parseInt(splitInput[1]);

        System.out.printf("두수의 합은 %d입니다.", number1+number2);
    }
}
