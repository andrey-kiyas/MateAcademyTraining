package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/design-task-manager
 */

public class LC3408DesignTaskManager {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager(Arrays.asList(
                Arrays.asList(1, 101, 10),
                Arrays.asList(2, 102, 20),
                Arrays.asList(3, 103, 15)
        ));

        taskManager.add(4, 104, 5);
        taskManager.edit(102, 8);
        System.out.println(taskManager.execTop()); // 3
        taskManager.rmv(101);
        taskManager.add(5, 105, 15);
        System.out.println(taskManager.execTop()); // 5
    }
}

class TaskManager {
    private final Map<Integer, int[]> taskMap = new HashMap<>();

    private final TreeSet<int[]> priorityQueue = new TreeSet<>((a, b) -> {
        if (a[0] == b[0]) {
            return b[1] - a[1];
        }
        return b[0] - a[0];
    });

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        taskMap.put(taskId, new int[]{userId, priority});

        priorityQueue.add(new int[]{priority, taskId});
    }

    public void edit(int taskId, int newPriority) {
        int[] taskInfo = taskMap.get(taskId);
        int userId = taskInfo[0];
        int oldPriority = taskInfo[1];

        priorityQueue.remove(new int[]{oldPriority, taskId});

        priorityQueue.add(new int[]{newPriority, taskId});

        taskMap.put(taskId, new int[]{userId, newPriority});
    }

    public void rmv(int taskId) {
        int[] taskInfo = taskMap.remove(taskId);
        int priority = taskInfo[1];

        priorityQueue.remove(new int[]{priority, taskId});
    }

    public int execTop() {
        if (priorityQueue.isEmpty()) {
            return -1;
        }

        int[] topTask = priorityQueue.pollFirst();
        assert topTask != null;
        int taskId = topTask[1];

        int[] taskInfo = taskMap.remove(taskId);

        return taskInfo[0];
    }
}

/*
  Your TaskManager object will be instantiated and called as such:
  TaskManager obj = new TaskManager(tasks);
  obj.add(userId,taskId,priority);
  obj.edit(taskId,newPriority);
  obj.rmv(taskId);
  int param_4 = obj.execTop();
 */
