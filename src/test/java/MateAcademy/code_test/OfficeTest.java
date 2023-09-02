package MateAcademy.code_test;

import org.junit.Test;
import org.junit.Assert;

public class OfficeTest {
    @Test
    public void findChairs_oneRoomEnoughChairs() {
        Room[] rooms = new Room[] {
                new Room("XX", 3),
        };
        int[] expected = new int[] {1};
        Assert.assertArrayEquals("Method should return the correct array if there is one room with enough chairs\n",
                expected, (int[]) Office.findChairs(rooms, 1));
    }

    @Test
    public void findChairs_oneRoomExtraChairs() {
        Room[] rooms = new Room[] {
                new Room("XXX", 8),
        };
        int[] expected = new int[] {3};
        Assert.assertArrayEquals("Method should return the correct array if there is one room with extra chairs\n",
                expected, (int[]) Office.findChairs(rooms, 3));
    }

    @Test
    public void findChairs_severalRoomsEnoughChairs() {
        Room[] rooms = new Room[] {
                new Room("XXX", 3),
                new Room("XXXXX", 6),
                new Room("XXXXXX", 9)
        };
        int[] expected = new int[] {0, 1, 3};
        Assert.assertArrayEquals("Method should return the correct array if the number of free chairs equals to need\n",
                expected, (int[]) Office.findChairs(rooms, 4));
    }

    @Test
    public void findChairs_extraChairsInLastRoom() {
        Room[] rooms = new Room[] {
                new Room("XXXX", 2),
                new Room("XXX", 5),
                new Room("XX", 4),
                new Room("X", 5),
        };
        int[] expected = new int[] {0, 2, 2, 2};
        Assert.assertArrayEquals("Method should return the correct array if there extra chairs in the last room\n",
                expected, (int[]) Office.findChairs(rooms, 6));
    }

    @Test
    public void findChairs_extraRooms() {
        Room[] rooms = new Room[] {
                new Room("XXX", 1),
                new Room("XXXXXX", 6),
                new Room("X", 2),
                new Room("XXXXXX", 8),
                new Room("X", 3),
                new Room("XXX", 1),
                new Room("XX", 4)
        };
        int[] expected = new int[] {0, 0, 1, 2, 2};
        Assert.assertArrayEquals("Method should return the correct array if the are extra rooms\n",
                expected, (int[]) Office.findChairs(rooms, 5));
    }

    @Test
    public void findChairs_noNeed() {
        Room[] rooms = new Room[] {
                new Room("XX", 2),
                new Room("XXXX", 6),
                new Room("XXXXX", 4)
        };
        Assert.assertEquals("Method should return the string \"No need!\" if no chairs are needed\n",
                "No need!", Office.findChairs(rooms, 0));
    }

    @Test
    public void findChairs_oneRoomNotEnough() {
        Room[] rooms = new Room[] {
                new Room("XXX", 5),
        };
        Assert.assertEquals("Method should return the string \"Not enough!\" if there are not enough chairs in one room\n",
                "Not enough!", Office.findChairs(rooms, 3));
    }

    @Test
    public void findChairs_severalRoomsNotEnough() {
        Room[] rooms = new Room[] {
                new Room("X", 1),
                new Room("XXX", 4),
                new Room("XXXXXX", 6)
        };
        Assert.assertEquals("Method should return the string \"Not enough!\" if there are not enough chairs in one room\n",
                "Not enough!", Office.findChairs(rooms, 2));
    }
}
