import java.util.ArrayList;
import java.util.List;

public class App {
    public static boolean valid = true;
    static Console console = new Console();

    static void setProducts(){
        List<Product> myProducts = new ArrayList<>();
        myProducts.add(new Product("Pen", 7, 100, 0));
        myProducts.add(new Product("Pencil", 5, 100,0));
        myProducts.add(new Product("Eraser", 2, 100,0));
        myProducts.add(new Product("Notebook", 10, 100, 0));

        Product.products = myProducts;
    }

    public static void main(String[] args) throws Exception {
        setProducts();
        console.flush();
        do {
            console.listenToInput();
        } while (valid);
    }
}



