package MateAcademy.more.swap;

public class Swap {
    public Object[] arguments;

    public Swap(Object[] args) {
        arguments = args;
    }

    public void swapValues() {
        Object[] args = new Object[]{arguments[0], arguments[1]};
        System.out.println("Before swap: " + arguments[0] + " " + arguments[1]);
        Object temp = args[0];
        args[0] = args[1];
        args[1] = temp;
        arguments = args;
        System.out.println("Swap: " + arguments[0] + " " + arguments[1]);
    }
}
