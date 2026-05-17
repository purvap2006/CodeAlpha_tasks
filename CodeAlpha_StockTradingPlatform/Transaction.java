import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Transaction {
    private String type;
    private String stockName;
    private int quantity;
    private double price;
    private LocalDateTime time;

    public Transaction(String type,String stockName, int quantity,double price ){
        this.type=type;
        this.stockName=stockName;
        this.quantity=quantity;
        this.price=price;
        this.time=LocalDateTime.now();
    }

        @Override
        public String toString() {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
            return type+ " | "+stockName+" | "+ quantity +" | Rs."+ String.format("%.2f",price)+" | "+time.format(format);
        }
}
