package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC2115FindAllPossibleRecipesFromGivenSupplies {
    public static void main(String[] args) {
        System.out.println(findAllRecipes(
                new String[]{"bread"},
                new ArrayList<>(Collections.singletonList(Arrays.asList("yeast", "flour"))),
                new String[]{"yeast", "flour", "corn"}));                                     // "bread"
        System.out.println(findAllRecipes(
                new String[]{"bread", "sandwich"},
                new ArrayList<>(Arrays.asList(Arrays.asList("yeast", "flour"),
                        Arrays.asList("bread", "meat"))),
                new String[]{"yeast", "flour", "meat"}));                                     // "bread","sandwich"
        System.out.println(findAllRecipes(
                new String[]{"bread", "sandwich", "burger"},
                new ArrayList<>(Arrays.asList(Arrays.asList("yeast", "flour"),
                        Arrays.asList("bread", "meat"),
                        Arrays.asList("sandwich", "meat", "bread"))),
                new String[]{"yeast", "flour", "meat"}));                                     // "bread","sandwich","burger"
    }

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> suppliesSet = new HashSet<>(Arrays.asList(supplies));
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            inDegree.put(recipe, ingredients.get(i).size());
            for (String ingredient : ingredients.get(i)) {
                graph.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
            }
        }

        for (String supply : suppliesSet) {
            queue.offer(supply);
        }

        while (!queue.isEmpty()) {
            String available = queue.poll();
            if (inDegree.containsKey(available)) {
                result.add(available);
            }
            if (graph.containsKey(available)) {
                for (String dependent : graph.get(available)) {
                    inDegree.put(dependent, inDegree.get(dependent) - 1);
                    if (inDegree.get(dependent) == 0) {
                        queue.offer(dependent);
                    }
                }
            }
        }

        return result;
    }
}
