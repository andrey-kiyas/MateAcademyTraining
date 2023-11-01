package MateAcademy.code_test;

import java.util.ArrayList;
import java.util.List;

public class RangeExtraction {
    public static String extractRange(int[] nums) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int rangeStart = nums[i];
            result.append(rangeStart);
            for (int j = i + 1; j <= nums.length; j++) {
                if (j == nums.length || nums[j] != rangeStart + (j - i)) {
                    if (j - i >= 3) {
                        result.append('-').append(nums[j - 1]);
                        i = j - 1;
                    }
                    result.append(',');
                    break;
                }
            }
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    public static String extractRange2(int[] nums) {
        // write code here
        List<String> ranges = new ArrayList<>();
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (end - start >= 2) {
                    ranges.add(start + "-" + end);
                } else {
                    ranges.add(String.valueOf(start));
                    if (end != start) {
                        ranges.add(String.valueOf(end));
                    }
                }
                start = nums[i];
                end = nums[i];
            }
        }
        if (end - start >= 2) {
            ranges.add(start + "-" + end);
        } else {
            ranges.add(String.valueOf(start));
            if (end != start) {
                ranges.add(String.valueOf(end));
            }
        }
        return String.join(",", ranges);
    }
}
