package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/design-a-number-container-system
 */

public class LC2349DesignANumberContainerSystem {
    private final Map<Integer, Integer> indexToNumber;
    private final Map<Integer, TreeSet<Integer>> numberToIndices;

    public LC2349DesignANumberContainerSystem() {
        indexToNumber = new HashMap<>();
        numberToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int oldNumber = indexToNumber.get(index);
            if (oldNumber != number) {
                numberToIndices.get(oldNumber).remove(index);
                if (numberToIndices.get(oldNumber).isEmpty()) {
                    numberToIndices.remove(oldNumber);
                }
            }
        }

        indexToNumber.put(index, number);
        numberToIndices.putIfAbsent(number, new TreeSet<>());
        numberToIndices.get(number).add(index);
    }

    public int find(int number) {
        return numberToIndices.containsKey(number) && !numberToIndices.get(number).isEmpty()
                ? numberToIndices.get(number).first()
                : -1;
    }
}
