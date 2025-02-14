package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers
 */

public class LC1352ProductOfTheLastKNumbers {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [1, 3]
        productOfNumbers.add(0);        // [1] (обнуление)
        productOfNumbers.add(2);        // [1, 2]
        productOfNumbers.add(5);        // [1, 2, 10]
        productOfNumbers.add(4);        // [1, 2, 10, 40]

        System.out.println(productOfNumbers.getProduct(2)); // 20  (5 * 4)
        System.out.println(productOfNumbers.getProduct(3)); // 40  (2 * 5 * 4)
        System.out.println(productOfNumbers.getProduct(4)); // 0   (бо був 0)
    }
}

class ProductOfNumbers {
    private final List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        int n = prefixProducts.size();
        if (k >= n) {
            return 0;
        }
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }
}
