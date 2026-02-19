public class App {

    public static void main(String[] args) {
        int price = 1000;
        System.out.println("Final Price: " + applyTax(price));
    }

    public static int applyTax(int price) {
        return price + 180;
    }
}
