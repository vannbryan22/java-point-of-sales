import java.util.List;

public class Transaction {
    public int id;
    public String name;
    public int price;
    public int quantitySold;
    public int total;
    private static int count = 0;
    private Console console = new Console();
    public static List<Transaction> transactions;

    public Transaction(){
        return;
    }

    public Transaction(String name, int price, int quantitySold, int total) {
        this.id = count;
        this.name = name;
        this.price = price;
        this.quantitySold = quantitySold;
        this.total = total;
        count++;
    }

    public void displayTransactions(){
        console.flush();
        // if(transactions.equals(null)){
        //     System.out.println("No transaction available. \n \n");
        // }

        System.out.printf("Id \t %-10s \t Price \t Quantity \t %-10s \n", "Name", "Sold");
        for (Transaction item : Transaction.transactions) {
            System.out.println(item);
        }
        console.divider();
    }

    public String toString() {
        return String.format("%d \t %-10s \t %d \t %d \t %d", id, name, price, quantitySold, total);
    }

    public void addTransaction(Transaction newTransaction){
        transactions.add(newTransaction);
    }

}
