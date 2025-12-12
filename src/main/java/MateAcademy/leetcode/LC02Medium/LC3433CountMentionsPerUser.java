package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-mentions-per-user
 */

public class LC3433CountMentionsPerUser {
    public static void main(String[] args) {
        List<List<String>> events1 = new ArrayList<>();
        events1.add(Arrays.asList("MESSAGE","10","id1 id0"));
        events1.add(Arrays.asList("OFFLINE","11","0"));
        events1.add(Arrays.asList("MESSAGE","71","HERE"));
        System.out.println(Arrays.toString(countMentions(2, events1))); // [2,2]

        List<List<String>> events2 = new ArrayList<>();
        events2.add(Arrays.asList("MESSAGE","10","id1 id0"));
        events2.add(Arrays.asList("OFFLINE","11","0"));
        events2.add(Arrays.asList("MESSAGE","12","ALL"));
        System.out.println(Arrays.toString(countMentions(2, events2))); // [2,2]

        List<List<String>> events3 = new ArrayList<>();
        events3.add(Arrays.asList("OFFLINE","10","0"));
        events3.add(Arrays.asList("MESSAGE","12","HERE"));
        System.out.println(Arrays.toString(countMentions(2, events3))); // [0,1]
    }

    public static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort((a, b) -> {
            int timestampA = Integer.parseInt(a.get(1));
            int timestampB = Integer.parseInt(b.get(1));
            if (timestampA == timestampB) {
                return a.get(0).charAt(2) - b.get(0).charAt(2);
            }
            return timestampA - timestampB;
        });

        int[] mentionCounts = new int[numberOfUsers];

        int[] onlineUntilTime = new int[numberOfUsers];

        int allMentionsCount = 0;

        for (List<String> event : events) {
            String eventType = event.get(0);
            int currentTime = Integer.parseInt(event.get(1));
            String content = event.get(2);

            if (eventType.charAt(0) == 'O') {
                int userId = Integer.parseInt(content);
                onlineUntilTime[userId] = currentTime + 60;
            } else if (content.charAt(0) == 'A') {
                allMentionsCount++;
            } else if (content.charAt(0) == 'H') {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (onlineUntilTime[i] <= currentTime) {
                        mentionCounts[i]++;
                    }
                }
            } else {
                String[] userIds = content.split(" ");
                for (String userIdStr : userIds) {
                    int userId = Integer.parseInt(userIdStr.substring(2));
                    mentionCounts[userId]++;
                }
            }
        }

        if (allMentionsCount > 0) {
            for (int i = 0; i < numberOfUsers; i++) {
                mentionCounts[i] += allMentionsCount;
            }
        }

        return mentionCounts;
    }
}
