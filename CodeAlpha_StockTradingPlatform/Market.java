import java.util.*;
public class Market {
    private List <Stock> stocks=new ArrayList<>();
    public Market(){
        stocks.add(new Stock("TCS", 3500));
        stocks.add(new Stock("INFY", 1500));
        stocks.add(new Stock("WIPRO", 450));
        stocks.add(new Stock("HDFC", 1600));
    }
    public void showStocks(){
        System.out.println("MARKET DATA-");
        for(Stock s: stocks){
            System.out.printf("%s - Rs.%.2f%n", s.getName() , s.getPrice());
        }
    }
    public Stock getStock(String name){
        for(Stock s:stocks){
            if(s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }
   public void updatePrices() {
    for (Stock s : stocks) {
        double change =(Math.random() * 100) - 50;
        double newPrice =s.getPrice() + change;
        // round to 2 decimal places
        newPrice =Math.round(newPrice * 100.0)/100.0;
        s.setPrice(Math.max(100,newPrice));
    }
}
}