public class Calendar {
    private static final int[] MAX_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] WEEKDAYS = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
    private static final int GREGORY_ORIGIN = 1583;
    private static final int GREGORY_ORIGIN_WEEKDAY = 6; // 1583/1/1 : SATURDAY;

    public static int getMaxDaysOfMonth(int year, int month) {
        if (isLeapYear(year) && month == 2) {
            return 29;
        }
        return MAX_DAYS[month - 1];
    }

    public static int getIndexOfWeekday(String weekday) {
        if (weekday.equals("SU")) {
            return 0;
        }
        if (weekday.equals("MO")) {
            return 1;
        }
        if (weekday.equals("TU")) {
            return 2;
        }
        if (weekday.equals("WE")) {
            return 3;
        }
        if (weekday.equals("TH")) {
            return 4;
        }
        if (weekday.equals("FR")) {
            return 5;
        }
        if (weekday.equals("SA")) {
            return 6;
        }
        return 0;
    }

    public static boolean isLeapYear(int year) {
        if ( year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static void printCalendar(int year, int month) {
        int daysOfMonth = getMaxDaysOfMonth(year, month);
        int dayIndex = getIndexOfWeekday(WEEKDAYS[getGregoryWeekday(year, month)]);

        System.out.printf("    << %4d%3d >>\n", year, month);
        System.out.println(" SU MO TU WE TH FR SA");
        System.out.println("---------------------");
        for(int i = 1; i <= dayIndex; i++) {
            System.out.print("   ");
        }
        for (int i = 1; i <= daysOfMonth; i++) {
            System.out.printf("%3d", i);
            if ((i + dayIndex) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    private static void printMaxDayOfMonth(int year, int month) {
        if (month < 1) {
            System.out.println("올바른 숫자가 아닙니다.");
        } else if (month > 12) {
            System.out.println("올바른 숫자가 아닙니다.");
        } else {
            System.out.printf("%d월은 %d일까지 있습니다.\n", month, getMaxDaysOfMonth(year, month));
        }
    }

    public static int getGregoryWeekday(int year, int month) {
        int weekday = GREGORY_ORIGIN_WEEKDAY;
        for (int i = GREGORY_ORIGIN; i < year; i++) {
            if (isLeapYear(i)) {
                weekday = (weekday + 2) % 7;
            }
            else {
                 weekday = (weekday + 1) % 7;
            }
        }

        for (int i = 1; i < month; i++) {
            weekday = (weekday + getMaxDaysOfMonth(year, i)) % 7;
        }

        return weekday;
    }
}