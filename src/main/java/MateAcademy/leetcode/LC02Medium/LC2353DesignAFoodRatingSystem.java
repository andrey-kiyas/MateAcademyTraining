package MateAcademy.leetcode.LC02Medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/design-a-food-rating-system
 */

public class LC2353DesignAFoodRatingSystem {
    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(
                new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"},
                new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"},
                new int[]{9, 12, 8, 15, 14, 7}
        );

        System.out.println(foodRatings.highestRated("korean"));   // kimchi
        System.out.println(foodRatings.highestRated("japanese")); // ramen
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // sushi
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // ramen
    }
}


class FoodRatings {
    private static class Food {
        String name;
        int rating;

        Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return name + "(" + rating + ")";
        }
    }

    private final Map<String, String> foodToCuisine;
    private final Map<String, Food> foodObjects;
    private final Map<String, TreeSet<Food>> cuisineToFoods;

    private final Comparator<Food> foodComparator = (a, b) -> {
        if (a.rating != b.rating) {
            return Integer.compare(b.rating, a.rating);
        }
        return a.name.compareTo(b.name);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodObjects = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            Food f = new Food(food, rating);
            foodToCuisine.put(food, cuisine);
            foodObjects.put(food, f);

            cuisineToFoods.computeIfAbsent(cuisine, k -> new TreeSet<>(foodComparator)).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        Food oldFood = foodObjects.get(food);

        cuisineToFoods.get(cuisine).remove(oldFood);

        Food updated = new Food(food, newRating);
        foodObjects.put(food, updated);
        cuisineToFoods.get(cuisine).add(updated);
    }

    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().name;
    }
}

/*
  Your FoodRatings object will be instantiated and called as such:
  FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
  obj.changeRating(food,newRating);
  String param_2 = obj.highestRated(cuisine);
 */