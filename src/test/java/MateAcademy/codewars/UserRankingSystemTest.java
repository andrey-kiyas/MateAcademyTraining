package MateAcademy.codewars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class UserRankingSystemTest {
    UserRankingSystem user = new UserRankingSystem();
    private void do_test(int rank, int expectedRank, int expectedProgress) {
        if(rank!=0) user.incProgress(rank);
        assertEquals("After applying rank of " + rank, expectedRank, user.rank);
        assertEquals("After applying rank of " + rank, expectedProgress, user.progress);
    }
    @Test
    public void testIncProgress() {
        do_test(-8, -8, 3);

        user = new UserRankingSystem();
        do_test(-7, -8, 10);

        user = new UserRankingSystem();
        do_test(-6, -8, 40);

        user = new UserRankingSystem();
        do_test(-5, -8, 90);

        user = new UserRankingSystem();
        do_test(-4, -7, 60);

        user = new UserRankingSystem();
        do_test(-8, -8, 3);

        user = new UserRankingSystem();
        do_test(1, -2, 40);
        do_test(1, -2, 80);
        do_test(1, -1, 20);
        do_test(1, -1, 30);
        do_test(1, -1, 40);
        do_test(2, -1, 80);
        do_test(2, 1, 20);
        do_test(-1, 1, 21);
    }
}
