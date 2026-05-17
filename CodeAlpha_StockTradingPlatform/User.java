import java.util.*;
public class User{
    private String name;
    private double balance=0;
    private Map<String,Integer> portfolio = new HashMap<>();
    //avg buy price storage
    private Map<String,Double> avgBuyPrice=new HashMap<>();
    //Transaction history
    private List<Transaction> history= new ArrayList<>();
    //total profit/loss
    private double totalProfit=0;
    //constructor
    public User(String name){
        this.name=name;
    }
    //add money
 public void addMoney(double amount){
        if(amount<=0){
            System.out.println("Invalid");
            return;
        }
        balance+=amount;
        System.out.printf("Money Added: RS.%.2f%n",amount);
    }
    //buy stock
public void buyStock(Stock stock,int qty){
        if(qty<=0){
            System.out.println("Invalid quantity");
            return;
        }
    double cost= stock.getPrice() * qty;
    // check balance
    if(balance>=cost){
        //deduct money
        balance-= cost;
        //old quantity
        int oldQty=portfolio.getOrDefault(stock.getName(),0);
        //update portfolio
        portfolio.put(stock.getName(),oldQty + qty);
        // old avg buy price
        double oldAvg= avgBuyPrice.getOrDefault(stock.getName(),0.0);
        //new avg buy price
        double newAvg= ((oldQty * oldAvg)+(qty * stock.getPrice()))/(oldQty + qty);
        //update average price
        avgBuyPrice.put(stock.getName(),newAvg);
        //save transaction
        history.add(new Transaction("BUY",stock.getName(),qty,stock.getPrice()));
        System.out.println("Bought "+qty+" shares of "+stock.getName());
    }else{
        System.out.println("Insufficient balance");
        }
    }
      
    //sell stock
public void sellStock(Stock stock,int qty){
        if(qty<=0){
            System.out.println("Invalid quantity");
            return;
        }
        //owned quantity
        int owned =portfolio.getOrDefault(stock.getName(),0);
        //check ownership
        if(owned>=qty){
            //buy price
            double buyPrice= avgBuyPrice.get(stock.getName());
            //get current sell price
            double sellPrice=stock.getPrice();

            //calculate profit or loss
         double profitLoss=(sellPrice-buyPrice)*qty;

            //add money to balance
            balance+= sellPrice*qty;

            //update portfolio
            if(owned==qty){
                portfolio.remove(stock.getName());
                avgBuyPrice.remove(stock.getName());
            }else{
                portfolio.put(stock.getName(),owned-qty);
                
            }
            //update total profit
            totalProfit+=profitLoss;
            //save transcation
            history.add(new Transaction("SELL",stock.getName(),qty,stock.getPrice()));

            //show profit or loss
            if(profitLoss>=0){
                System.out.printf("PROFIT: Rs.%.2f%n",profitLoss);
            }else{
                System.out.printf("LOSS: Rs.%.2f%n",profitLoss);
            }
        }else{
            System.out.println("Not enough shares");
        }
    }
    //show portfolio
public void showPortfolio(Market market){
        System.out.println("\n-----PORTFOLIO-----");
        System.out.println("User: "+name);
        System.out.printf("Balance: Rs.%.2f%n",balance);
        if(portfolio.isEmpty()){
            System.out.println("No Stocks Owned");
        }else{
            System.out.println("\nHoldings:");
        for(String key:portfolio.keySet()){
            int qty=portfolio.get(key);
            Stock stock=market.getStock(key);
            double currentPrice=stock.getPrice();
            double value=qty*currentPrice;
            System.out.printf("%s | Qty: %d | Price: Rs.%.2f | Value: Rs.%.2f%n",key,qty,currentPrice,value);
        }
    }
    System.out.printf("%nTotal Profit/Loss: Rs.%.2f%n",totalProfit);
    }
    //show history
public void showHistory(){
        System.out.println("\n-----TRANSACTION HISTORY-----");
        if(history.isEmpty()){
            System.out.println("No Transaction found");
        }else{
            for(Transaction t:history){
                System.out.println(t);
            }
        }
    }
    public void showOwnedStocks(){
        System.out.println("\n-----Your Stocks-----");
        if(portfolio.isEmpty()){
            System.out.println("No Stocks Owned");
        }else{
              for (String key :portfolio.keySet()) {
              System.out.println(key + " | Qty: " +portfolio.get(key));
             }
        }
    }
    
    // getter for name
    public String getName(){
        return name;
    }
    // getter for balance
    public double getBalance(){
        return balance;
    }
    // getter for portfolio
    public Map<String,Integer> getPortfolio(){
        return portfolio;
    }
    // getter for transaction history
public List<Transaction> getHistory(){
    return history;
}

}

