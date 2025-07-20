package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/delete-duplicate-folders-in-system
 */

public class LC1948DeleteDuplicateFoldersInSystem {

    public static void main(String[] args) {
        List<List<String>> paths1 = List.of(
                List.of("a"), List.of("c"), List.of("d"),
                List.of("a", "b"), List.of("c", "b"), List.of("d", "a")
        );
        List<List<String>> paths2 = List.of(
                List.of("a"), List.of("c"), List.of("a", "b"),
                List.of("c", "b"), List.of("a", "b", "x"),
                List.of("a", "b", "x", "y"), List.of("w"), List.of("w", "y")
        );
        List<List<String>> paths3 = List.of(
                List.of("a", "b"), List.of("c", "d"), List.of("c"), List.of("a")
        );

        System.out.println(deleteDuplicateFolder(paths1));
        System.out.println(deleteDuplicateFolder(paths2));
        System.out.println(deleteDuplicateFolder(paths3));
    }

    public static List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        Map<String, List<TrieNode>> subtreeToNodes = new HashMap<>();

        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr = curr.children.computeIfAbsent(folder, k -> new TrieNode());
            }
        }

        serialize(root, subtreeToNodes);

        for (List<TrieNode> nodes : subtreeToNodes.values()) {
            if (nodes.size() > 1) {
                for (TrieNode node : nodes) {
                    node.deleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private static String serialize(TrieNode node, Map<String, List<TrieNode>> map) {
        if (node.children.isEmpty()) return "()";

        List<String> serialParts = new ArrayList<>();
        for (String key : node.children.keySet()) {
            String serial = key + serialize(node.children.get(key), map);
            serialParts.add(serial);
        }

        Collections.sort(serialParts);
        String fullSerial = "(" + String.join("", serialParts) + ")";
        map.computeIfAbsent(fullSerial, k -> new ArrayList<>()).add(node);
        return fullSerial;
    }

    private static void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            if (!child.deleted) {
                path.add(folder);
                result.add(new ArrayList<>(path));
                collectPaths(child, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}

class TrieNode {
    Map<String, TrieNode> children = new HashMap<>();
    boolean deleted = false;
}
