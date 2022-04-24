import java.util.List;

/**
 * Product @params()
 */
public class Product {
    public int id;
    public String name;
    public int price;
    public int quantity;
    public int quantitySold;
    private static int count = 0;
    public static List<Product> products;


    public Product(String name, int price, int quantity, int quantitySold) {
        this.id = count;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.quantitySold = quantitySold;

        count++;
    }

    public String toString(){
        return String.format("%d \t %-10s \t %d \t %d \t %10d", id, name, price, quantity, quantitySold);
    }

    public void display() {
        System.out.println(id + name + price + quantity + quantitySold);
    }
}