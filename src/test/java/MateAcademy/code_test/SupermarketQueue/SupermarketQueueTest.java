package MateAcademy.code_test.SupermarketQueue;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SupermarketQueueTest {
    @Test
    public void calculateTotalTime_singleCustomer() {
        int[] customers = new int[]{5};
        int checkout = 1;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and one checkout till\n", 5, Arrays.toString(customers)), 5, actual);
    }

    @Test
    public void calculateTotalTime_twoCheckoutTills() {
        int[] customers = new int[]{2, 2, 3, 3, 4, 4};
        int checkout = 2;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and two checkout tills\n", 9, Arrays.toString(customers)), 9, actual);
    }

    @Test
    public void calculateTotalTime_singleTillManyCustomers() {
        int[] customers = new int[]{1, 2, 3, 4, 5};
        int checkout = 1;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and one checkout till\n", 15, Arrays.toString(customers)), 15, actual);
    }

    @Test
    public void calculateTotalTime_manyCheckoutTills() {
        int[] customers = new int[]{10, 2, 6, 3, 1, 4};
        int checkout = 100;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and one hundred checkout tills\n", 10, Arrays.toString(customers)), 10, actual);
    }

    @Test
    public void calculateTotalTime_noCustomers() {
        int[] customers = new int[]{};
        int checkout = 3;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and three checkout tills\n", 0, Arrays.toString(customers)), 0, actual);
    }

    @Test
    public void calculateTotalTime_longCustomerArray() {
        int[] customers = new int[]{29, 18, 6, 23, 25, 29, 24, 17, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26};
        int checkout = 7;
        int actual = SupermarketQueue.calculateTotalTime(customers, checkout);
        Assert.assertEquals(String.format("The total time should be %d for the queue of customers \"%s\"" +
                " and seven checkout tills\n", 72, Arrays.toString(customers)), 72, actual);
    }
}
