package MateAcademy.more.swap;

public class SwapRunner {
    public static void main(String[] args) {
        Object[] objects = new Object[2];
        objects[0] = 1;
        objects[1] = 1000;
        Swap swap = new Swap(objects);
        swap.swapValues();
    }
}
