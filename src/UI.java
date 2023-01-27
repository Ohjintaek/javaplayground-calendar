import java.util.*;

public class UI {
    private final static String MENU = "+----------------------+\n" +
            "| 1. 일정 등록           \n" +
            "| 2. 일정 검색           \n" +
            "| 3. 달력 보기\n" +
            "| h. 도움말 q. 종료\n" +
            "+----------------------+";

    private final static String ORDER = "명령 (1, 2, 3, h, q)";
    private final static String PROMPT = "> ";

    private Map<String, List<String>> userPlan = new HashMap<>();

    public static void runUI(UI ui) {
        System.out.println(MENU);
        Scanner scanner = new Scanner(System.in);
        Prompt p = new Prompt();
        String userInput;

        while (true) {
            System.out.println(ORDER);
            System.out.print(PROMPT);
            userInput = scanner.next();

            if (userInput.equals("1")) {
                register(scanner, ui);
            }

            if (userInput.equals("2")) {
                List<String> plans = search(scanner, ui);
                if (plans != null) {
                    int i = 1;
                    for (String plan : plans) {
                        System.out.printf("%d. %s\n", i, plan);
                        i++;
                    }
                } else {
                    System.out.println("등록된 일정이 없습니다.");
                }
            }

            if (userInput.equals("3")) {
                p.runPrompt(scanner);
            }

            if (userInput.equals("h")) {
                System.out.println(MENU);
            }

            if (userInput.equals("q")) {
                break;
            }
        }

        System.out.println("Bye");
        scanner.close();
    }

    private static void register(Scanner scanner, UI ui) {
        System.out.println("[일정 등록] 날짜를 입력하세요 (yyyy-MM-dd).");
        System.out.print(PROMPT);
        String date = scanner.next();

        System.out.println("일정을 입력하세요.");
        System.out.print(PROMPT);
        String plan = scanner.nextLine();

        if (ui.userPlan.containsKey(date)) {
            ui.userPlan.get(date).add(plan);
        } else {
            ui.userPlan.put(date, new ArrayList<>(Arrays.asList(plan)));
        }
        System.out.println("일정이 등록되었습니다.");
    }

    private static List<String> search(Scanner scanner, UI ui) {
        System.out.println("[일정 검색] 날짜를 입력하세요. (yyyy-MM-dd)");
        System.out.print(PROMPT);
        String date = scanner.next();

        if (ui.userPlan.containsKey(date)) {
            return ui.userPlan.get(date);
        }
        return null;
    }

    public static void main(String[] args) {
        // 셀 실행
        UI ui = new UI();
        runUI(ui);
    }
}
