import java.io.*;
import java.util.*;

public class FileHandler {
    public static void saveUser(User user){
        try{
        PrintWriter pw=new PrintWriter(new FileWriter(user.getName()+ ".txt"));
        //user info
        pw.println("----User Info----");
        pw.println("Name: "+ user.getName());
        pw.println("Balance: Rs." +String.format("%.2f", user.getBalance()));
        pw.println();
        //portfolio
        pw.println("----Portfolio----");
        if (user.getPortfolio().isEmpty()) {
         pw.println( "No Stocks Owned");
        }else{
        for(String key: user.getPortfolio().keySet()){
        pw.println(key +"| Qty: "+ user.getPortfolio().get(key));
        }
    }
        pw.println();
        //transaction history
         pw.println("===== TRANSACTION HISTORY =====");
            if (user.getHistory().isEmpty()) {
                pw.println( "No Transactions");
            } else {
                for (Transaction t :user.getHistory()) {
                    pw.println(t);
                }
            }
            pw.close();
        System.out.println("Data Saved successfully");
        }
        catch(Exception e){
         System.out.println("Error saving file");  
         e.printStackTrace(); 
        }  
    }
}
