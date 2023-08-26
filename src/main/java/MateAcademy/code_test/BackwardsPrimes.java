package MateAcademy.code_test;

public class BackwardsPrimes {
    public static void main(String[] args) {
        System.out.println(getBackwardsPrimes(1, 73));
        System.out.println(getBackwardsPrimes(-1, 0));
    }

    public static String getBackwardsPrimes(long start, long end) {
        // write code here
        StringBuilder builder = new StringBuilder();
        for (long i = start; i <= end; i++) {
            if (!isPrime(i)) {
                continue;
            }
            long backDig = backwardsInt(i);
            if (!isPrime(backDig)) {
                continue;
            }
            if (i == backDig) {
                continue;
            }
            builder.append(i).append(" ");
        }
        if (builder.substring(builder.length() - 1).equals(" ")) {
            builder.replace(builder.length() - 1, builder.length(), "");
        }
        return builder.toString();
    }

    // число в обратном порядке
    private static long backwardsInt(long number) {
        long reversed = 0;
        while (number != 0) {
            long digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }


    // проверка простого числа
    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
