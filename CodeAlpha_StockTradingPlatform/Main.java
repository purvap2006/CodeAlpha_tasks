import java.util.*;
public class Main {

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

       Market market = new Market();
       System.out.print("Enter name: ");
       String name=sc.nextLine();
       User user=new User(name);
       while(true){
        System.out.println("\n------------STOCK TRADING SYSTEM-------------");
        System.out.println("1. Add Money");
        System.out.println("2. View Market");
        System.out.println("3. Buy Stock");
        System.out.println("4. Sell Stock");
        System.out.println("5. Portfolio");
        System.out.println("6. Transaction History");
        System.out.println("7. Save Data");
        System.out.println("8. Exit");

        System.out.print("\nChoose: ");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("Enter Amount: ");
                double amount= sc.nextDouble();
                user.addMoney(amount);
                break;
            case 2:
                market.updatePrices();
                market.showStocks();
                break;
            case 3:
                market.showStocks();
                System.out.print("Enter stock name: ");
                String buyName=sc.next();
                System.out.print("Enter quantity: ");
                int buyQty=sc.nextInt();
                Stock buyStock=market.getStock(buyName);
                if(buyStock!= null){
                    user.buyStock(buyStock,buyQty);
                }else{
                    System.out.print("Stock not Found ");
                }
                break;
            case 4:
                user.showOwnedStocks();
                System.out.print("Enter stock name: ");
                String sellName=sc.next();
                System.out.print("Enter quantity: ");
                int sellQty=sc.nextInt();
                Stock sellStock=market.getStock(sellName);
                if(sellStock!=null){
                    user.sellStock(sellStock,sellQty);
                }else{
                    System.out.println("Stock not found");
                }
                break;
            case 5:
                user.showPortfolio(market);
                break;
            case 6:
                user.showHistory();
                break;
            case 7:
                FileHandler.saveUser(user);
                break;
            case 8:
                FileHandler.saveUser(user);
                System.out.println("Exiting..");
                sc.close();
                return;
            default:
                System.out.println("Invalid choice");
                }
            }
        }
    }