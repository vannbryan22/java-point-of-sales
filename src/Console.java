import java.util.Scanner;

public class Console {
    static App app = new App();
    public static int enteredCommand;
    private Product product = new Product();
    private static Transaction transaction = new Transaction();

    
    public void flush(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void promptKey(Scanner input, String text){
        if(text != null ){
            System.out.println(text);
            input.nextLine();
        }else{
            System.out.println("Press any key to continue.");
            input.nextLine();

        }
    }

    public void divider(){
        System.out.println("------------------------------------------------------------------------------");
    }

    public void getCommand(Scanner input){

        switch (enteredCommand) {
            case 1:
                product.displayInventory();
                break;
            case 2:
                product.addQuantity(input);
                break;
            case 3:
                product.buy(input);
                break;
            case 4:
                transaction.displayTransactions();
                break;
            default:
                App.valid = false;
                break;
        }

        return;
    }

    public void listenToInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n 1. Display Inventory \n 2. Add Product Quantity \n 3. Enter Sales Transaction \n 4. Display Sales Transactions \n");
        System.out.println(" Enter a command.");
        this.divider();

        String command = input.nextLine();

        try 
        {
            int integer = Integer.parseInt(command);
            enteredCommand = integer;
            if(enteredCommand > 5 && enteredCommand < 0){
                this.flush();
                divider();
                System.err.println("Command not found!");
                divider();
                this.promptKey(input, null);
                this.flush();
                this.listenToInput();
            }else{
                this.getCommand(input);
                this.promptKey(input, null);
                this.flush();
            }
        } 
        catch (NumberFormatException ex) {
            this.flush();
            divider();
            System.err.println("Command not found!");
            divider();
            this.promptKey(input, null);
            this.flush();
            this.listenToInput();
        }
    }
}
