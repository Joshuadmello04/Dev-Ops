public class App {

    public static void main(String[] args) {
        int price = 1000;
        System.out.println("Discounted Price: " + calculateDiscount(price));
    }

    public static int calculateDiscount(int price) {
        return price - 100;
    }
}
