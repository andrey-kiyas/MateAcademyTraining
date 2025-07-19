package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem
 */

public class LC1233RemoveSubFoldersFromTheFilesystem {
    public static void main(String[] args) {
        String[] input1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        String[] input2 = {"/a", "/a/b/c", "/a/b/d"};
        String[] input3 = {"/a/b/c", "/a/b/ca", "/a/b/d"};

        System.out.println(removeSubfolders(input1)); // ["/a", "/c/d", "/c/f"]
        System.out.println(removeSubfolders(input2)); // ["/a"]
        System.out.println(removeSubfolders(input3)); // ["/a/b/c", "/a/b/ca", "/a/b/d"]
    }

    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();

        for (String path : folder) {
            if (result.isEmpty() || !path.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(path);
            }
        }

        return result;
    }
}
