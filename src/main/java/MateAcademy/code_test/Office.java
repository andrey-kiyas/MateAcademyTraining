package MateAcademy.code_test;

public class Office {
    public static Object findChairs(Room[] rooms, int need) {
        if (need == 0) {
            return "No need!";
        }
        int[] foundChairs = new int[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            int freeChairs = rooms[i].chairs - rooms[i].occupants.length();
            if (freeChairs > 0) {
                if (freeChairs >= need) {
                    foundChairs[i] = need;
                    final int[] result = new int[i + 1];
                    System.arraycopy(foundChairs, 0, result, 0, i + 1);
                    return result;
                } else {
                    foundChairs[i] = freeChairs;
                    need -= freeChairs;
                }
            } else {
                foundChairs[i] = 0;
            }
        }
        return "Not enough!";
    }
}

class Room {
    String occupants;
    int chairs;

    public Room(String occupants, int chairs) {
        this.occupants = occupants;
        this.chairs = chairs;
    }
}
