package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/coupon-code-validator
 */

public class LC3606CouponCodeValidator {
    private static final List<String> ORDER =
            List.of("electronics", "grocery", "pharmacy", "restaurant");

    public static void main(String[] args) {
        System.out.println(validateCoupons(
                new String[]{"SAVE20","","PHARMA5","SAVE@20"},
                new String[]{"restaurant","grocery","pharmacy","restaurant"},
                new boolean[]{true,true,true,true}
        ));
        // [PHARMA5, SAVE20]

        System.out.println(validateCoupons(
                new String[]{"GROCERY15","ELECTRONICS_50","DISCOUNT10"},
                new String[]{"grocery","electronics","invalid"},
                new boolean[]{false,true,true}
        ));
        // [ELECTRONICS_50]
    }

    public static List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {

            if (!isActive[i]) continue;

            if (code[i] == null || code[i].isEmpty()) continue;
            if (!code[i].matches("[A-Za-z0-9_]+")) continue;

            if (!ORDER.contains(businessLine[i])) continue;

            result.add(businessLine[i] + "|" + code[i]);
        }

        result.sort((a, b) -> {
            String[] p1 = a.split("\\|");
            String[] p2 = b.split("\\|");

            int cmp = Integer.compare(
                    ORDER.indexOf(p1[0]),
                    ORDER.indexOf(p2[0])
            );
            if (cmp != 0) return cmp;

            return p1[1].compareTo(p2[1]);
        });

        List<String> ans = new ArrayList<>();
        for (String s : result) {
            ans.add(s.split("\\|")[1]);
        }

        return ans;
    }
}
