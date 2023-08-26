package MateAcademy.code_test;

public class HumanDuration {
    public static void main(String[] args) {
//        System.out.println(formatDuration(0));       // ==> "now"
//        System.out.println(formatDuration(1));       // ==> "1 second"
//        System.out.println(formatDuration(62));      // ==> "1 minute and 2 seconds"
//        System.out.println(formatDuration(3600));    // ==> "1 hour"
//        System.out.println(formatDuration(1560564)); // ==> "18 days, 1 hour, 29 minutes and 24 seconds"
        int sec = 30000000;
        System.out.println(formatDuration(sec));
        System.out.println(formatDuration2(sec));
    }

    public static String formatDuration2(int seconds) {
        String result = "";
        int[] units = new int[]{31536000, 86400, 3600, 60, 1};
        String[] labels = new String[]{"year", "day", "hour", "minute", "second"};
        if (seconds == 0) {
            return "now";
        }
        for (int i = 0; i < 5; i++) {
            if (seconds >= units[i]) {
                int quantity = seconds / units[i];
                seconds = seconds % units[i];
                result += (result.equals("") ? "" : (seconds == 0 ? " and " : ", "))
                        + quantity + " " + labels[i] + (quantity > 1 ? "s" : "");
            }
        }
        return result;
    }

    public static String formatDuration(int seconds) {
        // write code here
        if (seconds == 0) {
            return "now";
        }
        StringBuilder builder = new StringBuilder();
        int year = (seconds / 60) / 60 / 24 / 365;
        int day = (seconds / 60) / 60 / 24 % 365;
        int hour = (seconds / 60) / 60 % 24;
        int min = (seconds / 60) % 60;
        int sec = seconds % 60;
        if (year > 0) {
            builder.append(year).append(" year");
            if (year > 1) {
                builder.append("s");
            }
        }
        if (day > 0) {
            if (year > 0) {
                builder.append(", ");
            }
            builder.append(day).append(" day");
            if (day > 1) {
                builder.append("s");
            }
        }
        if (hour > 0) {
            if (day > 0 || year > 0) {
                builder.append(", ");
            }
            builder.append(hour).append(" hour");
            if (hour > 1) {
                builder.append("s");
            }
        }
        if (min > 0) {
            if (hour > 0 || day > 0 || year > 0) {
                if (sec == 0) {
                    builder.append(" and ");
                } else {
                    builder.append(", ");
                }
            }
            builder.append(min).append(" minute");
            if (min > 1) {
                builder.append("s");
            }
        }
        if (sec > 0) {
            if (min > 0 || hour > 0 || day > 0 || year > 0) {
                builder.append(" and ");
            }
            builder.append(sec).append(" second");
            if (sec > 1) {
                builder.append("s");
            }
        }
        return String.valueOf(builder);
    }
}
