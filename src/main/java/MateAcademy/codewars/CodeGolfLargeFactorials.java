package MateAcademy.codewars;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class CodeGolfLargeFactorials {
    public static void main(String[] args) {
        System.out.println(f(25));
    }

    public static String f(int n) {
        return null;
    }

    public static String f1(int n) {
        if (n == 0) return "1";
        if (n < 0) return null;
        BigInteger bigInteger = BigInteger.valueOf(1);
        while (n > 1) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(n--));
        }
        return bigInteger.toString();
    }

    public static String f2(int n) {
//        return (n > 1) ? new BigDecimal(n).multiply(new BigDecimal(f(n - 1))) + "" : "1";
        return (n > 1) ? new BigDecimal(n).multiply(new BigDecimal(Objects.requireNonNull(f(n - 1)))) + "" : "1";
    }
}
