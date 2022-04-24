import java.util.List;
import java.util.Scanner;

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

    static Console console = new Console();

    public Product(){
        return;
    }

    public void buy(Scanner input){
        Product chosenProduct = null;
        this.displayInventory();

        System.out.println("Enter ID of an item for the transaction.");
        String stringId = input.nextLine();

        try {
            int id = Integer.parseInt(stringId);

            for (Product product : products) {
                if(product.id == id){
                    chosenProduct = product;
                }
            }
            console.flush();
            System.out.printf("%s \t %-10s \t %s \t %s \t %s \n", "ID", "Name", "Price", "Quantity",  "QuantitySold");
            System.out.println(chosenProduct);
            
            System.out.println("Enter quantity sold");
            int quantity = input.nextInt();

            chosenProduct.quantity = chosenProduct.quantity - quantity;
            chosenProduct.quantitySold = chosenProduct.quantitySold + quantity;

            // List<Transaction> transaction = new ArrayList<>();

            Transaction newTransaction = new Transaction(chosenProduct.name, chosenProduct.price, chosenProduct.quantitySold, chosenProduct.price * quantity);

            Transaction transaction = new Transaction();
            transaction.addTransaction(newTransaction);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public Product(String name, int price, int quantity, int quantitySold) {
        this.id = count;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.quantitySold = quantitySold;

        count++;
    }

    public void addQuantity(Scanner input){
        Product chosenProduct = null;
        this.displayInventory();

        System.out.println("Enter product ID you want to add a quantity");

        String enteredId = input.nextLine();

        try {
            int id = Integer.parseInt(enteredId);

            for (Product product : products) {
                if(product.id == id){
                    chosenProduct = product;
                }
            }
            console.flush();
            System.out.printf("%s \t %-10s \t %s \t %s \t %s \n", "ID", "Name", "Price", "Quantity",  "QuantitySold");
            System.out.println(chosenProduct);
            
            System.out.println("Enter quantity to be added.");
            int quantity = input.nextInt();
            chosenProduct.quantity = chosenProduct.quantity + quantity;
        } catch (Exception e) {
            System.err.println(e);
        }

    }


    public void printFields(){
        System.out.printf("%d \t %-10s \t %s \t %s \n", "ID", "Name", "Price", "Quantity",  "QuantitySold");
    }

    public void addProduct(Scanner input){
        System.out.print("Enter product name => \t");
        String productName = input.nextLine();

        System.out.print("Enter product price => \t");
        int productPrice = input.nextInt();

        System.out.print("Enter product quantity => \t");
        int productQuantity = input.nextInt();

        console.flush();
        System.out.printf("%-10s \t %s \t %s \n", "Name", "Price", "Quantity");

        System.out.printf("%-10s \t %d \t %d", productName, productPrice, productQuantity);

        console.promptKey(input, "\n \nPlease enter S to Save.");
        String save = input.nextLine();

        if(save.equals("S")){
            console.flush();
            products.add(new Product(productName, productPrice, productQuantity, 0));
            System.out.println("Adding product successful.");
            console.divider();
        }else{
            return;
        }
    }


    public void displayInventory(){
        console.flush();
        System.out.printf("Id \t %-10s \t Price \t Quantity \t %-10s \n", "Name", "Sold");
        for (Product item : Product.products) {
            System.out.println(item);
        }
        console.divider();
    }

    public String toString(){
        return String.format("%d \t %-10s \t %d \t %d \t %10d", id, name, price, quantity, quantitySold);
    }

}