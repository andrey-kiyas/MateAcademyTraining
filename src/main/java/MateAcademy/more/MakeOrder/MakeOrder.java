package MateAcademy.more.MakeOrder;

public class MakeOrder {
    public int calculatePrice(Product[] products) {
        // write your code bellow this line
//        int a = 0;
//        for (int i = 0; i < products.length; i++) {
//            a += products[i].price;
//        }
//        return a;

        int sum = 0;
        for (Product product : products) {
            sum += product.price;
        }
        return sum;
        // write your code above this line
    }
}
