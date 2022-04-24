import java.util.Scanner;

public class Console {
    static App app = new App();
    public static int enteredCommand;
    
    public void flush(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void promptEnterKey(Scanner input){
        System.out.println("Press any key to continue.");
        input.nextLine();
    }

    public void divider(){
        System.out.println("------------------------------------------------------------------------------");
    }

    public void getCommand(){

        switch (enteredCommand) {
            case 1:
                this.flush();
                System.out.printf("Id \t %-10s \t Price \t Quantity \t %-10s \n", "Name", "Sold");
                for (Product item : Product.products) {
                    System.out.println(item);
                }
                this.divider();
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
            this.getCommand();
            this.promptEnterKey(input);
            this.flush();
        } 
        catch (NumberFormatException ex) {
            this.flush();
            divider();
            System.err.println("Command not found!");
            divider();
            this.promptEnterKey(input);
            this.flush();
            this.listenToInput();
        }
    }
}
