public class App {

    public static void main(String[] args) {
        int price = 1000;

        int discounted = calculateDiscount(price);
        int finalPrice = applyTax(discounted);

        System.out.println("Final Price after discount and tax: " + finalPrice);
    }

    public static int calculateDiscount(int price) {
        return price - 150;
    }

    public static int applyTax(int price) {
        return price + 180;
    }
}
