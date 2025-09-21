package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/design-movie-rental-system
 */

public class LC1912DesignMovieRentalSystem {
    public static void main(String[] args) {
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, new int[][]{
                {0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}
        });

        System.out.println(movieRentingSystem.search(1)); // [1,0,2]
        movieRentingSystem.rent(0, 1);
        movieRentingSystem.rent(1, 2);
        System.out.println(movieRentingSystem.report()); // [[0,1],[1,2]]
        movieRentingSystem.drop(1, 2);
        System.out.println(movieRentingSystem.search(2)); // [0,1]
    }
}

class MovieRentingSystem {
    private static class Entry {
        int shop, movie, price;

        Entry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    private final Map<Integer, TreeSet<Entry>> available = new HashMap<>();
    private final TreeSet<Entry> rented = new TreeSet<>(
            Comparator.comparingInt((Entry e) -> e.price)
                    .thenComparingInt(e -> e.shop)
                    .thenComparingInt(e -> e.movie)
    );
    private final Map<String, Entry> entryMap = new HashMap<>();

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            Entry entry = new Entry(shop, movie, price);

            available.computeIfAbsent(movie, k -> new TreeSet<>(
                    Comparator.comparingInt((Entry x) -> x.price)
                            .thenComparingInt(x -> x.shop)
            )).add(entry);

            entryMap.put(key(shop, movie), entry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        if (!available.containsKey(movie)) return result;

        Iterator<Entry> it = available.get(movie).iterator();
        while (it.hasNext() && result.size() < 5) {
            result.add(it.next().shop);
        }
        return result;
    }

    public void rent(int shop, int movie) {
        Entry entry = entryMap.get(key(shop, movie));
        available.get(movie).remove(entry);
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        Entry entry = entryMap.get(key(shop, movie));
        rented.remove(entry);
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        Iterator<Entry> it = rented.iterator();
        while (it.hasNext() && result.size() < 5) {
            Entry e = it.next();
            result.add(Arrays.asList(e.shop, e.movie));
        }
        return result;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}

/*
  Your MovieRentingSystem object will be instantiated and called as such:
  MovieRentingSystem obj = new MovieRentingSystem(n, entries);
  List<Integer> param_1 = obj.search(movie);
  obj.rent(shop,movie);
  obj.drop(shop,movie);
  List<List<Integer>> param_4 = obj.report();
 */